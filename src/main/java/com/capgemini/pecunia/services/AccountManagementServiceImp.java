package com.capgemini.pecunia.services;

import com.capgemini.pecunia.DAO.AccountManagementDAOImp;
import com.capgemini.pecunia.DTO.Accounts;

public class AccountManagementServiceImp implements AccountManagementService
{
	AccountManagementDAOImp DAOObject;
	public AccountManagementServiceImp()
	{
		DAOObject=new AccountManagementDAOImp();
	}
	public boolean deleteAccount(Accounts account)
	{
		return DAOObject.deleteAccount(account);		
	}
	public String updateCustomerName(Accounts account)
	{
		if(DAOObject.updateCustomerName(account))
			return "Name updated successfully";
		else
			return "Name not updated : Account does not exist";
		
	}
	public String updateCustomerContact(Accounts account)
	{
		if(DAOObject.updateCustomerContact(account))
			return "Contact updated successfully";
		else
			return "Contact not updated : Account does not exist";
	}
	public String updateCustomerAddress(Accounts account)
	{
		if(DAOObject.updateCustomerAddress(account))
			return "Address updated successfully";
		else
			return "Address not updated : Account does not exist";
	}

	public String addAccount(Accounts account)
	{
		String customerID=DAOObject.addCustomerDetails(account);
		account.setCustomerID(customerID);
		String accountID=DAOObject.calculateAccountID(account);
		account.setAccountID(accountID);
		String result=DAOObject.addAccount(account);
		if(result.equals(account.getAccountID()))
			return "Account created : "+account.getAccountID();
		else
			return "Account not created";
	}
	public String calculateAccountID(Accounts account)
	{
		return null;
		
	}
	public boolean showAccountDetails(Accounts account)
	{
		return DAOObject.showAccountDetails(account);
	}
	public void displayAccounts()
	{
		DAOObject.displayAccounts();
	}
}
