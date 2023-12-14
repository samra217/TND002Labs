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
				if (name.equals(p.getSurName()) || Integer.parseInt(name)== p.getPhoneNumber()); {
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
		System.out.println(splitName.length);
		if (splitName.length != 2 || numberFound) {
			return false;
		}
		
		Person newPerson = new Person(splitName[0],splitName[1], number);
		listOfNumbers.add(newPerson);
		
		return true;
		
	}
	
	public String load(String file) {

        try {
        	File phoneBook = new File(file);
        	
            BufferedReader fileReader = new BufferedReader(new FileReader(phoneBook));

            String lineString;
            String[] instOfPerson;
            int PhoneNum;

            while ((lineString = fileReader.readLine())!=null) {
                instOfPerson = lineString.split(" +");

                PhoneNum = Integer.parseInt(instOfPerson[2]);

                listOfNumbers.add(new Person(instOfPerson[0], instOfPerson[1], PhoneNum));

            }

            fileReader.close();


            return "Phone book loaded";
        } catch(IOException ierr) {
        	return "Try again";
        	}
        

    }
	
	
	public String deletePerson(String name, int phoneNum) {
        for (Person per : listOfNumbers) {
            if (per.getFullName().equals(name) && per.getPhoneNumber() == phoneNum) {
                listOfNumbers.remove(listOfNumbers.indexOf(per));
                return "Person deleted";
            }
        }
        return "The person/number does not exist";
    }
	
	public String save(String file) {

        File userFile = new File(file);

        try {
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(userFile));

            for (Person per : listOfNumbers) {

                fileWriter.write(String.format("%-20s %-5d\n", per.getFullName(), per.getPhoneNumber()));
            }

            fileWriter.flush();
            fileWriter.close();

            return "Saved " + listOfNumbers.size() + " people to the file";

        } catch (IOException ierr) {}

        return "Could not save to the file";
    }

}
