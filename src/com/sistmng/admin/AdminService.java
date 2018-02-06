package com.sistmng.admin;

import java.util.*;

public class AdminService {
	
	private AdminDAO dao = new AdminDAO();
	
	//1.관리자 메뉴
	public void adminMenu(Scanner sc) {
		boolean run = true;
		
		while(run) {
			
		System.out.println("----------------------------------------------------------------------------------------------------");
		System.out.println("1.기초 정보 관리 2.강사 계정 관리 3.개설 과정 관리 4.개설 과목 관리 5.수강생 관리 6.성적 조회 0.종료");
		System.out.println("----------------------------------------------------------------------------------------------------");
		
		int num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
		
		case 0 : run=false; break;
		case 1: basicInfoMenu(sc);break;
		case 2: break;
		case 3: break;
		case 4: break;
		case 5: break;
		case 6: break;
		
		
		}
			
		}
		
	}
	
	//1 기초정보관리 메뉴
	public void basicInfoMenu(Scanner sc) {
		
		boolean run = true;
		
		while(run) {
			
		System.out.println("---------------------------------------------------------");
		System.out.println("1.과정 관리 2.과목 관리 3.강의실 관리 4. 교재 관리 0.종료");
		System.out.println("---------------------------------------------------------");
		
		int num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
		
		case 0 : run=false; break;
		case 1: courseList(sc); break;
		case 2: subjectList(sc);break;
		case 3: classList(sc);break;
		case 4: bookList(sc);break;
		
		}
			
		}
		
		
		
	}
	
	//1.1.과정관리
	public void courseList(Scanner sc){
		
		List<Admin>list = dao.courseList();
		
		System.out.println("--------------------------------------");
		System.out.println("과정코드 / 과정명");
		System.out.println("--------------------------------------");
		
		for(Admin m : list) {
			System.out.printf(String.format("%s / %s%n"),m.getCourseCode(),m.getCourseName());
		}
		boolean run = true;
		
		while(run) {
		
		System.out.println("--------------------------------");
		System.out.println("1.과정 입력 2.과정 삭제 0.나가기");
		System.out.println("--------------------------------");
		
		
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.print("선택 >");
		
		switch(num) {
		
		case 0 : run=false; break;
		case 1: this.courseAdd(sc); break;
		case 2: this.courseDelete(sc);break;
		
		
		}
			
		}
		
	}
	
	//1.1.1 과정입력
	public void courseAdd(Scanner sc) {
		
		System.out.print("과정명 >");
		String courseName = sc.next();
		
		Admin m = new Admin();
		
		m.setCourseName(courseName);
		
		int result = dao.courseAdd(m);
		
		if(result > 0) {
			System.out.printf(String.format("[%s]과정이 성공적으로 추가되었습니다.%n", m.getCourseName()));
		} else {
			System.out.println("이미 존재하는 과정명입니다.");
		}
		
	}
	
	//1.1.2 과정삭제
	public void courseDelete(Scanner sc) {
		
		List<Admin>list = dao.courseDeleteList();
		
		System.out.println("삭제 가능 과정 목록입니다.");
		System.out.println("------------------------------------------");
		for(Admin m : list) {
			System.out.printf(String.format("%s / %s %n",m.getCourseCode(),m.getCourseName() ));
		}
		
		System.out.print("과정코드 >");
		String courseCode = sc.next();
		
		Admin m = new Admin();

		m.setCourseCode(courseCode);
		System.out.printf(String.format("[%s] 과정을 삭제하시겠습니까 (y/n)?", m.getCourseName()));
		String yn = sc.next();
		
		if (yn.equalsIgnoreCase("y")) {
			
			int result = dao.courseDelete(m);
			
			if (result > 0) {
			System.out.println("삭제가 완료되었습니다.");
			} else {
				System.out.println("삭제가 정상적으로 이루어지지 않았습니다.");
			}
			
		} else if (yn.equalsIgnoreCase("n")) {
			return;
		} else {
			System.out.println("올바른 입력이 아닙니다.");
			return;
		}

		
	}
	
	//1.2 과목관리
	public void subjectList(Scanner sc) {
		
		List<Admin>list = dao.subjectList();
		
		System.out.println("--------------------------");
		System.out.println("과목코드 / 과정명 / 교재명");
		System.out.println("--------------------------");
		
		for(Admin m : list) {
			System.out.printf(String.format("%s / %s / %s %n"),m.getSubjectCode(),m.getSubjectName(),m.getBookName());
		}
		boolean run = true;
		
		while(run) {
		
		System.out.println("--------------------------------");
		System.out.println("1.과목 입력 2.과목 삭제 0.나가기");
		System.out.println("--------------------------------");
		
		
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.print("선택 >");
		
		switch(num) {
		
		case 0 : run=false; break;
		case 1: this.courseAdd(sc); break;
		case 2: this.courseDelete(sc);break;
		
		
		}
			
		}
		
	}
	
	//1.2.1 과목입력
	public void subjectAdd(Scanner sc) {
		
		System.out.print("과목명 >");
		String subjectName = sc.next();
		
		Admin m = new Admin();
		
		m.setSubjectName(subjectName);
		
		int result = dao.subjectAdd(m);
		
		if(result > 0) {
			System.out.printf(String.format("[%s]과목이 성공적으로 추가되었습니다.%n", m.getSubjectName()));
		} else {
			System.out.println("이미 존재하는 과목명입니다.");
		}
	}
	
	//1.2.2 과목삭제
	public void subjectDelete(Scanner sc) {
		
		List<Admin>list = dao.subjectDeleteList();
		
		System.out.println("삭제 가능 과정 목록입니다.");
		System.out.println("------------------------------------------");
		for(Admin m : list) {
			System.out.printf(String.format("%s / %s %n",m.getSubjectCode(),m.getSubjectName() ));
		}
		
		System.out.print("과목코드 >");
		String subjectCode = sc.next();
		
		Admin m = new Admin();

		m.setSubjectCode(subjectCode);
		System.out.printf(String.format("[%s] 과목을 삭제하시겠습니까 (y/n)?", m.getSubjectName()));
		String yn = sc.next();
		
		if (yn == "y" && yn == "Y") {
			
			int result = dao.subjectDelete(m);
			
			if (result > 0) {
			System.out.println("삭제가 완료되었습니다.");
			} else {
				System.out.println("삭제가 정상적으로 이루어지지 않았습니다.");
			}
			
		} else if (yn == "n" && yn == "N") {
			return;
		} else {
			System.out.println("올바른 입력이 아닙니다.");
			return;
		}
		
	}
	
	//1.3 강의실 관리
	public void classList(Scanner sc) {
		
		List<Admin>list = dao.classList();
		
		System.out.println("--------------------------");
		System.out.println("강의실 고유번호 / 강의실명 / 정원");
		System.out.println("--------------------------");
		
		for(Admin m : list) {
			System.out.printf(String.format("%s / %s / %s %n"),m.getClassCode(),m.getClassName(),m.getClassQuota());
		}
		boolean run = true;
		
		while(run) {
		
		System.out.println("------------------------------------");
		System.out.println("1.강의실 입력 2.강의실 삭제 0.나가기");
		System.out.println("------------------------------------");
		
		
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.print("선택 >");
		
		switch(num) {
		
		case 0 : run=false; break;
		case 1: this.classAdd(sc); break;
		case 2: this.classDelete(sc);break;
		
		
		}
			
		}
	}
	
	//1.3.1 강의실 입력
	public void classAdd(Scanner sc) {
		
		System.out.print("강의실명 >");
		String className = sc.next();
		
		Admin m = new Admin();
		
		m.setClassName(className);
		
		int result = dao.classAdd(m);
		
		if(result > 0) {
			System.out.printf(String.format("[%s / 정원: %d명 ]이 성공적으로 추가되었습니다.%n",m.getClassName(),m.getClassQuota()));
		} else {
			System.out.println("이미 존재하는 강의실입니다.");
		}
	}
	
	//1.3.2 강의실 삭제
	public void classDelete(Scanner sc) {
		
		List<Admin>list = dao.classDeleteList();
		
		System.out.println("삭제 가능 강의실 목록입니다.");
		System.out.println("------------------------------------------");
		for(Admin m : list) {
			System.out.printf(String.format("%s / %s %n",m.getClassCode(),m.getClassName() ));
		}
		
		System.out.print("강의실코드 >");
		String classCode = sc.next();
		
		Admin m = new Admin();

		m.setClassCode(classCode);
		System.out.printf(String.format("[%s] 강의실을 삭제하시겠습니까 (y/n)?", m.getClassName()));
		String yn = sc.next();
		
		if (yn == "y" && yn == "Y") {
			
			int result = dao.classDelete(m);
			
			if (result > 0) {
			System.out.println("삭제가 완료되었습니다.");
			} else {
				System.out.println("삭제가 정상적으로 이루어지지 않았습니다.");
			}
			
		} else if (yn == "n" && yn == "N") {
			return;
		} else {
			System.out.println("올바른 입력이 아닙니다.");
			return;
		}
	}
	
	//1.4 교재관리
	public void bookList(Scanner sc) {
		
		List<Admin>list = dao.bookList();
		
		System.out.println("----------------------------");
		System.out.println("교재번호 / 교재이름 / 출판사");
		System.out.println("----------------------------");
		
		for(Admin m : list) {
			System.out.printf(String.format("%s / %s / %s %n"),m.getBookCode(),m.getBookName(),m.getBookPublisher());
		}
		boolean run = true;
		
		while(run) {
		
		System.out.println("--------------------------------");
		System.out.println("1.교재 입력 2.교재 삭제 0.나가기");
		System.out.println("--------------------------------");
		
		
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.print("선택 >");
		
		switch(num) {
		
		case 0 : run=false; break;
		case 1: this.bookAdd(sc); break;
		case 2: this.bookDelete(sc);break;
		
		
		}
			
		}
		
	}
	
	//1.4.1 교재입력
	public void bookAdd(Scanner sc) {
		
		System.out.print("교재명 >");
		String bookName = sc.next();
		
		Admin m = new Admin();
		
		m.setBookName(bookName);
		
		int result = dao.bookAdd(m);
		
		if(result > 0) {
			System.out.printf(String.format("[%s / %s ]이(가) 성공적으로 추가되었습니다.%n",m.getBookName(),m.getBookPublisher()));
		} else {
			System.out.println("이미 존재하는 교재입니다.");
		}
	}
	
	//1.4.2 교재삭제
	public void bookDelete(Scanner sc) {
		

		List<Admin>list = dao.bookDeleteList();
		
		System.out.println("삭제 가능 교재 목록입니다.");
		System.out.println("------------------------------------------");
		for(Admin m : list) {
			System.out.printf(String.format("%s / %s / %s %n",m.getBookCode(),m.getBookName(),m.getBookPublisher() ));
		}
		
		System.out.print("교재번호 >");
		String bookCode = sc.next();
		
		Admin m = new Admin();

		m.setBookCode(bookCode);
		System.out.printf(String.format("[%s / %s / %s] 교재를 삭제하시겠습니까 (y/n)?", m.getBookCode(),m.getBookName(),m.getBookPublisher()));
		String yn = sc.next();
		
		if (yn == "y" && yn == "Y") {
			
			int result = dao.bookDelete(m);
			
			if (result > 0) {
			System.out.println("삭제가 완료되었습니다.");
			} else {
				System.out.println("삭제가 정상적으로 이루어지지 않았습니다.");
			}
			
		} else if (yn == "n" && yn == "N") {
			return;
		} else {
			System.out.println("올바른 입력이 아닙니다.");
			return;
		}
		
	}
	
	//-----------------------------------------------
	
	//2. 강사 계정 관리
	
	public void InstructorMenu(Scanner sc) {
		
		boolean run = true;
		
		while(run) {
			
		System.out.println("---------------------------------------------------------");
		System.out.println("1.강사 목록 2.강사 등록 3.강사 삭제 0.종료");
		System.out.println("---------------------------------------------------------");
		
		int num = sc.nextInt();
		sc.nextLine();
		
		switch(num) {
		
		case 0 : run=false; break;
		case 1: (sc); break;
		case 2: (sc);break;
		case 3: (sc);break;
		
		}
			
		}
		
	}
	
	
	//2.1 강사 목록
	
	public void InstructorList(Scanner sc) {
	
		List<Admin>list = this.dao.InstructorList();
		
		
		System.out.println("------------------------------------------------------------------");
		System.out.println("강사번호 / 이름 / 주민번호 / 전화번호 / 강의가능과목 / 강사등록일 ");
		System.out.println("------------------------------------------------------------------");
		
		for(Admin m : list) {
			System.out.printf(String.format("%s / %s / %s / %s / %s / %s %n"),m.getMid(),m.getName_(),m.getSsn(),m.getPhone(),m.getSubjectName(),m.getInstructorRegDate());
		}
		boolean run = true;
		
		while(run) {
		
		System.out.println("------------------------------------------------------------");
		System.out.println("1.상세보기 2.강의가능과목 추가 3.강의가능과목 삭제 0.나가기");
		System.out.println("------------------------------------------------------------");
		
		
		int num = sc.nextInt();
		sc.nextLine();
		
		System.out.print("선택 >");
		
		switch(num) {
		
		case 0 : run=false; break;
		case 1: this.InstructorSubjectDetailList(sc); break;
		case 2: break;
		case 3: break;
		
		
		}
			
		}
		
		
	}
	
	//2.1.1 강사상세보기
	
	public void InstructorSubjectDetailList(Scanner sc) {
		
		
		System.out.print("강사번호 >");
		String value = sc.next();
		
		Admin m = new Admin();
		
		m.setMid(value);
		
		
		List<Admin>list1 = this.dao.midNameList(value);
		
		List<Admin>list2 = this.dao.InstructorSubjectDetailList(value);
		
		for (Admin m1 : list1) {
			if(m1.getMid().equals(value)) {
				System.out.printf(String.format("[ %s / %s ] 강사님 %n", m1.getMid(),m1.getName_()));
			} else {
				System.out.println("검색 결과가 없습니다.");
			}
		}
		
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		
		for(Admin m2 : list2) {
			System.out.printf(String.format(" %s / %s / %s / %s / %s / %s / %s / %s / %s %n", m2.getSubjectName(),m2.getOpenSubCode(),m2.getOpenSubStartDate(),m2.getOpenSubCloseDate(),m2.getCourseName(),m2.getOpenCoStartDate(),m2.getOpenCoCloseDate(),m2.getClassName(),m2.getInstStatus() ));
		}
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		
	}
	
	
	//2.1.2 강의가능과목 추가
	
	public void InstructorSubjectAdd(Scanner sc) {
	
	System.out.print("강사번호 > ");
	String mid = sc.next();
	System.out.print("추가과목번호 > ");
	String subjectCode = sc.next();
	
	int result = dao.InstructorSubjectAdd(mid,subjectCode);
	
	if(result > 0) {
		System.out.printf(String.format("[%s / %s ]과목이 성공적으로 추가되었습니다.%n",mid,subjectCode));
	} else {
		System.out.println("이미 존재하는 과목입니다.");
	}
	
	}
	
	
	//2.1.3 강의가능과목 삭제
	
	public void InstructorSubjectDelete(Scanner sc) {
		

		
		
		System.out.print("강사번호 >");
		String mid = sc.next();
		
		System.out.print("삭제과목번호 >");
		String subjectCode = sc.next();
		
		Admin m = new Admin();

		m.setMid(mid);
		m.setSubjectCode(subjectCode);
		
		System.out.printf(String.format("[ %s / %s ] 과목을 삭제하시겠습니까 (y/n)?", mid,subjectCode));
		String yn = sc.next();
		
		if (yn.equalsIgnoreCase("y")) {
			
			int result = dao.InstructorSubjectDelete(mid, subjectCode);
			
			if (result > 0) {
			System.out.printf(String.format("[ %s / %s ] 과목이 성공적으로 삭제되었습니다.",mid,subjectCode));
			} else {
				System.out.println("삭제가 정상적으로 이루어지지 않았습니다.");
			}
			
		} else if (yn.equalsIgnoreCase("n")) {
			return;
		} else {
			System.out.println("올바른 입력이 아닙니다.");
			return;
		}
		
	}
	//2.2 강사 등록
	
	//2.3 강사 삭제
	
	//-----------------------------------------------
	
	//3. 개설 과정 관리
	//3.1 개설 과정 출력
	//3.1.1 개설 과정 상세보기
	//3.1.1.1 과목 상세보기
	//3.1.1.2 수강생 보기
	
	//3.2 개설 과정 등록
	//3.3 개설 과정 삭제
	
	//-----------------------------------------------
	
	
	//4. 개설 과목 관리
	//4.1 과정 상세보기
	//4.2 과목 등록
	//4.3 과목 삭제
	
	//-----------------------------------------------
	
	//5. 수강생 관리
	//5.1 수강생 등록
	//5.2 수강생 출력(중도탈락 관리)
	//5.3 수강생 과정 등록
	//5.4 수강생 삭제
	//5.4.1 수강생 과정 삭제
	//5.4.2 수강생 삭제
	
	//-----------------------------------------------
	
	//6. 성적 조회
	//6.1 개설 과정 보기
	//6.1.1 상세보기
	//6.1.1.1 과목별 성적 보기
	//6.2 수강생 검색
	//6.2.1 상세보기 (과정)
	//6.2.1.1 상세보기(과목)
	//6.3 성적 정보
	//6.3.2 이름검색
	//6.3.3 시험코드 검색
	
}
