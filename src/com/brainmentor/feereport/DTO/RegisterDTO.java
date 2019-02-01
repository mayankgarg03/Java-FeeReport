package com.brainmentor.feereport.DTO;

import java.util.ArrayList;

public class RegisterDTO {

	
	private String username;
	private String Password;
	private String type;
	private String roleName;
	private ArrayList<RightDTO> rights = new ArrayList<>();

	
public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public ArrayList<RightDTO> getRights() {
		return rights;
	}
	public void setRights(ArrayList<RightDTO> rights) {
		this.rights = rights;
	}
	//	public RegisterDTO(String username, String password, String type) {
//		super();
//		this.username = username;
//		Password = password;
//		this.type = type;
//	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
