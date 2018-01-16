package com.dream.pojo;

public class Comment {
	private int cId;
	private String cUser;
	private String cResponsibility;
	private String cContent;
	private int cState;
	private int vId;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcUser() {
		return cUser;
	}
	public void setcUser(String cUser) {
		this.cUser = cUser;
	}
	public String getcResponsibility() {
		return cResponsibility;
	}
	public void setcResponsibility(String cResponsibility) {
		this.cResponsibility = cResponsibility;
	}
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	public int getcState() {
		return cState;
	}
	public void setcState(int cState) {
		this.cState = cState;
	}
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	
}
