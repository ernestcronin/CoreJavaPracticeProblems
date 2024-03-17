package my.java.practice.javaCourse.Section2.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Generate a Stream<List<String>> using the Stream.of(Arrays.asList(“a”, “b”),
 * Arrays.asList(“a”, “c”)) method call. Filter the stream so that only list’s
 * that contain “c” make it through the filter. Flatten the Stream<List<String>>
 * to a Stream<String> using the flatMap() operation. Note that flapMap() states
 * in the API “Each mapped stream is closed after its contents have been placed
 * into this [new] stream.”. Use forEach() to output the new stream.
 */
public class Q2_1787 {

	public static void main(String[] args) {

		Stream<List<String>> streamList = Stream.of(
				Arrays.asList("a", "b"), 
				Arrays.asList("a", "c"));

		streamList.filter(list -> list.contains("c"))
		.peek(list -> System.out.println(list))
				.flatMap(list -> list.stream())
				.peek(list -> System.out.println(list))
				.forEach(System.out::print);
	}
}
