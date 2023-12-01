package lab4;

import java.util.ArrayList;


public class Account {

	private final double savingsInterest = 1.01;
	private final double loanInterest = 1.05;
	private final double currentInterest = -10;
	
	
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
	
	//The constructor for a loan account, that makes the current account its connected to, its "other account"
	public Account(CurrentAccount CA) {
		this.otherAccount = CA;
		this.balance = CA.getBalance();
		this.thisAccountNumber = CA.getAccountNumber();
		this.customer = CA.getCustomer();
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
	
	public void annualChange() {
		if (this instanceof SavingsAccount) {
			this.setBalance(this.getBalance()*savingsInterest);
		}
		if (this instanceof Loan) {
			this.setBalance(this.getBalance()*loanInterest);
		}
		
		if (this instanceof CurrentAccount && this.getBalance()+currentInterest >= 0) {
			this.setBalance(getBalance()+currentInterest);
			if (this.getBalance() < 0) {
				theBank.getLoan((CurrentAccount) this);
			}
		}
		
		
	}
	
	
	public String toString () {
		String accountType = "";
		
		if (this instanceof SavingsAccount) {
			accountType = "Savings account";
			
		}
		if (this instanceof CurrentAccount) {
			accountType = "Current account"; 
		}
		if (this instanceof Loan) {
			accountType = "Loan";
		}

		
		
		String returnString = String.format("%s Balance: %.1f\n",accountType,  this.balance);
		for	(String acnt : transactions) {
			returnString += acnt + "\n";
		}
		
		return returnString;
	}
	
}