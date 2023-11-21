package com.tech.blog.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.user;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class RegisterServlets
 */
@WebServlet("/RegisterServlets")
@MultipartConfig
public class RegisterServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegisterServlets() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try (java.io.PrintWriter out = response.getWriter()) {
			
			
			// fecth form data
						String check = request.getParameter("check");
						if (check == null) {
							out.println("please check all details");

						} else {
							// fetch remaining data
							String name = request.getParameter("user_name");
							String email = request.getParameter("user_email");
							String password = request.getParameter("user_password");
							String gender = request.getParameter("gender");
							String about = request.getParameter("about");
							
							//create user object and set all data to that object
							user userr=new user(name,email,password,gender,about);
							
							
							//create user dao object
							UserDao dao=new UserDao(ConnectionProvider.getConnection());
							if(dao.saveuser(userr)) {
								out.println("Done");
							}else {
								out.println("Error");
							}
						}
						out.println(check);

			

			/*
			 * // fecth form data String check = request.getParameter("check"); if (check ==
			 * null) { out.println("please check all details");
			 * 
			 * } else { // fetch remaining data String name =
			 * request.getParameter("user_name"); String email =
			 * request.getParameter("user_email"); String password =
			 * request.getParameter("user_password"); String gender =
			 * request.getParameter("gender"); String about = request.getParameter("about");
			 * //create user dao object } out.println(check);
			 */
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
