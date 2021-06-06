package test.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet{
	HashMap<String, Controller> map = null;
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		map = new HashMap<String, Controller>();
		map.put("/login.do", new LoginController());
		map.put("/profEnrollSubject.do", new ProfEnrollSubjectController());
		map.put("/logout.do", new LogoutController());
		map.put("/profListResult.do", new ProfListResultController());
		map.put("/search.do", new SubjectSearchController());
		map.put("/studEnroll.do", new StudSubjectEnrollController());
		map.put("/studListResult.do", new StudListResultController());
		map.put("/profStudentList.do", new ProfStudentListController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath(); 
		String path = uri.substring(contextPath.length()); 
		
		Controller cont = map.get(path); 
		cont.execute(req, resp); 
	}
}
