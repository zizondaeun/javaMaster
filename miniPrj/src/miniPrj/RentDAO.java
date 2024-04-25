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
		String sql = "select b.rent_no, b.book_no, m.mem_no, m.mem_name, decode(b.return_status,'Y','반납','대출 중') as return_status, bk.book_title, return_date\r\n"
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
				rtbook.setMemName(rs.getString("mem_name"));
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

	// 대출기능
	public boolean rentBook(RentBook rentbook) {
		getConn();
		String sql = " insert into rent_book\r\n"
				+ " values (rent_seq.nextval,?,?,'N',sysdate + 12)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, rentbook.getBookNo());
			psmt.setInt(2, rentbook.getMemNo());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 반납기능
	public boolean rentBook(TurnBook turnbook) {
		getConn();
		String sql = " \r\n"
				+ " update rent_book tr\r\n"
				+ " set return_Status = 'Y'\r\n"
				+ " where tr.mem_no = ?\r\n"
				+ " and   tr.book_no = ?\r\n"
				+ " and   tr.return_status = 'N'";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, turnbook.getMemNo());
			psmt.setInt(2, turnbook.getBookNo());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	

}
