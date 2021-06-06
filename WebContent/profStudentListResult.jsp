<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.vo.UserVO" %>
<%@ page import="java.util.ArrayList" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		ArrayList<UserVO> list = (ArrayList<UserVO>)request.getAttribute("list");
		String name = request.getParameter("name");
		int i;
		if(!list.isEmpty()) {
	%>
		<table border="1">
			<tr><th>id</th><th>이름</th></tr>
	<%		for(i=0; i < list.size(); i++) {
				UserVO student = list.get(i); %>
				<tr><td><%=student.getId() %></td>
				<td><%=student.getName() %></td></tr>
			<%} %>
		</table>
		<br><%= name %> 총 수강인원: <%= i %>명
	<%	} else {
			out.print("<h3>등록된 수강생이 없습니다.</h3>");
		}
	%>
	<%@ include file="menu.jsp" %>
</body>
</html>