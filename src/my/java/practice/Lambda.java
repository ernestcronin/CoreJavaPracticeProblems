package my.java.practice;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

interface Evaluate<T> {
	boolean isNegative(T t);
}

//They provide a clear and concise way to represent one method interface using an expression. 
//Lambda expressions also improve the Collection libraries making it easier to iterate through, filter, and 
//extract data from a Collection .

//You use a Predicate (javadoc) when you need a function that takes one argument and returns a boolean .
//use a Predicate in a situation where you want to filter a stream to remove elements that don't satisfy some logical
//condition, or find the first element that satisfies the condition

//BiPredicate is two parameters BiPredicate<T t, U u> test(T t, U u)

//Supplier is a functional interface to get the Type with one method get()

//Consumer takes in and returns nothing void accept(T t)

//Function<T1, T2> where T1 is input and T2 is output with native method apply()

//BiFunction has two inputs and 1 output

//UnaryOperator and BinaryOperator
//Unary is related to Function and Binary is Related to BiFunction
//Input and Output types must match. that is why only one type is needed

//Final or Effectively final. This concept deals with local variables that are used by lambda expressions.
//These variables cannot be changed because the lambda is using them and the compiler will show an error at 
//the method level. It does not matter if the variable is changed before or after. It cannot be done.

public class Lambda {

	public static <T> boolean check(T t, Predicate<T> predicate) {

		return predicate.test(t);
	}

	public static LocalTime getLocalTime() {

		Supplier<LocalTime> time = () -> LocalTime.now();
		return time.get();
	}

	public static void main(String[] args) {

		// A functional interface has only 1 method.
		// Lamda is used to implement 1 method
		// input is the method input.
		// -> seperates the code
		// input < 0 is method function
		Evaluate<Integer> lambda = input -> input < 0;
		// the expression is a line of code and can be written as such when more complex
		//Evaluate<Integer> lambda1 = input -> {
		//	return input < 0;
		//};

		// execute lamda definition above
		System.out.println(lambda.isNegative(-1));
		System.out.println(lambda.isNegative(1));

		// Predicate is pre-defined API
		// create the predicate then define it's lamdba expression
		// call test
		Predicate<String> predicate = input -> input != null;
		System.out.println(predicate.test(null));

		String name = "ernest";
		System.out.println(check(name, input -> "ernest".equalsIgnoreCase(name)));

		String str1 = "str1";
		String str2 = "str";
		BiPredicate<String, String> bipredicateCheck = (input1, input2) -> str1.contains(str2);
		System.out.println("bipred check " + bipredicateCheck.test(str1, str2));

		// define the supplier type and access with single func method get()
		Supplier<StringBuilder> builder = () -> new StringBuilder();
		System.out.println("builder " + builder.get().append("a string"));

		Supplier<List<Integer>> list = () -> Arrays.asList(1, 2, 3, 4);
		System.out.println("list size " + list.get().size());

		// created a supplier function to get localtime
		System.out.println(getLocalTime());

		// create the consumer and function
		// use list consumer method to print the names
		Consumer<String> print1 = s -> System.out.println(s);
		List<String> names = Arrays.asList("ernest", "sandy", "dylan");
		names.forEach(print1);

		// consumer's native method accept()
		print1.accept("a string");

		//biconsumer is great for maps
		var mapCities = new HashMap<String, String>();
		BiConsumer<String, String> map = (key, value) -> mapCities.put(key, value);
		map.accept("philly", "USA");
		map.accept("bismark", "USA");
		System.out.println(mapCities);

		//create the consumer and use the map objects native consumer method for each
		BiConsumer<String, String> print = (key, value) -> System.out
				.println("the city is " + key + " and the country is " + value);
		mapCities.forEach(print);
		
		Function<String, Integer> func1 = s-> s.length();
		System.out.println(func1.apply("a string"));
		
		BiFunction<String, String, String> func2 = (s1, s2) -> s1.concat(s2);
		System.out.println(func2.apply("ernest", "cronin"));
		
		Function<Integer, Double> func3 = val -> val.doubleValue();
		System.out.println(func3.apply(Integer.valueOf(5)));
		
		UnaryOperator<String> uni = s -> "my name is " + s;
		System.out.println(uni.apply("ernest"));
		
		BinaryOperator<Integer> bi = (val1, val2) -> val1 + val2;
		System.out.println("5 + 5 is " + bi.apply(5, 5));
		
		methodBound();
		
		unbound();
		
		constructorMethodRef();
	}
	
	public static void methodBound() {
		
		Consumer<String> c1 = s -> System.out.println(s);
		c1.accept("ernest");
		
		Consumer<String> c2 = System.out::println;
		c2.accept("bound method");
		
		Predicate<Integer> p1 = s -> s > 5;
		System.out.println(p1.test(6));
		
		String name ="mike";
		Predicate<String> p2 = name::startsWith;
		System.out.println(p2.test("mi"));
	}
	
	public static void unbound() {
		
		Function<String, String> upperL = s -> s.toUpperCase();
		//just defining it's type
		Function<String, String> lowerC = String::toLowerCase;
		
		System.out.println(lowerC.apply("ErnNESt"));
	}
	
	//Collections are considered static  for staticMethod
	public static void staticMethod() {
		
		Consumer<List<Integer>> c1 = s -> Collections.sort(s);
		List<Integer> l1 = Arrays.asList(2,3,6,7);
		c1.accept(l1);
		
		Consumer<List<Integer>> c2 = Collections::sort;
		List<Integer> l2 = Arrays.asList(2,3,6,7);
		c2.accept(l2);
			
	}
	
	//Supplier is very popular for this
	public static void constructorMethodRef() {
		
		Supplier<ArrayList<String>> s1 = () -> new ArrayList<String>();
		s1.get().add("a string");
		
		List<String> values = new ArrayList<String>(Arrays.asList("str1", "str2"));
		
		Supplier<ArrayList<String>> s2 = ArrayList<String>::new;
		ArrayList<String> list = s2.get();
		System.out.println("added collection " + list.addAll(values));
		s2.get().add("temp1");
		System.out.println("the size " + s2.get().size());
		
		list.forEach(s -> System.out.println(s));
		
	}
}
