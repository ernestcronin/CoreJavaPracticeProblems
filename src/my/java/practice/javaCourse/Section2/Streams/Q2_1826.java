package my.java.practice.javaCourse.Section2.Streams;

import java.util.Optional;

public class Q2_1826 {

	/**
	 * Page 2 of 4 5. Code a method public static Optional<String> getGrade(int
	 * marks) (QID 2.1826) a. in the method getGrade: i. declare an empty optional,
	 * typed for String called grade ii. insert the following code: if (marks > 50)
	 * {grade = Optional.of(“PASS”);} else {grade.of(“FAIL”);}
	 * 
	 * @param mark
	 * @return
	 */
	public static Optional<String> getGrade(int mark) {

		Optional<String> grade = Optional.empty();
		if (mark > 50)
			grade = Optional.of("Pass");
		else
			grade = Optional.of("Fail");

		return grade;
	}

	/**
	 * in main(): i. declare an Optional, typed for String named grade1 which is
	 * initialised to the return value of calling getGrade(50) ii. declare an
	 * Optional, typed for String named grade2 which is initialised to the return
	 * value of calling getGrade(55) iii. using orElse() on grade1, output the value
	 * of grade1 or “UNKNOWN” iv. if(grade2.isPresent()) is true: use
	 * ifPresent(Consumer) to output the contents of grade2; if false, use orElse()
	 * to output the contents of grade2 or “Empty”
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Optional<String> grade1 = getGrade(50);
		Optional<String> grade2 = getGrade(55);
		Optional<String> grade3 = Optional.empty();
		
		System.out.println(grade1.orElse("UNKNOWN"));
		
		//anonymous implementation of Runnable interface
		grade2.ifPresentOrElse(System.out::println, () ->  System.out.println("Empty"));
		grade3.ifPresentOrElse(System.out::println, () ->  System.out.println("Empty"));
	}
}








