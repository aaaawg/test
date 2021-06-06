package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import test.vo.UserVO;

public class UserDAO {
	private static UserDAO dao = new UserDAO(); 
	private UserDAO() {} 
	public static UserDAO getInstance() {
		return dao;
	}
	public Connection connect() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/class","root","a025763");
		} catch (Exception e) {
			 System.out.println("MDAO:connect" + e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch(Exception e) {
				System.out.println("Pstmt close error" + e);
			}
		}
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				System.out.println("Conn close error" + e);
			}
		}
	}
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch(Exception e) {
				System.out.println("rs close error" + e);
			}
		}
		close(conn,pstmt);
	}
	public boolean login(String id, String pwd, String login) {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		try {
			conn = connect();
			if(login.equals("professor")) {
				pstmt = conn.prepareStatement("select * from prof where id=? and pwd=?;");
				pstmt.setString(1, id); 
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery(); 
				if(rs.next()) { 
					result = true;
				} else {
					result = false;
				}
			} else if (login.equals("student")) {
				pstmt = conn.prepareStatement("select * from student where id=? and pwd=?;");
				pstmt.setString(1, id); 
				pstmt.setString(2, pwd);
				rs = pstmt.executeQuery(); 
				if(rs.next()) { 
					result = true;
				} else {
					result = false;
				}
			}
		} catch (Exception e) {
			System.out.println("login error: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	public ArrayList<UserVO> profStudentList(String sid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO student = null;
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		try {
			conn = connect();				
			pstmt = conn.prepareStatement("select student.id, student.name "
					+ "from enroll, student where enroll.id=? and enroll.name=student.id;");
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				student = new UserVO();
				student.setId(rs.getString(1));
				student.setName(rs.getString(2));
				list.add(student); 
			}
		} catch (Exception e) {
			System.out.println("오류발생: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}

}
