<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>
<title>회원 가입>일반 회원가입</title>
<style>
    .container {
        position: relative;
        width: 100%;
        height: 100%;
    }

    .hpoint {
        color: black;
        font-size: 18px;
    }

    .info {
        font-size: 15px;
        color: black;
    }

    h1 {
        color: black !important;
    }

    h2 {
        color: black !important;
        font-weight: bold !important;
    }

    li {
        font-size: 13px;
        color: gray;
    }
</style>
<script>
    function go_save() {
    	if (document.formm.email.value == "") {
            alert("이메일을 입력하여 주세요.");
            document.formm.email.focus();
            return false;
        } else if (document.formm.pw.value == "") {
            alert("비밀번호를 입력해 주세요.");
            document.formm.pw.focus();
            return false;
        } else if (document.formm.pw.value != document.formm.pwCheck.value) {
            alert("비밀번호가 일치하지 않습니다.");
            document.formm.pw.focus();
            return false;
        } else if (document.formm.name.value == "") {
            alert("이름을 입력해 주세요.");
            document.formm.name.focus();
            return false;
        } else if (document.formm.phone_number.value == "") {
            alert("전화번호를 입력해 주세요.");
            document.formm.phone_number.focus();
            return false;
        }
        return true;
    }

    function resetID() {
        initIdCheck = false;
        fn.inputMsgClear("#email");
    }

    function not_yet() {
        alert("준비중인 서비스입니다.");
    }
    function idcheck() {
    	if (document.formm.email.value == "") {
    	    alert('아이디를 입력하여 주십시오.');
    	    document.formm.email.focus();
    	    return;
    	}
    	document.formm2.email.value = document.formm.email.value;
    	document.formm2.action = "HyundaiServlet?command=id_check_form&email=" + document.formm.email.value;
    	document.formm2.submit();
    }
</script>
<div style="text-align: center;">
    <div style="display: inline-block; margin-bottom: 100px;">
        <h2 style="text-align: left; margin-top: 50px;">현대식품관 회원가입</h2>
        <div id="wrap" class="member joinmain" style="border: 1px solid #dbd9d6; margin-top: 30px;">
            <div style="width: 680px;">
                <div class="innercon">
                    <div class="linearea" style="margin-top: 40px; text-align: left;">
                        <section class="totalmember" style="margin-left: 60px; margin-right: 60px;">
                            <h1>가입정보를 입력해 주세요.</h1>
                            <form id="emailcheck" method="post" name="formm2" ><input type="hidden" id="email" name="email"></form>
                            <form id="join" method="post" name="formm" onsubmit="return go_save();"
                                  action="HyundaiServlet?command=join">
                                <fieldset style="width: 560px; margin-top: 40px;">
                                    <strong>회원정보</strong> <small><span class="need">*</span> 필수입력사항</small>
                                    <div style="border-top: 1px solid black; margin-bottom: 30px;"></div>
                                    <ul>
                                        <li>
                                            <label class="form-entry inline">
                                                <span class="info">이메일</span><span class="need">*<span
                                                    class="hide">필수</span></span><br/>
                                                <input type="text" class="big" id="email" name="email" title="아이디"
                                                       placeholder="아이디" style="width: 460px;" onkeydown="resetID();"/>
                                                <button type="button" id="idc" class="btn fill big gray" onclick="idcheck();">
                                                    중복체크
                                                </button>
                                                <iframe width=0 height=0 name="_blank_1" style="display:none;"></iframe>
                                                <button type="button" class="btn-del">삭제</button>
                                            </label>
                                            <div class="infotxt" style="margin-bottom: 30px;">
                                                <ul>
                                                    <li>현대식품관은 이메일을 아이디로 사용합니다.</li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li>
                                            <label class="form-entry">
                                                <span class="info">비밀번호</span><span class="need">*<span
                                                    class="hide">필수</span></span>
                                                <input type="password" class="big" name="pw" id="pw" title="비밀번호 입력"
                                                       placeholder="비밀번호"/>
                                                <button type="button" class="btn-del">삭제</button>
                                            </label>
                                            <div class="infotxt" style="margin-bottom: 20px;">
                                                <ul>
                                                    <li>영문, 숫자, 특수문자를 포함하여 8~30자 사용 가능</li>
                                                    <li>연속된3자리 이상의 숫자,문자는 사용 불가</li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li class="pw">
                                            <label class="form-entry">
                                                <input type="password" class="big" name="pw2" id="pwCheck"
                                                       title="비밀번호 확인 입력" placeholder="비밀번호 확인"/>
                                                <button type="button" class="btn-del">삭제</button>
                                            </label>
                                            <div class="infotxt" style="margin-bottom: 30px;">
                                                <ul>
                                                    <li>비밀번호를 다시 입력해주세요.</li>
                                                </ul>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="form-birth" style="margin-bottom: 30px;">
                                                <label class="form-entry">
                                                    <span class="info">이름</span><span class="need">*<span class="hide">필수</span></span>
                                                    <input type="text" name="name" class="big" title="이름"
                                                           placeholder="이름" style="margin-bottom: 20px;"/>
                                                </label>

                                                <label class="form-entry">
                                                    <span class="info">전화번호</span><span class="need">*<span
                                                        class="hide">필수</span></span><input type="text"
                                                                                            name="phone_number"/>
                                                </label>
                                                <div class="infotxt" style="margin-bottom: 30px;">
                                                    <ul>
                                                        <li>'-'를 제외하고 입력해주세요.</li>
                                                    </ul>
                                                </div>

                                                <label class="form-entry"> <span class="info">생년월일 및 성별</span><input
                                                        type="number" name="birth" class="big" title="생년월일"
                                                        placeholder="생년월일" value=""/> </label>

                                                <div class="infotxt">
                                                    <ul>
                                                        <li>8자리 숫자만 입력 (예. 20190715)</li>
                                                    </ul>
                                                </div>
                                                <div class="gender"><input type="radio" name="gender" value="F"/>&nbsp;여성
                                                    <input type="radio" name="gender" value="M"/>&nbsp;남성
                                                </div>
                                            </div>
                                        </li>
                                        <li>
                                            <div class="form-addr">
                                                <span class="info">주소</span>
                                                <!-- <input type="text" name="RDNM_POST_NO" class="big post" title="우편번호" placeholder="우편번호" readonly> -->
                                                <!--  <button type="button" class="btn fill big gray" onclick="javascript:showSearchAddressPop('pc');">주소찾기</button> -->
                                                <input type="text" name="address" class="big" title="기본주소"
                                                       placeholder="기본주소"/>
                                                <!-- <label class="form-entry">
                                          <input type="text" id="RDNM_PTC_ADR"   name="RDNM_PTC_ADR" class="big" title="상세주소 입력" placeholder="상세주소 입력"><button type="button" class="btn-del">삭제</button>
                                          </label> -->
                                                <label><input type="checkbox" name="ADD_DSTN" class="big" id="ADD_DSTN"
                                                              value="Y" disabled/><span
                                                        class="info">배송지 목록에 추가</span></label>
                                            </div>
                                        </li>
                                    </ul>
                                </fieldset>
                                <div class="btns" style="margin-bottom: 60px;">
                                    <button type="button" class="btn big black"
                                            onclick="location.href='HyundaiServlet?command=joinStep1'"
                                            style="width: 275px;">취소
                                    </button>
                                    <button type="submit" class="btn fill big black" style="width: 275px;">가입하기</button>
                                </div>
                            </form>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
