package com.dream.pojo;

public class Commodity {
	private String cId;
	private String cName;
	private String cRef;
	private int cIntegral;
	private ComPicture  comPicture;
	private Merchant merchant;
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcRef() {
		return cRef;
	}
	public void setcRef(String cRef) {
		this.cRef = cRef;
	}
	public int getcIntegral() {
		return cIntegral;
	}
	public void setcIntegral(int cIntegral) {
		this.cIntegral = cIntegral;
	}
	public ComPicture getComPicture() {
		return comPicture;
	}
	public void setComPicture(ComPicture comPicture) {
		this.comPicture = comPicture;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public int getcCount() {
		return cCount;
	}
	public void setcCount(int cCount) {
		this.cCount = cCount;
	}
	private int cCount;
}
