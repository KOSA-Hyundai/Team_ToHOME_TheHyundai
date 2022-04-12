var pcYn = "N";
var basktGbcd = "01";

function fnProductDetailMove(slitmCd, sectId, ctgrId, basktGbcd, rintrvSubscrbSeqnSeq, gaParam){
	sectId = sectId=="undefined" ? "":sectId;
	sectId = sectId==null ? "":sectId;
	
	ctgrId = ctgrId=="undefined" ? "":ctgrId;
	ctgrId = ctgrId==null ? "":ctgrId;
	
	basktGbcd = basktGbcd=="undefined" ? "":basktGbcd;
	basktGbcd = basktGbcd==null ? "":basktGbcd;
	if(basktGbcd != ""){
		basktGbcd = "&basktGbcd="+basktGbcd;
	}
	gaParam = gaParam=="undefined" ? "":gaParam;
	gaParam = gaParam==null ? "":gaParam;
	if(gaParam != ""){
		gaParam = "&ga_param="+gaParam;
	}
	
	rintrvSubscrbSeqnSeq = rintrvSubscrbSeqnSeq=="undefined" ? "":rintrvSubscrbSeqnSeq;
	rintrvSubscrbSeqnSeq = rintrvSubscrbSeqnSeq==null ? "":rintrvSubscrbSeqnSeq;
	if(rintrvSubscrbSeqnSeq != ""){
		rintrvSubscrbSeqnSeq = "&rintrvSubscrbSeqnSeq="+rintrvSubscrbSeqnSeq;
	}
	
	location.href = vServerPath+"/pd/pdd/productDetail.do?slitmCd="+slitmCd+rintrvSubscrbSeqnSeq+"&sectId="+sectId+"&ctgrId="+ctgrId+basktGbcd+gaParam;
}

function fnStoreOrMenuDetailMove(slitmCd, sectId, ctgrId, autoDispTypeGbcd, gaParam){
	
	sectId = sectId=="undefined" ? "":sectId;
	sectId = sectId==null ? "":sectId;
	
	ctgrId = ctgrId=="undefined" ? "":ctgrId;
	ctgrId = ctgrId==null ? "":ctgrId;
	
	autoDispTypeGbcd = autoDispTypeGbcd=="undefined" ? "":autoDispTypeGbcd;
	autoDispTypeGbcd = autoDispTypeGbcd==null ? "":autoDispTypeGbcd;
	
	gaParam = gaParam=="undefined" ? "":gaParam;
	gaParam = gaParam==null ? "":gaParam;
	if(gaParam != ""){
		gaParam = "&ga_param="+gaParam;
	}
	
	if (autoDispTypeGbcd == '03' || autoDispTypeGbcd == '04'){ //메장
		location.href = vServerPath+"/pd/pdc/storeDetail.do?sectId="+sectId+gaParam;
	} else if ( slitmCd.indexOf('G') > -1){ //그로서리
		location.href = vServerPath+"/pd/pdd/groceryDetail.do?slitmCd="+slitmCd+"&sectId="+sectId+"&ctgrId="+ctgrId+gaParam;
	} else {
		$.ajax({
		       type : 'get',
		       url : vServerPath+'/pd/pdc/storeImdtDlivryChk.json',
		       data : "sectId="+sectId+"&ctgrId="+ctgrId, 
		       dataType : 'json',
		       success : function(data, status, xhr) {
		           if(data != null){
		        	   if(data.selSect.imdtDlivryYn == "Y"){
		        		   location.href = vServerPath+"/pd/pdc/storeDetail.do?slitmCd="+slitmCd+"&sectId="+sectId+"&anchor="+slitmCd+gaParam;
		        	   }else{
		        		   //준비중
		        		   //if(confirm('해당 매장의 바로배달 서비스는 준비중으로 예약주문만 가능합니다.\n배달 카테고리로 이동하여 예약주문 시간을 설정하시겠습니까?')){
		        		   //	location.href = vServerPath+"/pd/pdc/storeList.do?ctgrId="+data.selSect.highCtgrId+gaParam;
			        	   //}
		        		   const callData = encodeURIComponent(JSON.stringify({
		        	            cmd: "fnStoreOrMenuDetailMove", // 미리 협의한 호출ID
		        	            param: { // 파라미터. 파라미터가 없다면 param: {}
		        	            	ref: "/pd/pdc/storeList.do?ctgrId="+data.selSect.highCtgrId+gaParam,
		        	            	desc: "예약주문만 가능한 시간입니다.\n예약을 진행하시겠습니까?"
		        	            },
		        	            callback: "" // 콜백 함수명. 콜백이 필요없다면 callback: ""
		        	        }));
		        	        commonNativeCall(callData);
		        	   }
		           } 
		       }
		   });  
	}

}

/* 재입고알림 신청 팝업 호출 */
function arlim(slitmCd, pckgSlitmCd) {
	
	if (!isLogin || isLogin == 'N'){
    	if(confirm('재입고알림 신청시 로그인이 필요합니다.\n로그인하시겠습니까?')){
			location.href = vServerPath+'/cua/login.do';
			return true;
		}else return false;		
    	
    } else {
        var param = {
                  slitmCd : slitmCd
                , pckgSlitmCd : pckgSlitmCd
        };
        
        var vUrl = "";
    	if (vServerPath.indexOf('event') != -1) {
    		vUrl = "/front/od/odc/rishpNtReqPopupAjax.do?UseCache=N";
    	} else {
    		vUrl = vServerPath + "/od/odc/rishpNtReqPopupAjax.do?UseCache=N";
    	}
        
        $.ajax({
              type : "GET"
            , url : vUrl
            , data : param
            , dataType : "html"
            , async : false
            , success : function(data) {
                $("#popWeightingNight").html(data);
                
                if ($("#popWeightingNight input[name=rishpNtreqYn]").val() == "Y") {
                    alert("이미 재입고 알림 신청이 된 상품입니다.");
                    return;
                } else {
                    fn.popupOpen('#popWeightingNight');
                }
              }
            , error: function(xhr, status, error) {
                alert("처리중 오류가 발생하였습니다.");
              }
        });
    } 
}

/* 재입고 알림 신청 */
function rishpNotfReq() {
    if ($("#frmRishpNtReqInf input[name=mngtNotfSetupChecked]").length > 0) {
        if ($("#frmRishpNtReqInf input[name=mngtNotfSetupChecked]").is(":checked")) {
            $("#frmRishpNtReqInf input[name=mngtNotfSetupYn]").val("Y");
        } else {
            $("#frmRishpNtReqInf input[name=mngtNotfSetupYn]").val("N");
        }
    }
    
    var vUrl = "";
	if (vServerPath.indexOf('event') != -1) {
		vUrl = "/front/od/odc/saveRishpNtreqInf.ajax?UseCache=N";
	} else {
		vUrl = vServerPath + "/od/odc/saveRishpNtreqInf.ajax?UseCache=N";
	}
    
    $.ajax({
          type : "GET"
        , url : vUrl
        , data : $("#frmRishpNtReqInf").serialize()
        , dataType : "json"
        , async : false
        , success : function(data) {
            if (data.result.Msg) {
                alert(data.result.Msg);
            }
            fn.popupClose();
          }
        , error: function(xhr, status, error) {
            alert("처리중 오류가 발생하였습니다.");
          }
    });
}


function fnItemDetailInfo(slitmCd){
	var returnCd = "99";
	var returnCdFlag = true;
	 $.ajax({
         type : "GET"
       , url : vServerPath + "/pd/pdc/itemDetailInfo.json?UseCache=N"
       , data : "slitmCd="+slitmCd
       , dataType : "json"
       , async : false
       , success : function(data) {
           if (data.slitmCd != null) {
               //옵션상품여부
        	   if(data.pckgItemYn == "Y"){
        		   returnCd = "01";
        		   returnCdFlag = false;
        	   }
        	   
        	   //예약배송상품여부
        	   if(data.itemTypeGbcd == "1"){
        		   returnCd = "02";
        		   returnCdFlag = false;
        	   }else if(data.itemTypeGbcd == "2"){
        		   	//정기구독상품여부
        		   returnCd = "05";
        		   returnCdFlag = false;
        	   }
        	   
        	   
        	   //품절
        	   if(data.itemStatus == "01" || data.itemStatus == "01"){
        		   returnCd = "04";
        		   returnCdFlag = false;
        	   }
        	   
        	   //수량제한 & 재고부족
         	   if(data.itemStatus != "00" ){
         		   returnCd = "03";
         		   returnCdFlag = false;
         	   }
         	   
        	   
        	   if(returnCdFlag){
        		   returnCd = "00"+":"+data.dptsBrnCd+":"+data.venCd;
        	   }
        	   
           }
           
         }
       , error: function(xhr, status, error) {
    	   alert("처리중 오류가 발생하였습니다.");
         }
   });
	 
	 return returnCd;
}

function fnGrcyItemDetailInfo(slitmCd, dlivryRsvTimeGbcd, dlivryRsvDt){
	var returnCd = "99";
	var returnCdFlag = true;
	 $.ajax({
         type : "GET"
       , url : vServerPath + "/pd/pdc/itemDetailInfo.json?UseCache=N"
       , data : "slitmCd="+slitmCd+"&dlivryRsvTimeGbcd="+dlivryRsvTimeGbcd+"&dlivryRsvDt="+dlivryRsvDt
       , dataType : "json"
       , async : false
       , success : function(data) {
           if (data.slitmCd != null) {
               //옵션상품여부
        	   if(data.pckgItemYn == "Y"){
        		   returnCd = "01";
        		   returnCdFlag = false;
        	   }
        	   
        	   //예약배송상품여부
        	   if(data.itemTypeGbcd == "1"){
        		   returnCd = "02";
        		   returnCdFlag = false;
        	   }else if(data.itemTypeGbcd == "2"){
        		   	//정기구독상품여부
        		   returnCd = "05";
        		   returnCdFlag = false;
        	   }
        	   
        	   
        	   //품절
        	   if(data.itemStatus == "01" || data.itemStatus == "01"){
        		   returnCd = "04";
        		   returnCdFlag = false;
        	   }
        	   
        	   //수량제한 & 재고부족
         	   if(data.itemStatus != "00" ){
         		   returnCd = "03";
         		   returnCdFlag = false;
         	   }
         	   
        	   
        	   if(returnCdFlag){
        		   returnCd = "00"+":"+data.dptsBrnCd+":"+data.venCd;
        	   }
        	   
           }
           
         }
       , error: function(xhr, status, error) {
    	   alert("처리중 오류가 발생하였습니다.");
         }
   });
	 
	 return returnCd;
}

function fnProductBasketAdd(basktGbcd, slitmCd, sectId, ctgrId, dlivryRsvTimeGbcd, dlivryRsvDt)
{
	sectId = sectId=="undefined" ? "":sectId;
	sectId = sectId==null ? "":sectId;
	
	ctgrId = ctgrId=="undefined" ? "":ctgrId;
	ctgrId = ctgrId==null ? "":ctgrId;
	
	dlivryRsvTimeGbcd = dlivryRsvTimeGbcd=="undefined" ? "":dlivryRsvTimeGbcd;
	dlivryRsvTimeGbcd = dlivryRsvTimeGbcd==null ? "":dlivryRsvTimeGbcd;
	
	dlivryRsvDt = dlivryRsvDt=="undefined" ? "":dlivryRsvDt;
	dlivryRsvDt = dlivryRsvDt==null ? "":dlivryRsvDt;
	
	var slitmInf = [];
	//상품 상세 조회
	if (basktGbcd == "06") {
		var returnCd = fnGrcyItemDetailInfo(slitmCd, dlivryRsvTimeGbcd, dlivryRsvDt);
	} else {
		var returnCd = fnItemDetailInfo(slitmCd);		
	}
	if(returnCd == "01"){
		if (confirm("상품 옵션을 선택해주세요.\n상세로 이동하시겠습니까?")) {
			fnProductDetailMove(slitmCd, sectId, ctgrId, basktGbcd);
		}
	}else if(returnCd == "02"){
		if (confirm("이 상품은 예약배송 상품입니다.\n상품 상세에서 예약배송일을 선택해주세요.\n상세로 이동하시겠습니까?")) {
			fnProductDetailMove(slitmCd, sectId, ctgrId, basktGbcd);
		}
	}else if(returnCd == "03"){
		alert("해당상품이 품절되어 장바구니에 담을 수 없습니다.");
	}else if(returnCd == "04"){
		alert("상품이 품절되었습니다.");
		location.reload();
	}else if(returnCd == "05"){
		if (confirm("이 상품은 정기구독 상품입니다.\n상품 상세에서 상품을 확인해주세요.\n상세로 이동하시겠습니까?")) {
			fnProductDetailMove(slitmCd, sectId, ctgrId, basktGbcd);
		}
	}else{
		returnCd1 = returnCd.split(":")[0];
		if(returnCd1 == "00"){
			returnCd2 = returnCd.split(":")[1];
			returnCd3 = returnCd.split(":")[2];
			if(basktGbcd == "03"){
				slitmInf.push(slitmCd+"::"+returnCd2+":"+returnCd3+":"+sectId+":1");
			}else if(basktGbcd == "06"){
				if(dlivryRsvDt != "" && dlivryRsvTimeGbcd !=""){
					slitmInf.push(slitmCd+":::"+returnCd2+":"+returnCd3+":"+sectId+":1:Y:"+dlivryRsvDt+":"+dlivryRsvTimeGbcd);
				}else{
					slitmInf.push(slitmCd+":::"+returnCd2+":"+returnCd3+":"+sectId+":1:N");
				}
				
			}else{
				slitmInf.push(slitmCd+"::"+returnCd2+":"+returnCd3+":"+sectId+":1:N");
			}
			console.log(slitmInf);
			console.log(basktGbcd);
			basketInf.add(basktGbcd, slitmInf, function() {
				if(pcYn == "Y"){
					fn.popupOpen('#p_popCartAdd');
				}else{
					fn.popupCart('#popCartAdd');	
				}
				
		        basketInf.getBasketTotalCnt(basktGbcd, function(basktCnt) {
		        	basketInf.getBasketTotalCnt(basktGbcd, eval('fnPdTotalCntCallBackFn'));
		        	
		        	//앱에서 새벽배송 장바구니 카운트 update
		        	if(isApp == 'Y'){
		        		const callData = encodeURIComponent(JSON.stringify({

		        	        cmd: "updateDawnBasket", // 미리 협의한 호출ID

		        	        param: { // 파라미터. 파라미터가 없다면 param: {}
		        	        	p01: basktGbcd,
		        	        },

		        	        callback: "" // 콜백 함수명. 콜백이 필요없다면 callback: ""

		        	    }));

		        	    commonNativeCall(callData);

		        	}
		        	/*if (confirm("장바구니에 담기 완료되었습니다.[장바구니 건수 : "+basktCnt+"]\n장바구니로 이동하시겠습니까?")) {
		        		location.href = contextPath + "/od/odc/shippingBasketList.do?basktGbcd=" + basktGbcd;
		        	}*/
		        });
			});
		}
	}
}

//장바구니 클릭시
function fnPdShippingBasketList(){
	//console.log('fnPdShippingBasketList::'+vServerPath+'/od/odc/shippingBasketList.do');
	var f_basktGbcd = basktGbcd=="undefined" ? "":basktGbcd;
	f_basktGbcd = basktGbcd==null ? "":basktGbcd;
	
	if(f_basktGbcd != ""){
		f_basktGbcd = "?basktGbcd="+f_basktGbcd;
	}else{
		f_basktGbcd = "?basktGbcd=01";
	}

	if (vServerPath.indexOf('event') != -1) {
		location.href = '/front/od/odc/shippingBasketList.do'+f_basktGbcd;
	} else {
		location.href = vServerPath+'/od/odc/shippingBasketList.do'+f_basktGbcd;
	}
}

//장바구니 콜백함수
function fnPdTotalCntCallBackFn(cnt){
	//console.log('fnPdTotalCntCallBackFn::: '+cnt);
	$('#basketCnt').text(cnt);

}