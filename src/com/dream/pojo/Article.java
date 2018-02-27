package com.dream.pojo;

public class Article {
	private int aId;
	private String aTitle;
	private String aContent;
	private String aState;
	private int clicks;
	private String aTime;
	private User user;
	private int uId;
	private int auId;
	private String auName;
	private String aSendtime;
	private String aCover;
	
	
	public int getAuId() {
		return auId;
	}
	public void setAuId(int auId) {
		this.auId = auId;
	}
	public String getAuName() {
		return auName;
	}
	public void setAuName(String auName) {
		this.auName = auName;
	}
	public String getaSendtime() {
		return aSendtime;
	}
	public void setaSendtime(String aSendtime) {
		this.aSendtime = aSendtime;
	}
	public String getaCover() {
		return aCover;
	}
	public void setaCover(String aCover) {
		this.aCover = aCover;
	}
	public String getaState() {
		return aState;
	}
	public void setaState(String aState) {
		this.aState = aState;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public String getaTitle() {
		return aTitle;
	}
	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	public String getaTime() {
		return aTime;
	}
	public void setaTime(String aTime) {
		this.aTime = aTime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
