package test.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.service.Service;
import test.vo.UserVO;

public class ProfStudentListController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sid = request.getParameter("sid");
		
		Service service = Service.getInstance();
		ArrayList<UserVO> list = service.profStudentList(sid);
		
		request.setAttribute("list", list);
		HttpUtil.forward(request, response, "/profStudentListResult.jsp");
	}

}
