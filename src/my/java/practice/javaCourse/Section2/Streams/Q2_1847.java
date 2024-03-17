package my.java.practice.javaCourse.Section2.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given the Book class (in the zip file), declare a List typed for Book with
 * the following Book’s: a. title=”Gone with the wind”, price=5.0 b. title=”Gone
 * with the wind”, price=10.0 c. title=”Atlas shrugged”, price=15.0 In a
 * pipeline which has no return type: (QID 2.1847)  stream the books  using
 * the collect() method, generate a Map that maps the book title to its price 
 * using forEach(), output the title and price of each entry in the map What
 * happened and why? Fix this by using the Collectors.toMap(Function, Function,
 * BinaryOperator) method.
 */

//Merge function is used to avoid KEY collisions
public class Q2_1847 {

	public static void main(String[] args) {

		Book book1 = new Book("Atlas Shrugged", 15.0);
		Book book2 = new Book("Gone with the Wind", 10.0);
		Book book3 = new Book("Gone with the Wind", 5.0);
		
		List<Book> books = Arrays.asList(book1, book2, book3);
		
		//Map<Double, String> bookMap = 
				books.stream()
				.collect(Collectors.toMap(book -> book.getPrice(), book -> book.getTitle()))
				.forEach((k, v) -> System.out.println("Price: " + k + " Title: " + v));
				
				 books.stream()
		        	.collect(Collectors.
		        			toMap(book -> book.getTitle(), book -> book.getPrice(), (key1, key2) -> key1 *key2))
		        	.forEach((k, v) -> System.out.println("Price: " + k + " Title: " + v));
		
		//System.out.println(bookMap);
		
		

	}
}
