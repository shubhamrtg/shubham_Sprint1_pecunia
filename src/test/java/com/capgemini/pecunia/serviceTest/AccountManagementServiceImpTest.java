package com.capgemini.pecunia.serviceTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.pecunia.DTO.Accounts;
import com.capgemini.pecunia.DTO.Addresses;
import com.capgemini.pecunia.DTO.Branch1;
import com.capgemini.pecunia.DTO.Branch2;
import com.capgemini.pecunia.DTO.Customers;
import com.capgemini.pecunia.exceptions.InvalidAccountDetailException;
import com.capgemini.pecunia.exceptions.InvalidAddressException;
import com.capgemini.pecunia.exceptions.InvalidCustomerDetailException;
import com.capgemini.pecunia.services.AccountManagementServiceImp;
import com.capgemini.pecunia.util.AccountsRepository;

public class AccountManagementServiceImpTest
{
	static AccountManagementServiceImp obj;
	static Accounts accountBean;
	static Addresses addressBean;
	static Customers customerBean;
	
	@BeforeAll
	@Test
	public static void AccountManagementServiceImpObjectTest()
	{
		obj=new AccountManagementServiceImp();
		accountBean=new Accounts();
		addressBean=new Addresses();
		customerBean=new Customers();
  		customerBean.setCustomerName("test");
  		customerBean.setContact(1234567890);
  		customerBean.setAadhar(214445670987l);
  		customerBean.setPan("tests1234t");
  		addressBean.setCity("testCity");
  		addressBean.setState("testState");
  		addressBean.setCountry("testCountry");
  		addressBean.setZipCode("123456");
  		accountBean.setBreanchID("1234");
		accountBean.setType("current");
		accountBean.setStatus("open");
		accountBean.setAccountID("123401000044");
  		customerBean.setAddress(addressBean);
  		accountBean.setCustomer(customerBean);
	}
	
	@Test
	public void validationTest() throws InvalidAddressException, InvalidAccountDetailException, InvalidCustomerDetailException
	{
		Throwable exception = assertThrows(
			      Exception.class,() -> {
			    	  	customerBean.setCustomerName("test1");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid customer name", exception.getMessage());
		customerBean.setCustomerName("test");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	customerBean.setContact(123456789000l);
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid Contact number", exception.getMessage());
		customerBean.setContact(1234567890);
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	customerBean.setAadhar(214445687l);
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid Aadhar number", exception.getMessage());
		customerBean.setAadhar(214445670987l);
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	customerBean.setPan("test1234t");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid PAN number", exception.getMessage());
		customerBean.setPan("tests1234t");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	customerBean.setPan("tests123t");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid PAN number", exception.getMessage());
		customerBean.setPan("tests1234t");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	customerBean.setPan("tests1234sd");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid PAN number", exception.getMessage());
		customerBean.setPan("tests1234t");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	customerBean.setPan("tests12346");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid PAN number", exception.getMessage());
		customerBean.setPan("tests1234t");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	addressBean.setCity("testCity1");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid city name", exception.getMessage());
		addressBean.setCity("testCity");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	addressBean.setState("testState1");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid state name", exception.getMessage());
		addressBean.setState("testState");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	addressBean.setCountry("testCountry1");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid country name", exception.getMessage());
		addressBean.setCountry("testCountry");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	addressBean.setZipCode("12345s");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid zipcode", exception.getMessage());
		addressBean.setZipCode("123456");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	addressBean.setZipCode("1234567");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid zipcode", exception.getMessage());
		addressBean.setZipCode("123456");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	accountBean.setBreanchID("123s");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid branch id", exception.getMessage());
		accountBean.setBreanchID("1234");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	accountBean.setBreanchID("1234567");
				    	obj.validation(accountBean);   	  
			      });
		assertEquals("Invalid branch id", exception.getMessage());
		accountBean.setBreanchID("1234");
		
	}
	
	@Test
	public void addAccountTest() throws InvalidAddressException, InvalidAccountDetailException, InvalidCustomerDetailException
	{
		
		accountBean.setAccountID(null);
		
		int id=Branch1.customerID+1;
		String customerID=String.format("%04d", id);
		id=Branch1.accounts+1;
		String accounts=String.format("%04d", id);
		assertEquals("Account created : 1234"+customerID+""+accounts,obj.addAccount(accountBean));
		
		accountBean.setBreanchID("5678");
		id=Branch2.customerID+1;
		customerID=String.format("%04d", id);
		id=Branch2.accounts+1;
		accounts=String.format("%04d", id);
		accountBean.setAccountID(null);
		assertEquals("Account created : 5678"+customerID+""+accounts,obj.addAccount(accountBean));
		
		assertEquals("Account not created",obj.addAccount(accountBean));
	}
	
	@Test
	public void updateCustomerNameTest() throws InvalidCustomerDetailException, InvalidAccountDetailException
	{
		Throwable exception = assertThrows(
			      Exception.class,() -> {
			    	  	customerBean.setCustomerName("test1");
				    	obj.updateCustomerName(accountBean);   	  
			      });
		assertEquals("Invalid customer name", exception.getMessage());
		customerBean.setCustomerName("test");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	accountBean.setAccountID("123400650009s");
			    	  	obj.updateCustomerName(accountBean);     	  
			      });
		assertEquals("Invalid account id", exception.getMessage());
		accountBean.setAccountID("123400650009");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	accountBean.setAccountID("12340065000900");
			    	  	obj.updateCustomerName(accountBean);     	  
			      });
		assertEquals("Invalid account id", exception.getMessage());
		accountBean.setAccountID("123400650009");
		
		assertEquals("Name updated successfully",obj.updateCustomerName(accountBean));
		
		accountBean.setAccountID("123400650018");
		assertEquals("Name not updated : Account does not exist",obj.updateCustomerName(accountBean));
	}
	@Test
	public void updateCustomerContactTest() throws InvalidCustomerDetailException, InvalidAccountDetailException
	{
		Throwable exception = assertThrows(
			      Exception.class,() -> {
			    	  	customerBean.setContact(123456789000l);
			    	  	obj.updateCustomerContact(accountBean);   	  
			      });
		assertEquals("Invalid Contact number", exception.getMessage());
		customerBean.setContact(1234567890);
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	accountBean.setAccountID("123400650009s");
			    	  	obj.updateCustomerContact(accountBean);   	  
			      });
		assertEquals("Invalid account id", exception.getMessage());
		accountBean.setAccountID("123400650009");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	accountBean.setAccountID("12340065000900");
			    	  	obj.updateCustomerContact(accountBean);   	  
			      });
		assertEquals("Invalid account id", exception.getMessage());
		accountBean.setAccountID("123400650009");
		
		assertEquals("Contact updated successfully",obj.updateCustomerContact(accountBean));
		
		accountBean.setAccountID("123400650018");
		assertEquals("Contact not updated : Account does not exist",obj.updateCustomerContact(accountBean));
	}
	@Test
	public void updateCustomerAddressTest() throws InvalidAddressException, InvalidAccountDetailException
	{
		Throwable exception = assertThrows(
			      Exception.class,() -> {
			    	  	addressBean.setCity("testCity123");
				    	obj.updateCustomerAddress(accountBean);   	  
			      });
		assertEquals("Invalid city name", exception.getMessage());
		addressBean.setCity("testCity");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	addressBean.setState("testState1");
				    	obj.updateCustomerAddress(accountBean);   	  
			      });
		assertEquals("Invalid state name", exception.getMessage());
		addressBean.setState("testState");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	addressBean.setCountry("testCountry1");
				    	obj.updateCustomerAddress(accountBean);   	  
			      });
		assertEquals("Invalid country name", exception.getMessage());
		addressBean.setCountry("testCountry");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	addressBean.setZipCode("12345s");
				    	obj.updateCustomerAddress(accountBean);   	  
			      });
		assertEquals("Invalid zipcode", exception.getMessage());
		addressBean.setZipCode("123456");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	addressBean.setZipCode("1234567");
				    	obj.updateCustomerAddress(accountBean);   	  
			      });
		assertEquals("Invalid zipcode", exception.getMessage());
		addressBean.setZipCode("123456");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	accountBean.setAccountID("123400650009s");
				    	obj.updateCustomerAddress(accountBean);   	  
			      });
		assertEquals("Invalid account id", exception.getMessage());
		accountBean.setAccountID("123400650009");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	accountBean.setAccountID("12340065000900");
				    	obj.updateCustomerAddress(accountBean);   	  
			      });
		assertEquals("Invalid account id", exception.getMessage());
		accountBean.setAccountID("123400650009");
		
		assertEquals("Address updated successfully",obj.updateCustomerAddress(accountBean));
		
		accountBean.setAccountID("123400650018");
		assertEquals("Address not updated : Account does not exist",obj.updateCustomerAddress(accountBean));
	}

	@Test
	public void showAccountDetailsTest() throws InvalidAccountDetailException
	{
		Throwable exception = assertThrows(
			      Exception.class,() -> {
			    	  	accountBean.setAccountID("123400650009s");
				    	obj.showAccountDetails(accountBean);   	  
			      });
		assertEquals("Invalid account id", exception.getMessage());
		accountBean.setAccountID("123400650009");
		
		exception = assertThrows(
			      Exception.class,() -> {
			    	  	accountBean.setAccountID("12340065000900");
				    	obj.showAccountDetails(accountBean);   	  
			      });
		assertEquals("Invalid account id", exception.getMessage());
		accountBean.setAccountID("123400650009");
		
		assertTrue(obj.showAccountDetails(accountBean));
		
		accountBean.setAccountID("123400650014");
		assertFalse(obj.showAccountDetails(accountBean));
	}
	
	@Test
	public void displayAccounts()
	{
		assertThat(AccountsRepository.getListOfAccounts(), is(obj.displayAccounts()));
	}
	
	@Test
	public void deleteAccountTest()
	{
		int id=Branch1.customerID;
		String customerID=String.format("%04d", id);
		id=Branch1.accounts;
		String accounts=String.format("%04d", id);
		accountBean.setAccountID("1234"+customerID+accounts);
		assertTrue(obj.deleteAccount(accountBean));
		
		assertFalse(obj.deleteAccount(accountBean));

		
	}
}
