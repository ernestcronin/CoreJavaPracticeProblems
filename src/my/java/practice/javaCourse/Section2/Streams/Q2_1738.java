package my.java.practice.javaCourse.Section2.Streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Q2_1738 {

	public static void main(String[] args) {

		/**
		 * Using 1, 2 and 3 create a List of Integers. i. Stream the list and calculate
		 * the sum, using the sum() method from IntStream. ii. Stream the list again and
		 * calculate the maximum value, using the max() method from IntStream.
		 */
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		int sum = integers.stream()
				// when mapping to stream, use StreamType.of
				.flatMapToInt(num -> IntStream.of(Integer.valueOf(num)))
				.sum();

		//method practice. mapToInt is superfluous
		int sum2 = integers.stream().mapToInt(p -> p)
				.peek(System.out::println)
				.reduce((n1, n2) -> n1 + n2).orElse(Integer.MIN_VALUE);
		System.out.println("Sum2: " + sum2);
		
		int max = integers.stream().flatMapToInt(num -> IntStream.of(Integer.valueOf(num)))
				.max()
				.orElse(Integer.MIN_VALUE);
		
		System.out.println("Sum: " + sum + " Max: " + max);

		/**
		 * Given the Person class (in the zip file), declare a List typed for Person
		 * with the following Person’s: i. “Alan”, “Burke”, 22 ii. “Zoe”, “Peters”, 20
		 * iii. “Peter”, “Castle”, 29 Using the max(Comparator) from Stream, calculate
		 * the oldest person in the list.
		 */

		Person alan = new Person("Alan", "Burke", 22);
		Person zoe = new Person("Zoe", "Peters", 20);
		Person peter = new Person("Peter", "Castle", 29);

		List<Person> people = Arrays.asList(alan, zoe, peter);
		Person result = people.stream()
				.max(Comparator.comparing(Person -> Person.getAge()))
				.get();
		
		System.out.println(result);

		/**
		 * Using 10, 47, 33 and 23 create a List of Integers. Stream the list and using
		 * the following versions of reduce(), calculate the maximum value: i.
		 * Optional<T> reduce(BinaryOperator<T> accumulator) ii. T reduce(T identity,
		 * BinaryOperator<T> accumulator)
		 */
		
		List<Integer> list = Arrays.asList(10, 47, 33, 23);
		int noIdentity = list.stream()
				.reduce((n1, n2) -> n1 + n2).get();
		int identity = list.stream()
				.reduce(0, (n1, n2) -> n1 + n2);
		
		System.out.println("Binary accumulator values without and with identity param: " + noIdentity + ", " + identity);
	}
}
