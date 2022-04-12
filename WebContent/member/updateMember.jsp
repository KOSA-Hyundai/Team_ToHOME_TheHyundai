<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ include file="../header.jsp"%>
<title>마이페이지</title>
<style>
    .conarea .col-input input + span {
        margin-right: 40px;
    }
    .conarea .need {
        display: inline-block;
        margin-left: 4px;
        color: #767572;
        font-size: 15px;
    }
    .conarea .form-field legend {
        padding-top: 19px;
        line-height: 58px;
        color: #101010;
        font-size: 18px;
    }
    .conarea .form-field dl {
        display: table;
        margin-top: 8px;
        width: 100%;
        min-height: 42px;
    }
    .conarea .form-field dl:first-of-type {
        margin-top: 0;
    }
    .conarea .form-field dt {
        display: table-cell;
        width: 160px;
        line-height: 42px;
        vertical-align: top;
    }
    .conarea .form-field dd {
        position: relative;
        display: table-cell;
        color: #101010;
        vertical-align: middle;
    }
    .conarea .form-field dd > .btn {
        width: 112px;
    }
    .conarea .form-field dd .dd-txt {
        display: inline-block;
        line-height: 32px;
    }
    .conarea .form-field dd .dd-txt + .btn {
        margin-left: 40px;
        width: 60px;
    }
    .conarea .form-field dd > .form-entry {
        width: 456px;
    }
    .input-group {
    	margin-bottom: 10px;
    }
</style>
<script>
function go_save() {
	console.log("${sessionScope.loginUser.pw}");
	if (document.formm.oldpw.value == "") {
        alert("비밀번호를 입력해 주세요.");
        document.formm.oldpw.focus();
        return false;
    } else if(document.formm.oldpw.value !=  "${sessionScope.loginUser.pw}"){
		alert('기존 비밀번호를 확인해주세요.')
		document.formm.oldpw.focus();
        return false;
	} else if (document.formm.pw.value != document.formm.pwCheck.value) {
        alert("비밀번호가 일치하지 않습니다.");
        document.formm.pw.focus();
        return false;
    }
	alert('회원정보 변경이 완료되었습니다.');
	return true;
}
</script>
<article style="margin-bottom:1000px;">
    <div id="wrap" class="mypage mypage main">
        <div id="contents">
            <div class="innercon">
                <section class="lnbarea">
                    <h2>마이페이지</h2>
                    <ul>
                        <li class="lnb-depth1">
                            <a href="#">주문관리</a>
                            <ul class="lnb-depth2">
                                <li><a href="#">주문 내역</a></li>
                                <li><a href="#">주문취소</a></li>
                                <li><a href="#">반품/교환</a></li>
                                <li><a href="#">대량주문 문의</a></li>
                                <li><a href="#">투홈구독</a></li>
                                <li><a href="#">정기배송 설정</a></li>
                            </ul>
                        </li>

                        <li class="lnb-depth1">
                            <a href="#">쇼핑 혜택</a>
                            <ul class="lnb-depth2">
                                <li><a href="#">쿠폰</a></li>
                                <li><a href="#">H.Bonus</a></li>
                                <li><a href="#">투홈패스</a></li>
                                <li><a href="#">H.Point</a></li>
                                <li><a href="#">상품권 전환금</a></li>
                            </ul>
                        </li>
                        <li class="lnb-depth1">
                            <a href="#">나의 활동</a>
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
                            </ul>
                        </li>
                        <li class="lnb-depth1">
                            <a href="#">나의 정보</a>
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
                            </ul>
                        </li>
                    </ul>
                </section>
                <section class="conarea">
                    <h3 class="tit line">회원정보 변경</h3>

					<form id="join" method="post" name="formm" onsubmit="return go_save();" action="HyundaiServlet?command=update">                        
					<fieldset class="form-field">
                            <legend>회원정보</legend>

                            <dl>
                                <dt>
                                    이름<span class="need">*<span class="hide">필수</span></span>
                                </dt>
                                <dd>${sessionScope.loginUser.name}</dd>
                            </dl>

                            <dl>
                                <dt>
                                    이메일<span class="need">*<span class="hide">필수</span></span>
                                </dt>
                                <dd><input type="text" class="input-group" id="email" name="email" placeholder="기존 비밀번호" value="${sessionScope.loginUser.email }" readonly/></dd>
                            </dl>
                            <dl class="hpointpw">
                                <dt>
                                    비밀번호<span class="need">*<span class="hide">필수</span></span>
                                </dt>
                                <dd>
                                    <input type="password" class="input-group" id="oldpw" name="oldpw" title="기존 비밀번호 확인 입력" placeholder="기존 비밀번호" />
                                    <input type="password" class="input-group" id="pw" name="pw" title="신규 비밀번호 입력" placeholder="신규 비밀번호"/>
                                    <input type="password" class="input-group" id="pwCheck" name="pwCheck" title="비밀번호 확인 입력" placeholder="비밀번호 확인" />
                                </dd>
                            </dl>

                            <dl>
                                <dt>
                                    휴대폰번호<span class="need">*<span class="hide">필수</span></span>
                                </dt>
                                <dd>
                                    <input type="text" class="input-group" id="phone_number" name="phone_number" value="${sessionScope.loginUser.phone_number}" />
                                </dd>
                            </dl>
                            
                            <dl>
                                <dt>주소</dt>
                                <dd>
                                    <div class="form-addr">
                                        <input type="text" class="input-group" id="address" name="address" value="${sessionScope.loginUser.address }">
                                    </div>
                                </dd>
                            </dl>
                            <dl class="personal-info">
                                <dt>
                                    개인정보 유효기간<span class="need">*<span class="hide">필수</span></span>
                                </dt>
                                <dd>
                                    <div class="col-input">
                                        <label><input type="radio" name="CUST_VLID_TERM_GBCD" value="01" /><span>&nbsp;평생</span></label> <label><input type="radio" name="CUST_VLID_TERM_GBCD" value="02" checked /><span>&nbsp;1년</span></label>
                                    </div>
                                </dd>
                            </dl>

                            <div class="btns">
                                <button type="button" class="btn big lightgray" onclick="location.href='HyundaiServlet?command=mypage'">취소</button>
                                <button type="submit" class="btn fill big black">정보변경</button>
                            </div>
                            <div class="withdrawal-area" style="text-align:right; margin-top:430px;">
                        <p>탈퇴를 원하신다면?</p>
                        <a href="#" class="btn-line">회원탈퇴</a>
                    </div>
                        </fieldset>
                    </form>
                </section>
            </div>
        </div>
    </div>
</article>
<%@ include file="../footer.jsp"%>
