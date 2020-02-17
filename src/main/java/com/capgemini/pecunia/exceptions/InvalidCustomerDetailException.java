package com.capgemini.pecunia.exceptions;

public class InvalidCustomerDetailException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public InvalidCustomerDetailException(String s)
	{
		super(s);
	}

}
