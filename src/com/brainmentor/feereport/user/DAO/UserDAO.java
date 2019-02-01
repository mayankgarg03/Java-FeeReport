package com.brainmentor.feereport.user.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.brainmentor.feereport.DTO.RegisterDTO;
import com.brainmentor.feereport.DTO.RightDTO;
import com.brainmentor.feereport.utils.CommonDAO;
import com.brainmentor.feereport.utils.SQLQuery;

public class UserDAO {
             
	public String doRegister(RegisterDTO registerdto) throws ClassNotFoundException, SQLException{
		Connection con = null;
		PreparedStatement pstmt =null;
		try{
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement(SQLQuery.REGISTER_SQL);
		pstmt.setString(1, registerdto.getUsername());
		pstmt.setString(2,registerdto.getPassword());
		//pstmt.setString(3, registerdto.getType());
		int update = pstmt.executeUpdate();
		return update>0?"succcessfully register":"not register";
		
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
	
	
	
	public RegisterDTO doLogin(String username , String password) throws ClassNotFoundException, SQLException{
		RegisterDTO registerdto = null;
		
		
		Connection con = null;
		PreparedStatement pstmt =null;
		ResultSet rs =  null;
		ArrayList<RightDTO> rights = null;
		try{
		con = CommonDAO.getConnection();
		pstmt = con.prepareStatement(SQLQuery.LOGIN_SQL);
		pstmt.setString(1, username);
		pstmt.setString(2, password);
	//	pstmt.setString(3, type);
		
		rs = pstmt.executeQuery();
//		  if(rs.next()){
//	        	 return "WELCOME " + username +" "+type;
//	         }
//	         else
//	        	 return "invalid userid or password";
		
		
		while(rs.next()){
			if(registerdto==null){
				registerdto = new RegisterDTO();
				registerdto.setUsername(rs.getString("username"));
				registerdto.setRoleName(rs.getString("rolename"));
				rights = new ArrayList<>();
				registerdto.setRights(rights);
				
			}
	
		RightDTO rightdto = new RightDTO(rs.getString("rightname"),rs.getString("screenname"));
		rights.add(rightdto);
		}
		
	return registerdto;
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
}
}
	