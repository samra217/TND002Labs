package lab1;

public class Vector {
	private double x;
	private double y;
	private double z;
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
		this.vdef[0] = 0.0;
		this.vdef[1] = 0.0;
		this.vdef[2] = 0.0;
	}
}
