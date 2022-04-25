package com.edu;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BankManagement
{
	static Connection scon=null;
	static ResultSet rs=null;
	static Statement st=null;
	static int passwordno,i,withdraw_amount,deposit_amount;
	static String sql;
	static int balance;
	static String accno;
	static Scanner sc=new Scanner(System.in);
	
	public static void checkBalance() throws SQLException 
	{
		scon=Dbconnection.getConnection();
		st=scon.createStatement();
		System.out.println("Enter the Password Number:");
		passwordno=sc.nextInt();
		sql="select * from account where password="+passwordno;
		rs=st.executeQuery(sql);
		System.out.println("----------------------------------------------------------------------------------------------------------");
		System.out.println("accno\t\t\tpassword\taname\t\tphone\t\tmail\t\t\tbalance");
		System.out.println("----------------------------------------------------------------------------------------------------------");
		if(rs.next())
		{	//accno=rs.get(columnLabel)
			balance=rs.getInt("balance");
			System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t\t"+rs.getInt(6));
			System.out.println("YOUR CURRENT BALANCE IS:"+balance);
		}
		else
		{
			System.out.println("invalid password number!");
		
		}
		
	}
	public static void withdrawAmount() throws SQLException 
	{
		scon=Dbconnection.getConnection();
		st=scon.createStatement();
		System.out.println("Enter the Password Number:");
		passwordno=sc.nextInt();
	    sql="select * from account where password="+passwordno;
		rs=st.executeQuery(sql);
		if(rs.next())
		{
			System.out.println("Enter the Withdraw Amount:");
			withdraw_amount=sc.nextInt();
			if(withdraw_amount<rs.getFloat("balance")&&withdraw_amount<10000)
			{
				float amount=rs.getFloat("balance")-withdraw_amount;
				sql="update account set balance="+amount+" where password="+passwordno;
				i=st.executeUpdate(sql);
				
				if(i>0)
				{
					
					System.out.println("your withdraw amount is:"+withdraw_amount);
					
					System.out.println("Available Balance is: "+amount);
					//balance=rs.getInt("balance");
					System.out.println("----------------------------------------------------------------------------------------------------------");
					System.out.println("accno\t\t\tpassword\taname\t\tphone\t\tmail\t\t\tbalance");
					System.out.println("----------------------------------------------------------------------------------------------------------");
					
					sql=" select * from account where password='"+passwordno+"'";
					rs=st.executeQuery(sql);
					if(rs.next())
					{
						
					
						System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t\t"+rs.getInt(6));
					}
					else
					{
						System.out.println("not exit");
					}
				}
			}
			else
			{
				System.out.println(" INSUFFICIENT BALANCE");
			}
		}
		else
		{
			System.out.println("INVALID PASSWORD ");
		}
		
	}
	public static void depositAmount() throws SQLException
	{
		scon=Dbconnection.getConnection();
		st=scon.createStatement();
		System.out.println("Enter the Password Number:");
		passwordno=sc.nextInt();
		sql="select * from account where password="+passwordno;
		rs=st.executeQuery(sql);
		if(rs.next())
		{
			System.out.println("Enter the deposit amount:");
			deposit_amount=sc.nextInt();
			float amount=rs.getFloat("balance")+deposit_amount;
			sql="update account set balance="+amount+" where password="+passwordno;
			i=st.executeUpdate(sql);
			
			if(i>0)
			{
				//System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\t\t"+rs.getInt(6));
				System.out.println("your deposite amount is: "+deposit_amount);
				System.out.println("current Balance is: "+amount);
				System.out.println("----------------------------------------------------------------------------------------------------------");
				System.out.println("accno\t\t\tpassword\taname\t\tphone\t\tmail\t\t\tbalance");
				System.out.println("----------------------------------------------------------------------------------------------------------");
				
				sql=" select * from account where password='"+passwordno+"'";
				rs=st.executeQuery(sql);
				if(rs.next())
				{
					
				
					System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t\t"+rs.getInt(6));
				}
				else
				{
					System.out.println("not exit");
				}
				
			}
		}
		else
		{
			System.out.println("INVAILD PASSWORD NUMBER");
		}
		
	}
	public static void statementBalance() throws SQLException
	{
		scon=Dbconnection.getConnection();
		st=scon.createStatement();
		System.out.println("Enter the Password Number:");
		passwordno=sc.nextInt();
		sql="select * from account where password="+passwordno;
		rs=st.executeQuery(sql);
		if(rs.next())
		{
			System.out.println("your account number:"+rs.getInt("accno"));
			
			System.out.println("Account HOLDER is: "+rs.getString("aname"));
			System.out.println("Balance amount is:"+rs.getInt("balance"));
			System.out.println("withdraw amount is:"+withdraw_amount);
			System.out.println("deposit amount is:"+deposit_amount);
		}
		else
		{
			System.out.println("INVALID PASSWORD NUMBER");
		}
		
	}
	public static void exit() throws SQLException {
		System.out.println("THANK YOU");
		
	}
	
	
	

	

}