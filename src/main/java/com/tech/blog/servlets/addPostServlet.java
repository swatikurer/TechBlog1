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
import javax.servlet.http.Part;

import com.tech.blog.dao.postDao;
import com.tech.blog.entities.Post;
import com.tech.blog.entities.user;
import com.tech.blog.helper.ConnectionProvider;

/**
 * Servlet implementation class addPostServlet
 */
@WebServlet("/addPostServlet")
@MultipartConfig
public class addPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()){
			
			int cid=Integer.parseInt(request.getParameter("cid"));
			String pTitle=request.getParameter("pTitle");
			String pContent=request.getParameter("pContent");
			String pCode=request.getParameter("pCode");
			Part part=request.getPart("pic");
			
			//getting user id
			HttpSession session=request.getSession();
			user userr=(user)session.getAttribute("currentUser");
			
		
		
		out.println("your pic title is" + pTitle);
		out.println(part.getSubmittedFileName());
		
		Post p=new Post(pTitle,pContent,pCode,part.getSubmittedFileName(),null,cid,userr.getId());
		postDao dao=new postDao(ConnectionProvider.getConnection());
		if(dao.savePost(p)) {
			out.println("DOne");
			
		}
		else {
			out.println("error");
			
		}
		
		
		
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
