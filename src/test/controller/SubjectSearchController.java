package test.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.service.Service;
import test.vo.SubjectVO;

public class SubjectSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("sid");
		Service service = Service.getInstance();
		SubjectVO subject = service.subjectSearch(sid);
		
		request.setAttribute("subject", subject);
		request.setAttribute("error", "해당 과목을 찾을 수 없습니다.");
		HttpUtil.forward(request, response, "/studEnrollSubject.jsp");
	}

}
