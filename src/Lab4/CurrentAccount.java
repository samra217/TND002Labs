package lab4;

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
					
					currentTransaction = String.format("To savings account: %.1f with account number: %d", d, this.getAccountNumber());
					savingsTransaction = String.format("From current account: %.1fwith account number: %d",d,this.otherAccount.getAccountNumber());
			
					this.setBalance(this.getBalance()-d);
					this.otherAccount.setBalance(this.otherAccount.getBalance()+d);
					

				}
				else { //if current account don't have enough balance, 0 it add all to savings
					currentTransaction = String.format("To savings account: %.1fwith account number: %d", this.getBalance(),this.getAccountNumber());
					savingsTransaction = String.format("From current account: %.1fwith account number: %d",this.getBalance(),this.otherAccount.getAccountNumber());
					
					
					this.otherAccount.setBalance(this.otherAccount.getBalance()+this.getBalance());
					this.setBalance(0);

					
				}
				
			}
			else {
				if (this.otherAccount.getBalance() + d < 0) { //if saving account don't have enough balance, 0 it and add all to current
					savingsTransaction = String.format("To current account: %.1f with account number: %d", this.otherAccount.getBalance(), this.getAccountNumber());
					currentTransaction = String.format("From savings account: %.1f with account nu,ber:%d",this.otherAccount.getBalance(),this.otherAccount.getAccountNumber());
					
					
					this.setBalance(this.getBalance()+this.otherAccount.getBalance());
					this.otherAccount.setBalance(0.0);
					
				}
				else {
					this.setBalance(this.getBalance()-d);
					
					this.otherAccount.setBalance(this.otherAccount.getBalance()+d);
					
					savingsTransaction = String.format("To current account: %.1fwith account number: %d", -d,this.getAccountNumber());
					currentTransaction = String.format("From savings account: %.1fwith account number: %d",-d,this.otherAccount.getAccountNumber());
				}
				
			}
			this.transactions.add(currentTransaction);
			this.otherAccount.transactions.add(savingsTransaction);
		}
	}
	
	public void receive(String s, double amount) {
		
		this.setBalance(this.getBalance() + amount);
		if (s.equals("Cash payment")) {
			
			this.transactions.add(s + ": "+ amount+"\n");
		}
		
		else {
			this.transactions.add("Received from account of " + s + ": "+amount + "\n");
		}
	}
	
	
	public void send(double amount, CurrentAccount receiver) {
		receiver.receive(this.getCustomer(),amount);
		
		this.setBalance(this.getBalance() - amount);
		this.transactions.add("Sent to account of "+receiver.getCustomer()+ ": " +amount +"\n");
		
		
		
		if(this.getBalance()<0 && this.otherAccount != null && this.otherAccount instanceof SavingsAccount) {
			
			this.savings(this.getBalance());
				
		}
		if (this.getBalance()<0) {
			
			this.transactions.add("Covered by loan: " + Math.abs(this.getBalance()) +"\n");
			theBank.getLoan(this);
			this.setBalance(0.0);
		}
		
	}
	
	
	
	
}