package com.dream.pojo;

public class Agents {
	private int agId;
	private User user;
	private Member member;
	private String area;
	private float firstRebate;
	private float secondRebate;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public int getAgId() {
		return agId;
	}
	public void setAgId(int agId) {
		this.agId = agId;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public float getFirstRebate() {
		return firstRebate;
	}
	public void setFirstRebate(float firstRebate) {
		this.firstRebate = firstRebate;
	}
	public float getSecondRebate() {
		return secondRebate;
	}
	public void setSecondRebate(float secondRebate) {
		this.secondRebate = secondRebate;
	}
	
}
