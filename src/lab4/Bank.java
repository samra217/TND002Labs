package lab4;
import java.util.ArrayList;


public class Bank {
	public String NAME;
	private ArrayList<Account> theAccounts = new ArrayList<Account>();
	private ArrayList<Loan> theLoans = new ArrayList<Loan>();
	
	
	
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
		
		CurrentAccount account = searchAccount(customerName);
		
		if (account == null) {
			return "person does not exist";
		}
		String returnString = customerName + "\n";
		if (account.getSavingsAccount() != null) {
			returnString += account.toString() + account.otherAccount.toString();
		}
		if (account.getSavingsAccount() == null){
			returnString += account.toString();
		} 
		
		
		for(Loan loan : theLoans) {
			if (loan.getCustomer().equals(customerName)) {
				returnString += loan.toString();
			}
		}
		return returnString;
	}
	
	
	public void transfer(String customer1, String customer2, double amount) {
		CurrentAccount CA1 = searchAccount(customer1);
		CurrentAccount CA2 = searchAccount(customer2);
		
		if (CA1 != null &&  CA2 != null) {
			CA1.send(amount, CA2);
		}
		
	}
	
	
	public void getLoan(CurrentAccount CA) {
		Loan CAloan = new Loan(CA);
		theLoans.add(CAloan);
	}
	
	
	public void cashPayment(String customer, double amount) {
		double debtLeft = amount;

		for (int i = 0; i < theLoans.size(); i++) {
			if (theLoans.get(i).getCustomer().equals(customer)) {
				

				debtLeft = theLoans.get(i).payOff(debtLeft);
				
				
				if(debtLeft > 0) {
					 //amount to pay to the next loan
					theLoans.remove(i);
					--i;
				}  else return;//if you don't have enough money to pay back more loans, stop the loop
			}
		}
		if (debtLeft > 0 ) {
			searchAccount(customer).receive("Cash payment", debtLeft);
			
		}
	}
	
	
	
	
	public void computeAnnualChange() {
		for (Account acc : theAccounts) {
			acc.annualChange();
		}
		for (Loan loan: theLoans) {
			loan.annualChange();
		}
	}
	
	public String toString() {
		double currentSum = 0.0;
		double savingsSum = 0.0;
		double loanSum = 0.0;
		
		for(Account ac : theAccounts) {
			if (ac instanceof SavingsAccount) {
				savingsSum += ac.getBalance();
			}
			if (ac instanceof CurrentAccount) {
				currentSum += ac.getBalance();
			}
		}
		for (Loan loan : theLoans) {
			loanSum += loan.getBalance();
		}
		
		
		String returnString = String.format("Bank: %s \nAccounts: %d\nLoans: %d \nMoney in current / savings accounts / loans: %.2f / %.2f / %.2f" , NAME, theAccounts.size(), theLoans.size(), currentSum, savingsSum, loanSum);
		
		
		
		return returnString;
	}
	
}