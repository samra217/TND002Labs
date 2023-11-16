package lab2;


public class Word {
	
	public static final int ORIGINAL = 0;
	public static final int BYNAME = 1;
	public static final int BYCOUNTS = 2;
	
	private String theWord;
	private int count;
	private static int sortCriterion = ORIGINAL;
	
	
	private Word() {}
	
	public Word(String arg, int i) {
		this.theWord = arg;
		this.count = i;
	}
	
	public int getCount() {
		return this.count;
	}
	public String getWord() {
		return this.theWord;
	}
	
	public static void setCriterion(int arg) {
		sortCriterion = arg;
	}
	
	public int compareTo(Word arg) {
		   if (sortCriterion == ORIGINAL) {
		        return 2;
		    } else if (sortCriterion == BYNAME) {
		        if (this.theWord.compareTo(arg.theWord) <0 ) {
		        	return -1;
		        } else if (this.theWord.compareTo(arg.theWord) > 0) {
		        	return 1;
		        } else return 0;
		        
		        
		        
		    } else if (sortCriterion == BYCOUNTS) {
		        if (this.count < arg.count) {
		            return -1;
		        } else if (this.count > arg.count) {
		            return 1;
		        } else return 0; 
		        
		    }
		return 1;
	}
	
	
    public void swap(Word other) {
        String tempWord = this.theWord;
        int tempCount = this.count;

        this.theWord = other.theWord;
        this.count = other.count;

        other.theWord = tempWord;
        other.count = tempCount;
    }
	
	
	public String toString() {
		return String.format("Word:%10s   Count:%3d",this.theWord, this.count);
	}
}