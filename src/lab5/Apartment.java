package lab5;

public class Apartment extends Building implements CityProperty {
	private double monthlyFee;
	private int bedrooms;
	
	public Apartment(String address, double price, int sqM, double fee, int bed) {
		super(address, price, sqM);
		monthlyFee = fee;
		bedrooms = bed;
	}
	
	public int getBedrooms() {return bedrooms;}
	
	public double computePropertyTax() {
		return (10*squareMeters + 50*bedrooms);
	}
	public double maintenance() {
		return monthlyFee;
	}
	
	
}
