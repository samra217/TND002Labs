package lab2;
import java.io.*;


public class Lab2 {

	private static BufferedReader consoleReader = new BufferedReader(new  InputStreamReader(System.in));
	
	
	
	public static void main(String[] args) throws IOException{

		Dictionary theDictionary = new Dictionary();
		
		
		
	
		
			String userInput;
			File userFile;
		 do{
			 System.out.println("Type filename: ");
			userInput = consoleReader.readLine();
			userFile = new File(userInput);
		}while (!userFile.exists());
		consoleReader.close();
		
		
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(userFile));
			String fileString = "";
			String inputString;
			while ((inputString = fileReader.readLine())!=null) {
				
				fileString += inputString + " ";
				
			} 
				
			fileReader.close();
			System.out.println(fileString);
			
			
			
			
			String trimmedString = fileString.trim().toLowerCase();
			String[] stringArr =  trimmedString.split(" +");
			

			for (String i : stringArr) {
				try {
					Double.parseDouble(i);
				} catch(final NumberFormatException irr) {
					System.out.println(theDictionary.addString(i));
				}
								
			}
			
			
		} catch(IOException ierr) {};

		


		
		System.out.println(theDictionary);
		
		System.out.println(theDictionary.sortList(Word.BYCOUNTS));
		
		System.out.println(theDictionary);
		
		System.out.println(theDictionary.sortList(Word.BYNAME));

		System.out.println(theDictionary);
		
		System.out.println(theDictionary.sortList(Word.ORIGINAL));
		
		System.out.println(theDictionary);

		File resultFile = new File("result.txt");
		resultFile.createNewFile();
		
		
		try {
			Writer fileWriter = new BufferedWriter(new FileWriter(resultFile));
			
			fileWriter.write(theDictionary.sortList(Word.ORIGINAL).toString());
			fileWriter.write("\n"+theDictionary.toString());
			
			fileWriter.flush();
			fileWriter.close();
		} catch(IOException irr) {};	
		
		
		
		
	}

}