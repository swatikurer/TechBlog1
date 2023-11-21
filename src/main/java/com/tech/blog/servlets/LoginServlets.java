package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.user;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class RegisterServlets
 */
@WebServlet("/LoginServlets")
@MultipartConfig
public class LoginServlets extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlets() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try(PrintWriter out=response.getWriter()){
		String userEmail=request.getParameter("email");
		String userPassword=request.getParameter("password");
		UserDao dao=new UserDao(ConnectionProvider.getConnection());
		user u=dao.GetUSerByEmailAndPsssword(userEmail,userPassword);
		if(u==null) {
			System.out.println("invalid details....Try again");
			
			
		}else {
			HttpSession s=request.getSession();
			s.setAttribute("currentUser", u);
			response.sendRedirect("profile.jsp");
			
		}
		
	}
	}

	
	

}
	
