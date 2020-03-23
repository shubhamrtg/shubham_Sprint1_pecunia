package com.capgemini.pecunia.DAO;

import com.capgemini.pecunia.DTO.Accounts;
import com.capgemini.pecunia.exceptions.InvalidCustomerDetailException;

public interface AccountManagementDAO
{
	public boolean deleteAccount(Accounts account);
	public boolean updateCustomerName(Accounts account) throws InvalidCustomerDetailException;
	public boolean updateCustomerContact(Accounts account) throws InvalidCustomerDetailException;
	public boolean updateCustomerAddress(Accounts account);
	public String addCustomerDetails(Accounts account);
	public String addAccount(Accounts account);
	public String calculateAccountID(Accounts account);
	public boolean showAccountDetails(Accounts account);
}
