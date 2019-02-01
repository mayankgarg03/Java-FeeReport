package com.brainmentor.feereport.dashboard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.brainmentor.feereport.dashboard.DTO.AccountantDTO;
import com.brainmentor.feereport.utils.CommonDAO;
import com.brainmentor.feereport.utils.SQLQuery;

public class AccountantDAO {

	
	public String addAccountant(AccountantDTO accountantdto) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		//AccountantDTO accountantdto = new AccountantDTO();
		try{
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement(SQLQuery.ACCOUNTANT_SQL);
		pstmt.setString(1,  accountantdto.getName());
		pstmt.setString(2,  accountantdto.getPassword());
		pstmt.setString(3,  accountantdto.getEmail());
		pstmt.setString(4,  accountantdto.getPhoneNumber());
		int insertedCount = pstmt.executeUpdate();
		return insertedCount>0?"Accountant Add succesfully":"Accountant not added";
	
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
	
	
	public ArrayList<AccountantDTO> viewAccountant() throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
        ArrayList<AccountantDTO> accountlist = new ArrayList<>();
		try{
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement(SQLQuery.GET_ACCOUNTANT_SQL);
         rs  =  pstmt.executeQuery();
         while(rs.next()){
        	 AccountantDTO accountdto = new AccountantDTO();
        	 accountdto.setName(rs.getString("name"));
        	 accountdto.setEmail(rs.getString("email"));
        	 accountdto.setPhoneNumber(rs.getString("phone_number"));
        	 accountlist.add(accountdto);
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
		return accountlist;
		
	}
}

