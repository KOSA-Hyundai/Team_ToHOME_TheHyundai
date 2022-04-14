<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>  
<div id="contents">
	<!-- //메인 슬라이드 배너 -->
	<section class="mainbanner">
		<div class="swiper-container mainbannerswiper swiper-container-horizontal">
			<div class="swiper-wrapper" style="transform: translate3d(-20638px, 0px, 0px); transition-duration: 300ms;">
				<div class="swiper-slide" data-swiper-slide-index="0" style="margin-right: 10px;">
					<a href="" onclick=""><img src="images/main/main_banner_00.jpg" alt=""></a>
				</div>
				<div class="swiper-slide" data-swiper-slide-index="1" style="margin-right: 10px;">
					<a href="" onclick=""><img src="images/main/main_banner_01.png" alt=""></a>
				</div>
				<div class="swiper-slide" data-swiper-slide-index="2" style="margin-right: 10px;">
					<a href="" onclick=""><img src="images/main/main_banner_02.jpg" alt=""></a>
				</div>
				<div class="swiper-slide" data-swiper-slide-index="3" style="margin-right: 10px;">
					<a href="" onclick=""><img src="images/main/main_banner_03.jpg" alt=""></a>
				</div>
				<div class="swiper-slide" data-swiper-slide-index="4" style="margin-right: 10px;">
					<a href="" onclick=""><img src="images/main/main_banner_04.jpg" alt=""></a>
				</div>																
			</div>
			<div class="inneron">
				<div class="swiper-pagination-tot"><strong>12</strong> / <span>16</span></div>
				<a href="#" class="btn-play active">재생/일시정지</a>
			</div>
			<span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span>
		</div>
	</section>
	<!-- 메인 슬라이드 배너// -->
	
	<!-- //메인 띠 배너 1 -->
	<section class="innercon exhibition aos-init aos-animate" data-aos="fade-up">
		<ul class="exhibition-ban">
			<li>
				<a href="" onclick=""><img src="https://tohomeimage.thehyundai.com/DP/DP034/2021/11/01/104726/lqgpp.jpg?RS=1204x160" alt=""></a>
			</li>
		</ul>
	</section>
	<!-- 메인 띠 배너 1// -->
	
	<!-- //메인 띠 배너 2 -->
	<section class="innercon exhibition aos-init aos-animate" data-aos="fade-up">
		<ul class="exhibition-ban">
			<li>
				<a href="" onclick=""><img src="https://tohomeimage.thehyundai.com/DP/DP034/2022/04/04/145725/avlaf.jpg?RS=1204x160" alt=""></a>
			</li>
		</ul>
	</section>
	<!-- 메인 띠 배너 2// -->
	
	<!-- //상품 미리보기 1 -->
	<section class="innercon category aos-init" data-aos="fade-up">
		<h2><strong style="color:;font-weight:">${categoryList[7].bigCategory}</strong><a href="HyundaiServlet?command=productList&bigCtryId=${categoryList[7].bigId}&smallCtryId&sortType" onclick="" class="btn all">${categoryList[7].bigCategory} 전체보기</a></h2>
		<div class="swiper-container categoryswiper swiper-container-horizontal swiper-container-autoheight">
			<div class="swiper-wrapper" style="height: 331px; transform: translate3d(0px, 0px, 0px);">
				<div class="swiper-slide" style="width: 1204px; margin-right: 10px;">
					<ul class="product-list big">
						<c:forEach items="${productList}" var="productVO">
							<li>
								<a href="HyundaiServlet?command=product_detail&id=${productVO.id}">
									<span class="thumb"><img src="${productVO.prodImg}" alt="HyundaiServlet?command=product_detail&id=${productVO.id}" onerror="this.src='/UIUX/m/pjtCom/images/common/noimage_350x420.jpg'">
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
									</span><strong class="txt-ti ellipsis">${productVO.prodName}</strong>
								</a>
								<span class="info">
									<span class="txt-price">
										<c:choose> 
											<c:when test="${productVO.discount == 0}">
												<strong><em><fmt:formatNumber type="number" value="${productVO.price}"/></em>원</strong>												
											</c:when>
											<c:otherwise>
												<strong><em><fmt:formatNumber type="number" maxFractionDigits="0" value="${productVO.price - productVO.price*(productVO.discount/100)}"/></em>원</strong><del>${productVO.price}</del>
											</c:otherwise>
										</c:choose>
									</span>
								</span>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>											
	</section>
	<!-- 상품 미리보기 1// -->
	
	<!-- //상품 미리보기 2 -->
	<section class="innercon category aos-init" data-aos="fade-up">
		<h2><strong style="color:;font-weight:">${categoryList[41].bigCategory}</strong><a href="HyundaiServlet?command=productList&bigCtryId=${categoryList[41].bigId}&smallCtryId&sortType" onclick="" class="btn all">${categoryList[41].bigCategory} 전체보기</a></h2>
		<div class="swiper-container categoryswiper swiper-container-horizontal swiper-container-autoheight">
			<div class="swiper-wrapper" style="height: 331px; transform: translate3d(0px, 0px, 0px);">
				<div class="swiper-slide" style="width: 1204px; margin-right: 10px;">
					<ul class="product-list big">
						<c:forEach items="${productList2}" var="productVO">
							<li>
								<a href="HyundaiServlet?command=product_detail&id=${productVO.id}">
									<span class="thumb"><img src="${productVO.prodImg}" alt="" onerror="this.src='/UIUX/m/pjtCom/images/common/noimage_350x420.jpg'">
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
									</span><strong class="txt-ti ellipsis">${productVO.prodName}</strong>
								</a>
								<span class="info">
									<span class="txt-price">
										<c:choose> 
											<c:when test="${productVO.discount == 0}">
												<strong><em><fmt:formatNumber type="number" value="${productVO.price}"/></em>원</strong>												
											</c:when>
											<c:otherwise>
												<strong><em><fmt:formatNumber type="number" maxFractionDigits="0" value="${productVO.price - productVO.price*(productVO.discount/100)}"/></em>원</strong><del>${productVO.price}</del>
											</c:otherwise>
										</c:choose>
									</span>
								</span>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>																	
	</section>
	<!-- 상품 미리보기 2// -->	
</div>
<%@ include file="../footer.jsp" %> 
