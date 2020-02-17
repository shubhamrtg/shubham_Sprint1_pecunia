package com.capgemini.pecunia.DAO;

import java.util.List;
import java.util.Map;

import com.capgemini.pecunia.DTO.Accounts;
import com.capgemini.pecunia.DTO.Addresses;
import com.capgemini.pecunia.DTO.Branch1;
import com.capgemini.pecunia.DTO.Branch2;
import com.capgemini.pecunia.DTO.Customers;
import com.capgemini.pecunia.util.AccountsRepository;
import com.capgemini.pecunia.util.AddressesRepository;
import com.capgemini.pecunia.util.CustomersRepository;

public class AccountManagementDAOImp implements AccountManagementDAO
{
	public AccountManagementDAOImp()
	{
		new AccountsRepository();
	}
	
	public boolean deleteAccount(Accounts account)
	{
		Map<String,Accounts> newAccountsList=AccountsRepository.getListOfAccounts();
		if(newAccountsList.get(account.getAccountID()).getStatus().equalsIgnoreCase("Open"))
		{
			newAccountsList.get(account.getAccountID()).setStatus("Close");
			return true;
		}
		return false;
	}
	public boolean updateCustomerName(Accounts account)
	{
		Map<String,Accounts> newAccountsList=AccountsRepository.getListOfAccounts();
		if(newAccountsList.containsKey(account.getAccountID()))
		{
			newAccountsList.get(account.getAccountID()).getCustomer().setCustomerName(account.getCustomer().getCustomerName());
			return true;
		}
		return false;
		
	}
	public boolean updateCustomerContact(Accounts account)
	{
		Map<String,Accounts> newAccountsList=AccountsRepository.getListOfAccounts();
		if(newAccountsList.containsKey(account.getAccountID()))
		{
			newAccountsList.get(account.getAccountID()).getCustomer().setContact(account.getCustomer().getContact());
			return true;
		}
		return false;
		
	}
	public boolean updateCustomerAddress(Accounts account)
	{
		Map<String,Accounts> newAccountsList=AccountsRepository.getListOfAccounts();
		if(newAccountsList.containsKey(account.getAccountID()))
		{
			newAccountsList.get(account.getAccountID()).getCustomer().setAddress(account.getCustomer().getAddress());
			return true;
		}
		return false;	
	}
	
	public String addCustomerDetails(Accounts account)
	{
		List<Customers> newCustomersList =CustomersRepository.getListOfCustomers();
		newCustomersList.add(account.getCustomer());
		CustomersRepository.setListOfCustomers(newCustomersList);
		List<Addresses> newAddressesList= AddressesRepository.getListOfAddresses();
		newAddressesList.add(account.getCustomer().getAddress());
		AddressesRepository.setListOfAddresses(newAddressesList);
		
		String customerID = null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.customerID;
			customerID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.customerID;
			customerID=String.format("%04d", id);
		}
		return String.valueOf(customerID);	
	}
	
	public String addAccount(Accounts account)
	{
		Map<String,Accounts> newAccountList=AccountsRepository.getListOfAccounts();
		newAccountList.put(account.getAccountID(), account);
		AccountsRepository.setListOfAccounts(newAccountList);
		if(AccountsRepository.getListOfAccounts().containsKey(account.getAccountID()))
			return account.getAccountID();
		else
			return "Account not created";
	}
	
	public String calculateAccountID(Accounts account)
	{
		String accountID = null;
		if(account.getBreanchID().equals(Branch1.branchID))
		{
			int id=++Branch1.accounts;
			accountID=String.format("%04d", id);
		}
		if(account.getBreanchID().equals(Branch2.branchID))
		{
			int id=++Branch2.accounts;
			accountID=String.format("%04d", id);
		}
		return account.getBreanchID()+account.getCustomerID()+accountID;	
	}
	
	public boolean showAccountDetails(Accounts account)
	{
		Map<String,Accounts> newAccountsList=AccountsRepository.getListOfAccounts();
		if(newAccountsList.containsKey(account.getAccountID()))
		{
			System.out.println("Account ID : "+newAccountsList.get(account.getAccountID()).getAccountID());
			System.out.println("Account type : "+newAccountsList.get(account.getAccountID()).getType());
			System.out.println("balance : "+newAccountsList.get(account.getAccountID()).getBalance());
			System.out.println("balance : "+newAccountsList.get(account.getAccountID()).getStatus());
			return true;
		}
		return false;
	}
	
	public void displayAccounts()
	{
		for(String key:AccountsRepository.getListOfAccounts().keySet())
		{
			System.out.println(AccountsRepository.getListOfAccounts().get(key));
		}
	}
	

}
