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
				<a href="" onclick="GA_Event('PC_새벽투홈_메인', '직각배너','오늘의 추천상품이 궁금하다면');"><img src="https://tohomeimage.thehyundai.com/DP/DP034/2021/11/01/104726/lqgpp.jpg?RS=1204x160" alt=""></a>
			</li>
		</ul>
	</section>
	<!-- 메인 띠 배너 1// -->
	
	<!-- //메인 띠 배너 2 -->
	<section class="innercon exhibition aos-init aos-animate" data-aos="fade-up">
		<ul class="exhibition-ban">
			<li>
				<a href="" onclick="GA_Event('PC_새벽투홈_메인', '직각배너','오늘의 추천상품이 궁금하다면');"><img src="https://tohomeimage.thehyundai.com/DP/DP034/2022/04/04/145725/avlaf.jpg?RS=1204x160" alt=""></a>
			</li>
		</ul>
	</section>
	<!-- 메인 띠 배너 2// -->
	
	<!-- //상품 미리보기 1 -->
	<section class="innercon category aos-init" data-aos="fade-up">
		<h2><strong style="color:;font-weight:">아기와 어린이</strong><a href="" onclick="" class="btn all">${productList[0].id} 전체보기</a></h2>
		<div class="swiper-container categorytitleswiper swiper-container-horizontal">
			<div class="swiper-wrapper">
				<div class="swiper-slide" onclick="" style="margin-right: 36px;">유아용품</div>
				<div class="swiper-slide" onclick="" style="margin-right: 36px;">장난감 · 완구</div>
				<div class="swiper-slide" onclick="" style="margin-right: 36px;">장난감 · 완구</div>
				<div class="swiper-slide" onclick="" style="margin-right: 36px;">어린이 간식 · 음료</div>
			</div>
			<div class="swiper-pagination-categorytitle swiper-pagination-clickable swiper-pagination-bullets">
				<span class="swiper-pagination-bullet swiper-pagination-bullet-active" tabindex="0" role="button" aria-label="Go to slide 1"></span>
			</div>
			<span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span>
		</div>
		<div class="swiper-container categoryswiper swiper-container-horizontal swiper-container-autoheight">
			<div class="swiper-wrapper" style="height: 331px; transform: translate3d(0px, 0px, 0px);">
				<div class="swiper-slide" style="width: 1204px; margin-right: 10px;">
					<ul class="product-list big">
						<c:forEach items="${productList}" var="productVO">
							<li>
								<a href="">
									<span class="thumb"><img src="${productVO.prodImg}" alt="" onerror="this.src='/UIUX/m/pjtCom/images/common/noimage_350x420.jpg'">
										<div class="badgewrap">
											<span class="badge"><strong></strong></span>
										</div>
									</span><strong class="txt-ti ellipsis">${productVO.prodName}</strong>
								</a>
								<span class="info">
									<span class="txt-price">
										<c:choose> 
											<c:when test="${productVO.discount == 0}">
												<strong><em>${productVO.price}</em>원</strong>												
											</c:when>
											<c:otherwise>
												<strong><em></em>원</strong><del>${productVO.price}</del>
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
		<h2><strong style="color:;font-weight:">아기와 어린이</strong><a href="" onclick="" class="btn all">아기와 어린이 전체보기</a></h2>
		<div class="swiper-container categorytitleswiper swiper-container-horizontal">
			<div class="swiper-wrapper">
				<div class="swiper-slide" onclick="" style="margin-right: 36px;">유아용품</div>
				<div class="swiper-slide" onclick="" style="margin-right: 36px;">장난감 · 완구</div>
				<div class="swiper-slide" onclick="" style="margin-right: 36px;">장난감 · 완구</div>
				<div class="swiper-slide" onclick="" style="margin-right: 36px;">어린이 간식 · 음료</div>
			</div>
			<div class="swiper-pagination-categorytitle swiper-pagination-clickable swiper-pagination-bullets">
				<span class="swiper-pagination-bullet swiper-pagination-bullet-active" tabindex="0" role="button" aria-label="Go to slide 1"></span>
			</div>
			<span class="swiper-notification" aria-live="assertive" aria-atomic="true"></span>
		</div>
		<div class="swiper-container categoryswiper swiper-container-horizontal swiper-container-autoheight">
			<div class="swiper-wrapper" style="height: 331px; transform: translate3d(0px, 0px, 0px);">
				<div class="swiper-slide" style="width: 1204px; margin-right: 10px;">
					<ul class="product-list big">
						<li>
							<a href="">
								<span class="thumb"><img src="https://tohomeimage.thehyundai.com/PD/PDImages/S/6/1/5/4973655410516_00.JPG?RS=350x420" alt="" onerror="this.src='/UIUX/m/pjtCom/images/common/noimage_350x420.jpg'">
									<div class="badgewrap">
										<span class="badge"><strong>25%</strong></span>
									</div>
								</span><strong class="txt-ti ellipsis">[릿첼] AQ 첫걸음 드링킹 타입 (라이트블루)</strong>
							</a>
							<span class="info">
								<span class="txt-price">
									<strong><em>10,120</em>원</strong><del>13,500</del>
								</span>
							</span>
						</li>
						<li>
							<a href="">
								<span class="thumb"><img src="https://tohomeimage.thehyundai.com/PD/PDImages/S/6/1/5/4973655410516_00.JPG?RS=350x420" alt="" onerror="this.src='/UIUX/m/pjtCom/images/common/noimage_350x420.jpg'">
									<div class="badgewrap">
										<span class="badge"><strong>25%</strong></span>
									</div>
								</span><strong class="txt-ti ellipsis">[릿첼] AQ 첫걸음 드링킹 타입 (라이트블루)</strong>
							</a>
							<span class="info">
								<span class="txt-price">
									<strong><em>10,120</em>원</strong><del>13,500</del>
								</span>
							</span>
						</li>
						<li>
							<a href="">
								<span class="thumb"><img src="https://tohomeimage.thehyundai.com/PD/PDImages/S/6/1/5/4973655410516_00.JPG?RS=350x420" alt="" onerror="this.src='/UIUX/m/pjtCom/images/common/noimage_350x420.jpg'">
									<div class="badgewrap">
										<span class="badge"><strong>25%</strong></span>
									</div>
								</span><strong class="txt-ti ellipsis">[릿첼] AQ 첫걸음 드링킹 타입 (라이트블루)</strong>
							</a>
							<span class="info">
								<span class="txt-price">
									<strong><em>10,120</em>원</strong><del>13,500</del>
								</span>
							</span>
						</li>	
					</ul>
				</div>
			</div>
		</div>																	
	</section>
	<!-- 상품 미리보기 2// -->	
</div>
<%@ include file="../footer.jsp" %> 
