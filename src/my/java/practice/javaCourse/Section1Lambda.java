package my.java.practice.javaCourse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Section1Lambda {

	/**
	 * 
	 * Section 1 test on Lab on lambdas and method reference
	 */
	
	@FunctionalInterface
	interface Printable<T>{
		
		void print(String s);
	}
	
	@FunctionalInterface
	interface Retrievable<T>{
		
		Integer get77();		
	}
	
	@FunctionalInterface
	interface Evaluate<T>{
		
		boolean isGreaterThanZero(Integer value);
	}
	
	
	public static <T> boolean check(T t, Predicate<T> predicate) {
		return predicate.test(t);
	}
	
	static class Person{
		
		//All of these implement Comparable
		private String name;
		private Integer age;
		private Double height;
		
		public Person(String name, Integer age, Double height) {
			super();
			this.name = name;
			this.age = age;
			this.height = height;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public Double getHeight() {
			return height;
		}
		public void setHeight(Double height) {
			this.height = height;
		}
		
		private void print() {
			StringBuilder sb = new StringBuilder();
			sb.append("Name: " + name);
			sb.append(" Age: " + age);
			sb.append(" Height: " + height);
			System.out.println(sb.toString());
		}
		
		private static List<Person> getPeople() {

			List<Person> result = new ArrayList<>();

			result.add(new Person("Mike", 33, 1.8));

			result.add(new Person("Mary", 25, 1.4));

			result.add(new Person("Alan", 34, 1.7));

			result.add(new Person("Zoe", 30, 1.5));

			return result;

		}
		
		/**]
		 * These functions work because String, Integer and Double implement Comparable natively
		 * @param people
		 */
		public static void sortAge(List<Person> people) {
			
			Comparator<Person> personComp = Comparator.comparing(Person -> Person.age);
			Collections.sort(people, personComp);
		}
		
		public static void sortName(List<Person> people) {
			
			Comparator<Person> personComp = Comparator.comparing(Person -> Person.name);
			Collections.sort(people, personComp);
		}
		
		public static void sortHeight(List<Person> people) {
			
			Comparator<Person> personComp = Comparator.comparing(Person -> Person.height);
			Collections.sort(people, personComp);
			
		}
	}

	@FunctionalInterface
	interface Functionable<T>{
		
		String append(Integer value);
	}
	
	
	public static void main(String[] args) {
		
		//1a
		//create Lamda expression
		Printable<String> printable = input ->  System.out.println(input);
		printable.print("Lambda Expression");
		
		//1b
		//create a consumer lambda		
		Consumer<String> consumer1 = s -> System.out.println(s);
		consumer1.accept("Lambda Expression");
		
		//1c
		//create consumer using method reference
		Consumer<String> consumer2 = System.out::println;
		consumer2.accept("Lambda Expression");
		
		
		//1a
		//create lambda expression
		Retrievable<Integer> retrievable =  () -> Integer.valueOf(77);
		System.out.println(retrievable.get77());
		
		//1b
		//return a supplier
		Supplier<Retrievable<Integer>> supplier1 = () -> retrievable;
		System.out.println(supplier1.get().get77());
		
		//1a
		//create lambda expression. Returns true n > 0. invoke twice.
		Evaluate<Integer> eval = input -> input > 0;
		System.out.println(eval.isGreaterThanZero(1));
		System.out.println(eval.isGreaterThanZero(-1));
		
		//1b
		//implement using the Predicate interface
		Predicate<Integer> pred1 = input -> input > 0;
		System.out.println(pred1.test(1));
		System.out.println(pred1.test(-1));
		
		//1c declar generic check() method. param1 is generic, param2 is a predicate T.
		//1c1 is number even
		System.out.println("Is ten even? " + check(10, input -> (input%2) == 0));
		System.out.println("Is five even? " + check(5, input -> (input%2) == 0));
		
		//1c2 string starts with Mr.?
		System.out.println("“Mr. Joe Bloggs start with Mr? " + check("Mr. Joe Bloggs", input -> input.startsWith("Mr.")));
		System.out.println("“Ms. Ann Bloggs start with Mr? " + check("Ms. Ann Bloggs", input -> input.startsWith("Mr.")));
		
		//1c3 is person >= age 18?
		Person mike = new Person("Mike", 33, 1.8);
		System.out.println("Is Mike older than or equal to 18? " + check(mike, input -> input.getAge() >= 18));
		
		Person ann = new Person("Ann", 13, 1.4);
		System.out.println("Is Ann older than 18? " + check(ann, input -> input.getAge() >=18));
		
		//1a implement Functionable interface and return appended string
		Functionable<String> f = input -> "Number is: " + input;
		System.out.println(f.append(25));
		
		//1b use the Function interface
		Function<Integer, String> func = input -> "Number is: " + input;
		System.out.println(func.apply(25));
		
		//1a invoke getPeople and store in variable name listPeople
		var listPeople = Person.getPeople();
		
		Person.sortAge(listPeople);
		listPeople.forEach(p -> System.out.println(p.name));
		
		Person.sortName(listPeople);
		listPeople.forEach(p -> System.out.println(p.name));
		
		Person.sortHeight(listPeople);
		listPeople.forEach(p -> System.out.println(p.height));
		
		Person.sortAge(listPeople);
		listPeople.forEach(Person::print);
		
	}
}
