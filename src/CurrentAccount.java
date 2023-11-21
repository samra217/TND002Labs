package lab3;

public class CurrentAccount extends Account {
	
	public CurrentAccount(String s, double d) {
		super(s,d);
	}
	
	public CurrentAccount(String s, double d1, double d2) {
		super(s,d1,d2);
	}
	
	public void savings(double d) {
		
		String currentTransaction = "";
		String savingsTransaction = "";
		if (this.otherAccount instanceof SavingsAccount) {
			if (d > 0) {
				if (this.getBalance() - d >= 0) {
					
					currentTransaction = String.format("To savings account: %.1f", d);
					savingsTransaction = String.format("From current account: %.1f",d);
			
					this.setBalance(this.getBalance()-d);
					this.otherAccount.setBalance(this.otherAccount.getBalance()+d);
					

				}
				else { //if current account don't have enough balance, 0 it add all to savings
					currentTransaction = String.format("To savings account: %.1f", this.getBalance());
					savingsTransaction = String.format("From current account: %.1f",this.getBalance());
					
					
					this.otherAccount.setBalance(this.otherAccount.getBalance()+this.getBalance());
					this.setBalance(0);

					
				}
				
			}
			
			
			if (d <= 0) {
				if (this.otherAccount.getBalance()-d >= 0) {
					this.setBalance(this.getBalance()+d);
				
					this.otherAccount.setBalance(this.otherAccount.getBalance()-d);
					
					savingsTransaction = String.format("To current account: %.1f", d);
					currentTransaction = String.format("From savings account: %.1f",d);
					
				}
				else { //if saving account don't have enough balance, 0 it and add all to current
					savingsTransaction = String.format("To current account: %.1f", this.otherAccount.getBalance());
					currentTransaction = String.format("From savings account: %.1f",this.otherAccount.getBalance());
					
					
					this.setBalance(this.getBalance()+this.otherAccount.getBalance());
					this.otherAccount.setBalance(0);
				}
				
			}
			this.transactions.add(currentTransaction);
			this.otherAccount.transactions.add(savingsTransaction);
		}
	}
	
}
