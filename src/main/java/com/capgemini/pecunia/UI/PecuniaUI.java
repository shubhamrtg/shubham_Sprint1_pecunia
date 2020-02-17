package com.capgemini.pecunia.UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import com.capgemini.pecunia.DTO.Accounts;
import com.capgemini.pecunia.DTO.Addresses;
import com.capgemini.pecunia.DTO.Customers;
import com.capgemini.pecunia.exceptions.InvalidAccountDetailException;
import com.capgemini.pecunia.exceptions.InvalidCustomerDetailException;
import com.capgemini.pecunia.services.AccountManagementServiceImp;

public class PecuniaUI 
{
	public static void main(String[] args) 
	{
		AccountManagementServiceImp serviceObj=new AccountManagementServiceImp();
		Accounts accountBean;
		Addresses addressBean;
		Customers customerBean;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1 to add Account \nEnter 2 to update \nEnter 3 to delete");
		int ch=sc.nextInt();
		DateTimeFormatter myFormat =DateTimeFormatter.ofPattern("dd-MM-yyyy");
		while(ch!=0)
		{
			switch(ch)
			{
			case 1:
				accountBean=new Accounts();
				addressBean=new Addresses();
				customerBean=new Customers();
				System.out.println("Enter Customer and account details");
				try
				{
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
					if(!accountBean.getCustomer().getCustomerName().matches("^[a-zA-Z]*$"))
						throw new InvalidCustomerDetailException("Invalid customer name");
					if(String.valueOf(accountBean.getCustomer().getContact()).length()!=10)
						throw new InvalidCustomerDetailException("Invalid Contact number");
					if(String.valueOf(accountBean.getCustomer().getAadhar()).length()!=12)
						throw new InvalidCustomerDetailException("Invalid Aadhar number");
					if(!accountBean.getCustomer().getPan().substring(0, 5).matches("^[a-zA-Z]*$"))
						throw new InvalidCustomerDetailException("Invalid PAN number");
					if(accountBean.getCustomer().getPan().substring(5, 9).matches("^[a-zA-Z]*$"))
						throw new InvalidCustomerDetailException("Invalid PAN number");
					if(!accountBean.getCustomer().getPan().substring(9).matches("^[a-zA-Z]*$"))
						throw new InvalidCustomerDetailException("Invalid PAN number");
					if(!accountBean.getCustomer().getAddress().getCity().matches("^[a-zA-Z]*$"))
						throw new InvalidCustomerDetailException("Invalid city name");
					if(!accountBean.getCustomer().getAddress().getState().matches("^[a-zA-Z]*$"))
						throw new InvalidCustomerDetailException("Invalid state name");
					if(!accountBean.getCustomer().getAddress().getCountry().matches("^[a-zA-Z]*$"))
						throw new InvalidCustomerDetailException("Invalid country name");
					if(accountBean.getCustomer().getAddress().getZipCode().matches("^[a-zA-Z]*$") || accountBean.getCustomer().getAddress().getZipCode().length()!=6)
						throw new InvalidCustomerDetailException("Invalid zipcode");
					if(accountBean.getBreanchID().matches("^[a-zA-Z]*$") || accountBean.getBreanchID().length()!=4)
						throw new InvalidAccountDetailException("Invalid branch id");
					System.out.println(serviceObj.addAccount(accountBean));
				}
				catch(InvalidCustomerDetailException | DateTimeParseException | InvalidAccountDetailException e)
				{
					System.out.println(e);
				}
				break;
			case 2:
				System.out.println("Enter 1 to update name \nEnter 2 to update address \nEnter 3 to update contact");
				int ch1=sc.nextInt();
				switch(ch1)
				{
				case 1:
					accountBean=new Accounts();
					customerBean=new Customers();
					serviceObj.displayAccounts();
					try
					{
						System.out.println("Enter account ID");
						accountBean.setAccountID(sc.next());
						System.out.println("Enter new name");
						customerBean.setCustomerName(sc.next());
						accountBean.setCustomer(customerBean);
						if(!accountBean.getCustomer().getCustomerName().matches("^[a-zA-Z]*$"))
							throw new InvalidCustomerDetailException("Invalid customer name");
						if(accountBean.getAccountID().matches("^[a-zA-Z]*$") || accountBean.getAccountID().length()!=12)
							throw new InvalidAccountDetailException("Invalid account id");
						System.out.println(serviceObj.updateCustomerName(accountBean));
					}
					catch(InvalidCustomerDetailException | InvalidAccountDetailException e)
					{
						System.out.println(e);
					}
					break;
				case 2:
					accountBean=new Accounts();
					addressBean=new Addresses();
					customerBean=new Customers();
					serviceObj.displayAccounts();
					try
					{
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
						if(!accountBean.getCustomer().getAddress().getCity().matches("^[a-zA-Z]*$"))
							throw new InvalidCustomerDetailException("Invalid city name");
						if(!accountBean.getCustomer().getAddress().getState().matches("^[a-zA-Z]*$"))
							throw new InvalidCustomerDetailException("Invalid state name");
						if(!accountBean.getCustomer().getAddress().getCountry().matches("^[a-zA-Z]*$"))
							throw new InvalidCustomerDetailException("Invalid country name");
						if(accountBean.getCustomer().getAddress().getZipCode().matches("^[a-zA-Z]*$") || accountBean.getCustomer().getAddress().getZipCode().length()!=6)
							throw new InvalidCustomerDetailException("Invalid zipcode");
						if(accountBean.getAccountID().matches("^[a-zA-Z]*$") || accountBean.getAccountID().length()!=12)
							throw new InvalidAccountDetailException("Invalid account id");
						System.out.println(serviceObj.updateCustomerAddress(accountBean));
					}
					catch(InvalidCustomerDetailException | InvalidAccountDetailException e)
					{
						System.out.println(e);
					}
					break;
				case 3:
					accountBean=new Accounts();
					customerBean=new Customers();
					serviceObj.displayAccounts();
					try
					{
						System.out.println("Enter account ID");
						accountBean.setAccountID(sc.next());
						System.out.println("Enter new contact");
						customerBean.setContact(sc.nextLong());
						accountBean.setCustomer(customerBean);
						if(String.valueOf(accountBean.getCustomer().getContact()).length()!=10)
							throw new InvalidCustomerDetailException("Invalid Contact number");
						if(accountBean.getAccountID().matches("^[a-zA-Z]*$") || accountBean.getAccountID().length()!=12)
							throw new InvalidAccountDetailException("Invalid account id");
						System.out.println(serviceObj.updateCustomerContact(accountBean));
					}
					catch(InvalidCustomerDetailException | InvalidAccountDetailException e)
					{
						System.out.println(e);
					}
					break;
				default:
					System.out.println("GO HOME.. YOU ARE DRUNK..!!");
				}
				break;
			case 3:
				accountBean=new Accounts();
				try
				{
					System.out.println("Enter account ID");
					accountBean.setAccountID(sc.next());
					if(accountBean.getAccountID().matches("^[a-zA-Z]*$") || accountBean.getAccountID().length()!=12)
						throw new InvalidAccountDetailException("Invalid account id");
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
					System.out.println(e);
				}
				break;
			default:
				System.out.println("GO HOME.. YOU ARE DRUNK..!!");
			}
			System.out.println("Enter 1 to enter new author, 2 to update Existing author, 3 to delete, 4 to view all authors and 0 to exit");
			ch=sc.nextInt();
		}
		sc.close();
	}

}
