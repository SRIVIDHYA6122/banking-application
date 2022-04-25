package com.edu;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class NewUser {
	static Connection scon=null;
	static ResultSet rs=null;
	static Statement st=null;
	static int passwordno,i,withdraw_amount,deposit_amount;
	static String sql;
	static int balance;
	static Scanner sc=new Scanner(System.in);
	

	public static void Create() throws SQLException {
		scon=Dbconnection.getConnection();
		st=scon.createStatement();
		System.out.println("enter account number");
		String accno= sc.next();
		
		sql="select * from account where accno='"+accno+"'";
		rs=st.executeQuery(sql);
		if(!rs.next())
		{
			
		
		//System.out.println("enter the account number");
		//int accno=sc.nextInt();
		System.out.println("enter password");
		int password=sc.nextInt();
		System.out.println("enter account holder name");
		String aname= sc.next();
		System.out.println("enter phone number");
		String phone= sc.next();
		System.out.println("enter mail id");
		String mail=sc.next();
		System.out.println("enter the amount");
		double balance= sc.nextDouble();
		
		sql="insert into account values('"+accno+"',"+password+",'"+aname+"','"+phone+"','"+mail+"',"+balance+")";
		
		
		
		int i= st.executeUpdate(sql);
		if(i>0)
		{
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.println("accno\t\t\tpassword\taname\t\tphone\t\tmail\t\t\tbalance");
			System.out.println("----------------------------------------------------------------------------------------------------------");
		
		sql=" select * from account where accno='"+accno+"'";
		rs=st.executeQuery(sql);
		if(rs.next())
		{
			
		
			System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t\t"+rs.getInt(6));
		System.out.println("Record is inserted successfully");
		}
		else
		{
			System.out.println("not exit");
		}
			
			//System.out.println("Record is inserted successfully");
			
		}
		
		}
		else
		{
			System.out.println("account already exists");
		}
		
		
		
	}

}
