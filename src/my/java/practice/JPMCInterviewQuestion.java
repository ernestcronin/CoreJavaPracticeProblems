package my.java.practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JPMCInterviewQuestion {

	
	
	private static Set<String> set = new HashSet<>(Arrays.asList("java", "run", "time", "environment"));
	
	private static void isInDictionary(String input) {
		
		input = "javarun";
		
		
		for(int i=0; i<input.length(); i++) {
			
			char ch = input.charAt(i);
			
			for(String dict : set) {
				
				if(ch==dict.charAt(i)) {
					
				}
			}
		}
	}
	
}
