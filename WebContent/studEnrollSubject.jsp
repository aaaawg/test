<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.vo.SubjectVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Subject</h3>
	<form action="search.do" method="post">
		ID : <input type="text" name="sid"/><br>
		<input type="submit" value="Search"/>
	</form>	
	<%
		SubjectVO subject = (SubjectVO)request.getAttribute("subject");
		if(subject != null) {%>
		<form action="studEnroll.do" method="post">
			과목번호 : <input type="text" name="id" readonly value="${subject.sId }"><br>
			과목명 : <input type="text" name="sname" readonly value="${subject.name }"><br>
			<input type="submit" value="Enrolment">
		</form>
<%} else { %>
	${error }<p>
<%} %>
</body>
</html>