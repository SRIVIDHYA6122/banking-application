package com.edu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Display {
	static Connection scon=null;
	static ResultSet rs=null;
	static Statement st=null;
	static int passwordno,i,withdraw_amount,deposit_amount;
	static String sql;
	static int balance;
	static Scanner sc=new Scanner(System.in);

	public static void Account() {
		try
		{
			scon=Dbconnection.getConnection();
			st=scon.createStatement();
			
			String sql="select * from account";
			rs=st.executeQuery(sql);
			
			System.out.println("----------------------------------------------------------------------------------------------------------");
			System.out.println("accno\t\t\tpassword\taname\t\tphone\t\tmail\t\t\tbalance");
			System.out.println("----------------------------------------------------------------------------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t\t"+rs.getInt(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t\t"+rs.getInt(6));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
		
	}
		// TODO Auto-generated method stub
		
	}


