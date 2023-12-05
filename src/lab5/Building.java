package lab5;

public abstract class Building implements Comparable<Building>{
	private String address;
	private double price;
	protected int squareMeters;
	
	protected static int selection = 1;

	
	
	public Building(String address, double price, int sqM) {
		this.address = address;
		this.price = price;
		this.squareMeters = sqM;
	}
	
	
	public abstract double maintenance();
	
	public int compareTo(Building b) {
		return this.compareTo(b);
	}
	
	public String toString() {
		String returnString = String.format("Address: %16s Living area: %d Price: %8.2f Maintenance (per month): %5.2f", address, squareMeters, price, maintenance());
		if (this instanceof CityProperty) {
			returnString += "Property tax: " +  this.computePropertyTax();
		}
	}
	
}
