<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>

<title>로그인</title>
<script type="text/javascript">
    $(document).ready(function () {
        var userInputId = getCookie("userInputId");
        var setCookieYN = getCookie("setCookieYN");

        if (setCookieYN == "Y") {
            $("#saveId").prop("checked", true);
        } else {
            $("#saveId").prop("checked", false);
        }

        $("#email").val(userInputId);

        //로그인 버튼 클릭
        $("#loginbtn").click(function () {
            if ($("#saveId").is(":checked")) {
                var userInputId = $("#email").val();
                setCookie("userInputId", userInputId, 60);
                setCookie("setCookieYN", "Y", 60);
            } else {
                deleteCookie("userInputId");
                deleteCookie("setCookieYN");
            }

            document.fform.submit();
        });
    });

    //쿠키값 Set
    function setCookie(cookieName, value, exdays) {
        var exdate = new Date();
        exdate.setDate(exdate.getDate() + exdays);
        var cookieValue = escape(value) + (exdays == null ? "" : "; expires=" + exdate.toGMTString());
        document.cookie = cookieName + "=" + cookieValue;
    }

    //쿠키값 Delete
    function deleteCookie(cookieName) {
        var expireDate = new Date();
        expireDate.setDate(expireDate.getDate() - 1);
        document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
    }

    //쿠키값 가져오기
    function getCookie(cookie_name) {
        var x, y;
        var val = document.cookie.split(";");

        for (var i = 0; i < val.length; i++) {
            x = val[i].substr(0, val[i].indexOf("="));
            y = val[i].substr(val[i].indexOf("=") + 1);
            x = x.replace(/^\s+|\s+$/g, ""); // 앞과 뒤의 공백 제거하기

            if (x == cookie_name) {
                return unescape(y); // unescape로 디코딩 후 값 리턴
            }
        }
    }

    function not_yet() {
        alert("준비중인 서비스입니다.");
    }
</script>
<style>
    h1 {
        color: black !important;
        font-weight: bold !important;
    }
</style>
<article>
    <div id="contents">
        <div class="innercon" style="margin-top: 70px; text-align: center;">
            <h1>로그인</h1>
            <p class="txt" style="margin-top: 10px;">현대식품관 전용회원은 아이디를 이메일로 입력해 주세요.</p>
            <form method="post" action="HyundaiServlet?command=login" name="fform">
                <fieldset class="form-field">
                    <legend class="hide">로그인</legend>
                    <ul>
                        <li>
                            <label class="form-entry"> <input type="text" id="email" name="email" class="big"
                                                              title="아이디 입력" placeholder="아이디" value="${email}"
                                                              style="width: 440px; margin-top: 30px;"/> </label>
                        </li>
                        <li>
                            <label class="form-entry"> <input type="password" id="pw" name="pw" class="big"
                                                              title="비밀번호 입력" placeholder="비밀번호" value=""
                                                              style="width: 440px; margin-top: 10px;"/> </label>
                        </li>
                    </ul>
                    <label class="form-save" style="text-align: left;"><input type="checkbox" id="saveId" name="saveId"
                                                                              class="big"/><span>아이디저장</span></label>
                    <ul class="btn-group login-surport">
                        <li><a href="HyundaiServlet?command=joinStep1">회원가입</a></li>
                        <li><a onclick="not_yet()">아이디/비밀번호 찾기</a></li>
                    </ul>
                    <button type="submit" class="btn fill big black" id="loginbtn"
                            style="width: 440px; margin-top: 30px;">로그인
                    </button>
                    <br/>
                    <button type="button" class="btn black big btn-kakao" id="kakaoLoginBtn" onclick="not_yet()"
                            style="width: 440px; margin-top: 10px;">카카오 로그인
                    </button>
                </fieldset>
            </form>
            <button type="button" class="btn fill middle lightgray" onclick="not_yet()"
                    style="width: 440px; margin-top: 10px;">비회원 주문조회
            </button>
        </div>
    </div>
</article>
<%@ include file="../footer.jsp" %>
