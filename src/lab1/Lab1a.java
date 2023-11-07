package lab1;

public class Lab1a {

	public static void main(String[] args) {
		double[] da1 = new double[3];
		da1[0] = 1.0;
		da1[1] = 2.0;
		da1[2] = 3.0; 
		System.out.println(da1);
		double[] da2 = {0.0, -0.5, -2.0};
		
		double[] sum  = addition(da1, da2);
		double[] diff = subtraction(da1, da2);
		
		printVector(sum);
		printVector(diff);
		
	}
	
	
	public static double[] addition(double[]arr1, double[] arr2) {
		double[] result = new double[3];
		
		for (int i = 0; i < arr1.length; i++) {
			result[i] = arr1[i] + arr2[i];
		}
		
		return result;
	}
	
	public static double[] subtraction(double[] arg1, double[] arg2) {
		double[] result = new double[3];
		for (int i = 0; i < arg1.length; i++) {
			result[i] = arg2[i] - arg1[i];
		}
		return result;
	}
	
	public static void printVector(double[] arg) {
		String output = "Vector = (" + arg[0] +","+ arg[1] + "," + arg[2]+")";
		System.out.println(output);
	}

}
