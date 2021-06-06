package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.service.Service;
import test.vo.SubjectVO;

public class ProfEnrollSubjectController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("subject");
		String name = request.getParameter("title");
		int max = Integer.parseInt(request.getParameter("max"));
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		SubjectVO subject = new SubjectVO();
		subject.setsId(sid);
		subject.setName(name);
		subject.setMax(max);
		subject.setId(id);
		
		Service service = Service.getInstance();
		service.profEnrollSubject(subject);
		HttpUtil.forward(request, response, "professorMenu.jsp");
	}

}
