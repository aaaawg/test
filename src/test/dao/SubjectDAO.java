package test.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import test.vo.EnrollVO;
import test.vo.SubjectVO;

public class SubjectDAO {
	private static SubjectDAO sdao = new SubjectDAO(); 
	private SubjectDAO() {} 
	public static SubjectDAO getInstance() {
		return sdao;
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
	public void profEnrollSubject(SubjectVO subject) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into subject values(?, ?, ?, ?);");
			pstmt.setString(1, subject.getsId());
			pstmt.setString(2, subject.getName());
			pstmt.setInt(3, subject.getMax());
			pstmt.setString(4, subject.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("pEnroll error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public ArrayList<SubjectVO> profSubjectList(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectVO subject = null;
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();
		try {
			conn = connect();				
			pstmt = conn.prepareStatement("select * from subject where prof=?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				subject = new SubjectVO();
				subject.setsId(rs.getString(1));
				subject.setName(rs.getString(2));
				subject.setMax(rs.getInt(3));
				list.add(subject); 
			}
		} catch (Exception e) {
			System.out.println("오류발생: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	public SubjectVO subjectSearch(String sid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectVO subject = null;
		try {
			conn = connect();				
			pstmt = conn.prepareStatement("select * from subject where id=?;");
			pstmt.setString(1, sid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				subject = new SubjectVO();
				subject.setsId(rs.getString(1));
				subject.setName(rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println("오류발생: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return subject;
	}
	public void profEnrollSubject(EnrollVO enroll) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = connect();
			pstmt = conn.prepareStatement("insert into enroll values(?, ?);");
			pstmt.setString(1, enroll.getId());
			pstmt.setString(2, enroll.getName());
			pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("sEnroll error: " + e);
		} finally {
			close(conn, pstmt);
		}
	}
	public ArrayList<SubjectVO> studSubjectList(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		SubjectVO subject = null;
		ArrayList<SubjectVO> list = new ArrayList<SubjectVO>();
		try {
			conn = connect();				
			pstmt = conn.prepareStatement("select subject.id, subject.name "
					+ "from enroll, subject where enroll.id=subject.id and enroll.name=?;");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				subject = new SubjectVO();
				subject.setsId(rs.getString(1));
				subject.setName(rs.getString(2));
				list.add(subject); 
			}
		} catch (Exception e) {
			System.out.println("오류발생: " + e);
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}

}
