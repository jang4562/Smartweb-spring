<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/resources/css/bootstrap.css">
</head>
<body>
<h1>
	Hello world!  
</h1>
<%-- 컨트롤러에서 전달할 데이터를 받기위해 ${컨트롤러에서 전달한 이름}을 사용한다. --%>

<!--jsp에서 컨트롤러로 데이터를 전달하려면 form 태그를 이용  -->
<form method="post" action="<%=request.getContextPath() %>/" style="<c:if test="${user != null}">display:none;</c:if>">  <!-- action="/" 정확히 지정해 주면 기존 데이터 값은 저장안되고 새로운 데이터만 저장됨 -->
	<!-- 전달하려는 데이터가 있는 태그의 속성 name을 입력한다. -->
	
	<!-- [로그인]구현하기:  뷰(jsp) > 컨트롤러 > 서비스 > 다오 > 매퍼 > DB
	1.로그인 버튼을 눌렀을때 이동하는 컨트롤러에서 아이디와 비밀번호가 제대로 넘어가는지 확인
	2.form 태그 내용 확인 (method,action방식) >> 홈 컨트롤러에서 method,action방식 일치하는 곳에 작업
	3.컨트롤러에서 아이디와 비밀번호가 주어졌을때 회원인지 아닌지 확인하는 메소드를 서비스에서 호출 
	- 필요한 메소드(소유자>서비스): 아이디와 비밀번호가 주어졌을때 (매개변수)회원인지 아닌지 확인하는 (리턴타입)
	4.서비스에서 3번에서 호출한 메소드를 구현
	5.구현 상세 : DB에 아이디와 일치하는 객체가 있는지 확인하여 객체가 없으면 비회원, 객체가 있으면 비밀번호를 비교하여 일치하면 회원, 비일치시 비회원으로 
	  - DB에 접근 == dao를 이용 -->
	
	아이디 <input type="text" name="id"><br>
	비밀번호 <input type="password" name="pw"><br>
	<button class="btn btn-primary">로그인</button>     <!--자동으로 submit으로 됨 -->
</form>
<a href="<%=request.getContextPath() %>/signup">회원가입</a>
</body>
</html>
