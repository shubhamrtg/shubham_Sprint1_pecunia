package com.capgemini.pecunia.exceptions;

public class InvalidAddressException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public InvalidAddressException(String s)
	{
		super(s);
	}

}
