package banking;
import java.io.*;
import java.util.*;

class AmountInvelid extends Exception
{
	String s="Amount is less then 0 or 0 is not allowed";
	AmountInvelid()
	{
		System.out.println(s);
	}
}
class User
{
	private String name;
	private long accountno;
	private int amount=0;
	Scanner s=new Scanner(System.in);
	
	
	public void uName()
	{
		System.out.println("Enter the Name");
		name=s.nextLine();
		
		
	}
	
	public void accont()
	{
		System.out.println("Enter the Account Number");
		this.accountno=s.nextLong();
	}
	
	public void amount()
	{
		try
		{
		System.out.println("Enter the Amount To deposite");
	     amount=s.nextInt();
	     if(amount <= 0)
	     {
	    	 throw new AmountInvelid();
	     }
	    Bank.balance=amount;
	    
	    
		}
		catch(AmountInvelid e1)
		{
			
		}
	}
	
	public void getAccountNo()
	{
		System.out.println("Your Account No is " + accountno);
	}
	
	public void getName()
	{
		System.out.println("Your name is " + name);
	}
	
}

class Transaction
{
	
	Bank b=new Bank();
	Scanner s=new Scanner(System.in);
	String tran;
	
	
	public void  doTransaction()
	{
		System.out.println("Enter the Transaction Deposite or Withdrawal");
		tran=s.nextLine();
			if(tran.contains("deposite"))
			{
			
			b.deposite();
			
			
			}
			
			
			else if(tran.contains("withdrawal"))
			{
			b.withdrawal();
			
			}
		
	}
	
	public void totalBalance()
	{
		System.out.println("Total balance " +  b.balance);
	}
	
	
	
}

class Bank
{
	public static int balance;
	
	Scanner s=new Scanner(System.in);
	static int deptran;
	static int withtran;
	static int count;
	 static  String [] s1=new String[5];
	public void  deposite()
	{
		System.out.println("Enter the amount to deposite");
		deptran=s.nextInt();
		Bank.balance=  Bank.balance + deptran;
		s1[count++]="Deposited amount is "+Integer.toString(deptran) ;
	}
	
	
	
	public void  withdrawal ()
	{
		System.out.println("Enter the Withdrawal amount");
		 withtran=s.nextInt();
		if(withtran<Bank.balance)
		{
		if(Bank.balance>Bank.balance/100*10)
		{
			
			Bank.balance=Bank.balance-withtran;
		
			s1[count++]="Withdrawal amount is "  + Integer.toString(withtran);
			
		}
		
		else 
		{
			System.out.println("Balance Less then 10% is not allowed");
		}
		}
		else
		{
			System.out.println("Withdrawal is not possible ");
		}
	}
	
	public void getTotalAmount()
	{
		System.out.println(Bank.balance);
	}
	
	public void getLastFiveTransaction()
	{
		for(String str:s1)
		{	
			if(str != null) {
				System.out.println(str);
			}
			
		}
		System.out.println();
	}
	
}
public class Main
{

	public static void main(String args[])
	{
		User u1=new User();
		Transaction t1=new Transaction();
		Bank b1=new Bank();
		Scanner s=new Scanner(System.in);
		
		boolean b=true;
		
		u1.uName();
		u1.accont();
		
		
		u1.amount();
		l1:
		while(b)
		{
		
		
		
		t1.doTransaction();
		
		System.out.println("If You Want to Do Again TransacatioN Then Type Yes/No");
		String str=s.nextLine();
		if(str.contains("Yes") || str.contains("yes"))
		{
			continue l1;
		}
		
		else
		{
			b=false;
			break;
		}
		}
		
		
 
		b1.getLastFiveTransaction();
		
		
	
		
		do {
			System.out.println("1) press 1 to Get ToTal Amount");
			System.out.println("2) Press 2 for getting History");
			System.out.println("3) Press 3 for getting UserDetails");
			System.out.println("4) press 4 for Exit ");
			int i=s.nextInt();
			switch(i)
			{
			case 1:
				b1.getTotalAmount();
				break;
			
			case 2:
				b1.getLastFiveTransaction();
				break;
			
			case 3:
			 u1.getAccountNo();
			 u1.getName();
			 break;
			 
			case 4:
				System.out.println("Thanks for using our Banking Application");
				System.exit(0);
			}
			
		}while(true);
		
		
	
		
		
	}
	
	
}
