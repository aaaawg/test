package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.service.Service;
import test.vo.SubjectVO;

public class ProfListResultController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		
		Service service = Service.getInstance();
		ArrayList<SubjectVO> list = service.profSubjectList(id);
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/profListResult.jsp");
	}

}
