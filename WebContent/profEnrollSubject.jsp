<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Subject</h3>
	<form action="profEnrollSubject.do" method="post">
		ID : <input type="text" name="subject"/><br>
		TITLE : <input type="text" name="title"/><br>
		# of Student : <input type="text" name="max"/><br>
		<input type="submit" value="Enroll"/>
	</form>	
</body>
</html>