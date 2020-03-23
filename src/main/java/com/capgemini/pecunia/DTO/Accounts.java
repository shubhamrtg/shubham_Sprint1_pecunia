package com.capgemini.pecunia.DTO;

import com.capgemini.pecunia.exceptions.InvalidAccountDetailException;

public class Accounts
{
	private String customerID;
	private Customers customer; //holds customer detail
	private double balance;
	private double interestRate;
	private String type;
	private String branchID;
	private String accountID;
	private String status;
	
	public Accounts() 
	{
		super();
	}
	
	//getter & setter functions 
	public Customers getCustomer() 
	{
		return customer;
	}
	public void setCustomer(Customers customer) 
	{
		this.customer = customer;
	}
	public double getBalance()
	{
		return balance;
	}
	public void setBalance(double balance) 
	{
		this.balance = balance;
	}
	public double getInterestRate()
	{
		return interestRate;
	}
	public void setInterestRate(double interestRate)
	{
		this.interestRate = interestRate;
	}
	public String getType() 
	{
		return type;
	}
	public void setType(String type) 
	{
		this.type = type;
	}
	public String getBranchID() 
	{
		return branchID;
	}
	public void setBranchID(String branchID) throws InvalidAccountDetailException 
	{
		if(branchID.matches("[0-9]+") || branchID.length()!=4)
			throw new InvalidAccountDetailException("Invalid branch id");
		this.branchID = branchID;
	}
	public String getAccountID() 
	{
		return accountID;
	}
	public void setAccountID(String accountID) throws InvalidAccountDetailException 
	{
		if(accountID.matches("[0-9]+") || accountID.length()!=12)
			throw new InvalidAccountDetailException("Invalid account id");
		this.accountID = accountID;
	}

	public String getCustomerID() 
	{
		return customerID;
	}
	public void setCustomerID(String customerID) 
	{
		this.customerID = customerID;
	}
	public String getStatus() 
	{
		return status;
	}
	public void setStatus(String status) 
	{
		this.status = status;
	}

	@Override
	public String toString() 
	{
		return "Accounts [ accountID= "+ accountID + ", " + customer + ", balance=" + balance
				+ ", interestRate=" + interestRate + ", type=" + type + ", breanchID=" + branchID + ", customerID=" + customerID +  "]";
	}	
	
	
}
