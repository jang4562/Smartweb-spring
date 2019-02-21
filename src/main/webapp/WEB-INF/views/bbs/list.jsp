<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <style>
  #pagination {
    display : table;
    margin : 0 auto;
  }
  </style>
<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.css">
</head>
<body>
 	<table class="table table-bordered">
 		<tr>
 			<td>번호</td>
 			<td>제목</td>
 			<td>작성자</td>
 		</tr>
 		<c:forEach items="${list}" var="board">
 			<tr>
 				<td>${board.id}</td>
 				<td>${board.title}</td>
 				<td>${board.writer}</td>
 			</tr>
 		</c:forEach>
 	</table>
  <a href="<%=request.getContextPath()%>/bbs/register/"><button>등록</button></a>
<%-- 페이징 처리 시작 --%>
<div id="pagination">
  <ul class="pagination">
    <li class="page-item <c:if test="${!(pageMaker.prev)}">disabled</c:if>">
      <a class="page-link" href="<%=request.getContextPath() %>/bbs/list?page=${pageMaker.startPage-1}">Prev</a>
    </li>
  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
    <li class="page-item <c:if test="${pageMaker.criteria.page ==i}">active</c:if>">
      <a class="page-link" href="<%=request.getContextPath() %>/bbs/list?page=${i}"> ${i}</a>
    </li>
  </c:forEach>
    <li class="page-item <c:if test="${!(pageMaker.prev)}">disabled</c:if>">
      <a class="page-link" href="<%=request.getContextPath() %>/bbs/list?page=${pageMaker.endPage+1}">Next</a>
    </li>
  </ul>
</div>
<%-- 페이징 처리 끝 --%>
</body>
</html>