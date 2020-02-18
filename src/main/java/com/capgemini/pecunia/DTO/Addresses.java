package com.capgemini.pecunia.DTO;

public class Addresses 
{
	private String addressline1;
	private String addressline2;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	
	public String getAddressline1() 
	{
		return addressline1;
	}
	public void setAddressline1(String addressline1) 
	{
		this.addressline1 = addressline1;
	}
	public String getAddressline2() 
	{
		return addressline2;
	}
	public void setAddressline2(String addressline2) 
	{
		this.addressline2 = addressline2;
	}
	public String getCity() 
	{
		return city;
	}
	public void setCity(String city) 
	{
		this.city = city;
	}
	public String getState() 
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country) 
	{
		this.country = country;
	}
	public String getZipCode() 
	{
		return zipCode;
	}
	public void setZipCode(String zipCode) 
	{
		this.zipCode = zipCode;
	}
	@Override
	public String toString() 
	{
		return " addressline1=" + addressline1 + ", addressline2=" + addressline2 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipCode=" + zipCode;
	}	
}
