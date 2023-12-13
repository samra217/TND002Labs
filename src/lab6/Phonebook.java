package lab6;

import java.io.*;

import java.util.ArrayList;

public class Phonebook {
	private ArrayList<Person> listOfNumbers;
	
	public Phonebook() {

		listOfNumbers = new ArrayList<>();
	}
	
	
	
	public ArrayList<Person> search(String name){
		ArrayList<Person> listOfPeople = new ArrayList<>();
		
		for (Person p : listOfNumbers) {
			try {
				if (name == p.getSurName() || Integer.parseInt(name)== p.getPhoneNumber()); {
					listOfPeople.add(p);
				}
			} catch (NumberFormatException ignore) {}
			
		}
		
		return listOfPeople;
	}
	
	
	public boolean addPerson(String name, int number) {
		String[] splitName = name.split(" ");
		
		boolean numberFound = false;
		
		for (Person p : listOfNumbers) {
			if (p.getPhoneNumber() == number) {
				numberFound = true;
			}
		}
		
		if (splitName.length != 2 || numberFound == true) {
			return false;
		}
		
		Person newPerson = new Person(splitName[0],splitName[1], number);
		listOfNumbers.add(newPerson);
		return true;

		listOfNumbers = new ArrayList<Person>();
		
	}
	
	public String load(String file) {
		File phoneBook = new File(file);
		
		if (!phoneBook.exists()) {
			return "File does not exist";
		}
		
		try {
			BufferedReader fileReader = new BufferedReader(new FileReader(phoneBook));
			
			String lineString;
			String[] instOfPerson;
			int PhoneNum;
			
			while ((lineString = fileReader.readLine())!=null) {
				instOfPerson = lineString.split(" +");
				
				PhoneNum = Integer.parseInt(lineString[2]);
				
				listOfNumbers.add(new Person(lineString[0], lineString[1], PhoneNum));
			
			}
			
			fileReader.close();
			
			
			return "Phone book loaded";
		} catch(IOException ierr) {};
		
		return "Try again";

	}
	
	
	public String deletePerson(String name, int phoneNum) {
		for (Person per : listOfNumbers) {
			if (per.getFullName.equals(name) && per.getPhoneNumber()) {
				listOfNumbers.remove(per.indexOf());
				return "Person deleted";
			}
		}
		return "The person/number does not exist";
	}
	
	public String save(String file) {
		File userFile = new File(file);
		
		try {
			BufferedWriter fileWriter = new BufferedWriter(new FileWriter(userFile));
			
			for (Person per : listOfNumbers)
			
			return "Saved " + listOfNumbers.size() + " people to the file";
		} catch (IOException ierr) {}
		
		return "Could not save to the file";

	}
}
