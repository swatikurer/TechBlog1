package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.tech.blog.entities.Category;
import com.tech.blog.entities.Post;

public class postDao {
Connection con;

public postDao(Connection con) {
	super();
	this.con = con;
}
public ArrayList<Category> getAllCategories(){
	ArrayList<Category> list=new ArrayList<>();
	try {
		String query="Select * from categories";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()) {
			int cid=rs.getInt("cid");
			String name =rs.getString("name");
			String description =rs.getString("description");
			Category c=new Category(cid,name,description);
			list.add(c);
			
			
		}
		
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return list;
	
	
}
public boolean savePost(Post p) {
	
	boolean f=false;
	try {
		String q="insert into posts(pTitle,pContent,pCode,ppic,catid,postid) values(?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(q);
		ps.setString(1,p.getpTitle());
		ps.setString(2,p.getpContent());
		ps.setString(3,p.getpCode());
		ps.setString(4,p.getpPic());
		ps.setInt(5,p.getCatid());
		ps.setInt(6,p.getPid());
		ps.executeUpdate();
		f=true;
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return f;
	
}
}
