package com.tech.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tech.blog.entities.user;

public class UserDao {
private Connection con;

public UserDao(Connection con) {
	//super();
	this.con = con;
}
//method to insert dat into database
public boolean saveuser(user user) {
	boolean f=false;
	try {
		
		String insert_query="insert into user(name,email,password,gender,about) values(?,?,?,?,?)";
		PreparedStatement ps=this.con.prepareStatement(insert_query);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		ps.setString(4, user.getGender());
		ps.setString(5, user.getAbout());
		ps.executeUpdate();
		f=true;
		
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return f;
	
}

//get user by their email and password
public user GetUSerByEmailAndPsssword(String email,String password) {
	user userr=null;
	
	try {
		String query="Select * from user where email=? and password=?";
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			userr=new user();
			//data from db
			String name=rs.getString("name");
			//set to user object
			userr.setName(name);
			userr.setId(rs.getInt("id"));
			userr.setEmail(rs.getString("email"));
			userr.setPassword(rs.getString("password"));
			userr.setGender(rs.getString("gender"));
			userr.setAbout(rs.getString("about"));
			userr.setDateTime(rs.getTimestamp("rdate"));
			userr.setProfile(rs.getString("profile"));
			
			
		
		
		}
		
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	return userr;

}
public boolean updateUser(user userr) {
	boolean f=false;
	try {
		String query="update user set name=? , email=? ,password=?, gender=? ,about=?,profile=? where id=?";
		PreparedStatement p=con.prepareStatement(query);
		p.setString(1, userr.getName());
		p.setString(2, userr.getEmail());
		p.setString(3, userr.getPassword());
		p.setString(4, userr.getGender());
		p.setString(5, userr.getAbout());
		p.setString(6, userr.getProfile());
		p.setInt(7, userr.getId());
		p.executeUpdate();
		f=true;
		
		
	} catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	return f;
}
}
