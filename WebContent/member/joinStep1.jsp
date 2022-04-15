<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../header.jsp" %>
<!-- 
작성자 : 고정민
H.Point 통합 회원 가입과 일반 회원가입을 나누는 페이지
 -->
<title>회원 가입</title>
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

    h2 {
        color: black !important;
        font-weight: bold !important;
    }
</style>
<script>
    function not_yet() {
        alert("준비중인 서비스입니다.");
    }
</script>

<div style="text-align: center;">
    <div style="display: inline-block; width: 680px; margin-bottom: 30px;">
        <h2 style="text-align: left; margin-top: 50px;">회원가입</h2>
        <div id="wrap" class="member joinmain" style="border: 1px solid #dbd9d6; margin-top: 30px;">
            <div id="contents">
                <div class="innercon">
                    <div class="linearea" style="margin-top: 40px; text-align: left;">
                        <section class="totalmember" style="margin-left: 60px;">
                            <img src="images/common/hpoint.png" alt="hpoint" height="90px !important"/>
                            <p class="hpoint">H.Point 통합회원</p>
                            <p style="width: 560px; font-color: #454545 !important;">
                                현대백화점그룹의 모든 서비스를 이용할 수 있는 통합아이디를 만듭니다.<br/>
                                통합멤버십 H.Point(포인트) 적립/사용이 가능하며, 다양한 혜택을 받아 보실 수 있습니다.<br/>
                                기존 H.Point 가입자도 아래 버튼을 통해 간단한 전환 가입 절차로 가입이 가능합니다.<br/>
                                신규가입 혜택 및 이벤트(웰컴케어 프로그램) 참여를 원하지 않으실 경우에는 아래 일반회원가입을 통해 가입을 진행하실 수 있습니다.<br/>
                                ※ 자세한 신규회원 혜택 및 웰컴케어 프로그램은 이벤트 게시판 참조
                            </p>
                            <div class="img" style="margin-top: 50px;">
                                <a href="https://tohome.thehyundai.com/event/mk/mkf/gnrlEvnt.do?UseCache=N&evntNo=00000555"><img
                                        src="https://tohomeimage.thehyundai.com/DP/DP001/2021/12/22/160736/pc_benefit_btn2.jpg"/></a>
                            </div>
                            <button type="button" class="btn fill big black" onclick="not_yet()"
                                    style="width: 560px; margin-top: 40px; margin-bottom: 50px;">신규회원 및 웰컴케어 가입
                            </button>
                        </section>
                        <div style="border-top: 1px solid #dbd9d6; width: 680px"></div>
                        <section class="member" style="margin-left: 60px; margin-top: 30px;">
                            <img src="images/common/tohome.png" alt="tohome" height="70px !important"/>
                            <p class="hpoint">현대식품관 일반회원</p>
                            <p class="txt">
                                현대식품관에서만 사용 가능한 아이디를 만듭니다.<br/>
                                단, 통합 멤버십 H.Point(포인트) 적립/사용이 제한됩니다.<br/>
                                현대식품관 일반회원은 신규회원 혜택 및 웰컴케어 프로그램 참여가 제한됩니다.
                            </p>
                            <button type="button" class="btn big black"
                                    onclick="location.href='HyundaiServlet?command=joinStep2'"
                                    style="width: 560px; margin-top: 40px;">일반회원가입
                            </button>
                        </section>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<%@ include file="../footer.jsp" %>
