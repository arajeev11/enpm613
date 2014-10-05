package edu.umd.enpm613.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.umd.enpm613.dto.LoginDTO;
import edu.umd.enpm613.impl.LoginImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String user_role;
	private LoginDTO loggedUser;
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			username = request.getParameter("userid");
			password = request.getParameter("password");
			
			loggedUser = new LoginImpl().processLogin(username,password);
			if(null != loggedUser){
		    		user_role  = loggedUser.getUser_role();
		
		    	  redirectUser(user_role,response);
		    }
		    else{
		    	request.setAttribute("error", "Username or password incorrect");
		    	
		    }
	}
	
	protected static void redirectUser(String userType, HttpServletResponse response) throws IOException{
		if(userType.equals("admin")){
			response.sendRedirect("admin_home.jsp");
		}
		else if(userType.equals("student")){
			response.sendRedirect("student_home.jsp");
		}
	}

}
