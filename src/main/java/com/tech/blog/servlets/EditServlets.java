package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.user;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

/**
 * Servlet implementation class EditServlets
 */
@WebServlet("/EditServlets")
@MultipartConfig
public class EditServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlets() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()){
			//fetch all data
			String userEmail=request.getParameter("user_email");
			String userName=request.getParameter("user_name");
			String userPassword=request.getParameter("user_password");
			String userAbout=request.getParameter("user_about");
			Part part=request.getPart("image");
			String imagename=part.getSubmittedFileName();
			
			//get old details from the session
			HttpSession s=request.getSession();
			user userr=(user)s.getAttribute("currentUser");
			userr.setEmail(userEmail);
			userr.setName(userName);
			userr.setPassword(userPassword);
			userr.setAbout(userAbout);
			userr.setProfile(imagename);
			
			//update database
			UserDao userdao=new UserDao(ConnectionProvider.getConnection());
			boolean ans=userdao.updateUser(userr);
			if(ans==true) {
				out.println("updated successfully");
				///TechBlog/src/main/webapp/pics
				
				String path=request.getRealPath("/")+"pics"+File.separator +userr.getPassword();
			Helper.deleteFile(path);
					if(Helper.saveFile(part.getInputStream(), path)) {
						out.println("profile updated successfully");
					}
				
				
			}
			else {
				out.println("Not updated ");
			}
			
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
