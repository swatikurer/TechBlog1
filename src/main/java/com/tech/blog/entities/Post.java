package com.tech.blog.entities;

import java.security.Timestamp;

public class Post {
	private int pid;
	private String pTitle;
	private String pContent;
	private String pCode;
	private String pPic;
	private java.sql.Timestamp pDate;
	private int catid;
	private int userid;
	public Post() {
		super();
	}
	public Post(int pid, String pTitle, String pContent, String pCode, String pPic, java.sql.Timestamp pDate,
			int catid,int userid) {
		super();
		this.pid = pid;
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pPic = pPic;
		this.pDate = pDate;
		this.catid = catid;
		this.userid=userid;
	}
	public Post(String pTitle, String pContent, String pCode, String pPic, java.sql.Timestamp pDate, int catid,int userid) {
		super();
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pCode = pCode;
		this.pPic = pPic;
		this.pDate = pDate;
		this.catid = catid;
		this.userid=userid;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getpTitle() {
		return pTitle;
	}
	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}
	public String getpContent() {
		return pContent;
	}
	public void setpContent(String pContent) {
		this.pContent = pContent;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpPic() {
		return pPic;
	}
	public void setpPic(String pPic) {
		this.pPic = pPic;
	}
	public java.sql.Timestamp getpDate() {
		return pDate;
	}
	public void setpDate(java.sql.Timestamp pDate) {
		this.pDate = pDate;
	}
	public int getCatid() {
		return catid;
	}
	public void setCatid(int catid) {
		this.catid = catid;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int catid) {
		this.userid = userid;
	}
	

}
