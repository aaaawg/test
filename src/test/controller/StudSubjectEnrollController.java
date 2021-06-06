package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.service.Service;
import test.vo.EnrollVO;

public class StudSubjectEnrollController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("id");
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		EnrollVO enroll = new EnrollVO();
		enroll.setId(sid);
		enroll.setName(id);
		
		Service service = Service.getInstance();
		service.studEnrollSubject(enroll);
		HttpUtil.forward(request, response, "studentMenu.jsp");
	}

}
