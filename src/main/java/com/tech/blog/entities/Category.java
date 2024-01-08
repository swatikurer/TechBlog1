package com.tech.blog.entities;

public class Category {
private int cid;
private String name;
private String  dscription;
public Category(int cid, String name, String dscription) {
	super();
	this.cid = cid;
	this.name = name;
	this.dscription = dscription;
}
public Category() {
	super();
}
public Category(String name, String dscription) {
	super();
	this.name = name;
	this.dscription = dscription;
}
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDscription() {
	return dscription;
}
public void setDscription(String dscription) {
	this.dscription = dscription;
}


}
