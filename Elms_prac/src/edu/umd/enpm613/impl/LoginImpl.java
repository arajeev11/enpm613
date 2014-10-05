package edu.umd.enpm613.impl;

import java.sql.*;

import edu.umd.enpm613.dto.LoginDTO;

public class LoginImpl {

			LoginDTO loggedUser = new LoginDTO();
			String user_Id;
			String password;
			String user_role;
			Connection connection = null;
			Statement st = null;
			ResultSet rs = null;
			
			public LoginDTO processLogin(String userId, String pswd){
				
				DatabaseHelper db = new DatabaseHelper();
				connection = db.makeConnection();
				try{
					st = connection.createStatement();
					rs = st.executeQuery("select * from login_t");
					while(rs.next()){
						System.out.println("Looping resultset");
						user_Id = rs.getString(1);
						password = rs.getString(2);
						if(user_Id.equals(userId) && password.equals(pswd)){
							
							
							loggedUser.setUserId(user_Id);
							loggedUser.setPassword(pswd);
							user_role = rs.getString(3);
							loggedUser.setUser_role(user_role);
							return loggedUser;
						}
						
					}
					
					
				}
				catch(SQLException sqe)
				{
					sqe.printStackTrace();
				}
				return null;
			}
}
