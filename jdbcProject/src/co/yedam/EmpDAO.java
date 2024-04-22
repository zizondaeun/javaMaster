package co.yedam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	//DB에 접속 후 Connection.
	private void getConn() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,"jsp","jsp");
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}//end of getConn()
	
	//사원목록 반환 기능.
	List<Employee> empList() {
		getConn();
		List<Employee> list = new ArrayList<>();
		String sql = "select * from emp order by emp_no";
		try {
			psmt = conn.prepareStatement(sql); //예외처리
			rs = psmt.executeQuery();
			//System.out.println("사원번호 \t 사원명 \t 	연락처 \t 	급여 \t 입사일");
			//System.out.println("------------------------------------------------------------");
			//조회결과
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpNo(rs.getInt("emp_no"));
				emp.setEmpName(rs.getString("emp_name"));
				emp.setEmpName(rs.getString("email"));
				emp.setEmpPhone(rs.getString("emp_phone"));
				emp.setSalary(rs.getInt("salary"));
				emp.setHireDate(rs.getString("hire_date"));
				
				list.add(emp);
				
			//	System.out.println(rs.getInt("emp_no") + "\t" + rs.getString("emp_name") + "\t"
			//	+ rs.getString("emp_phone")+ "\t" + rs.getInt("salary") + "\t" + rs.getString("hire_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}//end of getConn()
	
	//사원등록 기능 (void -> boolean)
	boolean insertEmp(Employee emp) {
		getConn();
		String sql = "insert into emp (emp_no,emp_name,emp_phone,email,salary,hire_date)\r\n"
				+ "values(emp_seq.nextval, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getEmpName());
			psmt.setString(2, emp.getEmpPhone());
			psmt.setString(3, emp.getEmpEmail());
			psmt.setInt(4, emp.getSalary());
			psmt.setString(5, emp.getHireDate());
			
			int r = psmt.executeUpdate(); //실제 쿼리실행구문 / 처리된 건수 반환
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; //예외발생하거나 처리된 건수가 0 일 경우.
	}//end of insert
	
	//정보수정 기능
	boolean updateEmp(Employee emp) {
		getConn();
		String sql = "update emp";
		sql += " 	 set salary = ?";
		sql += " 	 ,email = ?";
		sql += " 	 where emp_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, emp.getSalary());
			psmt.setString(2, emp.getEmpEmail());
			psmt.setInt(3, emp.getEmpNo());
			
			int r = psmt.executeUpdate(); 
			if(r > 0) {
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}//end of update
	
	//사원삭제 기능
	boolean deleteEmp(int eno) {
		getConn();
		String sql = "delete from emp where emp_no = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eno);
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end of delete
	
	//종료
}
