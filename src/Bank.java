package lab3;
import java.util.ArrayList;
import java.util.Formatter.*;

public class Bank {
	public String NAME;
	private ArrayList<Account> theAccounts = new ArrayList<Account>();

	
	public Bank(String name) {
		this.NAME = name;
		Account.setBank(this);
	}
	
	
	public CurrentAccount searchAccount(String customer) {
		
		for (Account a : theAccounts) {

			if (a.getCustomer().equals(customer) && (a instanceof CurrentAccount)) {

				return (CurrentAccount) a;
			}
		}
	
		return null;
	}
	
	public String createAccount(String customerName, double currentBalance, double savingsBalance) {
		if (searchAccount(customerName) == null) {
			Account newAccount = new CurrentAccount(customerName, currentBalance, savingsBalance);
			theAccounts.add(newAccount);
			theAccounts.add(newAccount.otherAccount);
			
			return "Current and savings account created for: " + customerName;
			
		}
		
		return "Account(s) already exists for: " + customerName;
	}
	
	public String createAccount(String customerName, double currentBalance ) {
		if (searchAccount(customerName) == null) {
			theAccounts.add(new CurrentAccount(customerName, currentBalance));
			return "Current account created for: " + customerName;
		}
		else return "Account already exists for: " + customerName;
	}
	
	public void currentToSavings(String customerName, double transferAmount) {
		CurrentAccount currentAccount = searchAccount(customerName);
		if (currentAccount != null) {
			currentAccount.savings(transferAmount);
		}
		
	}
	
	public String checkPerson(String customerName) {
		
		if (searchAccount(customerName) == null) {
			return "person does not exist";
		}
		String returnString = customerName + "\n";
		if (searchAccount(customerName).getSavingsAccount() != null) {
			returnString += searchAccount(customerName).toString() + searchAccount(customerName).otherAccount;
		}
		else {
			returnString += searchAccount(customerName).toString();
		}
		
		return returnString;
	}
	
	
	public String toString() {
		double currentSum = 0.0;
		double savingsSum = 0.0;
		
		for(Account ac : theAccounts) {
			if (ac instanceof SavingsAccount) {
				savingsSum += ac.getBalance();
			}
			if (ac instanceof CurrentAccount) {
				currentSum += ac.getBalance();
			}
		}
		
		
		String returnString = String.format("Bank: %s \nAccounts: %d \nMoney in current / savings accounts: %.2f / %.2f", NAME, theAccounts.size(), currentSum, savingsSum);
		
		
		
		return returnString;
	}
	
}
