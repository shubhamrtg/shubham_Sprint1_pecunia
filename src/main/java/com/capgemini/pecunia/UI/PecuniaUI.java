package com.capgemini.pecunia.UI;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.pecunia.DTO.Accounts;
import com.capgemini.pecunia.DTO.Addresses;
import com.capgemini.pecunia.DTO.Customers;
import com.capgemini.pecunia.exceptions.InvalidAccountDetailException;
import com.capgemini.pecunia.exceptions.InvalidAddressException;
import com.capgemini.pecunia.exceptions.InvalidCustomerDetailException;
import com.capgemini.pecunia.services.AccountManagementService;
import com.capgemini.pecunia.services.AccountManagementServiceImp;
import com.capgemini.pecunia.util.AccountsRepository;

public class PecuniaUI 
{
	public static void main(String[] args) throws InvalidAccountDetailException, InvalidAddressException, InvalidCustomerDetailException 
	{
		//service object to access functionalities of AccountManagementService
		AccountManagementService serviceObj=new AccountManagementServiceImp();
		
		//Declaring bean classes for further use
		Accounts accountBean;
		Addresses addressBean;
		Customers customerBean;
		
		//scanner to take input from user
		Scanner sc=new Scanner(System.in);
		
		//date time formatter to parse date in a particular format
		DateTimeFormatter myFormat =DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		//menu driven user interface
		
		int ch=-1;
		do
		{
			System.out.println("Enter 1 to add Account \nEnter 2 to update \nEnter 3 to delete \nEnter 4 to display all accounts \nEnter 0 to exit");
			try 
			{
				ch=sc.nextInt();
			}

			catch(InputMismatchException exception)
			{
				System.out.println("Enter only number");
				sc.next();
			}
		}while(ch<0);
		
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
				while(true)
				{
					System.out.println("Enter name");
					try 
					{
						customerBean.setCustomerName(sc.next()+sc.nextLine());
					} 
					catch (InvalidCustomerDetailException e1) 
					{
						System.out.println(e1.getMessage());
					}
					while(true)
					{
						System.out.println("Enter contact number");
						try
						{
							customerBean.setContact(sc.nextLong());
							break;
						}
						catch(InputMismatchException | InvalidCustomerDetailException e)
						{
							System.out.println("invalid contact number : enter 10 digit numeric value");
							sc.next();
						}
					}
						
					while(true)
					{
						System.out.println("Enter DOB");
						try
						{
							customerBean.setDateOfBirth(LocalDate.parse(sc.next(), myFormat));
							break;
						}
						catch(DateTimeParseException e)
						{
							System.out.println("invalid Date : enter date in dd-mm-yyyy format");
							sc.next();
						}
					}
					while(true)
					{
						System.out.println("Enter aadhar number");
						try
						{
							customerBean.setAadhar(sc.nextLong());
							break;
						}
						catch(InputMismatchException | InvalidCustomerDetailException e)
						{
							System.out.println("invalid aadhar number : enter 12 digit numeric value");
							sc.next();
						}
					}
					System.out.println("Enter gender");
					try 
					{
						customerBean.setGender(sc.next());
					} 
					catch (InvalidCustomerDetailException e1) 
					{
						System.out.println(e1.getMessage());
					}
					System.out.println("Enter Pan code");
					try 
					{
						customerBean.setPan(sc.next());
					}
					catch (InvalidCustomerDetailException e1) 
					{
						System.out.println(e1.getMessage());
					}
					System.out.println("Enter address line 1");
					addressBean.setAddressline1(sc.next()+sc.nextLine());
					System.out.println("Enter address line 2");
					addressBean.setAddressline2(sc.next()+sc.nextLine());
					System.out.println("Enter city");
					try 
					{
						addressBean.setCity(sc.next());
					} 
					catch (InvalidAddressException e1) 
					{
						System.out.println(e1.getMessage());
					}
					System.out.println("Enter state");
					try 
					{
						addressBean.setState(sc.next());
					} 
					catch (InvalidAddressException e1) 
					{
						System.out.println(e1.getMessage());
					}
					System.out.println("Enter country");
					try 
					{
						addressBean.setCountry(sc.next());
					} 
					catch (InvalidAddressException e1) 
					{
						System.out.println(e1.getMessage());
					}
					System.out.println("Enter zip code");
					try 
					{
						addressBean.setZipCode(sc.next());
					} 
					catch (InvalidAddressException e1) 
					{
						System.out.println(e1.getMessage());
					}
					customerBean.setAddress(addressBean);
					accountBean.setCustomer(customerBean);
					while(true)
					{
						System.out.println("Enter account balance");
						try
						{
							accountBean.setBalance(sc.nextDouble());
							break;
						}
						catch(InputMismatchException e)
						{
							System.out.println("invalid balance : enter numeric value");
							sc.next();
						}
					}
					System.out.println("Enter branch id");
					try 
					{
						accountBean.setBranchID(sc.next());
					}
					catch (InvalidAccountDetailException e1)
					{
						System.out.println(e1.getMessage());
					}
					while(true)
					{
						System.out.println("Enter interest rate");
						try
						{
							accountBean.setInterestRate(sc.nextDouble());
							break;
						}
						catch(InputMismatchException e)
						{
							System.out.println("invalid interest rate : enter numeric value");
							sc.next();
						}
					}
					System.out.println("Enter account type");
					accountBean.setType(sc.next());
					System.out.println("Enter account status");
					accountBean.setStatus(sc.next());
					try
					{	
						//calling add account function from service package
						System.out.println(serviceObj.addAccount(accountBean));
						break;
					}
					catch(InvalidAddressException | InvalidAccountDetailException |InvalidCustomerDetailException e)
					{
						System.out.println(e.getMessage());
					}
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
					try 
					{
						accountBean.setAccountID(sc.next());
					} 
					catch (InvalidAccountDetailException e1) 
					{
						System.out.println(e1.getMessage());
					}
					System.out.println("Enter new name");
					sc.next();
					try 
					{
						customerBean.setCustomerName(sc.next()+sc.nextLine());
					} 
					catch (InvalidCustomerDetailException e1) 
					{
						System.out.println(e1.getMessage());
					}
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
					try 
					{
						accountBean.setAccountID(sc.next());
					} 
					catch (InvalidAccountDetailException e1) 
					{
						System.out.println(e1.getMessage());
					}
					System.out.println("Enter new address");
					addressBean.setAddressline1(sc.next());
					addressBean.setAddressline2(sc.next());
					try 
					{
						addressBean.setCity(sc.next());
					} 
					catch (InvalidAddressException e1) 
					{
						System.out.println(e1.getMessage());
					}
					try 
					{
						addressBean.setState(sc.next());
					} 
					catch (InvalidAddressException e1) 
					{
						System.out.println(e1.getMessage());
					}
					try 
					{
						addressBean.setCountry(sc.next());
					} 
					catch (InvalidAddressException e1) 
					{
						System.out.println(e1.getMessage());
					}
					try 
					{
						addressBean.setZipCode(sc.next());
					}
					catch (InvalidAddressException e1)
					{
						System.out.println(e1.getMessage());
					}
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
					try 
					{
						accountBean.setAccountID(sc.next());
					} 
					catch (InvalidAccountDetailException e1) 
					{
						System.out.println(e1.getMessage());
					}
					while(true)
					{
						System.out.println("Enter contact number");
						try
						{
							customerBean.setContact(sc.nextLong());
							break;
						}
						catch(InputMismatchException | InvalidCustomerDetailException e)
						{
							System.out.println("invalid contact number : enter 10 digit numeric value");
							sc.next();
						}
					}
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
				try 
				{
					accountBean.setAccountID(sc.next());
				} 
				catch (InvalidAccountDetailException e1) 
				{
					System.out.println(e1.getMessage());
				}
				
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
			
			ch=-1;
			do
			{
				System.out.println("Enter 1 to add Account \nEnter 2 to update \nEnter 3 to delete \nEnter 4 to display all accounts \nEnter 0 to exit");
				try 
				{
					ch=sc.nextInt();
				}

				catch(InputMismatchException exception)
				{
					System.out.println("Enter only number");
					sc.next();
				}
			}while(ch<0);
		}
		sc.close();
	}

}
