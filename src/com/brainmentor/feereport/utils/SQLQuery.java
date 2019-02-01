package com.brainmentor.feereport.utils;

public interface SQLQuery {
            String REGISTER_SQL = "insert into user_mst (username , password) values(?,?)";
           // String LOGIN_SQL = "select username , password , type from fee_user where username = ? and password = ? and type = ?";

String LOGIN_SQL = " SELECT USER_MST.USERNAME, ROLE_MST.NAME AS ROLENAME, RIGHT_MST.NAME AS RIGHTNAME,RIGHT_MST.SCREENNAME FROM "
		+ "USER_MST, ROLE_MST,RIGHT_MST,USER_ROLE_MAPPING,ROLE_RIGHT_MAPPING WHERE USER_MST.UID=USER_ROLE_MAPPING.UID AND "
		+ "ROLE_MST.ROLEID=USER_ROLE_MAPPING.ROLEID AND ROLE_MST.ROLEID=ROLE_RIGHT_MAPPING.ROLEID AND"
		+ " RIGHT_MST.RIGHTID=ROLE_RIGHT_MAPPING.RIGHTID AND USER_MST.USERNAME=? and USER_MST.PASSWORD=?";

String ACCOUNTANT_SQL = "insert into accountant (name,password,email,phone_number) values(?,?,?,?)";
String GET_ACCOUNTANT_SQL = "select name,email,phone_number from accountant";
String STUDENT_SQL = "insert into student (name , email , course , fee , paid , due ,address,city,state,country,phone_number,rollno) "
		+ "values(?,?,?,?,?,?,?,?,?,?,?,?) ";
String GET_STUDENT_SQL = "select name , email , course , fee , paid , due ,address,city,state,country,phone_number,rollno from student";
String LOAD_STUDENT_SQL = "select name , email , course , fee , paid , due ,address,city,state,country,phone_number from student where rollno = ?";
String UPDATE_STUDENT_SQL = "update student set name = ? ,  email = ? , course = ? ,address = ?,city = ?,state = ?,country = ?,phone_number = ?";
String DUE_FEE_SQL = "select name,fee,paid,due from student where rollno = ?";
String FEE_SQL = "update student set paid = ? , due = ?  where rollno = ?";
}

