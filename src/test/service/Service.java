package test.service;

import java.util.ArrayList;

import test.dao.SubjectDAO;
import test.dao.UserDAO;
import test.vo.EnrollVO;
import test.vo.SubjectVO;
import test.vo.UserVO;

public class Service {
	private static Service service = new Service(); 
	public UserDAO dao = UserDAO.getInstance(); 
	public SubjectDAO sdao = SubjectDAO.getInstance();
	
	private Service() {} 
	public static Service getInstance() { 
		return service;
	}	
	public boolean login(String id, String pwd, String login) {
		return dao.login(id, pwd, login);
	}
	public void profEnrollSubject(SubjectVO subject) {
		sdao.profEnrollSubject(subject);
	}
	public ArrayList<SubjectVO> profSubjectList(String id) {
		return sdao.profSubjectList(id);
	}
	public SubjectVO subjectSearch(String sid) {
		// TODO Auto-generated method stub
		return sdao.subjectSearch(sid);
	}
	public void studEnrollSubject(EnrollVO enroll) {
		sdao.profEnrollSubject(enroll);
	}
	public ArrayList<SubjectVO> studSubjectList(String id) {
		// TODO Auto-generated method stub
		return sdao.studSubjectList(id);
	}
	public ArrayList<UserVO> profStudentList(String sid) {
		// TODO Auto-generated method stub
		return dao.profStudentList(sid);
	}
}
