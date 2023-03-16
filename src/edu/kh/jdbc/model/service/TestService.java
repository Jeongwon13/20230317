package edu.kh.jdbc.model.service;

import static edu.kh.jdbc.common.JDBCTemplate.close;
import static edu.kh.jdbc.common.JDBCTemplate.commit;
import static edu.kh.jdbc.common.JDBCTemplate.getConnection;
import static edu.kh.jdbc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.sql.SQLException;

import edu.kh.jdbc.model.dao.TestDAO;
import edu.kh.jdbc.model.vo.TestVO;

public class TestService {
	
	private TestDAO dao = new TestDAO();
	
	public int insert(TestVO vo1) throws SQLException {
		
		Connection conn = getConnection();
		
		int result = dao.insert(conn, vo1);
		
		if(result > 0) commit(conn);
		else	rollback(conn);
		
		close(conn);
		
		return result;
		
	}
	

	public int insert(TestVO vo1, TestVO vo2, TestVO vo3) throws Exception {
		
		Connection conn = getConnection();
		
		int result = 0;
		
		try {
			int result1 = dao.insert(conn, vo1);
			int result2 = dao.insert(conn, vo2);
			int result3 = dao.insert(conn, vo3);
			
			if(result1 + result2 + result3 == 3) {
				commit(conn);
				result = 1;
			} else {
				rollback(conn);
				result = 0;
			}
		} catch(SQLException e) {
			rollback(conn);
			
			throw new Exception("DAO 수행 중 예외 발생");
		
		} finally {
			close(conn);
		}
		
		return result;
	}
	
}
