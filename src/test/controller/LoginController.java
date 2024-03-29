package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.service.Service;

public class LoginController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String login = request.getParameter("login");
		
		String path = null;
		Service service = Service.getInstance(); 
		boolean result = service.login(id, pwd, login);
		
		if(result == true && login.equals("professor")) {
			HttpSession session = request.getSession(); 
			session.setAttribute("id", id); 
			path = "professorMenu.jsp";
		} else if(result == true && login.equals("student")) {
			HttpSession session = request.getSession(); 
			session.setAttribute("id", id); 
			path = "studentMenu.jsp";
		} else {
			path = "index.jsp";
		}
		HttpUtil.forward(request, response, path);
	}
}
