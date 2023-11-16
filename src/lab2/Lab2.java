package lab2;
import java.io.*;


public class Lab2 {

	private static BufferedReader consoleReader = new BufferedReader(new  InputStreamReader(System.in));
	
	
	public static void main(String[] args) throws IOException{

		Dictionary theDictionary = new Dictionary();
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
		consoleReader.close();
		
		FileReader fileReader = new FileReader(userFile);
		String fileString = "";
		while(userFile.canRead()) {
			fileString += fileReader.read();
		}
		fileReader.close();
		
		
		String trimmedString = fileString.trim().toLowerCase();
		String[] stringArr =  trimmedString.split(trimmedString);
		
		for (String i : stringArr) {
			if (Integer.parseInt(i)) {
				theDictionary.addString(i);
				System.out.println(theDictionary.addString(i));
			}
		}
		
		System.out.println(theDictionary);
		
		System.out.println(theDictionary.sortList(Word.BYCOUNTS));
		
		System.out.println(theDictionary);
		
		System.out.println(theDictionary.sortList(Word.BYCOUNTS));

		System.out.println(theDictionary);
		
		System.out.println(theDictionary.sortList(Word.ORIGINAL));
		
		System.out.println(theDictionary);

		File resultFile = new File(filePath+"result.txt");
		resultFile.createNewFile();
		
		
		
	}

}
