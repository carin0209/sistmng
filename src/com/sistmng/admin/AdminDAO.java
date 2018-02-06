package com.sistmng.admin;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.sistmng.*;

public class AdminDAO {
	
	
	public List<Admin> info() {
		
		List<Admin> result = new ArrayList<Admin>();
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String courseCode = rs.getString("courseCode");
				String courseName = rs.getString("courseName");
				
				Admin m = new Admin();
				
				m.setCourseCode(courseCode);
				m.setCourseName(courseName);
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
		
		
	}

	// -----------------------------------------------

	// 1. 기초정보관리 메뉴

	// 1.1 과정관리

	public List<Admin> courseList() {
		List<Admin> result = new ArrayList<Admin>();
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String courseCode = rs.getString("courseCode");
				String courseName = rs.getString("courseName");
				
				Admin m = new Admin();
				
				m.setCourseCode(courseCode);
				m.setCourseName(courseName);
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}

	// 1.1.1 과정입력

	public int courseAdd(Admin m) {
		
		int result = 0;
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getCourseName());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
		
	}

	// 1.1.2 과정삭제

	public int courseDelete(Admin m) {

		int result = 0;
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getCourseName());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}
	
	
	//1.1.2 과정 삭제 가능 리스트
	
	public List<Admin> courseDeleteList() {
		List<Admin> result = new ArrayList<Admin>();
		
		//삭제 쿼리문
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String courseCode = rs.getString("courseCode");
				String courseName = rs.getString("courseName");
				
				Admin m = new Admin();
				
				m.setCourseCode(courseCode);
				m.setCourseName(courseName);
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}

	// 1.2 과목관리

	public List<Admin> subjectList() {

		List<Admin> result = new ArrayList<Admin>();
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String subjectCode = rs.getString("subjectCode");
				String subjectName = rs.getString("subjectName");
				String bookName = rs.getString("bookName");
				
				Admin m = new Admin();
				
				m.setSubjectCode(subjectCode);
				m.setSubjectName(subjectName);
				m.setBookName(bookName);
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}

	// 1.2.1 과목입력

	public int subjectAdd(Admin m) {
		
		int result = 0;
		
		//subjectCode자동증가
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getSubjectName());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
		
	}

	// 1.2.2 과목삭제

	public int subjectDelete(Admin m) {

		int result = 0;
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getSubjectCode());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}
	
	// 1.2.2 과목 삭제 가능 리스트
	
	public List<Admin> subjectDeleteList() {

		List<Admin> result = new ArrayList<Admin>();
		
		//삭제 쿼리문
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String subjectCode = rs.getString("subjectCode");
				String subjectName = rs.getString("subjectName");
				
				Admin m = new Admin();
				
				m.setSubjectCode(subjectCode);
				m.setSubjectName(subjectName);
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}

	// 1.3 강의실 관리

	public List<Admin> classList() {

		List<Admin> result = new ArrayList<Admin>();
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String classCode = rs.getString("classCode");
				String className = rs.getString("className");
				String classQuota = rs.getString("classQuota");
				
				Admin m = new Admin();
				
				m.setClassCode(classCode);
				m.setClassName(className);
				m.setClassQuota(Integer.parseInt(classQuota));
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}

	// 1.3.1 강의실 입력

	public int classAdd(Admin m) {

		int result = 0;
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getClassName());
			pstmt.setInt(2,m.getClassQuota());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}

	// 1.3.2 강의실 삭제

	public int classDelete(Admin m) {

		int result = 0;
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getClassCode());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}
	
	//1.3.2 강의실 삭제 가능 리스트
	public List<Admin> classDeleteList() {
		
		List<Admin> result = new ArrayList<Admin>();
		
		//삭제 쿼리
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String classCode = rs.getString("classCode");
				String className = rs.getString("className");
				String classQuota = rs.getString("classQuota");
				
				Admin m = new Admin();
				
				m.setClassCode(classCode);
				m.setClassName(className);
				m.setClassQuota(Integer.parseInt(classQuota));
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}

	// 1.4 교재 관리

	public List<Admin> bookList() {
		
		List<Admin> result = new ArrayList<Admin>();
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String bookCode = rs.getString("bookCode");
				String bookName = rs.getString("bookName");
				String bookPublisher = rs.getString("bookPublisher");
				
				Admin m = new Admin();
				
				m.setBookCode(bookCode);
				m.setBookName(bookName);
				m.setBookPublisher(bookPublisher);
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;


	}

	// 1.4.1 교재 입력

	public int bookAdd(Admin m) {

		int result = 0;
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getBookName());
			pstmt.setString(2, m.getBookPublisher());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}

	// 1.4.2 교재 삭제

	public int bookDelete(Admin m) {
		
		int result = 0;
		
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getBookName());
			pstmt.setString(2, m.getBookPublisher());
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;
	}
	
	// 1.4.2 교재 삭제 가능 목록
	public List<Admin> bookDeleteList() {
		
		List<Admin> result = new ArrayList<Admin>();
		
		//삭제 쿼리
		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String bookCode = rs.getString("bookCode");
				String bookName = rs.getString("bookName");
				String bookPublisher = rs.getString("bookPublisher");
				
				Admin m = new Admin();
				
				m.setBookCode(bookCode);
				m.setBookName(bookName);
				m.setBookPublisher(bookPublisher);
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;


	}

	// -----------------------------------------------

	// 2. 강사 계정 관리
	
	//현재 날짜 구하는 변수
	private LocalDate now = LocalDate.now();
	
	//회원번호,이름 구하는 메소드
	public List<Admin>midNameList(String value) {
		

		List<Admin> result = new ArrayList<Admin>();
		
		String sql = "";
		
		sql += " WHERE memberStatus = I";
		sql += " AND name_ = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, value);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String mid = rs.getString("mid");
				String name_ = rs.getString("name_");
				
				Admin m = new Admin();
				
				m.setMid(mid); 
				m.setName_(name_);
				
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

		

	}
	
	
	
	// 2.1 강사 목록

	public List<Admin>InstructorList() {
		

		List<Admin> result = new ArrayList<Admin>();
		
		String sql = "";
		
		sql += " WHERE memberStatus = I";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String mid = rs.getString("mid");
				String name_ = rs.getString("name_");
				String ssn = rs.getString("ssn");
				String phone = rs.getString("phone");
				String subjectName = rs.getString("subjectName");
				String instructorRegDate = rs.getString("instructorRegDate");
				
				Admin m = new Admin();
				
				m.setMid(mid); 
				m.setName_(name_);
				m.setSsn(ssn);
				m.setPhone(phone);
				m.setSubjectCode(subjectName);
				m.setInstructorRegDate(LocalDate.parse(instructorRegDate));
				
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

		

	}

	// 2.1.1 강사상세보기

	public List<Admin> InstructorSubjectDetailList(String value) {
		
		List<Admin> result = new ArrayList<Admin>();
		
		String sql = "";
		   sql += " WHERE mid = ?";
		   sql += " AND memberStatus = I";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, value);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String subjectName = rs.getString("subjectName");
				String openSubCode = rs.getString("openSubCode");
				String openSubStartDate = rs.getString("openSubStartDate");
				String openSubCloseDate = rs.getString("openSubCloseDate");
				String courseName = rs.getString("courseName");
				String openCoStartDate = rs.getString("openCoStartDate");
				String openCoCloseDate = rs.getString("openCoCloseDate");
				String className = rs.getString("className");
				
				Admin m = new Admin();
				
				m.setSubjectName(subjectName);
				m.setOpenSubCode(openSubCode);
				m.setOpenSubStartDate(LocalDate.parse(openSubStartDate));
				m.setOpenSubCloseDate(LocalDate.parse(openSubCloseDate));
				m.setCourseName(courseName);
				m.setOpenCoStartDate(LocalDate.parse(openCoStartDate));
				m.setOpenCoCloseDate(LocalDate.parse(openCoCloseDate));
				m.setClassName(className);
				
				if(m.getOpenCoCloseDate().isAfter(now)) {
					m.setInstStatus("강의종료");
				} else if (m.getOpenCoCloseDate().isBefore(now) && m.getOpenCoStartDate().isBefore(now)) {
					m.setInstStatus("강의중");
				} else {
					m.setInstStatus("강의 예정");
				}
				
				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

		
		

	}

	// 2.1.2 강의가능과목 추가

	public int InstructorSubjectAdd(String mid,String subjectCode) {

		int result = 0;
		
		String sql = "";
		
		   sql += " WHERE mid = ?";
		   sql += " AND subjectCode = ?";
		   
		   sql += " AND memberStatus = I";
	

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1,mid);
			pstmt.setString(2,subjectCode);
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}

	// 2.1.3 강의가능과목 삭제

	public int InstructorSubjectDelete(String mid,String subjectCode) {

		int result = 0;
		
		String sql = "";
		
		   sql += " WHERE mid = ?";
		   sql += " AND memberStatus = I";


		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,mid);
			pstmt.setString(2,subjectCode);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}
	
	//2.2 강사 등록 출력 리스트
	public List<Admin> InstructorAddList(Admin m) {
		
		List<Admin> result = new ArrayList<Admin>();
		
		String sql = "";
		sql += " WHERE name_ = ? ";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String mid = rs.getString("mid");
				String name_ = rs.getString("name_");
				String ssn = rs.getString("ssn");
				String phone = rs.getString("phone");
				String memberRegDate = rs.getString("memberRegDate");
				String memberStatus = rs.getString("memberStatus");
				
				Admin m = new Admin();
				
				m.setMid(mid);
				m.setName_(name_);
				m.setSsn(ssn);
				m.setPhone(phone);
				m.setMemberRegDate(LocalDate.parse(memberRegDate));
				m.setMemberStatus(memberStatus);

				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}

	// 2.2 강사 등록(기존회원)

	public int InstructorAdd(Admin m,String key) {

		int result = 0;
		
		
		String sql = "";
		

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getMid());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}
	
	//2.2 강사등록 (신규회원)
	public int InstructorAddNew(Admin m,String key) {

		int result = 0;
		
		
		String sql = "";
		

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "name_");
			pstmt.setString(2, "ssn");
			pstmt.setString(3, "phone");
			pstmt.setString(4, "memberRegDate");
			
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}

	// 2.3 강사 삭제

	// [삭제 가능 강사] -> (cf.개설과목등록여부로 판단, 강의가능과목은 cascade옵션 사용,

	// 강사와 회원가입테이블 같이 DELETE)
	
	//2.2 강사 등록 출력 리스트
	public List<Admin> deleteList(String key,String value) {
		
		List<Admin> result = new ArrayList<Admin>();
		
		String sql = "";
		
		switch (key) {
		  case "강사명":
		   sql += " WHERE name_ = ? ";
		   sql += " AND memberStatus = I";
		   break;
		 }
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				String mid = rs.getString("mid");
				String name_ = rs.getString("name_");
				String ssn = rs.getString("ssn");
				String phone = rs.getString("phone");
				String memberRegDate = rs.getString("memberRegDate");
				String memberStatus = rs.getString("memberStatus");
				
				Admin m = new Admin();
				
				m.setMid(mid);
				m.setName_(name_);
				m.setSsn(ssn);
				m.setPhone(phone);
				m.setMemberRegDate(LocalDate.parse(memberRegDate));
				m.setMemberStatus(memberStatus);

				result.add(m);
				
			}
			rs.close();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}
		
		return result;

	}
	

	public int InstructorDelete(Admin m,String key) {

		int result = 0;
		
		String sql = "";
		

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getMid());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException se) {
			System.out.print(se.getMessage());
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException se) {
			}
			try {
				SQLConnection.close();
			} catch (SQLException se) {
				System.out.print(se.getMessage());
			}
		}

		return result;

	}
	
	
	
	
	
	
	
	

	// -----------------------------------------------

	// 3.개설 과정 관리

	// 3.1 개설 과정 출력

	public String openCourseList() {

		String result = null;

		return result;

	}

	// 3.1.1 개설 과정 상세보기

	public String openCourseDetailList() {

		String result = null;

		return result;

	}

	// 3.1.1.1 과목 상세보기

	public String subjectDetailList() {

		String result = null;

		return result;

	}

	// 3.1.1.2 수강생 보기

	public String studentDetailList() {

		String result = null;

		return result;

	}

	// 3.2 개설 과정 등록

	// courseList() 메소드 호출

	// classList() 메소드 호출

	public String openCourseAdd() {

		String result = null;

		return result;

	}

	// 3.3 개설 과정 삭제

	// openCourseList() 메소드 호출

	public String openCourseDelete() {

		String result = null;

		return result;

	}

	// -----------------------------------------------

	// 4. 개설 과목 관리

	public String openSubjectManagerment() {

		// openCourseList() 메소드 호출

		String result = null;

		return result;

	}

	// 4.1 과정 상세보기

	public String openSubjectDetailList() {

		String result = null;

		return result;

	}

	// 4.2 과목 등록

	public String openSubjectAdd() {

		// subjectList() 호출

		// InstructorList() 호출

		// bookList() 호출

		String result = null;

		return result;

	}

	// 4.3 과목 삭제

	public String openSubjectDelete() {

		// 과목코드/ 과목명 / 과목시작일 / 과목종료일 / 교재명 / 강사명

		String result = null;

		return result;

	}

	// -----------------------------------------------

	// 5.수강생 관리

	public String studentList() {

		String result = null;

		return result;

	}

	public String studentSearch() {

		String result = null;

		return result;

	}

	// 개설과정에 등록되지 않은 수강생 목록

	public String studentListWithOutDropOut() {

		String result = null;

		return result;

	}

	// 등록 가능한 개설 과정 리스트

	public String openCourseAddList() {

		String result = null;

		return result;

	}

	// 5.1 수강생 등록

	public String studentAdd() {

		// studentSearch() 호출

		// openCourseList() 호출

		String result = null;

		return result;

	}

	// 5.2 수강생 출력(중도탈락 관리)

	public String studentSearch() {

		// dropOut() 메소드 호출

		String result = null;

		return result;

	}

	public String dropOut() {

		String result = null;

		return result;

	}

	// 5.3 수강생 과정 등록

	public String studentCourseAdd() {

		// studentListWithOutDropOut() 호출

		// openCourseAddList() 호출

		String result = null;

		return result;

	}

	// 5.4 수강생 삭제

	public String studentDelete() {

		String result = null;

		return result;

	}

	// 5.4.1 수강생 과정 삭제

	public String studentCourseDelete() {

		// studentSearch() 호출

		String result = null;

		return result;

	}

	// 5.4.2 수강생 삭제

	public String studentDelete() {

		// studentSearch() 호출

		String result = null;

		return result;

	}

	// -----------------------------------------------

	// 6. 성적 조회

	public String scoreSearch() {

		String result = null;

		return result;

	}

	// 6.1 개설 과정 보기

	public String scoreOpenCourseList() {

		// searchScoreOpenCourseDetailList() 호출

		String result = null;

		return result;

	}

	// 6.1.1 상세보기

	public String scoreOpenCourseDetailList() {

		String result = null;

		return result;

	}

	// 6.1.1.1 과목별 성적 보기

	public String scoreOpenSubjectList() {

		String result = null;

		return result;

	}

	// 6.2 수강생 검색

	public String searchStudent() {

		String result = null;

		return result;

	}

	// 6.2.1 상세보기 (과정)

	public String studentOpenCourseDetail() {

		String result = null;

		return result;

	}

	// 6.2.1.1 상세보기 (과목)

	public String studentOpenSubjectDetail() {

		String result = null;

		return result;

	}

	// 6.3 성적 정보

	public String scoreInfo() {

		String result = null;

		return result;

	}

	// 6.3.1 성적 전체 출력

	public String viewAllScoreList() {

		String result = null;

		return result;

	}

	// 6.3.2 이름 검색

	public String searchNameScoreList() {

		String result = null;

		return result;

	}

	// 6.3.3 시험 코드 검색

	public String searchTestCodeScoreList() {

		String result = null;

		return result;

	}

}
