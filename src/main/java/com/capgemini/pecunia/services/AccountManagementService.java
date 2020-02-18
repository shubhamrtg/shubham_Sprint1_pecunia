package com.capgemini.pecunia.services;

import com.capgemini.pecunia.DTO.Accounts;
import com.capgemini.pecunia.exceptions.InvalidAccountDetailException;
import com.capgemini.pecunia.exceptions.InvalidAddressException;
import com.capgemini.pecunia.exceptions.InvalidCustomerDetailException;

public interface AccountManagementService 
{
	public boolean deleteAccount(Accounts account);
	public String updateCustomerName(Accounts account) throws InvalidAccountDetailException, InvalidCustomerDetailException;
	public String updateCustomerContact(Accounts account) throws InvalidAccountDetailException, InvalidCustomerDetailException;
	public String updateCustomerAddress(Accounts account) throws InvalidAddressException, InvalidAccountDetailException;
	public String addAccount(Accounts account) throws InvalidAddressException, InvalidAccountDetailException, InvalidCustomerDetailException;
	public String calculateAccountID(Accounts account);
	public boolean showAccountDetails(Accounts account) throws InvalidAccountDetailException;

}
