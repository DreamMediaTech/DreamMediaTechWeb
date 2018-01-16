package com.dream.pojo;

public class Member {
	private int mId;
	private String birthday;
	private String mail;
	private String alipay;
	private String wechat;
	private float reBate;
	private String introducer;
	private String firstSuperior;
	private String secondSuperior;
	private int bonusIntegral;
	private int consumptionIntegral;
	private int sharingIntegral;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private int superQuota;
	private int iId;
	
		
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public int getmId() {
		return mId;
	}
	public void setmId(int mId) {
		this.mId = mId;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getAlipay() {
		return alipay;
	}
	public void setAlipay(String alipay) {
		this.alipay = alipay;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public float getReBate() {
		return reBate;
	}
	public void setReBate(float reBate) {
		this.reBate = reBate;
	}
	public String getIntroducer() {
		return introducer;
	}
	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}
	public String getFirstSuperior() {
		return firstSuperior;
	}
	public void setFirstSuperior(String firstSuperior) {
		this.firstSuperior = firstSuperior;
	}
	public String getSecondSuperior() {
		return secondSuperior;
	}
	public void setSecondSuperior(String secondSuperior) {
		this.secondSuperior = secondSuperior;
	}
	public int getBonusIntegral() {
		return bonusIntegral;
	}
	public void setBonusIntegral(int bonusIntegral) {
		this.bonusIntegral = bonusIntegral;
	}
	public int getConsumptionIntegral() {
		return consumptionIntegral;
	}
	public void setConsumptionIntegral(int consumptionIntegral) {
		this.consumptionIntegral = consumptionIntegral;
	}
	public int getSharingIntegral() {
		return sharingIntegral;
	}
	public void setSharingIntegral(int sharingIntegral) {
		this.sharingIntegral = sharingIntegral;
	}
	
	public int getSuperQuota() {
		return superQuota;
	}
	public void setSuperQuota(int superQuota) {
		this.superQuota = superQuota;
	}
}
