package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
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
	
	//도서정보 조회
	List<Book> bookList(){
		getConn();
		List<Book> list = new ArrayList<>();
		String sql = " select * from book order by book_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			//데이터 커서바꿔주는거 값이 있으면 계속 돌아감
			while(rs.next()) {
				Book book = new Book();
				book.setBookNo(rs.getInt("book_no"));
				book.setBookTitle(rs.getString("book_title"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setPublish(rs.getString("publish"));
				book.setPubDate(rs.getString("pubdate"));
				
				list.add(book);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//도서등록
	boolean insertBook(Book book) {
		getConn();
		String sql = "insert into book(book_no,book_title,book_writer,publish,pubdate)\r\n"
				+ " values (book_seq.nextval, ?, ?, ?, ?)";
		try {
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookWriter());
			psmt.setString(3, book.getPublish());
			psmt.setString(4, book.getPubDate());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//도서정보수정
	boolean updateBook(Book book) {
		getConn();
		String sql = "update book";
		sql += " set book_title = ?,book_writer = ?,publish = ?,pubdate = ?";
		sql += " where book_no = ?";
		//sql += " set book_no = ?";
		//sql += " where in (select book_title,book_writer,publish,pubdate"
		//		+ "from book)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookWriter());
			psmt.setString(3, book.getPublish());
			psmt.setString(4, book.getPubDate());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//도서삭제
	boolean deleteBook(int bookno) {
		getConn();
		String sql = "delete book from book where book_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bookno);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//회원조회
	
	//도서대출/반남현황
	
	//종료
	
}
