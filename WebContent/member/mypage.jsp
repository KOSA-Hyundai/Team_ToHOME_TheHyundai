<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>마이페이지</title>
<link rel="stylesheet" type="text/css" href="css/member/mypage.min.css" />
</head>
<body>
	<div id="wrap" class="mypage mypage main">
		<div id="contents">
			<div class="innercon">
				<section class="lnbarea">
					<h2>마이페이지</h2>
					<ul>
						<li class="lnb-depth1"><a href="#">주문관리</a>
							<ul class="lnb-depth2">
								<li><a href="#">주문 내역</a></li>
								<li><a href="#">주문취소</a></li>
								<li><a href="#">반품/교환</a></li>
								<li><a href="#">대량주문 문의</a></li>
								<li><a href="#">투홈구독</a></li>
								<li><a href="#">정기배송 설정</a></li>
							</ul></li>

						<li class="lnb-depth1"><a href="#">쇼핑 혜택</a>
							<ul class="lnb-depth2">
								<li><a href="#">쿠폰</a></li>
								<li><a href="#">H.Bonus</a></li>
								<li><a href="#">투홈패스</a></li>
								<li><a href="#">H.Point</a></li>
								<li><a href="#">상품권 전환금</a></li>
							</ul></li>
						<li class="lnb-depth1"><a href="#">나의 활동</a>
							<ul class="lnb-depth2">
								<li><a href="#">리뷰</a></li>
								<li><a href="#">좋아요</a></li>
								<li><a href="#">최근 본 상품</a></li>
								<li><a href="#">1:1 문의내역</a></li>
								<li><a href="#">매거진 보관함</a></li>
								<li><a href="#">늘 필요한 상품</a></li>
								<li><a href="#">이벤트 참여현황</a></li>
								<li><a href="#">투홈백 관리</a></li>
								<li><a href="#">재입고 알림</a></li>
							</ul></li>
						<li class="lnb-depth1"><a href="#">나의 정보</a>
							<ul class="lnb-depth2">
								<li><a href="#">회원정보 변경</a></li>
								<li><a href="#">배송지 관리</a></li>
								<li><a href="#">로그인 기록</a></li>
								<li><a href="#">H.Point Pay</a></li>
								<li><a href="#">HomePay</a></li>
								<li><a href="#">개인정보 이용현황</a></li>
								<li><a href="#">환불계좌/현금영수증</a></li>
								<li><a href="#">임직원 인증</a></li>
								<li><a href="#">차량 등록</a></li>
							</ul></li>

					</ul>
				</section>
				<section class="conarea">
					<h3 class="hide">마이페이지</h3>
					<section class="mystate-section">
						<div class="myinfo">
							<div class="memclass normal">
								<div class="cont">
									<strong class="name">${sessionScope.loginUser.name}</strong>
									<ul>
										<li><a href="#" class="btn-line">회원정보</a></li>
										<li><a href="#" class="btn-line">멤버십 혜택</a></li>
									</ul>
								</div>
							</div>
						</div>
						<div class="point">
							<ul>
								<li><a href="#">
										<div class="inner">
											<strong><span>3</span>장</strong> 쿠폰
										</div>
								</a></li>
								<li><a href="#">
										<div class="inner">
											<strong><span id="curHBonus">10800</span>B</strong> H.Bonus
										</div>
								</a></li>
								<li><a href="#">
										<div class="inner">
											<strong><span id="upointCurAmt">8800</span>P</span></strong> H.Point
										</div>
								</a></li>
								<li><a href="#">
										<div class="inner">
											<strong><span id="curAmt">0</span>원</span></strong> 상품권 전환금
										</div>
								</a></li>
								<li><a href="#">
										<div class="inner">
											<strong><span>0</span>건</span></strong> 상품리뷰
										</div>
								</a></li>
							</ul>
						</div>
					</section>
					<section class="like-section">
						<header class="header">
							<h4>
								<span>좋아요 </span><strong>0</strong>
							</h4>
						</header>
						<div class="nodata">좋아요한 상품이 없습니다.</div>
					</section>
				</section>
			</div>
		</div>
	</div>
</body>
</html>