<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<title>마이페이지</title>
<style>
.point2 {background:#f3f3f3;overflow:hidden;}
.point2 li {position:relative;float:left;width:20%;height:110px;font-size:13px;line-height:1;color:#aea7a2;}
.point2 li:first-child:after {display:none;}
.point2 li:after {content:"";position:absolute;top:0;left:0;bottom:0;width:1px;height:56px;margin:auto;background:#e5e3e2;}
.point2 li a {display:block;height:100%;text-align:center;}
.point2 li a:after {content:"";display:inline-block;height:100%;vertical-align:middle;}
.point2 li a > .inner {display:inline-block;font-size:13px;color:#aea7a2;vertical-align:middle;}
.point2 li strong {display:block;font-size:15px;color:#101010;margin-bottom:8px;}
.point2 li strong span {display:inline-block;font-family: "Roboto";font-size:24px;margin-right:5px;}
.mystate-section .myinfo .memclass {position: relative;padding: 0 20px;width: 100%;height: 60px;background-color: #fff;color: #101010;font-size: 0;font-weight: 600;font-family: "NotoSansKR";border-radius: 0;}
.mystate-section .myinfo .memclass:after {content: "";display: block;clear: both;}
.mystate-section .myinfo .memclass .cont {display: inline-block;}
.mystate-section .myinfo .memclass strong {margin-top: 18px;display: inline-block;line-height: 1;color: #fff;font-size: 26px;font-family: "Roboto";text-transform: uppercase;vertical-align: top;}
.mystate-section .myinfo .memclass .name {margin-top: 19px;margin-left: 12px;color: #fff;font-size: 22px;font-weight: 600;font-family: "NotoSansKR";text-transform: none;}
.mystate-section .myinfo .memclass .pass {margin-top: 21px;margin-left: 8px;padding: 3px 10px 0 8px;height: 21px;line-height: 1;color: #fff;font-size: 12px;font-weight: 600;font-family: "NotoSansKR";border: 1px solid #fff;border-radius: 10px;text-transform: none;}
.mystate-section .myinfo .memclass .cont ul {position: absolute;top: 0;right: 20px;}
.mystate-section .myinfo .memclass .cont ul:after {content: "";display: block;clear: both;}
.mystate-section .myinfo .memclass .cont ul li {float: left;}
.mystate-section .myinfo .memclass .cont ul li a {margin-left: 22px;padding-right: 20px;line-height: 60px;color: #fff;font-size: 14px;}
.mystate-section .myinfo .memclass .cont ul li a:after {margin-top: -5px;width: 7px;height: 12px;background-position: -200px -400px;}
.mystate-section .myinfo .memclass.normal .name {margin-left: 0;color: #101010;}
.mystate-section .myinfo .memclass.normal .pass {color: #101010;border-color: #101010;}
.mystate-section .myinfo .memclass.normal .cont ul li a {color: #454545;}
.mystate-section .myinfo .memclass.normal .cont ul li a:after {margin-top: -5px;width: 7px;height: 12px;background-position: -51px -51px;}
.like {font-size:25px; color:black;}
</style>
<article style="margin-bottom: 1000px;">
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
							<li><a href="HyundaiServlet?command=updateMember">회원정보
									변경</a></li>
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
								<strong class="name">${sessionScope.loginUser.name}님</strong>
								<ul>
									<li><a href="HyundaiServlet?command=updateMember"
										class="btn-line">회원정보</a></li>
									<li><a href="#" class="btn-line">멤버십 혜택</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="point2">
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
					<div style="border-top: 2px solid black; margin-top:60px; margin-bottom:20px;"></div>
							<p class="like">좋아요<strong style="color:orange">&nbsp;0</strong></p>
					</header><br>
					<div class="nodata">좋아요한 상품이 없습니다.</div>
				</section>
			</section>
		</div>
	</div>
</article>
<%@ include file="../footer.jsp"%>