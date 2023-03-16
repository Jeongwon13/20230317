package edu.kh.jdbc.run;

import java.sql.SQLException;

import edu.kh.jdbc.model.service.TestService;
import edu.kh.jdbc.model.vo.TestVO;

public class Run2 {

	public static void main(String[] args) throws Exception {
	
		TestService service = new TestService();
		
		TestVO vo1 = new TestVO(2,"제목222","내용222");
		TestVO vo2 = new TestVO(3,"제목333","내용333");
		TestVO vo3 = new TestVO(4,"제목444","내용444");
		
		try {
			int result = service.insert(vo1, vo2, vo3);
			
			if(result > 0) {
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패~");
			}
			
		} catch(SQLException e) {
			System.out.println("SQL 수행 중 오류 발생");
		}
		
	}

}
