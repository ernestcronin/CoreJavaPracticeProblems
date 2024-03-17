package my.java.practice.javaCourse.Section2.Streams;

import java.util.stream.Stream;

/**
 * 9. Given the Person class (in the zip file), declare a List typed for Person
 * with the following Person’s: a. name=”Bob”, age=31 b. name=”Paul”, age=32 c.
 * name=”John”, age=33 Pipeline the following where the return type is double:
 * (QID 2.1810)  stream the people  filter the stream for Person’s whose age
 * is < 30  map to int primitives  calculate the average age. This should
 * generate a NoSuchElementException. Using orElse(), fix the pipeline (not the
 * filter) so that 0.0 is returned instead of an exception being generated.
 */

//You need to remember mapping types
//.flatMapToInt(num -> IntStream.of(Integer.valueOf(num)))
//.mapToInt(p -> p)
public class Q2_1810 {

	public static void main(String[] args) {
		
		Person bob = new Person("Bob", null, 31);
		Person paul = new Person("Paul", null, 32);
		Person john = new Person("John", null, 33);
		
		double average = Stream.of(bob, paul, john)
			.filter(person -> person.getAge() < 30)
			.mapToInt(person -> person.getAge())
			.average().orElse(0);
		
		System.out.println("average: " + average);
	}
}
