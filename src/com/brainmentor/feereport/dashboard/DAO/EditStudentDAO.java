package com.brainmentor.feereport.dashboard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.brainmentor.feereport.dashboard.DTO.StudentDTO;
import com.brainmentor.feereport.utils.CommonDAO;
import com.brainmentor.feereport.utils.SQLQuery;

public class EditStudentDAO {

	
	
	
	
	public StudentDTO loadStudent(int rollno) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentDTO studentdto = new StudentDTO();
		try{
		con = CommonDAO.getConnection();
		System.out.println("rollno recieved:"+rollno);
		pstmt = con.prepareStatement(SQLQuery.LOAD_STUDENT_SQL);
		pstmt.setInt(1, rollno);
		rs = pstmt.executeQuery();
		while(rs.next()){
			studentdto.setName(rs.getString("name"));
			studentdto.setCourse(rs.getString("course"));
			studentdto.setCity(rs.getString("city"));
			studentdto.setAddress(rs.getString("address"));
			studentdto.setCountry(rs.getString("country"));
			studentdto.setEmail(rs.getString("email"));
			studentdto.setPhone_number(rs.getString("phone_number"));
			studentdto.setState(rs.getString("state"));
			studentdto.setDue(rs.getInt("due"));
			studentdto.setFee(rs.getInt("fee"));
			studentdto.setPaid(rs.getInt("paid"));
		}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		return studentdto;
		
		}
	
	
	
	     public String updateStudent(StudentDTO studentdto) throws ClassNotFoundException, SQLException{
	    // studentdto = new StudentDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement(SQLQuery.UPDATE_STUDENT_SQL);
		pstmt.setString(1,studentdto.getName() );
		pstmt.setString(2, studentdto.getEmail() );
		pstmt.setString(3, studentdto.getCourse());
		pstmt.setString(4, studentdto.getAddress());
		pstmt.setString(5, studentdto.getCity());
		pstmt.setString(6, studentdto.getState());
		pstmt.setString(7, studentdto.getCountry());
		pstmt.setString(8, studentdto.getPhone_number());
		
		int update = pstmt.executeUpdate();
		return update>0?"update successfully":"update unsuccessfull";
		}
		finally{
			if(pstmt!=null){
				pstmt.close();
			}
			if(con!=null){
				con.close();
			}
		}
		
	}
	
	}
	

