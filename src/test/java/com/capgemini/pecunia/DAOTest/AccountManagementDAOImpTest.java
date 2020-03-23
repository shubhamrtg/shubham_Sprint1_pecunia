package com.capgemini.pecunia.DAOTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.pecunia.DAO.AccountManagementDAOImp;
import com.capgemini.pecunia.DTO.Accounts;
import com.capgemini.pecunia.DTO.Addresses;
import com.capgemini.pecunia.DTO.Customers;
import com.capgemini.pecunia.exceptions.InvalidAccountDetailException;
import com.capgemini.pecunia.exceptions.InvalidAddressException;
import com.capgemini.pecunia.exceptions.InvalidCustomerDetailException;
import com.capgemini.pecunia.util.AccountsRepository;

public class AccountManagementDAOImpTest 
{
	static AccountManagementDAOImp obj;
	static Accounts accountBean;
	static Addresses addressBean;
	static Customers customerBean;
	
	@BeforeAll
	@Test
	public static void AccountManagementServiceImpObjectTest() throws InvalidCustomerDetailException, InvalidAddressException, InvalidAccountDetailException
	{
		obj=new AccountManagementDAOImp();
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
  		accountBean.setBranchID("1234");
		accountBean.setType("current");
		accountBean.setStatus("open");
		accountBean.setCustomerID("0000");
		accountBean.setAccountID("123400000044");
  		customerBean.setAddress(addressBean);
  		accountBean.setCustomer(customerBean);
	}
	
	@Test
	public void addAccountTest() throws InvalidAddressException, InvalidAccountDetailException, InvalidCustomerDetailException
	{
		accountBean.setAccountID(null);
		assertEquals("Account not created",obj.addAccount(accountBean));
		
		accountBean.setAccountID("123400000044");
		assertEquals("123400000044",obj.addAccount(accountBean));
	}
	
	@Test
	public void calculateAccountIdTest() throws InvalidAccountDetailException
	{
		accountBean.setBranchID("1234");
		accountBean.setAccountID(null);
		assertEquals("123400000014",obj.calculateAccountID(accountBean));
		
		accountBean.setBranchID("5678");
		accountBean.setAccountID(null);
		assertEquals("567800000014",obj.calculateAccountID(accountBean));
		
		accountBean.setAccountID("123400000044");
		assertEquals(null,obj.calculateAccountID(accountBean));
	}
	
	@Test
	public void updateCustomerNameTest() throws InvalidCustomerDetailException, InvalidAccountDetailException
	{
		accountBean.setAccountID("123400650009");
		assertTrue(obj.updateCustomerName(accountBean));
		
		accountBean.setAccountID("123400650018");
		assertFalse(obj.updateCustomerName(accountBean));
	}
	@Test
	public void updateCustomerContactTest() throws InvalidCustomerDetailException, InvalidAccountDetailException
	{
		accountBean.setAccountID("123400650009");
		assertTrue(obj.updateCustomerContact(accountBean));
		
		accountBean.setAccountID("123400650018");
		assertFalse(obj.updateCustomerContact(accountBean));
	}
	@Test
	public void updateCustomerAddressTest() throws InvalidAddressException, InvalidAccountDetailException
	{
		accountBean.setAccountID("123400650009");
		assertTrue(obj.updateCustomerAddress(accountBean));
		
		accountBean.setAccountID("123400650018");
		assertFalse(obj.updateCustomerAddress(accountBean));
	}

	@Test
	public void showAccountDetailsTest() throws InvalidAccountDetailException
	{
		accountBean.setAccountID("123400650009");
		assertTrue(obj.showAccountDetails(accountBean));
		
		accountBean.setAccountID("123400650014");
		assertFalse(obj.showAccountDetails(accountBean));
	}
	
	@Test
	public void addCustomerDetailsTest() throws InvalidAccountDetailException
	{
		assertEquals("0070", obj.addCustomerDetails(accountBean));
		
		accountBean.setBranchID("5678");
		assertEquals("0134", obj.addCustomerDetails(accountBean));
	}
	
	@Test
	public void displayAccounts()
	{
		assertThat(AccountsRepository.getListOfAccounts(), is(obj.displayAccounts()));
	}
	
	@Test
	public void deleteAccountTest() throws InvalidAccountDetailException
	{
		accountBean.setAccountID("123400650009");
		assertTrue(obj.deleteAccount(accountBean));

		assertFalse(obj.deleteAccount(accountBean));
	}
}
