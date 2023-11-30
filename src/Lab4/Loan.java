package lab4;

public class Loan extends Account {
	public Loan(CurrentAccount CA) {
		super(CA);
	}
	
	
	public double payOff(double amount) {
		this.setBalance(this.getBalance() + amount);
		this.transactions.add("paid off: " + amount );
		
		
		return this.getBalance();
		
	}
}
