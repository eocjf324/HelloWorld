package co.yedam.hr;

import java.util.List;

public class JdbcExe {
	public static void main(String[] args) {

		EmpVO emp = new EmpVO(1006, "황길동", "hwang@email2222", "대전시2222", 1300);
		EmpDAO dao = new EmpDAO();

//		등록
//		if(dao.addEmp(emp)) {
//			System.out.println("등록성공.");
//		}else {
//			System.out.println("등록실패.");
//		}

//		목록조회
//		List<EmpVO> list = dao.empList();
//		for(EmpVO vo : list) {
//			System.out.println(vo.toString());
//		}

//		if(dao.editEmp(emp)) {
//			System.out.println("수정 성공.");
//		}else {
//			System.out.println("수정 실패.");
//		}
		//삭제
//		if (dao.delEmp(1004)) {
//			System.out.println("삭제 성공.");
//		} else {
//			System.out.println("삭제 실패.");
//		}
		//단건조회
		emp = dao.getEmp(1002);
		if(emp != null) {
			System.out.println(emp.toString());
		}else {
			System.out.println("조회된결과없음");
		}

		System.out.println("end of prog");
	}

}
