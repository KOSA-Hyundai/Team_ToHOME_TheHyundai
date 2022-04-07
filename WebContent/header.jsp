<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>새벽투홈</title>
  <link rel="shortcut icon" type="image/x-icon" href="images/common/favicon.ico">
  <link rel="stylesheet" type="text/css" href="css/main/css-library.min.css">
  <script type="text/javascript" src="js/main/jquery-library.min.js?ver=15"></script>
  <script type="text/javascript" src="js/main/function.min.js?ver=15"></script>
  
  <link rel="stylesheet" type="text/css" href="css/main/common.min.css">
  <script type="text/javascript" src="js/main/common.js?ver=1649312205468"></script>
</head>
<body>
	<div id="wrap" class="main">
		<!--헤더파일 들어가는 곳 시작 -->
		<header id="header">
		
			<div id="topBanner"></div>
			
			<!-- //상단배너 -->
			<div class="inner">
			
		   		<!-- //toparea -->
		    	<div class="toparea">
		    	
		    		<!-- //로고 들어가는 곳--->
		      		<h1><a href="#none"><img src="images/header/header_logo_freex34.png" alt="tohome"></a></h1>
		      		<!--로고 들어가는 곳//-->
		      		
		      		<!-- //로그인, 회원가입, 마이페이지, 고객센터 -->
			    	<div class="util" id="dawnLoginN" style="display:hidden">
				    	<c:choose>	    	
					    	<c:when test="${empty sessionScope.loginUser}">
					        	<a href="#none">로그인</a>		       
					       		<a href="#none">회원가입</a>
					       	</c:when>
					       	<c:otherwise>
								<a style="color:orange">${sessionScope.loginUser.name}(${sessionScope.loginUser.id})</a>
						    	<a href="#none">로그아웃</a>
					       	</c:otherwise>       
				    	</c:choose>
				        <a href="#none">마이페이지</a>
				        <a href="#none">고객센터</a>
			    	</div>
					<!-- 로그인, 회원가입, 마이페이지, 고객센터// --> 
					
					<!-- //팝업 : 개인화 상품 추천 -->
	                <div id="popProd"></div>
	                <!-- 팝업 : 개인화 상품 추천// --> 
		    	</div>
		    	<!-- //toparea -->
		    	
	    		<!-- //gnbarea -->     	
	    		<nav class="gnbarea">
	    		
	    			<div id="popCategory">
	    				<script type="text/javascript">  
							$(document).ready(function(){
								// 퍼블 정상 동작을 위해 $(document).ready에 추가 
							    $('.depth1.brand-wrap .depth2 button, .depth3').hover(function(){
							    	$(this).parents('ul.lnb').addClass('on');
							    }, function() {
							    	$(this).parents('ul.lnb').removeClass('on');
							    });
						
							    $('.exhibition-wrap, .brand-ct').hover(function(){
							        $(this).parents('ul.lnb').addClass('on2');
							    }, function() {
							        $(this).parents('ul.lnb').removeClass('on2');
							    });
						 	});
						
						</script>	    	
	    				<!-- //카테고리 -->
						<button type="button" class="btn-category">카테고리 전체보기</button>
						<div id="p_popCategory" class="popcategory">
							<nav class="lnb-list">
								<ul class="lnb">
									<li class="depth1">
										<button type="button" onclick="">대분류1</button>
										<ul class="depth2">
											<li><a href="#none" onclick="">소분류1</a></li>
											<li><a href="#none" onclick="">소분류2</a></li>
											<li><a href="#none" onclick="">소분류3</a></li>
											<li><a href="#none" onclick="">소분류4</a></li>
										</ul>
									</li>
									<li class="depth1">
										<button type="button" onclick="">대분류2</button>
									</li>
									<li class="depth1">
										<button type="button" onclick="">대분류3</button>
									</li>
								</ul>
							</nav>
						</div>  			
	    			</div>
	    			<!-- 카테고리// -->
	    			
	    			<!-- //gnb-list -->
	        		<ul class="gnb-list" id="homeGnbList">
				    	<li><a class href="#none">베스트</a></li>  
				    	<li><a class href="#none">세일</a></li>  
				        <li><a class href="#none">신상품</a></li> 
				        <li><a class href="#none">매거진</a></li> 
				        <li><a class href="#none">선물하기</a></li>
				        <li><a class href="#none">이벤트</a></li>
	        		</ul>
	        		<!--gnb-list// -->
	        		
			        <!-- //searcharea -->
			    	<div class="searcharea">
			    		<form name="pdPcSearchForm" id="pdPcSearchForm" method="post">
                        <fieldset>
                            <legend class="hide">검색어 입력</legend>

                            <div class="form-entry exist search">
                                <input type="text" name="keyWord" title="검색어 입력" onfocus="fn.addClass('.searcharea');$('.defaultsearch').fadeIn();" oninput="handleOnInput(this, 20);" autocomplete="off" onkeyup="fnPDSearchAutoSelect(this, event);">
                                <!-- <button type="button" class="btn-del" tabindex="-1">삭제</button> -->
                                <button type="button" class="btn-search" onclick="GA_Event('PC_공통', '헤더', '검색'); fnPDSearchSubmit();">검색</button>
                            </div>
                            <input type="text" name="searchTerm" class="hide">
                            <input type="text" name="category" class="hide">
                            <input type="text" name="pageNumber" class="hide">
                            <input type="text" name="rowsPerPage" class="hide">
                            <input type="text" name="tagNm" class="hide">
                        </fieldset>
                    </form>
			    	</div>
			    	<!-- searcharea// -->
			    	<button type="button" class="btn-cart" onclick="GA_Event('PC_공통', '헤더', '장바구니'); javascript:fnPdShippingBasketList( this);">장바구니
			    		<span id="basketCnt">0</span>
			    	</button>
	    		</nav>
	    		<!-- gnbarea// -->	    	
			</div>
			<!-- 상단배너// -->
	  </header>
  	  <!--헤더파일 들어가는 곳 끝 -->