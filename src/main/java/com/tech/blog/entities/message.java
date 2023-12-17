package com.tech.blog.entities;

public class message {
	private String content;
	private String type;
	private String CSSclass;

	public message(String content, String type, String cSSclass) {
		super();
		this.content = content;
		this.type = type;
		CSSclass = cSSclass;
	}
	//getters and setters

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCSSclass() {
		return CSSclass;
	}

	public void setCSSclass(String cSSclass) {
		CSSclass = cSSclass;
	}
	

}
