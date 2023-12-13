package lab6;
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
	}
}
