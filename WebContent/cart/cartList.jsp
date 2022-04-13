<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>
			<div id="contents">
				<div class="innercon">
					<h2 style="margin-bottom:30px">장바구니</h2>
					

					<form id="frmBasktInfo">
						<input type="hidden" name="basktGbcd" value="01">
						<!-- 새벽 배송// -->
						<fieldset class="list-field toggle active">
							<div class="cont">
								<ul class="product-list vertical">
								<c:forEach items="${prodInCartList}" var="picVO">
									<li dlvDivision="1_DAWN" data-dlvc_pay_gbcd="10" style="margin-bottom:30px">
										<button type="button" class="btn-del"
											onclick="javascript:deleteBasketItem(this);" style="margin-top:40px">삭제</button> <label
										class="thumb"> <img src="${picVO.prodImg}" alt="" onerror="this.src='/UIUX/m/pjtCom/images/common/noimage_350x420.jpg'" style="width:150px; height:150px; margin-top:10px;"></span>
									</label>
										<div class="contr" style="margin-left:100px; width:900px">
											<a href="/front/pd/pdd/productDetail.do?slitmCd=S02101030250">
												<strong class="txt-ti ellipsis">${picVO.prodName }</strong>
											</a> <span class="info">
												<div class="ea-area">
													<input type="number" title="수량 입력" name="ordQty" value="${picVO.qty }"
														readonly="readonly">
													<button type="button" class="btn-down"
														onclick="changeOrdQtyDown(this);">수량 낮추기</button>
													<button type="button" class="btn-up"
														onclick="changeOrdQtyUp(this);">수량 올리기</button>
													<input type="hidden" name="minBuyQty" value="1"> <input
														type="hidden" name="maxBuyQty" value="999"> <input
														type="hidden" name="pckgMinBuyQty" value="0"> <input
														type="hidden" name="pckgMaxBuyQty" value="0"> <input
														type="hidden" name="stckQty" value="130">
												</div> <span class="txt-price"> <strong><em><fmt:formatNumber value="${picVO.price }" type="number" pattern="###,###" /></em>원</strong>

											</span>
												<div class="probtn">

													<button type="button" id="btnWish0" class="btn-wish">좋아요</button>
													<button type="button" class="btn orange btn-buy">바로구매</button>
												</div>
											</span>
										</div>

									</li>
									</c:forEach>
								</ul>
							</div>
						</fieldset>
						<!-- //새벽배송 -->
						<div class="rightarea">
							<fieldset class="price-field">
								<legend class="hide">결제내역</legend>
								<dl class="orderprice">
									<dt>총 상품금액</dt>
									<dd>
										<strong style="font-size:30px; color:orange"><em id="emPriceFTotNrmlPrice"><fmt:formatNumber value="${totalPrice }" type="number" pattern="###,###" /></em>원</strong>
									</dd>
								</dl>
								
							</fieldset>
							<!-- 결제내역// -->
							<button type="button" class="btn fill bigger orange btn-order" style="float:right">
								주문하기<em id="emTotalItemCnt">3</em>
							</button>
						</div>
					</form>
					<!-- 주문 안내// -->
					<section class="cart-info infotxt">
						<strong>주문 안내</strong>
						<ul>
							<li>장바구니에 담긴 상품은 최대 60일간 보관됩니다.(로그인 기준)</li>
							<li>패키지/딜 종료 시 해당 상품은 자동 삭제됩니다.</li>
							<li>상품을 장기간 보관하시려면 "좋아요"를 눌러주십시오.</li>
							<li>장바구니에 최대 100개 상품을 담을 수 있습니다.</li>
						</ul>
					</section>
					<!-- 주문 안내// -->
				</div>
			</div>
	<%@ include file="../footer.jsp"%>