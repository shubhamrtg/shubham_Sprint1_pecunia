package com.capgemini.pecunia.services;

import java.util.Map;

import com.capgemini.pecunia.DAO.AccountManagementDAOImp;
import com.capgemini.pecunia.DTO.Accounts;
import com.capgemini.pecunia.exceptions.InvalidAccountDetailException;
import com.capgemini.pecunia.exceptions.InvalidAddressException;
import com.capgemini.pecunia.exceptions.InvalidCustomerDetailException;

public class AccountManagementServiceImp implements AccountManagementService
{
	AccountManagementDAOImp DAOObject;
	public AccountManagementServiceImp()
	{
		DAOObject=new AccountManagementDAOImp();
	}
	public void validation(Accounts account) throws InvalidAddressException, InvalidAccountDetailException, InvalidCustomerDetailException
	{
		//validation of all the input given by user
		if(!account.getCustomer().getCustomerName().matches("^[a-zA-Z]*$"))
			throw new InvalidCustomerDetailException("Invalid customer name");
		if(String.valueOf(account.getCustomer().getContact()).length()!=10)
			throw new InvalidCustomerDetailException("Invalid Contact number");
		if(String.valueOf(account.getCustomer().getAadhar()).length()!=12)
			throw new InvalidCustomerDetailException("Invalid Aadhar number");
		if(!account.getCustomer().getPan().substring(0, 5).matches("^[a-zA-Z]*$"))
			throw new InvalidCustomerDetailException("Invalid PAN number");
		if(!account.getCustomer().getPan().substring(5, 9).matches("[0-9]+"))
			throw new InvalidCustomerDetailException("Invalid PAN number");
		if(!account.getCustomer().getPan().substring(9).matches("^[a-zA-Z]*$") || account.getCustomer().getPan().substring(9).length()!=1)
			throw new InvalidCustomerDetailException("Invalid PAN number");
		if(!account.getCustomer().getAddress().getCity().matches("^[a-zA-Z]*$"))
			throw new InvalidAddressException("Invalid city name");
		if(!account.getCustomer().getAddress().getState().matches("^[a-zA-Z]*$"))
			throw new InvalidAddressException("Invalid state name");
		if(!account.getCustomer().getAddress().getCountry().matches("^[a-zA-Z]*$"))
			throw new InvalidAddressException("Invalid country name");
		if(!account.getCustomer().getAddress().getZipCode().matches("[0-9]+") || account.getCustomer().getAddress().getZipCode().length()!=6)
			throw new InvalidAddressException("Invalid zipcode");
		if(!account.getBreanchID().matches("[0-9]+") || account.getBreanchID().length()!=4)
			throw new InvalidAccountDetailException("Invalid branch id");	

	}
	public boolean deleteAccount(Accounts account)
	{
		return DAOObject.deleteAccount(account);		
	}
	public String updateCustomerName(Accounts account) throws InvalidCustomerDetailException, InvalidAccountDetailException
	{
		//validation of input given by user
		if(!account.getCustomer().getCustomerName().matches("^[a-zA-Z]*$"))
			throw new InvalidCustomerDetailException("Invalid customer name");
		if(!account.getAccountID().matches("[0-9]+") || account.getAccountID().length()!=12)
			throw new InvalidAccountDetailException("Invalid account id");
		
		if(DAOObject.updateCustomerName(account))
			return "Name updated successfully";
		else
			return "Name not updated : Account does not exist";
		
	}
	public String updateCustomerContact(Accounts account) throws InvalidCustomerDetailException, InvalidAccountDetailException
	{
		//validation of input given by the user
		if(String.valueOf(account.getCustomer().getContact()).length()!=10)
			throw new InvalidCustomerDetailException("Invalid Contact number");
		if(!account.getAccountID().matches("[0-9]+") || account.getAccountID().length()!=12)
			throw new InvalidAccountDetailException("Invalid account id");
		
		if(DAOObject.updateCustomerContact(account))
			return "Contact updated successfully";
		else
			return "Contact not updated : Account does not exist";
	}
	public String updateCustomerAddress(Accounts account) throws InvalidAddressException, InvalidAccountDetailException
	{
		//validation of input given by the user
		if(!account.getCustomer().getAddress().getCity().matches("^[a-zA-Z]*$"))
			throw new InvalidAddressException("Invalid city name");
		if(!account.getCustomer().getAddress().getState().matches("^[a-zA-Z]*$"))
			throw new InvalidAddressException("Invalid state name");
		if(!account.getCustomer().getAddress().getCountry().matches("^[a-zA-Z]*$"))
			throw new InvalidAddressException("Invalid country name");
		if(!account.getCustomer().getAddress().getZipCode().matches("[0-9]+") || account.getCustomer().getAddress().getZipCode().length()!=6)
			throw new InvalidAddressException("Invalid zipcode");
		if(!account.getAccountID().matches("[0-9]+") || account.getAccountID().length()!=12)
			throw new InvalidAccountDetailException("Invalid account id");
		
		if(DAOObject.updateCustomerAddress(account))
			return "Address updated successfully";
		else
			return "Address not updated : Account does not exist";
	}

	public String addAccount(Accounts account) throws InvalidAddressException, InvalidAccountDetailException, InvalidCustomerDetailException
	{
		validation(account);	
		String customerID=null;
		customerID=DAOObject.addCustomerDetails(account);
		account.setCustomerID(customerID);
		String accountID=calculateAccountID(account);
		account.setAccountID(accountID);
		String result=DAOObject.addAccount(account);
		if(result.equals(account.getAccountID()))
			return "Account created : "+account.getAccountID();
		else
			return "Account not created";
	}
	public String calculateAccountID(Accounts account)
	{
		return DAOObject.calculateAccountID(account);
	}
	public boolean showAccountDetails(Accounts account) throws InvalidAccountDetailException
	{
		//validation of input given by the user
		if(!account.getAccountID().matches("[0-9]+") || account.getAccountID().length()!=12)
			throw new InvalidAccountDetailException("Invalid account id");
		
		return DAOObject.showAccountDetails(account);
	}
	public Map<String,Accounts> displayAccounts()
	{
		return DAOObject.displayAccounts();
	}
}
