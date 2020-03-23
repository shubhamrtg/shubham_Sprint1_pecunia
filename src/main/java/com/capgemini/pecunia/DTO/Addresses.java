package com.capgemini.pecunia.DTO;

import com.capgemini.pecunia.exceptions.InvalidAddressException;

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
	public void setCity(String city) throws InvalidAddressException 
	{
		if(city.matches("^[a-zA-Z]*$"))
			throw new InvalidAddressException("Invalid city name");
		this.city = city;
	}
	public String getState() 
	{
		return state;
	}
	public void setState(String state) throws InvalidAddressException
	{
		if(state.matches("^[a-zA-Z]*$"))
			throw new InvalidAddressException("Invalid state name");
		this.state = state;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country) throws InvalidAddressException 
	{
		if(country.matches("^[a-zA-Z]*$"))
			throw new InvalidAddressException("Invalid country name");
		this.country = country;
	}
	public String getZipCode() 
	{
		return zipCode;
	}
	public void setZipCode(String zipCode) throws InvalidAddressException 
	{
		if(zipCode.matches("[0-9]+") || zipCode.length()!=6)
			throw new InvalidAddressException("Invalid zipcode");
		this.zipCode = zipCode;
	}
	@Override
	public String toString() 
	{
		return " addressline1=" + addressline1 + ", addressline2=" + addressline2 + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", zipCode=" + zipCode;
	}	
}
