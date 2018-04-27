package com.revature.model;

public class Request {
	private int id;
	private double amount;
	private String email;

	public Request(int id, double amount, String email) {
		super();
		this.id = id;
		this.amount = amount;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
