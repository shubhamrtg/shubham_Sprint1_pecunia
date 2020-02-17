package com.capgemini.pecunia.DTO;

import java.time.LocalDate;

public class Customers 
{
	private String customerName;
	private long contact;
	private long aadhar;
	private String pan;
	private LocalDate dateOfBirth;
	private String gender;
	private Addresses address;
	
	public Customers() 
	{
		super();
	}
	
	public String getCustomerName() 
	{
		return customerName;
	}
	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}
	public long getContact()
	{
		return contact;
	}
	public void setContact(long contact)
	{
		this.contact = contact;
	}
	public long getAadhar() 
	{
		return aadhar;
	}
	public void setAadhar(long aadhar)
	{
		this.aadhar = aadhar;
	}
	public String getPan() 
	{
		return pan;
	}
	public void setPan(String pan) 
	{
		this.pan = pan;
	}
	public LocalDate getDateOfBirth() 
	{
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() 
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	public Addresses getAddress() 
	{
		return address;
	}
	public void setAddress(Addresses address) 
	{
		this.address = address;
	}

	@Override
	public String toString() {
		return " customerName=" + customerName + ", contact=" + contact + ", aadhar=" + aadhar + ", pan="
				+ pan + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", address=" + address;
	}
	
	
}
