package com.capgemini.pecunia.DAO;

import com.capgemini.pecunia.DTO.Accounts;

public interface AccountManagementDAO
{
	public boolean deleteAccount(Accounts account);
	public boolean updateCustomerName(Accounts account);
	public boolean updateCustomerContact(Accounts account);
	public boolean updateCustomerAddress(Accounts account);
	public String addCustomerDetails(Accounts account);
	public String addAccount(Accounts account);
	public String calculateAccountID(Accounts account);
	public boolean showAccountDetails(Accounts account);
}
