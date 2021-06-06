<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.vo.SubjectVO" %>
<%@ page import="java.util.ArrayList" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		ArrayList<SubjectVO> list = (ArrayList<SubjectVO>)request.getAttribute("list");
		if(!list.isEmpty()) {
	%>
		<table border="1">
			<tr><th>과목번호</th><th>과목명</th></tr>
	<%		for(int i=0; i < list.size(); i++) {
				SubjectVO subject = list.get(i); %>
				<tr><td><%=subject.getsId() %></td>
				<td><%=subject.getName() %></td></tr>
			<%} %>
		</table>
	<%	} else {
			out.print("<h3>수강 과목이 없습니다.</h3>");
		}
	%>
	<%@ include file="smenu.jsp" %>
</body>
</html>