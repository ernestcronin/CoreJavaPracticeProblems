package my.java.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuestionOne {

	 public static void staticMR() {
		 
		 List<Integer> list = Arrays.asList(1,2,7,4,5);
		 list.sort(Comparator.comparing(input -> input));
		 list.forEach(i -> System.out.println(i));
		 
		 int i =0;
		Object[] x = list.stream().toArray();
		 Arrays.sort(x);
		 
		 Arrays.stream(x).forEach(p -> System.out.print(p));
		 
		 list = Arrays.asList(1,2,7,4,5);
		 Comparator<Integer> comp = Comparator.comparing(input -> input);
		 Collections.sort(list, comp);
		 list.forEach(System.out::println);
	 }
		

	public static void main(String[] args) {

		staticMR();
	}
}
