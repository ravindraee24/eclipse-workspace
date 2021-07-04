package com.tml.hulcsvexport.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dataset {
public Dataset() {
		super();
		// TODO Auto-generated constructor stub
	}
@Id
long id;
	public String getVmn() {
		return vmn;
	}
	public void setVmn(String vmn) {
		this.vmn = vmn;
	}
	public String getMissedcalldate() {
		return missedcalldate;
	}
	public void setMissedcalldate(String missedcalldate) {
		this.missedcalldate = missedcalldate;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getCircle() {
		return circle;
	}
	public void setCircle(String circle) {
		this.circle = circle;
	}
	public String getCoupon() {
		return coupon;
	}
	public void setCoupon(String coupon) {
		this.coupon = coupon;
	}
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	private String vmn;
	public Dataset(String vmn, String missedcalldate, String operator, String circle, String coupon, String msisdn) {
		super();
		this.vmn = vmn;
		this.missedcalldate = missedcalldate;
		this.operator = operator;
		this.circle = circle;
		this.coupon = coupon;
		this.msisdn = msisdn;
	}
	private String missedcalldate;
	private String operator;
	private String circle;
	private String coupon;
	private String msisdn;
	
}
