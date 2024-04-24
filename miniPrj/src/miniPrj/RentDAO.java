package miniPrj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class RentDAO {
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

	// 대출/반납현황
	List<RentBook> rentList(Search search) {
		getConn();
		List<RentBook> list = new ArrayList<>();
		String sql = "select b.rent_no, b.book_no, m.mem_no, decode(b.return_status,'Y','반납','대출 중') as return_status, bk.book_title, return_date\r\n"
				+ " from rent_book b\r\n"//
				+ " join member m\r\n"//
				+ " on b.mem_no = m.mem_no\r\n"//
				+ " join book bk\r\n"//
				+ " on b.book_no = bk.book_no\r\n"//
				+ " where m.mem_no = nvl(?,m.mem_no)"
				+ " and b.book_no = nvl(?,b.book_no)\r\n"//
				+ " order by b.rent_no";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, search.getMemNo());
			psmt.setString(2, search.getBookNo());
			rs = psmt.executeQuery();

			while (rs.next()) {
				RentBook rtbook = new RentBook();
				rtbook.setRentNo(rs.getInt("rent_no"));
				rtbook.setBookNo(rs.getInt("book_no"));
				rtbook.setMemNo(rs.getInt("mem_no"));
				rtbook.setReturnStatus(rs.getString("return_status"));
				rtbook.setReturnDate(rs.getString("return_date"));
				rtbook.setBookTitle(rs.getString("book_title"));

				list.add(rtbook);

			}
//			for (RentBook rentBook : list) {
//				System.out.println(rentBook.toString()); 
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

//				" select rent_no,m.mem_no,bk.book_title,decode(return_status,'Y','반납','대출') as flag\r\n"
//				+ " from rent_book b\r\n"
//				+ " join mem m\r\n"
//				+ " on b.mem_no = m.mem_no\r\n"
//				+ " join book bk\r\n"
//				+ " on b.book_no = bk.book_no\r\n"
//				+ " order by b.rent_no";
//		try {
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			
//			while(rs.next()) {
//				rtbook.setRentNo(rs.getInt("b.rent_no"));
//				rtbook.setBookNo(rs.getInt("book_no"));
//				rtbook.setMemNo(rs.getInt("mem_no"));
//				rtbook.setReturnStatus(rs.getString("return_status"));
//				rtbook.setReturnDate(rs.getString("return_date"));
//				rtbook.setBook_title(rs.getString("book_title"));
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return list;
//		
//	}

}
