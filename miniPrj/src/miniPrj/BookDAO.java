package miniPrj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	Scanner scn = new Scanner(System.in); //이 클래스에서 쓴적있나?

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

	// 도서리스트
	List<Book> bookList() {
		getConn();
		List<Book> list = new ArrayList<>();
		String sql = " select * from book order by book_no";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			// 데이터 커서바꿔주는거 값이 있으면 계속 돌아감
			while (rs.next()) {
				Book book = new Book();
				book.setBookNo(rs.getInt("book_no"));
				book.setBookTitle(rs.getString("book_title"));
				book.setBookWriter(rs.getString("book_writer"));
				book.setPublish(rs.getString("publish"));
				book.setPubDate(rs.getString("pubdate"));

				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 도서등록
	boolean insertBook(Book book) {
		getConn();
		String sql = "insert into book(book_no,book_title,book_writer,publish,pubdate)\r\n"
				+ " values (book_seq.nextval, ?, ?, ?, ?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookWriter());
			psmt.setString(3, book.getPublish());
			psmt.setString(4, book.getPubDate());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 도서정보수정
	boolean updateBook(Book book) {
		System.out.println(book);
		getConn();
		String sql = "update book set book_title = ?,book_writer = ?,publish = ?,pubdate = ? where book_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getBookTitle());
			psmt.setString(2, book.getBookWriter());
			psmt.setString(3, book.getPublish());
			psmt.setString(4, book.getPubDate());
			psmt.setInt(5, book.getBookNo());

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 도서삭제
	boolean deleteBook(int bookno) {
		getConn();
		String sql = "delete book where book_no = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, bookno);

			int r = psmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}// 도서관리 끝

	// 도서검색 - 제목
	List<Book> titleSearch(Book book) {
		getConn();
		List<Book> list = new ArrayList<>();
		String sql = " select *\r\n"
				+ " from book\r\n"
				+ " where book_title like ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + book.getBookTitle() + "%");
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Book b = new Book();
				b.setBookNo(rs.getInt("book_no")); //화면에 보일게 두갠데
				b.setBookTitle(rs.getString("book_title"));
				b.setBookWriter(rs.getString("book_writer"));
				b.setPublish(rs.getString("publish"));
				b.setPubDate(rs.getString("pubdate"));
				
				list.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 도서검색 - 저자
	List<Book> writerSearch(Book book) {
		getConn();
		List<Book> list = new ArrayList<>();
		String sql = " select *\r\n" + " from book\r\n" + " where book_writer like ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, "%" + book.getBookWriter() + "%");

			rs = psmt.executeQuery();

			while (rs.next()) {
				Book b = new Book();
				b.setBookTitle("book_title"); //화면에 보일게 두갠데
				b.setBookWriter("book_writer");

				list.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
