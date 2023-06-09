package com.shinhan.model;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.vo.EmpVO;

//Service : 업무로직담당 
@Service //Component + service
public class EmpService {
	
	@Autowired	//Spring이 EmpDAO 타입이 같으면 Bean을 생성하여 자동주입
	EmpDAOMybatis empDao;
	
	// SP 호출
	/*
	 * public EmpVO getSalary(int empid) { return empDao.getSalary(empid); }
	 */

	public List<EmpVO> selectAll() {
 		return empDao.selectAll();
	}

	public EmpVO selectById(int empid) {
 		return empDao.selectById(empid);
	}

	public List<EmpVO> selectByDept(int deptid) {
		return empDao.selectByDept(deptid);
	}

	public List<EmpVO> selectByCondition(Integer[] deptid, String jobid, Double salary, Date hiredate) {
		return empDao.selectByCondition(deptid, jobid, salary, hiredate);
	}

	// 자신의 속한 부서의 평균 급여보다 더 적은 급여를 받는 직원들을 조회하시오
	/*
	 * public List<EmpVO> selectLAB() { List<EmpVO> emplist = empDao.selectLAB();
	 * System.out.println("[EempService] 실행건수:" + emplist.size()); return emplist; }
	 */

	// 신규직원등록 (insert)
	public String empInsert(EmpVO emp) {
		int result = empDao.empInsert(emp);
		return result > 0 ? "입력성공" : "입력실패";
	}

	// 직원정보수정 (update)
	public String empUpdate(EmpVO emp) {
		int result = empDao.empUpdate(emp);
		return result > 0 ? "update성공" : "update실패";
	}

	// 한건의 직원를 삭제하기
	public String empDelete(int empid) {
		int result = empDao.empDelete(empid);
		return result > 0 ? "delete성공" : "delete실패";

	}

}
