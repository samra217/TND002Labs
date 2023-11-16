package lab2;

import java.util.ArrayList;


public class Dictionary {
	private ArrayList<Word> theList;
	private ArrayList<Word> backup = null;
	
	public Dictionary() {
		theList = new ArrayList<Word>();
	}
	
	public String addString(String arg) {
		
		
        for (Word word : this.theList) {
            if (word.getWord().equals(arg)) {
				
				Word dupeWord = new Word(arg, word.getCount()+1);
				this.theList.set(this.theList.indexOf(word), dupeWord);
				return dupeWord.toString();
			}
		}
	
		Word newWord = new Word(arg, 1);
		this.theList.add(newWord);
		return newWord.toString();
	}
	




	
	public String sortList(int arg) {
		if (backup == null) {
			backup = new ArrayList<Word>();
			for (int i = 0; i<theList.size();i++) {
				backup.add(new Word(theList.get(i).getWord(), theList.get(i).getCount()));
			}
			
		}
		


		String returnString;
		switch(arg) {
		case Word.ORIGINAL:
			this.theList = this.backup;
			Word.setCriterion(arg);
			return "word list was reset";
			
		case Word.BYCOUNTS:
			Word.setCriterion(arg);
			returnString = "Sorted by counts";
			break;
		
		case Word.BYNAME:
			Word.setCriterion(arg);
			returnString = "Sorted alphabetically";
			break;
			
		default: 
			return "Sort criterion not known";
		}

		
		for (int i = 0; i < this.theList.size(); i++) {
			for (int j = i +1; j < this.theList.size(); j++) {
				
				if ((this.theList.get(i).compareTo(this.theList.get(j))) == -1) {
					this.theList.get(i).swap(this.theList.get(j));
				}
			}
		}
		return returnString;
		
			
	}
	public String toString() {
		String s = "Content: \n";
		for (Word w: theList) {
			s += w.toString() +"\n";
		}
		return s;
	}
}