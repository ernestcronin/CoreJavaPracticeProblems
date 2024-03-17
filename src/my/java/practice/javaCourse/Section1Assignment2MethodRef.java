package my.java.practice.javaCourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Section1Assignment2MethodRef {

	/**
	 * a. in staticMR(), declare a List of integers with 1, 2, 7, 4, and 5 as
	 * values.
	 * 
	 * b. using a Consumer typed for List<Integer> and the Collections.sort static
	 * method, code a lambda that sorts the list passed in.
	 * 
	 * c. invoke the lambda.
	 * 
	 * d. prove that the sort worked.
	 * 
	 * e. re-initialise the list (so it is unsorted again).
	 * 
	 * f. code the method reference version.
	 * 
	 * i. sort() is overloaded : sort(List) and sort(List, Comparator)
	 * 
	 * ii. how does Java know which version to call?
	 * 
	 * g. invoke the method reference version.
	 * 
	 * h. prove that the sort worked.
	 */
	public static void staticMR() {

		List<Integer> list = Arrays.asList(1, 2, 7, 4, 5);
		list.sort(Comparator.comparing(input -> input)); // use lamda to sort
		list.forEach(i -> System.out.println(i)); // invoke lamda

		list = Arrays.asList(1, 2, 7, 4, 5);
		Comparator<Integer> comp = Comparator.comparing(input -> input);
		Collections.sort(list, comp); // comparator unnecessary since Integer implements Comparable
		Collections.sort(list);
		list.forEach(System.out::println); // method reference

		// for own amusement, convert back to array and sort.
		list = Arrays.asList(1, 2, 7, 4, 5);
		Object[] x = list.stream().toArray();
		Arrays.sort(x);
		Arrays.stream(x).forEach(System.out::println);
	}

	/**
	 * a. in boundMR(), declare a String variable called name and initialise it to
	 * “Mr. Joe Bloggs”.
	 * 
	 * b. using a Predicate typed for String, code a lambda that checks to see if
	 * name starts with the prefix passed in.
	 * 
	 * c. invoke the lambda passing in “Mr.” which should return true.
	 * 
	 * d. invoke the lambda passing in “Ms.” which should return false.
	 * 
	 * e. code the method reference version.
	 * 
	 * f. repeat c and d above except using the method reference version.
	 */
	public static void boundMR() {

		String str = "Mr. Joe Bloggs";
		Consumer<String> con = System.out::println; // consumer to print

		Predicate<String> check1 = input -> str.contains(input); // predicate with lamda

		boolean bool1 = check1.test("Mr.");
		con.accept(String.valueOf(bool1));

		boolean bool2 = check1.test("Mrs.");
		con.accept(String.valueOf(bool2));

		Predicate<String> check2 = str::contains; // predicate with method reference

		boolean bool3 = check2.test("Mr.");
		con.accept(String.valueOf(bool3));

		boolean bool4 = check2.test("Mrs.");
		con.accept(String.valueOf(bool4));
	}

	/**
	 * a. in unboundMR(), code a Predicate lambda typed for String that checks to
	 * see if the string passed in is empty.
	 * 
	 * b. invoke the lambda passing in “” (returns true).
	 * 
	 * c. invoke the lambda passing in “xyz” (returns false).
	 * 
	 * d. code the method reference version of the lambda from (a).
	 * 
	 * e. repeat b and c above except using the method reference version.
	 * 
	 * f. code a BiPredicate lambda typed for String and String:
	 * 
	 * i. the lambda takes in two parameters (hence “Bi”)
	 * 
	 * ii. check if the first parameter starts with the second parameter
	 * 
	 * iii. invoke the lambda twice:
	 * 
	 * 1. passing in “Mr. Joe Bloggs” and “Mr.” (returns true)
	 * 
	 * 2. passing in “Mr. Joe Bloggs” and “Ms.” (returns false)
	 * 
	 * g. code the method reference version of the lambda from (f).
	 * 
	 * h. test it as per above in (f.iii)
	 * 
	 * @param args
	 */

	public static void unboundMR() {
		Consumer<String> con = System.out::println; // consumer to print

		Predicate<String> check1 = input -> input.length() == 0; // predicate with lamda
		boolean bool1 = check1.test("");
		con.accept(String.valueOf(bool1));

		boolean bool2 = check1.test("xyz");
		con.accept(String.valueOf(bool2));

		Predicate<String> check2 = String::isEmpty;
		boolean bool11 = check2.test("");
		con.accept(String.valueOf(bool11));

		boolean bool22 = check2.test("xyz");
		con.accept(String.valueOf(bool22));

		BiPredicate<String, String> check3 = (input1, input2) -> input1.startsWith(input2);
		boolean bool3 = check3.test("Mr Joe Bloggs", "Mr");
		con.accept(String.valueOf(bool3));

		boolean bool4 = check3.test("Mr Joe Bloggs", "Mrs");
		con.accept(String.valueOf(bool4));

		BiPredicate<String, String> check4 = String::startsWith;
		boolean bool5 = check4.test("Mr Joe Bloggs", "Mr");
		con.accept(String.valueOf(bool5));

		boolean bool6 = check4.test("Mr Joe Bloggs", "Mrs");
		con.accept(String.valueOf(bool6));

	}

	/**
	 * a. in constructorMR(), code a Supplier typed for List<String> that returns a
	 * new ArrayList.
	 * 
	 * b. invoke the lambda to create a new List<String> named list.
	 * 
	 * c. add “Lambda” to the list.
	 * 
	 * d. output the list to show it worked.
	 * 
	 * e. code the method reference version of the lambda:
	 * 
	 * i. re-initialise list by invoking the method reference version.
	 * 
	 * ii. add “Method Reference” to the list.
	 * 
	 * iii. output the list to show it worked.
	 * 
	 * f. next, we want to use the overloaded ArrayList constructor passing in 10 as
	 * the initial capacity (note: the default constructor assumes a capacity of
	 * 10).
	 * 
	 * i. thus, we need to pass IN something and get back OUT something:
	 * 
	 * 1. IN: 10 OUT: ArrayList
	 * 
	 * ii. we need a Function typed for Integer and List<String> for this.
	 * 
	 * iii. code the lambda.
	 * 
	 * iv. re-initialise the list by invoking the lambda passing in 10 as the
	 * capacity.
	 * 
	 * v. add “Lambda” to the list.
	 * 
	 * vi. output the list to show it worked.
	 * 
	 * g. code the method reference version.
	 * 
	 * i. note that the method reference version is the exact same as above in e!!
	 * 
	 * ii. this is where context is all important:
	 * 
	 * 1. the first method reference was for a Supplier and Supplier’s functional
	 * method is T get() and thus, Java knew to look for the ArrayList constructor
	 * that takes in NO argument
	 * 
	 * 2. the first method reference was for a Function and Function’s functional
	 * method is R apply(T t) and thus, Java knew to look for the ArrayList
	 * constructor that takes in ONE argument.
	 * 
	 * @param args
	 */
	
	public static void constructorMR() {
		
		Supplier<List<String>> sup1 = () ->  //lambda version
		new ArrayList<>();
		
		List<String> list1 = sup1.get();
		list1.add("Lambda");
		System.out.println(list1);
		
		Supplier<List<String>> sup2 = ArrayList::new;
		List<String> list2 = sup2.get();
		list2.add("Method Reference");
		System.out.println(list2);
		
		Function<Integer, ArrayList<String>> func1 = input -> 
			 new ArrayList<>(input);
			 
		List<String> list3 = func1.apply(10);
		list3.add("Function1");
		System.out.println(list3);
		
		Function<Integer, ArrayList<String>> func2 = ArrayList::new;
		List<String> list4 = func2.apply(10);
		list4.add("Function2");
		System.out.println(list4);
	}

	public static void main(String[] args) {

		// staticMR();
		// boundMR();
		unboundMR();
		constructorMR();
	}
}
