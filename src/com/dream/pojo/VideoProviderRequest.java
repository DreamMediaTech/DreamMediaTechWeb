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
	private int vprResponsibility;
	private String vprName;
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
	
	public int getVprResponsibility() {
		return vprResponsibility;
	}
	public void setVprResponsibility(int vprResponsibility) {
		this.vprResponsibility = vprResponsibility;
	}
	public String getVprName() {
		return vprName;
	}
	public void setVprName(String vprName) {
		this.vprName = vprName;
	}
	public String getVprState() {
		return vprState;
	}
	public void setVprState(String vprState) {
		this.vprState = vprState;
	}

	
}
