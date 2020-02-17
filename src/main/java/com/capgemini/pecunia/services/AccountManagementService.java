package com.capgemini.pecunia.services;

import com.capgemini.pecunia.DTO.Accounts;

public interface AccountManagementService 
{
	public boolean deleteAccount(Accounts account);
	public String updateCustomerName(Accounts account);
	public String updateCustomerContact(Accounts account);
	public String updateCustomerAddress(Accounts account);
	public String addAccount(Accounts account);
	public String calculateAccountID(Accounts account);
	public boolean showAccountDetails(Accounts account);

}
