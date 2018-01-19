package com.dream.pojo;

public class Buy {
	private int bId;
	private Member member;
	private Commodity commodity;
	private String bExpress;
	private String bTime;
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	public String getbExpress() {
		return bExpress;
	}
	public void setbExpress(String bExpress) {
		this.bExpress = bExpress;
	}
	public String getbTime() {
		return bTime;
	}
	public void setbTime(String bTime) {
		this.bTime = bTime;
	}
	
}
