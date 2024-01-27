package my.java.practice;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
	 .	Any character (may or may not match line terminators)
	\d	A digit: [0-9]
	\D	A non-digit: [^0-9]
	\s	A whitespace character: [ \t\n\x0B\f\r]
	\S	A non-whitespace character: [^\s]
	\w	A word character: [a-zA-Z_0-9]
	\W	A non-word character: [^\w]
	
Boundary Matchers
	^	The beginning of a line
	$	The end of a line
	\b	A word boundary
	\B	A non-word boundary
	\A	The beginning of the input
	\G	The end of the previous match
	\Z	The end of the input but for the final terminator, if any
	\z	The end of the input
 */

public class RegexPractice {

	// Write a Java program to check whether a string contains only a certain set of
	// characters (in this case a-z, A-Z and 0-9).
	public static boolean hasOnlyWordChars(String str) {

		String pattern = "\\w*";
		boolean b = false;

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		b = m.matches();

		return b;
	}

	// Write a Java program that matches a string that has a p followed by zero or
	// more q's.
	public static boolean hasPFollowedByZeroOrMoreQs(String str) {

		String pattern = ".*[p]q*.*";

		boolean b = false;

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		b = m.matches();

		return b;
	}

	// Write a Java program to find sequences of lowercase letters joined by an
	// underscore.
	public static boolean hasLowerCaseJoinedByUnderScore(String str) {

		String pattern = ".*[a-z]+[_][a-z]+.*";

		boolean b = false;

		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		b = m.matches();

		return b;
	}
	
	//Write a Java program to enforce a password of 8-16 characters, 
	//with at least one uppercase, special char and number
	public static boolean hasSatisfactoryUserPassword(String str) {
			
		String upperCase = ".*[A-Z]+.*";
		String lowerCase = ".*[a-z]*.*";
		String number = ".*[0-9]+.*";
		String specialChar = ".*\\W+.*";
		
		String[] stringPatterns = { upperCase, lowerCase, number, specialChar};
		
		boolean b = true;
		
		if(str.length()<8 || str.length() > 16)
			return false;
		
		for(String pattern : stringPatterns) {
					
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(str);
			b = m.matches();
			if(!b)
				return b;
		}		
		return true;
	}

	public static void main(String[] args) {

		testHasSatisfactoryUserPassword();
	}
	
	private static void testHasSatisfactoryUserPassword() {
		
		String s1 = "G012!@#$($56_)";
		String s2 = "aaaaaaa!1";
		String s3 = "aaaaaaaA1";
		String s4 = "aaaaaaaA!";
		String s5 = "aaaaaaaA1!";
		
		System.out.println(hasSatisfactoryUserPassword(s1));
		System.out.println(hasSatisfactoryUserPassword(s2));
		System.out.println(hasSatisfactoryUserPassword(s3));
		System.out.println(hasSatisfactoryUserPassword(s4));
		System.out.println(hasSatisfactoryUserPassword(s5));
	}
	
	private static void testHasLowerCaseJoinedByUnderScore() {
		
		String s1 = "a_a";
		String s2 = "a_";
		String s3 = "_dd";
		String s4 = "abd_bec";
		String s5 = "abd_bec_";

		System.out.println(hasLowerCaseJoinedByUnderScore(s1));
		System.out.println(hasLowerCaseJoinedByUnderScore(s2));
		System.out.println(hasLowerCaseJoinedByUnderScore(s3));
		System.out.println(hasLowerCaseJoinedByUnderScore(s4));
		System.out.println(hasLowerCaseJoinedByUnderScore(s5));
	}
	
	private static void testHasPFollowedByZeroOrMoreQs() {
		
		String s1 = "abcDE13a5555ddajg";
		String s2 = "p";
		String s3 = "pq";
		String s4 = "aaapqaap";
		String s5 = "!qp!";
		
		System.out.println(hasPFollowedByZeroOrMoreQs(s1));
		System.out.println(hasPFollowedByZeroOrMoreQs(s2));
		System.out.println(hasPFollowedByZeroOrMoreQs(s3));
		System.out.println(hasPFollowedByZeroOrMoreQs(s4));
		System.out.println(hasPFollowedByZeroOrMoreQs(s5));
	}

	private static void testhasOnlyWordChars() {
		
		String s1 = "abcDE13a5555ddajg";
		String s2 = "a!";
		String s3 = " ";
		String s4 = "a";
		String s5 = "D";

		System.out.println(hasOnlyWordChars(s1));
		System.out.println(hasOnlyWordChars(s2));
		System.out.println(hasOnlyWordChars(s3));
		System.out.println(hasOnlyWordChars(s4));
		System.out.println(hasOnlyWordChars(s5));
	}
}
