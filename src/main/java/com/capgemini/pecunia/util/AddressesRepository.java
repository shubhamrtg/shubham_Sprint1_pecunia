package com.capgemini.pecunia.util;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecunia.DTO.Addresses;
import com.capgemini.pecunia.exceptions.InvalidAddressException;

public class AddressesRepository
{
	private static List<Addresses> listOfAddresses=new ArrayList<Addresses>();

	public AddressesRepository() throws InvalidAddressException
	{
		Addresses address=new Addresses();
		address.setAddressline1("hno.-2j/5");
		address.setAddressline2("Nirmal nagar, hume pipe");
		address.setCity("Jamshedpur");
		address.setState("Jharkhand");
		address.setCountry("India");
		address.setZipCode("831001");
		listOfAddresses.add(address);
		
		address=new Addresses();
		address.setAddressline1("hno.-2j/6");
		address.setAddressline2("Lovely Professional University");
		address.setCity("Jalandhar");
		address.setState("Punjab");
		address.setCountry("India");
		address.setZipCode("831005");
		listOfAddresses.add(address);
		
		address=new Addresses();
		address.setAddressline1("hno.-2g/10");
		address.setAddressline2("Nirmal nagar, hume pipe");
		address.setCity("Jamshedpur");
		address.setState("Jharkhand");
		address.setCountry("India");
		address.setZipCode("831001");
		listOfAddresses.add(address);
		
		address=new Addresses();
		address.setAddressline1("hno.415");
		address.setAddressline2("Lovely Professional University");
		address.setCity("Jalandhar");
		address.setState("Punjab");
		address.setCountry("India");
		address.setZipCode("831005");
		listOfAddresses.add(address);
		
		address=new Addresses();
		address.setAddressline1("hno.-2j/5");
		address.setAddressline2("Nirmal nagar, hume pipe");
		address.setCity("Jamshedpur");
		address.setState("Jharkhand");
		address.setCountry("India");
		address.setZipCode("831001");
		listOfAddresses.add(address);
		
		address=new Addresses();
		address.setAddressline1("hno.-h/2");
		address.setAddressline2("sakchi");
		address.setCity("Jamshedpur");
		address.setState("Jharkhand");
		address.setCountry("India");
		address.setZipCode("831001");
		listOfAddresses.add(address);
		
		address=new Addresses();
		address.setAddressline1("hno.-h/10");
		address.setAddressline2("Mango");
		address.setCity("Jamshedpur");
		address.setState("Jharkhand");
		address.setCountry("India");
		address.setZipCode("831001");
		listOfAddresses.add(address);
		
		address=new Addresses();
		address.setAddressline1("hno.-2j/5");
		address.setAddressline2("Lovely Professional University");
		address.setCity("Jalandhar");
		address.setState("Punjab");
		address.setCountry("India");
		address.setZipCode("831005");
		listOfAddresses.add(address);
		
		address=new Addresses();
		address.setAddressline1("hno.-2j/5");
		address.setAddressline2("Nirmal nagar, hume pipe");
		address.setCity("Jamshedpur");
		address.setState("Jharkhand");
		address.setCountry("India");
		address.setZipCode("831001");
		listOfAddresses.add(address);
		
		address=new Addresses();
		address.setAddressline1("hno.-042");
		address.setAddressline2("Lovely Professional Unibersity");
		address.setCity("Jalandhar");
		address.setState("Punjab");
		address.setCountry("India");
		address.setZipCode("831001");
		listOfAddresses.add(address);	
	}

	public static List<Addresses> getListOfAddresses()
	{
		return listOfAddresses;
	}

	public static void setListOfAddresses(List<Addresses> listOfAddresses)
	{
		AddressesRepository.listOfAddresses = listOfAddresses;
	}
	
}
