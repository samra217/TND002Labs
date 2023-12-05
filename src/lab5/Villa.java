package lab5;

public class Villa extends Building implements CityProperty {
	private double heating;
	private double electricty;
	private int bedrooms;
	
	public Villa(String address, double price, int sqM, double el, int bed, double heat) {
		super(address, price, sqM);
		electricty = el;
		bedrooms = bed;
		heating = heat;
	}
	
	public int getBedrooms() {
		return bedrooms;
	}
	
	public double maintenance() {
		return (electricty+heating);
	}
	
	public double computePropertyTax() {
		return (20*squareMeters + 100*bedrooms);
	}
	
}
