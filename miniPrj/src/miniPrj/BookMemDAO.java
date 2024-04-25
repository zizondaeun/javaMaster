package miniPrj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			conn = DriverManager.getConnection(url, "jsp", "jsp");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	// 회원조회
	List<BookMem> bookmemList(String name) {
		getConn();
		List<BookMem> list = new ArrayList<>();
		String sql = " select *\r\n" //
				+ " from member " //
				+ " where mem_name = nvl(?, mem_name) " //
				+ " order by mem_no";
				
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, name);

			rs = psmt.executeQuery();
			while (rs.next()) {
				BookMem member = new BookMem();
				member.setMemNo(rs.getInt("mem_no"));
				member.setMemName(rs.getString("mem_name"));
				member.setMemPhone(rs.getString("mem_phone"));
				member.setMemBirth(rs.getString("mem_birth"));
				member.setMemAddress(rs.getString("mem_address"));
				member.setReturnStatus(rs.getString("return_status"));
				member.setBookNo(rs.getInt("book_no"));

				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


}
