package lab1;

public class Vector {
	private double x = 0.0;
	private double y = 0.0;
	private double z = 0.0;
	public double[] vdef = {x,y,z};
	
	public Vector() {
		setToDefault();
	}
	
	public Vector(double d1, double d2, double d3) {
		x = d1;
		y = d2;
		z = d3;
	}
	
	public void setToDefault(double arg) {
		x = arg;
		y = arg;
		z = arg;
		
	}
	
	public void setToDefault() {
		x = 0.0;
		y = 0.0;
		z = 0.0;
	}
}
