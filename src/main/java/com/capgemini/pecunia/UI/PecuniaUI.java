package com.capgemini.pecunia.UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.capgemini.pecunia.DTO.Accounts;
import com.capgemini.pecunia.DTO.Addresses;
import com.capgemini.pecunia.DTO.Customers;
import com.capgemini.pecunia.exceptions.InvalidAccountDetailException;
import com.capgemini.pecunia.exceptions.InvalidAddressException;
import com.capgemini.pecunia.exceptions.InvalidCustomerDetailException;
import com.capgemini.pecunia.services.AccountManagementServiceImp;
import com.capgemini.pecunia.util.AccountsRepository;

public class PecuniaUI 
{
	public static void main(String[] args) 
	{
		//service object to access functionalities of AccountManagementService
		AccountManagementServiceImp serviceObj=new AccountManagementServiceImp();
		
		//Declaring bean classes for further use
		Accounts accountBean;
		Addresses addressBean;
		Customers customerBean;
		
		//scanner to take input from user
		Scanner sc=new Scanner(System.in);
		
		//date time formatter to parse date in a particular format
		DateTimeFormatter myFormat =DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		//menu driven user interface
		System.out.println("Enter 1 to add Account \nEnter 2 to update \nEnter 3 to delete \nEnter 4 to display all accounts \nEnter 0 to exit");
		int ch=sc.nextInt();
		
		while(ch!=0)
		{
			switch(ch)
			{
			case 1:
				//adding new account
				
				//new bean classes for adding data
				accountBean=new Accounts();
				addressBean=new Addresses();
				customerBean=new Customers();
				
				//taking input from user
				System.out.println("Enter Customer and account details");
				customerBean.setCustomerName(sc.next());
				customerBean.setContact(sc.nextLong());
				customerBean.setDateOfBirth(LocalDate.parse(sc.next(), myFormat));
				customerBean.setAadhar(sc.nextLong());
				customerBean.setGender(sc.next());
				customerBean.setPan(sc.next());
				addressBean.setAddressline1(sc.next());
				addressBean.setAddressline2(sc.next());
				addressBean.setCity(sc.next());
				addressBean.setState(sc.next());
				addressBean.setCountry(sc.next());
				addressBean.setZipCode(sc.next());
				customerBean.setAddress(addressBean);
				accountBean.setCustomer(customerBean);
				accountBean.setBalance(sc.nextDouble());
				accountBean.setBreanchID(sc.next());
				accountBean.setInterestRate(sc.nextDouble());
				accountBean.setType(sc.next());
				accountBean.setStatus(sc.next());
				
				try
				{
					//calling add account function from service package
					System.out.println(serviceObj.addAccount(accountBean));
				}
				catch(InvalidAddressException | DateTimeParseException | InvalidAccountDetailException |InvalidCustomerDetailException e)
				{
					System.out.println(e.getMessage());
				}
			break;
				
			case 2:
				//menu driven user interface for updating customer details
				System.out.println("Enter 1 to update name \nEnter 2 to update address \nEnter 3 to update contact");
				int ch1=sc.nextInt();
				
				switch(ch1)
				{
				case 1:
					//updating customer name
					
					accountBean=new Accounts();
					customerBean=new Customers();
					
					//to display all the account in the repository
					for(String key:serviceObj.displayAccounts().keySet())
					{
						System.out.println(AccountsRepository.getListOfAccounts().get(key));
					}
					
					//taking account id and customer name as input from user
					System.out.println("Enter account ID");
					accountBean.setAccountID(sc.next());
					System.out.println("Enter new name");
					customerBean.setCustomerName(sc.next());
					accountBean.setCustomer(customerBean);
					
					try
					{	
						//calling update customer name function in service package
						System.out.println(serviceObj.updateCustomerName(accountBean));
					}
					catch(InvalidCustomerDetailException | InvalidAccountDetailException e)
					{
						System.out.println(e.getMessage());
					}
				break;
					
				case 2:
					//updating customer address
					
					accountBean=new Accounts();
					addressBean=new Addresses();
					customerBean=new Customers();
					
					//to display all the accounts in the repository
					for(String key:serviceObj.displayAccounts().keySet())
					{
						System.out.println(AccountsRepository.getListOfAccounts().get(key));
					}
					
					//taking account id and new address as input from user
					System.out.println("Enter account ID");
					accountBean.setAccountID(sc.next());
					System.out.println("Enter new address");
					addressBean.setAddressline1(sc.next());
					addressBean.setAddressline2(sc.next());
					addressBean.setCity(sc.next());
					addressBean.setState(sc.next());
					addressBean.setCountry(sc.next());
					addressBean.setZipCode(sc.next());
					customerBean.setAddress(addressBean);
					accountBean.setCustomer(customerBean);
					
					try
					{
						//calling update customer address function in service package
						System.out.println(serviceObj.updateCustomerAddress(accountBean));
					}
					catch(InvalidAddressException | InvalidAccountDetailException e)
					{
						System.out.println(e.getMessage());
					}
				break;
				
				case 3:
					//updating customer contact
					
					accountBean=new Accounts();
					customerBean=new Customers();
					
					//to display all the accounts in the repository
					for(String key:serviceObj.displayAccounts().keySet())
					{
						System.out.println(AccountsRepository.getListOfAccounts().get(key));
					}
					
					//taking account id and new contact as input from user
					System.out.println("Enter account ID");
					accountBean.setAccountID(sc.next());
					System.out.println("Enter new contact");
					customerBean.setContact(sc.nextLong());
					accountBean.setCustomer(customerBean);
					
					try
					{
						//calling update customer contact function in service package
						System.out.println(serviceObj.updateCustomerContact(accountBean));
					}
					catch(InvalidCustomerDetailException | InvalidAccountDetailException e)
					{
						System.out.println(e.getMessage());
					}
				break;
				
				default:
					//default case for invalid input
					System.out.println("GO HOME.. YOU ARE DRUNK..!!");
				}
			break;
			
			case 3:
				//deleting account
				
				accountBean=new Accounts();
				
				//taking account id as input from user
				System.out.println("Enter account ID");
				accountBean.setAccountID(sc.next());
				
				try
				{
					//to get confirmation for deleting account from the user
					if(serviceObj.showAccountDetails(accountBean))
					{
						System.out.println("press y to confirm deletion \npress n to cancel");
						char choice=sc.next().charAt(0);
						if(choice=='y' || choice=='Y')
						{
							if(serviceObj.deleteAccount(accountBean))
								System.out.println("Account closed");
							else
								System.out.println("Account already closed");
						}
						else if(choice=='n' || choice=='N')
							break;
						else
							System.out.println("Wrong input");
					}
					else
						System.out.println("Account does not exist");
				}
				catch(InvalidAccountDetailException e)
				{
					System.out.println(e.getMessage());
				}
			break;
			
			case 4:
				//display all accounts
				
				//to display all the accounts in the repository
				for(String key:serviceObj.displayAccounts().keySet())
				{
					System.out.println(AccountsRepository.getListOfAccounts().get(key));
				}
			break;
			
			default:
				System.out.println("GO HOME.. YOU ARE DRUNK..!!");
			}
			System.out.println("Enter 1 to add Account \nEnter 2 to update \nEnter 3 to delete \nEnter 4 to diplay all accounts \nEnter 0 to exit");
			ch=sc.nextInt();
		}
		sc.close();
	}

}
