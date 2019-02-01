package com.brainmentor.feereport.dashboard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.brainmentor.feereport.dashboard.DTO.StudentDTO;
import com.brainmentor.feereport.utils.CommonDAO;
import com.brainmentor.feereport.utils.SQLQuery;

public class DueFeeDAO {

	
	
	public StudentDTO dueFee(int rollno) throws  SQLException, ClassNotFoundException{
		StudentDTO studentdto = new StudentDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement(SQLQuery.DUE_FEE_SQL);
		pstmt.setInt(1, rollno);
		//System.out.println("in duefee"+rollno);
		rs= pstmt.executeQuery();
		while(rs.next()){
			studentdto.setName(rs.getString("name"));
			studentdto.setFee(rs.getInt("fee"));
			studentdto.setPaid(rs.getInt("paid"));
			studentdto.setDue(rs.getInt("due"));
          					
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
	
	
	public String submitDueFee(int rollno,int paid,int due) throws ClassNotFoundException, SQLException{
//		StudentDTO studentdto = new StudentDTO();
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
		con=CommonDAO.getConnection();
		pstmt = con.prepareStatement(SQLQuery.FEE_SQL);
		pstmt.setInt(1, paid);
		pstmt.setInt(2, due);
		pstmt.setInt(3, rollno);
		int update = pstmt.executeUpdate();
		return update>0?"fee submit succesfully":"fee not submitted";
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
