<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko">
<%@ include file="../detailHeader.jsp"%>
<head>
    <!-- 상품 공통 태그 -->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=chrome">
    <meta name="format-detection" content="telephone=no, email=no, address=no">
    <!-- // 상품 공통 태그 -->
	<meta http-equiv="X-UA-Compatible" content="IE=chrome">
	<meta name="viewport" content="width=device-width, iniial-scale=1.0, maximum-scale=1.0, viewport-fit=cover">

<!-- 상품 상세 태그 -->

<title>상품상세&gt;"${productList[0].prodName}"</title><%--prod_name --%>

<script type="text/javascript">
<script src="/js/sso/SsoHttpRequest.js?ver=041114"></script>
<script src="/js/sso/SsoAjax.js?ver=041114"></script>
<script type="text/javascript" src="/js/main/product.share.js?ver=14"></script>


<!-- 아래부터 body 시작 -->
    
    <!-- body -->
    <!-- 상품 공통 -->
    <link rel="stylesheet" type="text/css" href="/css/main/s-style_v2.min.css">
    <script type="text/javascript" src="/js/main/slazy_v2.min.js"></script>

    <link rel="stylesheet" type="text/css" href="/css/productList/product.min.css">
    <script type="text/javascript" src="/js/productList/product.min.js?ver=1649653322184"></script>

    <script type="text/javascript" src="/js/main/jquery.cookie.js?ver=14"></script>
    <!-- // 상품 공통 -->
   </head> 
<body>
  
<script type="text/javascript" src="/js/productList/product.detail.pc.js?ver=1649653322184"></script>

    <div id="wrap" class="product detail">
        <!-- header// -->
        <!--begin:ca-exclude-->
  
<script type="text/javascript" src="/js/main/product.search.pc.init.js?ver=14"></script>
<script type="text/javascript" src="/js/main/jquery.cookie.js"></script>
<script type="text/javascript"> </script> 

<!-- header// -->
<!--  
<header id="header">
</header>
-->
<!-- //header -->

<!-- contents// -->
<div id="contents">
    <div class="innercon">
        <section class="proinfo-area">
            <!-- propic// -->
            <div class="propic">
                <div class="propicbig">
                    
                            <!-- 이미지가 있을 경우 첫번째 이미지를 넣어줌. -->
                            
                                            <img data-zoom-image="" src="${productList[0].prodImg}" onerror="${productList[0].prodImg}">
                               
                </div>
                
                <div class="propicsmall">
                    <div class="swiper-pagination-propic"><span class="current"></span>  <span class="total"></span></div>
                    <div class="swiper-button-next-propic"></div>
                    <div class="swiper-button-prev-propic"></div>
                    <div class="swiper-container propicsmallswiper">
                        <div id="P_picSmall" class="swiper-wrapper">
                     
                                    <%-- 
                                        <div class="swiper-slide">
                                        <a href="#" data-image="https://tohomeimage.thehyundai.com/PD/PDImages/S/9/9/7/8806079687799_00.jpg?RS=720x864" data-zoom-image="https://tohomeimage.thehyundai.com/PD/PDImages/S/9/9/7/8806079687799_00.jpg?RS=1500x1800">
                                        <img src="https://tohomeimage.thehyundai.com/PD/PDImages/S/9/9/7/8806079687799_00.jpg?RS=720x864" onerror="this.src='/UIUX/m/pjtCom/images/common/noimage_350x420.jpg'">
                                        </a></div>    --%>                             
                        </div>
                    </div>
                </div>
            </div>
            <!-- //propic -->
            
            <!-- proinfo// -->
            <div class="proinfo">
				<h2>
					<strong>${productList[0].prodName}</strong>
					
					
						<small>${productList[0].prodDetail}<small>
					
					
				</h2>

				<!-- 레이블 -->
               
                <!-- 가격(fnPDSetPriceSection)  -->
                <div class="price" id="price_section">
                <span class="txt-price">
					<strong><em>${productList[0].price}</em>원</strong>
				</span>
                </div>

                <div class="detailinfo">
                    <dl>
                    
                            <!-- 선물배송은 원산지, 포장타입, 알레르기 정보 안나옴.  -->
                            
                                
                                    <dt>원산지</dt>
                                    <dd>
                                        ${productList[0].origin}
                                    </dd>                       
                                
                                        <dt>포장타입</dt>
                                        <dd>
                                            ${productList[0].packageType}
                                            
                                        </dd>  
                                     
	                            <dt>추가 혜택가</dt>
	                            <dd >
	                                <strong id="benefit_title1"><em>0</em>원</strong>
	                                <!-- <button type="button" class="btn-linedown btn-salecard" onclick="fn.popupOpen('#p_popSaleCard');" id="benefit_title2"></button>-->
	                                <!--<button type="button" class="btn-linedown btn-freecard" onclick="fn.popupOpen('#p_popFreeCard');">무이자 할부</button>  나중에 개발 -->
	                            </dd>
	                            <dt>배송형태</dt>
	                            <dd id="deliverySection">    새벽배송 / 밤 11시까지 결제 시<br>
									배송비 3,500원 (5만원 이상 구매 시 무료)<br>
								<%-- <button type="button" class="btn-linedown btn-deliveryinfo" onclick="fn.popupOpen('#p_popDeliveryInfo');">배송안내</button>--%>
								</dd>
                            	<dt>상품선택</dt>
                            	<dd>
                            <!-- 상품선택// start-->
                            <div class="optionarea" id="top_optionarea"><div class="optionls">
    			<div>
    		<strong class="txt-ti">${productList[0].prodName}
    		</strong>
    		<div class="ea-area">
        		<input type="number" title="수량 입력" value="1" readonly="">
        		<button type="button" class="btn-down" onclick="fnOptionEaDown(this);">수량 낮추기</button>
        		<button type="button" class="btn-up" onclick="fnOptionEaUp(this);">수량 올리기</button>
    </div>
    		<span class="txt-price"><em>${productList[0].price}</em>원</span>
    	</div>
	</div>
</div>
                        </dd>
                            
                </div>
                
                <!-- buybutton 상단(p_popCartAdd) 작업중 // -->
                <div class="buybutton" id="top_buybutton">
                  
                            <p class="txt-total">총 금액 <strong><em>${productList[0].price}</em>원</strong></p>
                        
                    <div class="btns">
	                                                <button type="button" class="btn orange bigger btn-buy" onclick="fnPopupScaleOpenA(this, '#p_popCartAdd');">장바구니</button>
	                                                <button type="button" class="btn fill orange bigger btn-buy" onclick="fnPopupScaleOpenB(this, '');">바로구매</button>                                                
                    </div>                 
                </div>
                <!-- //buybutton -->
            </div>
            </div>
            <!-- //proinfo -->
        </section>
        
        <div class="prodetailcont" style="min-height: 339px;">
            
            <div class="prodetail-area">
            
                <!-- tabs// -->
                <div class="tab-menu protabs" style="position: relative; inset: 40px 40px ;">
                    <a href="#p_proReview" class ="active" style="width: 25%;"><span>리뷰 <em id="reviewCnt"></em></span></a>
                <div class="select review menu" style="position: absolute;">    
                   <table align="center">
                   <tr width="200" height="200">
                    <td><button type="button" class="btn fill black middle btn-confirm" onclick="location.href='/HyundaiServlet?command=review_form'";>리뷰 작성</button></td>
                    <td><button type="button" class="btn fill black middle btn-confirm" onclick="location.href='/HyundaiServlet?command=review_list&prod_id=${productList[0].id}'">리뷰 조회</button></td>
                    <td><button type="button" class="btn fill black middle btn-confirm" onclick="fnReviewSave();">리뷰 수정</button></td>
                    <td><button type="button" class="btn fill black middle btn-confirm" onclick="fnReviewSave();">리뷰 삭제</button></td>
                </div></table>
                <!-- //tabs -->            
                
                <!-- 리뷰// -->
                <section id="p_proReview" class="tab-contents proreview">
                    <h3 class="hide"><strong>리뷰</strong></h3>
                    
                    <div class="list-top"><button type="button" class="btn black btn-review" onclick="fnReviewSelectPopupOpen(this, 'A');">리뷰 작성</button>
</div>

                    <!-- 리뷰 리스트 -->
                    <div class="review-list">
                    <a href="/HyundaiServlet?command=product_detail&id=${productVO.id}
                    <c:forEach var="rev" items="${reviewList}">
                    <ul>
	<li data-no="" data-wrt-id="" data-ord-no="" data-slitm-cd="" data-opt-cd="" data-img-path="" data-contents="" data-img-path1="" data-img-path2="" data-img-path3="" data-slitm-nm="" data-slitm-desc="" data-atfl-no="" data-scrg="">
    <div class="recont">
        <div class="ti">
            <span class="txt-option">
            
            </span>
            <span class="txt-review">${rev.contents}</span>
        </div>
    </div>
        <div class="info">
            <span class="txt-id"></span>
            <span class="txt-date">${rev.create_date}</span>
        </div>
</li>
<li data-no="" data-wrt-id="" data-ord-no="" data-slitm-cd=${productList[0].id} data-opt-cd="" data-img-path="" data-contents="" data-img-path1="" data-img-path2="" data-img-path3="" data-slitm-nm="" data-slitm-desc="" data-atfl-no="" data-scrg="">
    <div class="recont">
        <div class="ti">
            <span class="txt-option">
            
            </span>
            <span class="txt-review"></span>
        </div>
    </div>
        <div class="info">
            <span class="txt-id"></span>
            <span class="txt-date"></span>
        </div>
     
</li>
<li data-no="" data-wrt-id="" data-ord-no="" data-slitm-cd="" data-opt-cd="" data-img-path="" data-contents="" data-img-path1="" data-img-path2="" data-img-path3="" data-slitm-nm="" data-slitm-desc="" data-atfl-no="" data-scrg="">
    <div class="recont">
        <div class="ti">
            <span class="txt-option">
            
            </span>
            <span class="txt-review"></span>
        </div>
    </div>
        <div class="info">
            <span class="txt-id"></span>
            <span class="txt-date"></span>
        </div>
</li>
<li data-no="" data-wrt-id="" data-ord-no="" data-slitm-cd="" data-opt-cd="" data-img-path="" data-contents="" data-img-path1="" data-img-path2="" data-img-path3="" data-slitm-nm=${productList[0].prodName} data-slitm-desc="" data-atfl-no="" data-scrg="">
    <div class="recont">
        <div class="ti">
            <span class="txt-option">
            
            </span>
            <span class="txt-review"></span>
        </div>
    </div>
        <div class="info">
            <span class="txt-id"></span>
            <span class="txt-date"></span>
        </div>
</li>
	</ul>
	</c:forEach>
</div>
                    
                </section>
            </div>
             
            <div class="rightarea" id="bottom_rightarea" style="position: absolute; inset: 0px 0px auto auto;"><div class="optionarea">
    <div class="optionls">
         <div>
             <strong class="txt-ti">${productList[0].prodName}
             </strong>
             <div class="ea-area">
                 <input type="number" title="수량 입력" value="1" readonly="">
                 <button type="button" class="btn-down" onclick="fnOptionEaDown(this);">수량 낮추기</button>
                 <button type="button" class="btn-up" onclick="fnOptionEaUp(this);">수량 올리기</button>
             </div>
             <span class="txt-price"><em>${productList[0].price}</em>원</span>
         </div>
    </div>
</div> 
<div class="buybutton">
    <p class="txt-total">총 금액 <strong><em>${productList[0].price}</em>원</strong></p>
    <div class="btns">
        <button type="button" class="btn orange bigger btn-buy" onclick="fnPopupScaleOpenA(this, '#p_popCartAdd');">장바구니</button>
        <button type="button" class="btn fill orange bigger btn-buy" onclick="fnPopupScaleOpenB(this, '');">바로구매</button>
    </div>
</div>
</div>
        </div>
 
    </div>
</div>
<!-- //contents -->

<!-- footer// -->

<!-- //footer -->
 
    </div>
</body>


</html>

