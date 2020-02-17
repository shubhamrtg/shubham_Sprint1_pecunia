package com.capgemini.pecunia.exceptions;

public class InvalidAccountDetailException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public InvalidAccountDetailException(String s)
	{
		super(s);
	}
}
