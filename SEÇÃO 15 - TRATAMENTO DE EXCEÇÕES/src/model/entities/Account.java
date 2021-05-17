package model.entities;

import model.exceptions.DomainException2;

public class Account {
	private Integer number;
	private String holder;
	private double balance;
	private double withdrawLimit;

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		super();
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(double value) {
		this.balance += value;
	}

	public void withdraw(double value) throws DomainException2{
		if(value > getWithdrawLimit()) {
			throw new DomainException2("the amounts Exceeds withdraw Limit");
		}else if(getBalance() < value) {
			throw new DomainException2("Not Enough Balance");
		}else {
			this.balance -= value;
			System.out.println("New Balance: " + getBalance());
		}
	}
	


}
