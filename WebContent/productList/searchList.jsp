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
    					<span class="word" id="titleName"><b style="color:orange; font-size:25px">'<%= request.getParameter("productName") %>'</b></span> 검색결과 
    					<em id="titleCnt" style="color:black;">${fn:length(searchList)}</em>건</strong>
				</section>			
				<ul class="product-list" id="ulItemList">

				  <c:forEach items="${searchList}" var="productVO">
					<li>
						<a href="HyundaiServlet?command=product_detail&id=${productVO.id}">						
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