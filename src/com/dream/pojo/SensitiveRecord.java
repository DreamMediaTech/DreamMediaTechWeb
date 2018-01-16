package com.dream.pojo;

public class SensitiveRecord {
	private int srId;
	private String operator;
	private String srContent;
	private String srTime;
	public int getSrId() {
		return srId;
	}
	public void setSrId(int srId) {
		this.srId = srId;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getSrContent() {
		return srContent;
	}
	public void setSrContent(String srContent) {
		this.srContent = srContent;
	}
	public String getSrTime() {
		return srTime;
	}
	public void setSrTime(String srTime) {
		this.srTime = srTime;
	}
}
