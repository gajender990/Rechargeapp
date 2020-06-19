package com.example.Recharge;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Rechargedetails {
	@Id
	private int sid;
	
	private String packdetails;
	private int validity;
	private int amount;
	
	public String getPackdetails() {
		return packdetails;
	}
	
	public void setPackdetails(String packdetails) {
		this.packdetails = packdetails;
	}
	
	public int getValidity() {
		return validity;
	}
	
	public void setValidity(int validity) {
		this.validity = validity;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}
}
