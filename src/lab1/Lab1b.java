package lab1;

public class Lab1b {

	public static void main(String[] args) {
		System.out.println(Vector.vdef);
		
		Vector V1 = new Vector();
		System.out.println(V1);
		
		Vector.vdef = new Vector(1.0,2.0,3.0);
		V1.setToDefault();
		System.out.println(V1);
		

		
		
		
		Vector V2 = new Vector(1.0,1.0,2.0);
		System.out.println(V2);
		
		System.out.println("Length = " + V1.length());
		
		double[][] m1 =  {{1.0, 0.0, 0.0}, {0.0, 1.0, 0.0}, {0.0, 0.0,1.0}};
		
		System.out.println(V1.matrixMult(m1));
		
		double[][] m2 = {{1.0, 0.0}, {0.0, 1.0}};
		System.out.println(V1.matrixMult(m2));
		
		double[][] m3 =  {{0.0, 1.0, 0.0}, {1.0, 0.0, 0.0}, {0.0, 0.0,1.0}};
		System.out.println(V1.matrixMult(m3));
		
		System.out.println(Vector.plus(V1, V2));
		
		System.out.println(V1.minus(V2));
		
		System.out.println(V1.mult(2));
		
		System.out.println(V1.mult(V2));
		
		System.out.println(V1.compareTo(V2));
		
		V1.norm();
		V2.norm();
		
		System.out.println(V1.mult(V2));
		System.out.println(V2.mult(V2));
		
	}
	
}
