package com.edu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class User 
{
	static Connection scon=null;
	static ResultSet rs=null;
	static Statement st=null;
	static String accno;
	static String sql;
	static Scanner sc=new Scanner(System.in);
	public static void logIn() throws SQLException 
	{
		System.out.println("Enter the Account no:");
		String accno=sc.next();
		scon=Dbconnection.getConnection();
		st=scon.createStatement();
		sql="select * from account where accno="+accno;
		rs=st.executeQuery(sql);
		
		if(rs.next())
		{
			rs.getInt("accno");
			System.out.println("Enter the Choice:");
			System.out.println("1.view balance");
	        System.out.println("2.withdraw amount");
	        System.out.println("3.deposit amount");
	        System.out.println("4.account statement");
	        System.out.println("5.display all account");
	        System.out.println("6.exit");
	       
	        
	        int choice=sc.nextInt();
	        switch(choice)
	        {
	        case 1: BankManagement.checkBalance();
	        break;
	        case 2: BankManagement.withdrawAmount();
	        break;
	        case 3: BankManagement.depositAmount();
	        break;
	        case 4: BankManagement.statementBalance();
	        break;
	        case 5: BankManagement.displayallAccount();
	        break;
	        case 6: BankManagement.exit();
	        break;
	        default: System.out.println("Invalid choice....");
	        }
	        
		}
		
		else
		{
			System.out.println("PLEASE ENTER THE CORRECT ACCOUNT NUMBER!");
		}
		
	}

}

