package lab2;
import java.io.*;


public class Lab2 {

	static BufferedReader consoleReader = new BufferedReader(new  InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws IOException{

		Dictionary theDicionary = new Dictionary();
		System.out.println("Type filename: ");
		
		
		String userInput = consoleReader.readLine();
		String directoryPath = System.getProperty("user.dir");
		String filePath = directoryPath +"\\"+ userInput;
		
		File userFile = new File(filePath);
		
		while (!userFile.exists()) {
			System.out.println("Error: file name");
			userInput = consoleReader.readLine();
			filePath = directoryPath + userInput;
			userFile = new File(filePath);
		}
		
		FileReader fileReader = new FileReader(userFile);
		String fileString;
		while(userFile.canRead()) {
			fileString += 
		}
	

			

		
		
		
	}

}
