package com.brainmentor.feereport.dashboard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.brainmentor.feereport.dashboard.DTO.StudentDTO;
import com.brainmentor.feereport.utils.CommonDAO;
import com.brainmentor.feereport.utils.SQLQuery;

public class StudentDAO {

	public String AddStudent(StudentDTO studentdto) throws ClassNotFoundException, SQLException{
	
	Connection con = null;
	PreparedStatement pstmt = null;
	
	try{
	con = CommonDAO.getConnection();
	pstmt = con.prepareStatement(SQLQuery.STUDENT_SQL);
	pstmt.setString(1, studentdto.getName() );
	pstmt.setString(2, studentdto.getEmail() );
	pstmt.setString(3, studentdto.getCourse() );
	pstmt.setInt(4, studentdto.getFee() );
	pstmt.setInt(5, studentdto.getPaid() );
	pstmt.setInt(6, studentdto.getDue() );
	pstmt.setString(7, studentdto.getAddress() );
	pstmt.setString(8, studentdto.getCity());
	pstmt.setString(9, studentdto.getState());
	pstmt.setString(10, studentdto.getCountry());
	pstmt.setString(11, studentdto.getPhone_number() );
	pstmt.setInt(12, studentdto.getRollno());
	
	int insertedCount = pstmt.executeUpdate();
	return insertedCount>0?"inserted successfully":"not inserted successfully";
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
	
	
	
	
	
	public ArrayList<StudentDTO> viewStudent() throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<StudentDTO>  studentlist = new ArrayList<>();
		try{
		con = CommonDAO.getConnection();
		pstmt  = con.prepareStatement(SQLQuery.GET_STUDENT_SQL);
		rs = pstmt.executeQuery();
		while(rs.next()){
			StudentDTO studentdto = new StudentDTO();
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
			studentdto.setRollno(rs.getInt("rollno"));
			
			studentlist.add(studentdto);
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
		return studentlist;
	}
}
