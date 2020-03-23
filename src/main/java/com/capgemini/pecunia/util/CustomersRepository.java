package com.capgemini.pecunia.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.capgemini.pecunia.DTO.Customers;
import com.capgemini.pecunia.exceptions.InvalidAddressException;
import com.capgemini.pecunia.exceptions.InvalidCustomerDetailException;

public class CustomersRepository 
{
	private static List<Customers> listOfCustomers=new ArrayList<Customers>();
	
	public CustomersRepository() throws InvalidAddressException, InvalidCustomerDetailException
	{
		DateTimeFormatter myFormat =DateTimeFormatter.ofPattern("dd-MM-yyyy");
		new AddressesRepository();
		
		Customers customer=new Customers();
		customer.setCustomerName("Shubham");
		customer.setContact(8360036501l);
		customer.setAadhar(1234_5678_9876l);
		customer.setPan("SHUBH1234R");
		customer.setGender("Male");
		customer.setDateOfBirth(LocalDate.parse("04-01-1998", myFormat));
		customer.setAddress(AddressesRepository.getListOfAddresses().get(0));
		listOfCustomers.add(customer);
		
		customer=new Customers();
		customer.setCustomerName("Shashwat");
		customer.setContact(8360036502l);
		customer.setAadhar(1234_5678_1234l);
		customer.setPan("SHUBH1234R");
		customer.setGender("Male");
		customer.setDateOfBirth(LocalDate.parse("25-02-1998", myFormat));
		customer.setAddress(AddressesRepository.getListOfAddresses().get(1));
		listOfCustomers.add(customer);
		
		customer=new Customers();
		customer.setCustomerName("Madhu");
		customer.setContact(8360036523l);
		customer.setAadhar(1234_5678_4567l);
		customer.setPan("SHUBH1234R");
		customer.setGender("Male");
		customer.setDateOfBirth(LocalDate.parse("04-11-1998", myFormat));
		customer.setAddress(AddressesRepository.getListOfAddresses().get(2));
		listOfCustomers.add(customer);
		
		customer=new Customers();
		customer.setCustomerName("Yogesh");
		customer.setContact(8360036534l);
		customer.setAadhar(1234_5678_9876l);
		customer.setPan("SHUBH1234R");
		customer.setGender("Male");
		customer.setDateOfBirth(LocalDate.parse("21-04-1998", myFormat));
		customer.setAddress(AddressesRepository.getListOfAddresses().get(3));
		listOfCustomers.add(customer);
		
		customer=new Customers();
		customer.setCustomerName("Sohaib");
		customer.setContact(8360034501l);
		customer.setAadhar(1234_6456_9876l);
		customer.setPan("SHUBH1234R");
		customer.setGender("Male");
		customer.setDateOfBirth(LocalDate.parse("24-11-1998", myFormat));
		customer.setAddress(AddressesRepository.getListOfAddresses().get(4));
		listOfCustomers.add(customer);
		
		customer=new Customers();
		customer.setCustomerName("Kiran");
		customer.setContact(8360036876l);
		customer.setAadhar(1234_5678_9876l);
		customer.setPan("SHUBH1234R");
		customer.setGender("Female");
		customer.setDateOfBirth(LocalDate.parse("16-05-1995", myFormat));
		customer.setAddress(AddressesRepository.getListOfAddresses().get(5));
		listOfCustomers.add(customer);
		
		customer=new Customers();
		customer.setCustomerName("Midget");
		customer.setContact(8374536501l);
		customer.setAadhar(1234_1234_3456l);
		customer.setPan("SHUBH1234R");
		customer.setGender("Female");
		customer.setDateOfBirth(LocalDate.parse("24-12-1998", myFormat));
		customer.setAddress(AddressesRepository.getListOfAddresses().get(6));
		listOfCustomers.add(customer);
		
		customer=new Customers();
		customer.setCustomerName("Renu");
		customer.setContact(8360036321l);
		customer.setAadhar(1234_9876_3456l);
		customer.setPan("SHUBH1234R");
		customer.setGender("Female");
		customer.setDateOfBirth(LocalDate.parse("27-12-1997", myFormat));
		customer.setAddress(AddressesRepository.getListOfAddresses().get(7));
		listOfCustomers.add(customer);
		
		customer=new Customers();
		customer.setCustomerName("Shruti");
		customer.setContact(9430036501l);
		customer.setAadhar(9876_5678_9876l);
		customer.setPan("SHUBH1234R");
		customer.setGender("Female");
		customer.setDateOfBirth(LocalDate.parse("04-10-1999", myFormat));
		customer.setAddress(AddressesRepository.getListOfAddresses().get(8));
		listOfCustomers.add(customer);
		
		customer=new Customers();
		customer.setCustomerName("Tanya");
		customer.setContact(8360031231l);
		customer.setAadhar(1234_1234_9876l);
		customer.setPan("SHUBH1234R");
		customer.setGender("Female");
		customer.setDateOfBirth(LocalDate.parse("07-09-1997", myFormat));
		customer.setAddress(AddressesRepository.getListOfAddresses().get(9));
		listOfCustomers.add(customer);
	}

	public static List<Customers> getListOfCustomers() 
	{
		return listOfCustomers;
	}

	public static void setListOfCustomers(List<Customers> listOfCustomers) 
	{
		CustomersRepository.listOfCustomers = listOfCustomers;
	}
	
	
}
