package lab2;

import java.util.ArrayList;


public class Dictionary {
	private ArrayList<Word> theList;
	private ArrayList<Word> backup = null;
	
	public Dictionary() {
		
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
	
	private static void swap(Word w1, Word w2) {
		Word placement = w1;
		w1 = w2;
		w2 = placement;
	}
	
	
	public String sortList(int arg) {
		if (backup == null) {
			backup = theList;
		}
		if (arg == Word.ORIGINAL) {
			theList = backup;
			Word.setCriterion(arg);
			return "word list was reset";
		}
		if (arg == Word.BYCOUNTS) {
			Word.setCriterion(arg);
			for (int i = 0; i < theList.size(); i++) {
				for (int j = ++i; j < theList.size(); j++) {
					
					if (theList.get(i).compareTo(theList.get(j)) == -1) {
						swap(theList.get(i), theList.get(j));
					}
				}
			}
			
		}
		if (arg == Word.BYNAME) {
			Word.setCriterion(arg);
			
		}
			
	}
	public String toString() {
		String s = "Content: \n";
		for (Word w: theList) {
			s += w +"\n";
		}
		return s;
	}
	
}
