package com.dream.pojo;

public class VideoProviderRequest {
	private int vprId;
	private int uId;
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	private User user;
	private String vprState;
	private User vprResponsibility;
	public int getVprId() {
		return vprId;
	}
	public void setVprId(int vprId) {
		this.vprId = vprId;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getVprResponsibility() {
		return vprResponsibility;
	}
	public void setVprResponsibility(User vprResponsibility) {
		this.vprResponsibility = vprResponsibility;
	}
	public String getVprState() {
		return vprState;
	}
	public void setVprState(String vprState) {
		this.vprState = vprState;
	}

	
}
