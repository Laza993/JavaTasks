package reverSentence;


//	Write a program that returns words in reverse order 
//	for a given string (method argument). 
//	Words are considered to be groups of letters separated by an arbitrary number of blank characters 
//	or punctuation marks. The resulting string should contain punctuation marks so that the structure
//	of the sentence is maintained while several consecutive blank characters can be replaced by one.
//	The first word of a new sentence should start with a capital letter. All other words except the
//	first word of the input sentence should retain their initial form.

//	EXAMPLE:
//		Agree with you, the council does. Your apprentice, Skywalker will be.
//		Be will Skywalker, apprentice your. Does council the, you with agree.

public class ReverseSentence {

	public static void main(String args[]){
    	System.out.println("Agree with you, the council does. Your apprentice, Skywalker will be.");
    	System.out.println("###############");
    	System.out.println(reverse("Agree with you, the council does. Your apprentice, Skywalker will be."));
    }
    
	public static String reverse(String args) {
		StringBuilder strBuild = new StringBuilder();
		// split text with by dot
		String[] strinSentences = args.split("[.]");
		//reverse order of sentences
		for(int n = strinSentences.length-1; n >= 0; n--) {
//			split sentences by ","
			String[] partsofSent = (strinSentences[n].substring(0,1).toLowerCase() + strinSentences[n].substring(1)).split("[,]");
			String parts = "";
			for(int j = partsofSent.length-1; j >= 0; j--) {
				if(j != 0) {
					parts += reverseWords(partsofSent[j].strip())+ ", ";
				}else {
					parts += reverseWords(partsofSent[j].strip());
				}	
			}
			
//			build text from parts
//			First letter of sentence is set to upper case
			strBuild.append(parts.substring(0, 1).toUpperCase() + parts.substring(1) + ". ");
		}
		return strBuild.toString();
	}
	
	public static String reverseWords(String partsOfSent) {
		String newStr = "";
		
		String[] strings = partsOfSent.split(" ");
		
		for(int i = strings.length-1; i>=0; i--) {
			if(i != 0) {
				newStr += strings[i].strip() + " ";
			}else {
				newStr += strings[i].strip();
			}
		}
		return newStr;
	}

}
