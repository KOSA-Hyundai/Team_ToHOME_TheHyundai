<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <article>
	<!-- 새벽배송 공통 js -->
	<div id="wrap2" class="product category" >

		<div id="contents" style = "padding-top: 0px;">
			<div class="innercon" id="reset_section">
				<section class="list-filter">
    				<strong class="txt-total">
    					<span class="word" id="titleName"><b>'<%= request.getParameter("productName") %>'</b></span> 검색결과 
    					<em id="titleCnt">${fn:length(searchList)}</em>건</strong>
				</section>			

				<section class="list-filter">
	                <strong class="txt-total"></strong>
	                <div class="filter-wrapper">
		                <div class="shipping-select active" onchange="fnAddItemList('N');">
		                    <label><input type="radio" name="sort" class="sort" data-active-ti="sort" value="A"><span>새벽배송</span></label>
	                        <label><input type="radio" name="sort" class="sort" data-active-ti="sort" value="C"><span>브랜드직송</span></label>
		                </div>
		                <div class="form-filter">		                		                    
		                    <ul class="btn-group" id="sortType" onchange="fnAddItemList('N');">
		                        <li>    
		                            <div class="popinline recominfo">
		                                <button type="button" class="icon question" onclick="fn.toggleClass('#p_popRecomInfo');">?</button>
		                                <div id="p_popRecomInfo" class="popinner">
		                                    <button type="button" class="btn-close" onclick="fn.toggleClass('#p_popRecomInfo');">닫기</button>
		                                    판매량, 사용자 선호도 등을 고려해 상품을 추천해 드리며, 일부 광고상품이 상단에 노출될 수 있습니다.
		                                </div>
		                            </div>
		                            <button type="button" class="active" onclick="GA_Event('PC_카테고리','정렬방식','정렬_추천순'); fnSortType('A');">추천순</button><!-- 활성화 : class="active" 추가 -->
		                        </li>
		                        <li><button type="button" onclick="GA_Event('PC_카테고리','정렬방식','정렬_인기상품순'); fnSortType('B');">인기상품순</button></li>
		                        <li><button type="button" onclick="GA_Event('PC_카테고리','정렬방식','정렬_신상품순'); fnSortType('C');">신상품순</button></li>
		                        <li><button type="button" onclick="GA_Event('PC_카테고리','정렬방식','정렬_낮은가격순'); fnSortType('D');">낮은가격순</button></li>
		                        <li><button type="button" onclick="GA_Event('PC_카테고리','정렬방식','정렬_높은가격순'); fnSortType('E');">높은가격순</button></li>
		                    </ul>
		                    <button type="button" id="btn_filter" class="btn small black btn-filter" onclick="fn.toggleClass('.btn-filter');fn.toggleClass('.filternav');">필터</button>
		                </div>
		            </div>
	
	             <!-- filternav// -->
	             <div class="filternav">
	                 <div class="scrollbox">
	                     <!--혜택  -->
	                     
	                     <div class="price">
	                         <strong class="ti">가격</strong>
	                         <div class="con form-price" id="priceSelDiv">
	                             <label><input type="radio" name="price" data-active-ti="price" data-value="null, 5000" value=",5000"><span class="btn small balck">~5천원</span></label>
	                             <label><input type="radio" name="price" data-active-ti="price" data-value="5000, 10000" value="5000,10000"><span class="btn small balck">5천원~1만원</span></label>
	                             <label><input type="radio" name="price" data-active-ti="price" data-value="10000, 20000" value="10000,20000"><span class="btn small balck">1~2만원</span></label>
	                             <label><input type="radio" name="price" data-active-ti="price" data-value="20000, 30000" value="20000,30000"><span class="btn small balck">2~3만원</span></label>
	                             <label><input type="radio" name="price" data-active-ti="price" data-value="30000, 40000" value="30000,40000"><span class="btn small balck">3~4만원</span></label>
	                             <label><input type="radio" name="price" data-active-ti="price" data-value="50000, null" value="50000,"><span class="btn small balck">5만원~</span></label>
	                             <span class="txt">직접입력</span>
	                             <input type="number" id="pricemin" name="pricemin" title="최소 가격 입력" placeholder="0" data-active-ti="price" onkeyup="this.value=this.value.replace(/[^0-9]/g, '');">
	                             <span class="txt-won">원 &nbsp; ~ &nbsp; </span>
	                             <input type="number" id="pricemax" name="pricemax" title="최대 가격 입력" placeholder="0" data-active-ti="price" onkeyup="this.value=this.value.replace(/[^0-9]/g, '');">
	                             <span class="txt-won">원</span>
	                         </div>
	                     </div>
	                     <!--브랜드  -->
	                     
	                     <!--배송  -->
	                     <div class="delivery">
	                         <strong class="ti">배송구분</strong>
	                         <div class="con">
	                             <label><input type="radio" name="delivery" data-active-ti="deliverydiv" value="C"><span>정기배송</span></label>
	                             <label><input type="radio" name="delivery" data-active-ti="deliverydiv" value="D"><span>예약배송</span></label>
	                         </div>
	                     </div>
	                 </div>
	
	                <div class="btns">
	                    <button type="button" class="btn black btn-reset" onclick="fn.filterNavReset();">초기화</button>
	                    <button type="button" class="btn fill black btn-apply" onclick="GA_Event('PC_카테고리', '필터', '확인'); fn.toggleClass('.btn-filter');fn.toggleClass('.filternav');">확인</button>
	                </div>
	            </div>
	
	            <div class="select-filter">
	                <div class="con"></div>
	                <button type="button" class="btn small black btn-reset" onclick="fn.filterNavReset();">초기화</button>
	            </div>
	            </section>

				<ul class="product-list" id="ulItemList">

				  <c:forEach items="${searchList}" var="productVO">
					<li>
						<a href="">						
							<span class="thumb">
								<img src="${productVO.prodImg}" alt="" onerror="this.src='/UIUX/m/pjtCom/images/common/noimage_350x420.jpg'">
 								<div class="badgewrap">
											<c:choose> 
												<c:when test="${productVO.discount != 0}">
													<span class="badge"><strong>${productVO.discount}%</strong></span>
												</c:when>
												<c:otherwise>
													<span class="badge"><strong></strong></span>
												</c:otherwise>
											</c:choose> 								                                                            
		                        </div>
							</span>
							<strong class="txt-ti ellipsis">${productVO.prodName}</strong>
						</a>
						<span class="info">
		                    <span class="txt-price">
		                    	<strong>
		                    		<em>
		                    		<fmt:formatNumber value="${productVO.price * (1 - (productVO.discount / 100)) }"
		                    		type="number" pattern="###,###" />		                    		
		                    		</em>
		                    		원
		                   		</strong>
		                   		<del>
         				           <fmt:formatNumber value="${productVO.price}"
		                    		type="number" pattern="###,###" />		                    				                   		
	                   		    </del>
		                 	</span>
		                    <button type="button" class="btn-cart" onclick="javascript:GA_Event('PC_카테고리', '장바구니', '장바구니_[현대쌀집][백미4kg] 골든퀸3호 쌀');fnProductBasketAdd('01', 'S02006002137','102004','110520');">
		                    	장바구니 담기
		                   	</button>
		                </span> 						
					</li>																					 					
				  </c:forEach>
 				</ul>		
			</div>
		</div>
	</div>
</article>
<!-- </body> -->
<%@ include file="../footer.jsp" %>  