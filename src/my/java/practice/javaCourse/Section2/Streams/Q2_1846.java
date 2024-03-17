package my.java.practice.javaCourse.Section2.Streams;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Given the Book class (in the zip file), declare a List typed for Book with
 * the following Book’s: a. title=”Atlas Shrugged”, price=10.0 b. title=”Freedom
 * at Midnight”, price=5.0 c. title=”Gone with the wind”, price=5.0 Stream the
 * books and instantiate a Map named ‘bookMap’ that maps the book title to its
 * price. To do this use the collect(Collectors.toMap(Function fnToGetKey,
 * Function fnToGetValue)). Iterate through ‘bookMap’ (using the Map
 * forEach(BiConsumer) method). The BiConsumer only outputs prices where the
 * title begins with “A”.
 */
public class Q2_1846 {

	public static void main(String[] args) {
		
		Book book1 = new Book("Atlas Shrugged", 10.0);
		Book book2 = new Book("Freedom at Midnight", 5.0);
		Book book3 = new Book("Gone with the Wind", 5.0);
		
		Map<String, Double> books = Stream.of(book1, book2, book3)
				.sorted(Comparator.comparing(book -> book.getTitle()))
				.peek(System.out::println)
				.collect(Collectors.toMap(book -> book.getTitle()
						, book -> book.getPrice()));
		
		System.out.println(books);
		
		// @see #toConcurrentMap(Function, Function, BinaryOperator, Supplier)
		//Don't think this is legal without a legitimate merge function
		TreeMap<String, Double> booksSorted = Stream.of(book1, book2, book3)
				.sorted(Comparator.comparing(book -> book.getTitle()))
				.peek(System.out::println)
				.collect(Collectors.toMap(book -> book.getTitle(),
						book -> book.getPrice(),
						(title1, title2) -> title1 + title2,
						() -> new TreeMap<>()));
		System.out.println(booksSorted);
				
	}
}
