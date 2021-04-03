package pascalCase;

import java.util.Arrays;
import java.util.regex.Pattern;

public class PascalCase {
	public static void main(String[] args) {
		System.out.println(toCamelCase("Text-Hello_World"));
	}

	
//	solution one
	static String toCamelCase(String text){
		StringBuilder builder = new StringBuilder();
		for(int i =0; i < text.length(); i++) {
			if(text.charAt(i) != '-' && text.charAt(i) != '_') {
				builder.append(text.charAt(i)) ;
			}else {
				i++;
				builder.append(Character.toUpperCase(text.charAt(i)));
			}
		}
		return builder.toString();
	  }
	
	
// solution two - taken from codeWars
	 static String toCamelCase1(String str){
		    String[] words = str.split("[-_]");
		    return Arrays.stream(words, 1, words.length)
		            .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
		            .reduce(words[0], String::concat);
		  }
//	solution three - taken from codeWars
	 static String toCamelCase2(String s){
		    return Pattern.compile("[-|_](.)").matcher(s).replaceAll(r -> r.group(1).toUpperCase());
		  }
}
