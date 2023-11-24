package lab3;

import java.util.ArrayList;

public class Account {

	private static int accountNumbers = 1;
	private String customer;
	private int thisAccountNumber;
	private double balance;
	
	protected static Bank theBank;
	protected Account otherAccount;
	protected ArrayList<String> transactions = new ArrayList<String>();
	
	public Account (String s, double d) {
		this.customer = s;
		this.balance = d;
		this.thisAccountNumber = accountNumbers;
		++accountNumbers;
	}
	
	public Account (String s, double d1, double d2) {
		this.customer = s;
		this.balance = d1;
		this.thisAccountNumber = accountNumbers;
		++accountNumbers;
		this.otherAccount = new SavingsAccount(s, d2);
		otherAccount.otherAccount = this;
		
	}
	
	public int getAccountNumber () {
		return this.thisAccountNumber;
	}
	
	public String getCustomer() {
		return this.customer;
	}
	
	public double getBalance () {
		return this.balance;
	}
	
	public void setBalance (double d) {
		this.balance = d;
	}
	
	public static void setBank (Bank b) {
		theBank = b;
	}
	
	public SavingsAccount getSavingsAccount () {
		if(this.otherAccount instanceof SavingsAccount) {
				return (SavingsAccount) this.otherAccount;
			}
		else return null;
		
		
	}
	
	public String toString () {
		String accountType = "";
		
		if (this instanceof SavingsAccount) {
			accountType = "Savings account";
			
		} else accountType = "Current account"; 

		
		
		String returnString = String.format("%s with account number: %s Balance: %.1f\n",accountType, this.thisAccountNumber, this.balance);
		for	(String acnt : transactions) {
			returnString += acnt + "\n";
		}
		
		return returnString;
	}
	
}
