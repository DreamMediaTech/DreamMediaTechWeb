package com.dream.pojo;

public class Function {
	private int fId;
	private String fName;
	private String fDescribe;
	private int fState = 1;
	
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Function [fId=" + fId + ", fName=" + fName + ", fDescribe=" + fDescribe + ", fState=" + fState
				+ ", getfId()=" + getfId() + ", getfName()=" + getfName() + ", getfDescribe()=" + getfDescribe()
				+ ", getfState()=" + getfState() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	public int getfId() {
		return fId;
	}
	public void setfId(int fId) {
		this.fId = fId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getfDescribe() {
		return fDescribe;
	}
	public void setfDescribe(String fDescribe) {
		this.fDescribe = fDescribe;
	}
	public int getfState() {
		return fState;
	}
	public void setfState(int fState) {
		this.fState = fState;
	}
	
	
	
	
	
	
}
