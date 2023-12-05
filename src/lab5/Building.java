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
		if (selection == 1) {
			return (price == b.price) ? 0 : (price < b.price) ? -1 : 1;
		}
		if (selection == 2) {
			return (squareMeters == b.squareMeters) ? 0: (squareMeters < b.squareMeters) ? -1  : 1;
		}
		return 2;
		
	}
	
	public String toString() {
		String returnString = String.format("Address: %16s Living area: %d Price: %8.2f Maintenance (per month): %5.2f\n", address, squareMeters, price, maintenance());
		if (this instanceof CityProperty) {
			returnString += "Property tax: " + ((CityProperty)this).computePropertyTax()+"\n";
		}
		else returnString +="\n";
		return returnString;
	}
	
}
