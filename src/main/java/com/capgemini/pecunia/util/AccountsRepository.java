package com.capgemini.pecunia.util;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.pecunia.DTO.Accounts;
import com.capgemini.pecunia.DTO.Branch1;
import com.capgemini.pecunia.DTO.Branch2;

public class AccountsRepository 
{
	private static Map<String,Accounts> listOfAccounts=new HashMap<String,Accounts>();
	public AccountsRepository()
	{
		new CustomersRepository();
		new Branch1();
		new Branch2();
		
		Accounts account=new Accounts();
		account.setCustomerID("1");
		account.setBalance(100000);
		account.setInterestRate(5.5);
		account.setCustomer(CustomersRepository.getListOfCustomers().get(0));
		account.setBreanchID("1234");
		account.setType("savings");
		String accountID = null;
		String customerID=null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.accounts;
			accountID=String.format("%04d", id);
			id=++Branch1.customerID;
			customerID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.accounts;
			accountID=String.format("%04d", id);
			id=++Branch2.customerID;
			customerID=String.format("%04d", id);
		}
		account.setCustomerID(customerID);
		account.setAccountID(account.getBreanchID()+account.getCustomerID()+accountID);
		account.setStatus("Open");
		listOfAccounts.put(account.getAccountID(), account);
		
		account=new Accounts();
		account.setCustomerID("1");
		account.setBalance(1034500);
		account.setInterestRate(5);
		account.setCustomer(CustomersRepository.getListOfCustomers().get(1));
		account.setBreanchID("1234");
		account.setType("savings");
		accountID = null;
		customerID=null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.accounts;
			accountID=String.format("%04d", id);
			id=++Branch1.customerID;
			customerID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.accounts;
			accountID=String.format("%04d", id);
			id=++Branch2.customerID;
			customerID=String.format("%04d", id);
		}
		account.setCustomerID(customerID);
		account.setAccountID(account.getBreanchID()+account.getCustomerID()+accountID);
		account.setStatus("Open");
		listOfAccounts.put(account.getAccountID(), account);
		
		account=new Accounts();
		account.setCustomerID("1");
		account.setBalance(1000245);
		account.setInterestRate(5.5);
		account.setCustomer(CustomersRepository.getListOfCustomers().get(2));
		account.setBreanchID("1234");
		account.setType("savings");
		accountID = null;
		customerID=null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.accounts;
			accountID=String.format("%04d", id);
			id=++Branch1.customerID;
			customerID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.accounts;
			accountID=String.format("%04d", id);
			id=++Branch2.customerID;
			customerID=String.format("%04d", id);
		}
		account.setCustomerID(customerID);
		account.setAccountID(account.getBreanchID()+account.getCustomerID()+accountID);
		account.setStatus("Open");
		listOfAccounts.put(account.getAccountID(), account);
		
		account=new Accounts();
		account.setCustomerID("1");
		account.setBalance(100123);
		account.setInterestRate(5.5);
		account.setCustomer(CustomersRepository.getListOfCustomers().get(3));
		account.setBreanchID("5678");
		account.setType("savings");
		accountID = null;
		customerID=null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.accounts;
			accountID=String.format("%04d", id);
			id=++Branch1.customerID;
			customerID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.accounts;
			accountID=String.format("%04d", id);
			id=++Branch2.customerID;
			customerID=String.format("%04d", id);
		}
		account.setCustomerID(customerID);
		account.setAccountID(account.getBreanchID()+account.getCustomerID()+accountID);
		account.setStatus("Open");
		listOfAccounts.put(account.getAccountID(), account);
		
		account=new Accounts();
		account.setCustomerID("1");
		account.setBalance(1000);
		account.setInterestRate(5.5);
		account.setCustomer(CustomersRepository.getListOfCustomers().get(4));
		account.setBreanchID("5678");
		account.setType("savings");
		accountID = null;
		customerID=null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.accounts;
			accountID=String.format("%04d", id);
			id=++Branch1.customerID;
			customerID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.accounts;
			accountID=String.format("%04d", id);
			id=++Branch2.customerID;
			customerID=String.format("%04d", id);
		}
		account.setCustomerID(customerID);
		account.setAccountID(account.getBreanchID()+account.getCustomerID()+accountID);
		account.setStatus("Open");
		listOfAccounts.put(account.getAccountID(), account);
		
		account=new Accounts();
		account.setCustomerID("1");
		account.setBalance(10040);
		account.setInterestRate(5.5);
		account.setCustomer(CustomersRepository.getListOfCustomers().get(5));
		account.setBreanchID("5678");
		account.setType("savings");
		accountID = null;
		customerID=null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.accounts;
			accountID=String.format("%04d", id);
			id=++Branch1.customerID;
			customerID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.accounts;
			accountID=String.format("%04d", id);
			id=++Branch2.customerID;
			customerID=String.format("%04d", id);
		}
		account.setCustomerID(customerID);
		account.setAccountID(account.getBreanchID()+account.getCustomerID()+accountID);
		account.setStatus("Open");
		listOfAccounts.put(account.getAccountID(), account);
		
		account=new Accounts();
		account.setCustomerID("1");
		account.setBalance(1234500);
		account.setInterestRate(5.5);
		account.setCustomer(CustomersRepository.getListOfCustomers().get(6));
		account.setBreanchID("1234");
		account.setType("savings");
		accountID = null;
		customerID=null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.accounts;
			accountID=String.format("%04d", id);
			id=++Branch1.customerID;
			customerID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.accounts;
			accountID=String.format("%04d", id);
			id=++Branch2.customerID;
			customerID=String.format("%04d", id);
		}
		account.setCustomerID(customerID);
		account.setAccountID(account.getBreanchID()+account.getCustomerID()+accountID);
		account.setStatus("Open");
		listOfAccounts.put(account.getAccountID(), account);
		
		account=new Accounts();
		account.setCustomerID("1");
		account.setBalance(10340);
		account.setInterestRate(5.5);
		account.setCustomer(CustomersRepository.getListOfCustomers().get(7));
		account.setBreanchID("1234");
		account.setType("savings");
		accountID = null;
		customerID=null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.accounts;
			accountID=String.format("%04d", id);
			id=++Branch1.customerID;
			customerID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.accounts;
			accountID=String.format("%04d", id);
			id=++Branch2.customerID;
			customerID=String.format("%04d", id);
		}
		account.setCustomerID(customerID);
		account.setAccountID(account.getBreanchID()+account.getCustomerID()+accountID);
		account.setStatus("Open");
		listOfAccounts.put(account.getAccountID(), account);
		
		account=new Accounts();
		account.setCustomerID("1");
		account.setBalance(102340);
		account.setInterestRate(5.5);
		account.setCustomer(CustomersRepository.getListOfCustomers().get(8));
		account.setBreanchID("5678");
		account.setType("savings");
		accountID = null;
		customerID=null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.accounts;
			accountID=String.format("%04d", id);
			id=++Branch1.customerID;
			customerID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.accounts;
			accountID=String.format("%04d", id);
			id=++Branch2.customerID;
			customerID=String.format("%04d", id);
		}
		account.setCustomerID(customerID);
		account.setAccountID(account.getBreanchID()+account.getCustomerID()+accountID);
		account.setStatus("Open");
		listOfAccounts.put(account.getAccountID(), account);
		
		account=new Accounts();
		account.setCustomerID("1");
		account.setBalance(153450);
		account.setInterestRate(5.5);
		account.setCustomer(CustomersRepository.getListOfCustomers().get(9));
		account.setBreanchID("5678");
		account.setType("savings");
		accountID = null;
		customerID=null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.accounts;
			accountID=String.format("%04d", id);
			id=++Branch1.customerID;
			customerID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.accounts;
			accountID=String.format("%04d", id);
			id=++Branch2.customerID;
			customerID=String.format("%04d", id);
		}
		account.setCustomerID(customerID);
		account.setAccountID(account.getBreanchID()+account.getCustomerID()+accountID);
		account.setStatus("Open");
		listOfAccounts.put(account.getAccountID(), account);
	}
	
	public static Map<String, Accounts> getListOfAccounts() 
	{
		return listOfAccounts;
	}
	public static void setListOfAccounts(Map<String, Accounts> listOfAccounts)
	{
		AccountsRepository.listOfAccounts = listOfAccounts;
	}

}
