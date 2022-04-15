/*
* Description : GA360 공통
* Date : 2022.01.12
* tohome.thehyundai.com에서 인용하였습니다.
* */

var AndroidWebview = 'GA_Android';											// Android userAgent
var iOS_Webview_WK = 'GA_iOS_WK';												// WKWebView userAgent
var CommonData = new Object;
var isMoveFlag = false;
var browserInfo = navigator.userAgent;

/*
 * 페이지뷰데이터 전송시 맞춤측정기준데이터 함께 전송
 * 맞춤측정기준데이터는 모든페이지 적용
*/

function setGaPageViewObj(cuDimensionObj){  
	
	var pvdmObj = new Object();

	//페이지뷰
	var gaTitle = document.title;	//페이지제목및화면이름 엑셀 > 화면이름으로 업무담당자가 해당 화면 <title>에 적용한 값
	pvdmObj.title = gaTitle;		//페이지뷰

	
	//맞춤측정정보 셋팅(각 담당자가 데이터셋팅 로직개발)
    //방문_채널유형
    if(isMobile == "N"){
        pvdmObj.dimension12 = 'PC_WEB';
    }else if(isApp == "Y"){
        pvdmObj.dimension12 = 'APP';
        pvdmObj.dimension15 = window.location.href; //페이지_하이브리드url - App Native 화면 내 하이브리드 영역에서만 적용
    }else{
        pvdmObj.dimension12 = 'MO_WEB';
    }
    
    pvdmObj.dimension13 = '현대식품관투홈';    //방문_사이트명
    if(typeof viewType !== 'undefined' && viewType == 'spexSect' && sectId != null){
        pvdmObj.dimension28 = sectId;    //페이지_기획전코드
    }

	
    var url = window.location.href;
	var urlSplit = url.split('/');
	
	if((new URL(url)).searchParams.get('evntNo') != null){
		pvdmObj.dimension16	= (new URL(url)).searchParams.get('evntNo');	//페이지_이벤트코드
	}
	if((new URL(url)).searchParams.get('mgzNo') != null){
		pvdmObj.dimension29	= (new URL(url)).searchParams.get('mgzNo');		//페이지_매거진코드
	}
	
	
	pvdmObj.dimension25 = '';	//검색_검색어
	pvdmObj.dimension26 = '';	//검색_검색유형
	pvdmObj.dimension27 = '';	//검색_결과수

	//고객변수 세팅
	if(cuDimensionObj != null)
	{
		pvdmObj.dimension1 = cuDimensionObj.cuCid;		//고객_CID
		pvdmObj.dimension14 = cuDimensionObj.cuLoginYN;	//방문_로그인여부
		
		if(cuDimensionObj.cuLoginYN == 'Y')
		{
			pvdmObj.dimension2 = cuDimensionObj.cuUid;	//고객_UID
			pvdmObj.dimension5 = cuDimensionObj.cuSex;	//고객_성별
			pvdmObj.dimension6 = cuDimensionObj.cuAge;	//고객_연령
			
			pvdmObj.dimension7 = cuDimensionObj.cuTcpGrdNm;		//고객_TCP등급(대)
			pvdmObj.dimension8 = cuDimensionObj.cuTCPGrdCd;		//고객_TCP등급코드
			pvdmObj.dimension51 = cuDimensionObj.cuJasminBLCK;	//고객_쟈스민블랙코드
			pvdmObj.dimension52 = cuDimensionObj.cuJasmiinBL;	//고객_쟈스민블루코드
			
			pvdmObj.dimension9 = cuDimensionObj.cuLoc;				//고객_지역
			pvdmObj.dimension10 = cuDimensionObj.cuLoginGubun;		//고객_회원구분(로그인상태)
			pvdmObj.dimension11 = cuDimensionObj.cuStaffYN;			//고객_임직원여부
			pvdmObj.dimension17 = cuDimensionObj.cuPushYN;			//알림_푸쉬알림_수신여부
			pvdmObj.dimension18 = cuDimensionObj.cuAdPushYN;		//알림_광고푸쉬알림_수신여부
			
			pvdmObj.dimension19 = cuDimensionObj.cuStateGubun;		//고객_회원구분(회원상태)
			pvdmObj.dimension21 = cuDimensionObj.cuAutoLoginYN;		//고객_자동로그인_설정여부	
			
			if(cuDimensionObj.cuLoginGubunCd == "U")
			{
				pvdmObj.dimension3 = cuDimensionObj.cuHId;			//고객_통합멤버십회원ID -> 통합고객번호
				pvdmObj.dimension22 = cuDimensionObj.cuHRegDtm;		//고객_통합회원가입일자
			}
			else if(cuDimensionObj.cuLoginGubunCd == "C")
			{
				pvdmObj.dimension4 = cuDimensionObj.cuRegDtm;		//고객_일반회원가입일자
			}
			else if(cuDimensionObj.cuLoginGubunCd == "K")
			{
				pvdmObj.dimension20 = cuDimensionObj.cuSnsGubun;	//고객_간편로그인유형
			}
			
			pvdmObj.dimension23 = cuDimensionObj.cuItntGrd;			//고객_현대식품관투홈등급
			pvdmObj.dimension24 = cuDimensionObj.cuMaketingRcvYN;	//마케팅_마케팅수신동의여부
			pvdmObj.dimension30 = cuDimensionObj.cuOrdYN;			//고객_고매여부
			
			if(cuDimensionObj.cuOrdYN == 'Y')
			{
				pvdmObj.dimension31 = cuDimensionObj.cuRcntOrdDtm;	//고객_최근구매일
				pvdmObj.dimension32 = cuDimensionObj.cuOrdCnt;		//고객_구매회수
				pvdmObj.dimension33 = cuDimensionObj.cuOrdAmt;		//고객_구매금액대
			}
		}
	}
	
	//상품변수 세팅
//	pvdmObj.dimension35	= '';	//상품_구매처
//	pvdmObj.dimension36	= '';	//상품_88코드
//	pvdmObj.dimension37	= '';	//상품_구매서비스유형
//	pvdmObj.dimension38	= '';	//상품_구매방법
//	pvdmObj.dimension39	= '';	//상품_브랜드명
//	pvdmObj.dimension40	= '';	//상품_협력사명
//	pvdmObj.dimension41	= '';	//상품_카테고리명
//	pvdmObj.dimension42	= '';	//상품_유형
//	pvdmObj.dimension43	= '';	//상품_점포면
//	pvdmObj.dimension44	= '';	//상품_MD코드
	//주문변수 세팅
//	pvdmObj.dimension34	= '';	//고객_구매지역 (주문완료 시, 데이터 전송)
//	pvdmObj.dimension45	= '';	//주문_주결제수단
//	pvdmObj.dimension46	= '';	//주문_구매방법
//	pvdmObj.dimension47	= '';	//주문_선물하기
//	pvdmObj.dimension48	= '';	//주문_배송지

	console.log(pvdmObj);
	
	return pvdmObj
}


function Convert_Element(RemoveValue){
	var return_Value = new Object();
    for(key in RemoveValue){
      if(RemoveValue[key] === "" || RemoveValue[key] === undefined || RemoveValue[key] === null){
        delete RemoveValue[key]
      }
    }
    return_Value = RemoveValue;
    return return_Value
}

  
function Hybrid(GADATA){
    var emptyObject = JSON.parse(JSON.stringify(Convert_Element(CommonData)));
    emptyObject = $.extend(emptyObject, Convert_Element(GADATA))
    if (browserInfo.indexOf(AndroidWebview) > -1) window.gascriptAndroid.GA_DATA(JSON.stringify(emptyObject));
    else if (browserInfo.indexOf(iOS_Webview_WK) > -1) webkit.messageHandlers.gascriptCallbackHandler.postMessage(JSON.stringify(emptyObject));  
}

  
function GADataScreen(Object){
	try {
	    CommonData = Object;
	    if(browserInfo.indexOf(iOS_Webview_WK) > -1 || browserInfo.indexOf(AndroidWebview) > -1){ 
	      CommonData.type = "screen"
	      Hybrid(CommonData); 
	    }
	    else{ 
	    dataLayer = [CommonData]; 
	    (function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
	    new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
	    j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
	    'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	    })(window,document,'script','dataLayer','GTM-5X5C4H3');
	    }
	} catch(e) {
		console.log(e);
	}
}
  
  
function GA_Event(category, action, label, dimension11, dimension12){
	try {
		if(browserInfo.indexOf(iOS_Webview_WK) > -1 || browserInfo.indexOf(AndroidWebview) > -1){ 
			var GAData = new Object();
			GAData.category = category.replace("MO_", "APP_");
			GAData.action = action;
			GAData.label = label;
			GAData.type = "event"
				Hybrid(GAData); 
		}else{
			if(typeof dataLayer != 'undefined'){
				dataLayer.push({
					"event" : "ga_event",
					"category" : category,
					"action" : action,
					"label" : label
				});
			}
		}
		console.log(category +'|'+ action +'|'+ label);
	} catch(e) {
		console.log(e);
	}
}


function EcommerceSet(E_step, Products, actionList, addDimension){
	try {
		  if (browserInfo.indexOf(iOS_Webview_WK) > -1 || browserInfo.indexOf(AndroidWebview) > -1) {
			var APPData = new Object();
			APPData.EcommerceStep = E_step;
			APPData.type = 'ecommerce';
			APPData.Products = Products;
			APPData.transaction = actionList;
			APPData.transaction.currencyCode = "KRW"
			APPData = $.extend(APPData, addDimension);
			Hybrid(APPData)
		} else {
			var EcommerceData = new Object();
			var Ecommerce = new Object();
			var EcommerceStep = E_step;

			EcommerceData = $.extend({}, addDimension);
			EcommerceData.event = 'ga_ecommerce';
			EcommerceData.category = 'Ecommerce';
			EcommerceData.action = E_step;

			Ecommerce[EcommerceStep] = {
				actionField : {},
				products : []
			}
			Ecommerce[EcommerceStep].products = Products;
			Ecommerce[EcommerceStep].actionField = actionList;
			Ecommerce.currencyCode = "KRW"

			EcommerceData.ecommerce = Ecommerce;
			dataLayer.push(EcommerceData)
			dataLayer.push({
				'category' : undefined,
				'action' : undefined,
				'ecommerce' : undefined,
				'nonInteraction' : undefined
			})
		}
	} catch(e) {
		console.log(e);
	}
}


