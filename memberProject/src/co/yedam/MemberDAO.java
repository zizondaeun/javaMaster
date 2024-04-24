package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
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
	
	//회원목록 기능
	List<Member> memList(){
		getConn();
		List<Member> list = new ArrayList<>();
		String sql = "select * from mem order by mem_no";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				Member mem = new Member();
				mem.setMemNo(rs.getInt("mem_no"));
				mem.setName(rs.getString("mem_name"));
				mem.setPhone(rs.getString("mem_phone"));
				mem.setBirths(rs.getString("mem_births"));
				mem.setGender(rs.getString("mem_gender"));
				
				list.add(mem);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//회원등록 기능
	boolean insertMem(Member mem) {
		getConn();
		String sql = "insert into mem(mem_no,mem_name,mem_phone,mem_births,mem_gender)\r\n"
				+ " values(mem_seq.nextval, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getName());
			psmt.setString(2, mem.getPhone());
			psmt.setString(3, mem.getBirths());
			psmt.setString(4, mem.getGender());
			
			int r = psmt.executeUpdate();
			if(r>0) {
				return true;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	//회원수정 기능
	boolean updateMem(Member mem) {
		getConn();
		String sql = "update mem";
		sql += " set phone = ?";
		sql += " where mem_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mem.getPhone());
			psmt.setInt(2, mem.getMemNo());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	//회원삭제 기능
	boolean deleteMem(int memno) {
		getConn();
		String sql = "delete from mem where mem_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, memno);
			
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
