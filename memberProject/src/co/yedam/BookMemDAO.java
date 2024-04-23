package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookMemDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	private void getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,"jsp","jsp");
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	//회원조회
	List<BookMem> list = new ArrayList<>();
	//String sql = ;
	
	//도서대출/반남현황
	
	//종료
}
