package simpleEncription;

public class Kata {
	public static void main(String[] args) {
		System.out.println(decrypt(encrypt("It works", 3), 3));
		
	}
	
	static StringBuilder builder = new StringBuilder();  
	
	  public static String encrypt(final String text, final int n) {
		if( text==null || text == "" || n <= 0) return text;
		
		builder.setLength(0);
	    	
	    for(int j = 1; j < text.length(); j+=2 ) {builder.append(text.charAt(j));}
	    for(int k = 0; k < text.length(); k+=2 ) {builder.append(text.charAt(k));}
	     
	    return encrypt(builder.toString(), n - 1);
	  }
	  
	  public static String decrypt(final String text, final int n) {
		  if(text == null || text == "" || n <= 0) return text;
		  builder.setLength(0);
		  
		  int mid = text.length()/2;
		  String firstHalf = text.substring(0, mid);
		  String secondHalf = text.substring(mid);
		  
		  if(firstHalf.length() == secondHalf.length()) {
			  for( int i =0; i < firstHalf.length(); i++) {
				  builder.append(secondHalf.charAt(i));
				  builder.append(firstHalf.charAt(i));
			  }
		  }else {
			  builder.append(secondHalf.charAt(0));
			  for( int i =0; i < firstHalf.length(); i++) {
				  builder.append(firstHalf.charAt(i));
				  builder.append(secondHalf.charAt(i+1));
			  }
		  }
		  return decrypt(builder.toString(), n-1);
	  }
}
