package lab1;
import java.util.*;


public class Vector {
	private double x;
	private double y;
	private double z;
	
	private double resultx;
	private double resulty;
	private double resultz;
	
	public static Vector vdef = new Vector(0.0, 0.0, 0.0);
	
	
	public Vector() {
		setToDefault();
	}
	
	public Vector(double d1, double d2, double d3) {
		this.x = d1;
		this.y = d2;
		this.z = d3;
	}
	
	public static void setToDefault(Vector V) {
		vdef.x = V.x;
		vdef.y = V.y;
		vdef.z = V.z;
		
	}
	
	public void setToDefault() {
		this.x = vdef.x;
		this.y = vdef.y;
		this.z = vdef.z;
	}
	
	public static Vector plus(Vector V1, Vector V2) {
		double resultx = V1.x + V2.x;
		double resulty = V1.y +V2.y;
		double resultz = V1.z + V2.z;
		Vector result = new Vector(resultx,resulty,resultz);
		return result;
		
	}
	
	public Vector minus(Vector V) {
		resultx = this.x - V.x;
		resulty =  this.y - V.y;
		resultz = this.z -V.z;
		return new Vector(resultx, resulty, resultz);
		
	}
	
	public Vector mult(double arg) {
		resultx = this.x*arg;
		resulty = this.y*arg;
		resultz = this.z*arg;
		return new Vector(resultx, resulty, resultz);
	
	}
	
	public double mult(Vector V) {
	
		double sum = 0.0;
		sum += this.x*V.x;
		sum += this.y*V.y;
		sum += this.z*V.z;
		return sum;
	}
	
	public double length() {
		resultx = Math.pow(this.x, 2);
		resulty = Math.pow(this.y, 2);
		resultz = Math.pow(this.z, 2);
		return Math.sqrt(resultx+resulty+resultz);
		
	}
	
	public Vector matrixMult(double[][] matrix) {
		if(matrix.length != 3) {
			return this;
		}
		for (double[] row : matrix) {
			if (row.length != 3) {
				return this;
			}
		}
		
		double[] vector = {this.x,this.y,this.z};
		
		resultx = 0.0;  
		resulty = 0.0; 
		resultz = 0.0;
		
		
		for (int row = 0; row < 3 ; ++row) {
			for (int column = 0; column < 3; ++column ) {
				if (row == 0) {
					 resultx +=  matrix[row][column]* vector[column];
				}
				if (row == 1) {
					resulty +=  matrix[row][column]* vector[column];
				}
				if (row == 2) {
					resultz +=  matrix[row][column]* vector[column];
				}
			}
		}
		
		return new Vector(resultx, resulty, resultz);
		
	}
	
	
	public void norm() {
		double length = this.length();
		this.x /= length;
		this.y /= length;
		this.z /= length;

	}
	
	public int compareTo(Vector V) {
		if (this.length() == V.length() ) {
			return 0;
		}
		
		if (this.length() > V.length()) {
			return 1;
		}
		return -1; 
		
	}
	
	public String toString() {
		//return "Vector = (" + this.x +","+ this.y + "," + this.z+")";
		return String.format("Vector = (%.1f, %.1f, %.1f)",this.x,this.y,this.z);
	
	}
}
