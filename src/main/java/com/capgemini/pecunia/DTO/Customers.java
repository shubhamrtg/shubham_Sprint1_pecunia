package com.capgemini.pecunia.DTO;

import java.time.LocalDate;

import com.capgemini.pecunia.exceptions.InvalidCustomerDetailException;

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
	public void setCustomerName(String customerName) throws InvalidCustomerDetailException 
	{
		if(customerName.replaceAll(" ", "").matches("^[a-zA-Z]*$"))
			throw new InvalidCustomerDetailException("Invalid customer name");
		this.customerName = customerName;
	}
	public long getContact()
	{
		return contact;
	}
	public void setContact(long contact) throws InvalidCustomerDetailException
	{
		if(String.valueOf(contact).length()!=10)
			throw new InvalidCustomerDetailException("Invalid Contact number");
		this.contact = contact;
	}
	public long getAadhar() 
	{
		return aadhar;
	}
	public void setAadhar(long aadhar) throws InvalidCustomerDetailException
	{
		if(String.valueOf(aadhar).length()!=12)
			throw new InvalidCustomerDetailException("Invalid Aadhar number");
		this.aadhar = aadhar;
	}
	public String getPan() 
	{
		return pan;
	}
	public void setPan(String pan) throws InvalidCustomerDetailException 
	{
		if(pan.substring(0, 5).matches("^[a-zA-Z]*$"))
			throw new InvalidCustomerDetailException("Invalid PAN number");
		if(pan.substring(5, 9).matches("[0-9]+"))
			throw new InvalidCustomerDetailException("Invalid PAN number");
		if(pan.substring(9).matches("^[a-zA-Z]*$") || pan.substring(9).length()!=1)
			throw new InvalidCustomerDetailException("Invalid PAN number");
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
	public void setGender(String gender) throws InvalidCustomerDetailException 
	{
		if(gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"))
			throw new InvalidCustomerDetailException("Invalid gender");
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
				+ pan + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", " + address;
	}
	
	
}
