package lab1;

public class Vector {
	private double x = 0.0;
	private double y = 0.0;
	private double z = 0.0;
	public double[] vdef = new double[3];
	
	public Vector() {
		setToDefault();
	}
	
	public Vector(double d1, double d2, double d3) {
		this.vdef[0] = d1;
		this.vdef[1] = d2;
		this.vdef[2] = d3;
	}
	
	public void setToDefault(double arg) {
		this.vdef[0] = arg;
		this.vdef[1] = arg;
		this.vdef[2] = arg;
	}
	
	public void setToDefault() {
		this.vdef[0] = x;
		this.vdef[1] = y;
		this.vdef[2] = z;
	}
}
