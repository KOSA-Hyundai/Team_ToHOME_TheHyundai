<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>  
<!DOCTYPE html>
<html>
<head>
 <style>
   .cls1 {text-decoration:none;}
   .cls2{text-align:center; font-size:30px;}
  </style>
  <meta charset="UTF-8">
  <title>리뷰목록</title>
</head>
<body>
<table align="center" border="1"  width="80%"  >
  <tr height="10" align="center"  bgcolor="lightgreen">
     <td >리뷰번호</td>
     <td >작성자</td>              
     <td >내용</td>
     <td >평점</td>
     <td >작성일</td>
  </tr>
<c:choose>
  <c:when test="${empty reviewsList }" >
    <tr  height="10">
      <td colspan="4">
         <p align="center">
            <b><span style="font-size:9pt;">등록된 리뷰가 없습니다.</span></b>
        </p>
      </td>  
    </tr>
  </c:when>
  <c:when test="${!empty reviewsList}" >
    <c:forEach  var="review" items="${reviewsList}" varStatus="reviewNum" >
     <tr align="center">
	<td width="10%">${review.id}</td>
	<td width="10%">${review.name}</td>
	<td align='left'  width="35%">
	  <span style="padding-right:30px">${review.contents}</span>
	  </td>
	  <td  width="10%">${review.score}</td> 
	  <td  width="10%"><fmt:formatDate value="${review.create_date}" /></td> 
	</tr>
    </c:forEach>
     </c:when>
    </c:choose>
</table>
<a  class="cls1"  href="HyundaiServlet?command=review_form"><p class="cls2">리뷰쓰기</p></a>
</body>
</html>