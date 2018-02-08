package com.sistmng.admin;

import java.util.*;

import com.sistmng.SQLConnection;

import java.sql.*;
import java.time.LocalDate;

public class AdminDAO {

	// 현재 날짜 구하는 변수
	private LocalDate now = LocalDate.now();

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

		String sql = "SELECT courseCode,courseName FROM course_";

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

	public int courseAdd(String value) {

		int result = 0;

		String sql = "INSERT INTO course_(courseCode,courseName) VALUES ((SELECT CONCAT('COU', LPAD(NVL(SUBSTR(MAX(courseCode), 4), 0) + 1, 3, 0)) AS newCourseCode FROM course_),?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

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

	public int courseDelete(String value) {

		int result = 0;

		String sql = "DELETE FROM course_ WHERE courseCode = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

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

	// 1.1.2 과정 삭제 가능 리스트

	public List<Admin> courseDeleteList() {
		List<Admin> result = new ArrayList<Admin>();

		// 삭제 쿼리문
		String sql = "SELECT c.courseCode, c.CourseName FROM course_ c, openCourse_ oc WHERE  c.courseCode = oc.courseCode(+) AND oc.courseCode IS NULL GROUP BY c.courseCode, c.courseName";

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

	// 과정 이름 물어보는 메소드
	public List<Admin> courseNameList(String value) {

		List<Admin> result = new ArrayList<Admin>();

		String sql = "SELECT courseCode,courseName FROM course_ WHERE courseCode=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

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

		String sql = "SELECT subjectCode,subjectName FROM subject_";

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

	public int subjectAdd(String value) {

		int result = 0;

		String sql = "INSERT INTO subject_(subjectCode,subjectName) VALUES ((SELECT CONCAT('SUB', LPAD(NVL(SUBSTR(MAX(subjectCode), 4), 0) + 1, 3, 0)) AS newSubjectCode FROM subject_),?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

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

	public int subjectDelete(String value) {

		int result = 0;

		String sql = "DELETE FROM subject_ WHERE subjectCode = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

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

		// 삭제 쿼리문
		String sql = "SELECT s.subjectCode, s.subjectName FROM subject_ s, openSubject_ os WHERE  s.subjectCode = os.subjectCode(+) AND os.subjectCode IS NULL GROUP BY  s.subjectCode, s.subjectName";

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

	// 과목이름 물어보는 메소드
	public List<Admin> subjectList(String value) {

		List<Admin> result = new ArrayList<Admin>();

		String sql = "SELECT subjectCode,subjectName FROM subject_ WHERE subjectCode =?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String courseCode = rs.getString("subjectCode");
				String courseName = rs.getString("subjectName");

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

	// 1.3 강의실 관리

	public List<Admin> classList() {

		List<Admin> result = new ArrayList<Admin>();

		String sql = "SELECT classCode,className,classQuota FROM class_";

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

	public int classAdd(String value1, int value2) {

		int result = 0;

		String sql = "INSERT INTO class_(classCode,className,classQuota) VALUES ((SELECT CONCAT('CLA', LPAD(NVL(SUBSTR(MAX(CLA), 4), 0) + 1, 3, 0)) AS newClassCode FROM class_),?,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value1);
			pstmt.setInt(2, value2);

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

	public int classDelete(String value) {

		int result = 0;

		String sql = "DELETE FROM class_ WHERE classCode=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

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

	// 1.3.2 강의실 삭제 가능 리스트
	public List<Admin> classDeleteList() {

		List<Admin> result = new ArrayList<Admin>();

		// 삭제 쿼리
		String sql = "SELECT c.classCode, c.className FROM class_ c, openCourse_ oc WHERE  c.classCode = oc.classCode(+) AND oc.classCode IS NULL GROUP BY  c.classCode, c.className";

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

	// 강의실 물어보는 메소드
	public List<Admin> classList(String value) {

		List<Admin> result = new ArrayList<Admin>();

		String sql = "SELECT classCode,className FROM class_";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String classCode = rs.getString("classCode");
				String className = rs.getString("className");

				Admin m = new Admin();

				m.setClassCode(classCode);
				m.setClassName(className);

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

		String sql = "SELECT bookCode,bookName,bookPublisher FROM books_";

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

	public int bookAdd(String value1, String value2) {

		int result = 0;

		String sql = "INSERT INTO books_(bookCode,bookName,bookPublisher) VALUES ((SELECT CONCAT('BOK', LPAD(NVL(SUBSTR(MAX(bookCode), 4), 0) + 1, 3, 0)) AS newBookCode FROM books_),?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value1);
			pstmt.setString(2, value2);

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

	public int bookDelete(String value) {

		int result = 0;

		String sql = "DELETE FROM books_ WHERE bookCode=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

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

		// 삭제 쿼리
		String sql = "SELECT b.bookCode, b.bookName FROM books_ b, openSubject_ os WHERE  b.bookCode = os.bookCode(+) AND  os.bookCode IS NULL GROUP BY  b.bookCode, b.bookName";

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

	// 교재 물어보는 메소드
	public List<Admin> bookList(String value) {

		List<Admin> result = new ArrayList<Admin>();

		String sql = "SELECT bookCode,bookName,bookPublisher FROM books_";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

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

	// 회원번호, 이름 구하는 메소드
	public List<Admin> midNameList(String value) {

		List<Admin> result = new ArrayList<Admin>();

		String sql = "SELECT mid,name_ FROM member_";

		sql += " WHERE memberStatus = I";
		sql += " AND mid = ?";

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

	public List<Admin> InstructorList() {

		List<Admin> result = new ArrayList<Admin>();

		/*
		 * SELECT m.mid, m.name_, m.ssn, m.phone, s.subjectName, i.instructorRegDate
		 * FROM member_ m, instructor_ i, checkSubject_ c, subject_ s WHERE m.mid =
		 * i.mid AND c.mid = i.mid AND s.subjectCode = c.subjectCode ORDER BY m.mid;
		 */

		// 강사고유번호, 이름, 주민등록번호 뒷자리, 전화번호, 강의가능과목, 강사등록일
		String sql = "SELECT m.mid, m.name_, m.ssn, m.phone, s.subjectName, i.instructorRegDate FROM member_ m, instructor_ i, checkSubject_ c, subject_ s WHERE m.mid = i.mid AND c.mid = i.mid AND s.subjectCode = c.subjectCode ORDER BY m.mid";
		int i = 0;
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
				LocalDate instructorRegDate = rs.getDate("instructorRegDate").toLocalDate();

				Admin m = new Admin();

				m.setMid(mid);
				m.setName_(name_);
				m.setSsn(ssn);
				m.setPhone(phone);
				m.setSubjectName(subjectName);
				m.setInstructorRegDate(instructorRegDate);

				if (result.size() == 0) {
					result.add(m);
				} else if (result.get(i).getMid().equals(mid)) {
					result.get(i).setSubjectName(String.format("%s / %s", result.get(i).getSubjectName(), subjectName));
				} else {
					result.add(m);
					++i;
				}

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

	public List<Admin> InstructorSubjectDetailList(String mid) {

		List<Admin> result = new ArrayList<Admin>();
		// [MEM002 / 장혜진]강사님
		// 강의 과목 / 개설 과목 코드 / 과목 시작일 / 과목 종료일 / 개설 과정 / 개설과정명 / 과정 시작일 / 과정 종료일 / 강의실 /
		// 강의상태
		/*
		 * CREATE OR REPLACE VIEW detailInstructor AS SELECT s.subjectName,
		 * p.openSubCode, p.openSubStartDate, p.openSubCloseDate, o.openCoCode,
		 * c.courseName, o.openCoStartDate, o.openCoCloseDate, l.className, k.mid FROM
		 * checkSubject_ k, subject_ s, openCourse_ o, course_ c, class_ l, openSubject_
		 * p WHERE p.mid = k.mid AND k.subjectCode = s.subjectCode AND s.subjectCode =
		 * p.subjectCode AND o.openCoCode = p.openCoCode AND o.classCode = l.classCode
		 * AND o.courseCode = c.courseCode AND p.subjectCode = s.subjectCode;
		 */
		String sql = "SELECT subjectName, openSubCode, openSubStartDate, openSubCloseDate, openCoCode, courseName, openCoStartDate, openCoCloseDate, className FROM detailInstructor WHERE mid = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mid);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				String subjectName = rs.getString("subjectName");
				String openSubCode = rs.getString("openSubCode");
				LocalDate openSubStartDate = rs.getDate("openSubStartDate").toLocalDate();
				LocalDate openSubCloseDate = rs.getDate("openSubCloseDate").toLocalDate();
				String courseName = rs.getString("courseName");
				LocalDate openCoStartDate = rs.getDate("openCoStartDate").toLocalDate();
				LocalDate openCoCloseDate = rs.getDate("openCoCloseDate").toLocalDate();
				String className = rs.getString("className");

				Admin m = new Admin();

				m.setSubjectName(subjectName);
				m.setOpenSubCode(openSubCode);
				m.setOpenSubStartDate(openSubStartDate);
				m.setOpenSubCloseDate(openSubCloseDate);
				m.setCourseName(courseName);
				m.setOpenCoStartDate(openCoStartDate);
				m.setOpenCoCloseDate(openCoCloseDate);
				m.setClassName(className);

				if (m.getOpenCoCloseDate().isAfter(now)) {
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

	public int InstructorSubjectAdd(String mid, String subjectCode) {

		int result = 0;

		String sql = "INSERT INTO checkSubject_(mid,subjectCode) VALUES (?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mid);
			pstmt.setString(2, subjectCode);

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

	public int InstructorSubjectDelete(String mid, String subjectCode) {

		int result = 0;

		String sql = "DELETE FROM checkSubject_ WHERE mid=? AND subjectCode = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mid);
			pstmt.setString(2, subjectCode);

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

	// 2.2 강사 등록 출력 리스트
	public List<Admin> InstructorAddList(String value) {

		List<Admin> result = new ArrayList<Admin>();

		String sql = "SELECT mid,name_,ssn,phone,memberRegDate,memberStatus FROM member_";
		sql += " WHERE name_ = ? ";
		sql += " AND memberStatus = S";

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
	
	public List<Admin> InstructorAddList(String value1,String value2) {

		List<Admin> result = new ArrayList<Admin>();

		String sql = "SELECT mid,name_,ssn,phone,memberRegDate,memberStatus FROM member_";
		sql += " WHERE name_ = ? ";
		sql += " AND ssn = ?";
		sql += " AND memberStatus = S";

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

	public int InstructorAdd(String value) {

		int result = 0;

		String sql = "INSERT INTO instructor_(mid,instructorRegDate) VALUES (?,SYSDATE)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

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
	
	

	// 2.2 강사등록 (신규회원)
	public int InstructorAddNew(String name_, String ssn, String phone, String memberRegDate) {

		int result = 0;

		String sql = "INSERT INTO member_(mid,memberStatus,name_,ssn,phone,memberRegDate) VALUES ((SELECT CONCAT('MEM', LPAD(NVL(SUBSTR(MAX(mid), 4), 0) + 1, 3, 0)) AS newMid FROM member_),'I',?,?,?,?)";
		
		
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
	
	public List<Admin> memberList(String value1,String value2){
		
		List<Admin> result = new ArrayList<Admin>();

		String sql = "SELECT mid,name_,ssn,phone,memberRegDate,memberStatus FROM member_";
		sql += " WHERE name_ = ? ";
		sql += " AND ssn = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value1);
			pstmt.setString(2, value2);

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
	


	// 2.3 강사 삭제

	// [삭제 가능 강사] -> (cf.개설과목등록여부로 판단, 강의가능과목은 cascade옵션 사용,

	// 강사와 회원가입테이블 같이 DELETE)

	// 2.2 강사 등록 출력 리스트
	public List<Admin> InstructorDeleteList() {

		List<Admin> result = new ArrayList<Admin>();

		String sql = "";

		sql += " WHERE name_ = ? ";
		sql += " AND memberStatus = I";

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
				m.setSubjectName(subjectName);
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

	public int InstructorDelete(String value) {

		int result = 0;

		String sql = "";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = SQLConnection.connect();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, value);

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

	public String studentSearch1() {

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

	public String studentDelete1() {

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

	public String studentDelete2() {

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