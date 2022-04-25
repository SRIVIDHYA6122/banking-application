package com.edu;


import java.sql.SQLException;

import java.util.Scanner;

public class Bank
{
	static int choice;
    static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) throws SQLException 
	{
		
		while(true)
		{
		System.out.println("SIMPLE BANKING APPLICATION");
		System.out.println("------IOB BANK-------");
		System.out.println("Enter the choice:");
		System.out.println("1.USER");
		System.out.println("2.NEW USER");
		System.out.println("3.DISPLAY ALL ACCOUNT DETAILS");
		
		System.out.println("---------");
		
	    choice=sc.nextInt();
		switch(choice)
		{
		case 1: User.logIn();
		        break;
		case 2:NewUser.Create();
				break;
		case 3:Display.Account();
				break;
		
		default:
			System.out.println("INVALID LOGIN");
			
	}

		}
}
}