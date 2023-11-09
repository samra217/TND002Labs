package lab2;

import java.util.ArrayList;


public class Dictionary {
	private ArrayList<Word> theList;
	private ArrayList<Word> backup = null;
	
	public Dictionary() {
		theList.add();
	}
	
	public String addString(String arg) {
	
		for (int i = 0; i < this.theList.size(); i++) {
			if (this.theList.get(i).getWord() == arg) {
				
				Word newWord = new Word(arg, this.theList.get(i).getCount()+1);
				
				this.theList.add(newWord);
				return newWord.toString();
			}
		}
		
		Word newWord = new Word(arg, 1);
		this.theList.add(newWord);
		return newWord.toString();
	}
}
