package lab5;

public class Cottage extends Building {
	private double electricity;
	
	public Cottage(String address, double price, int sqM, double el) {
		
		super(address, price, sqM);
		electricity = el;
	}
	

	public double maintenance() {
		return electricity;
	}
	
}
