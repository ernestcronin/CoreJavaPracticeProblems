package my.java.practice.javaCourse.Section2.Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * Given the Book class (in the zip file), declare a List typed for Book with
 * the following Book’s: a. title=”Thinking in Java”, price=30.0 b. title=”Java
 * in 24 hrs”, price=20.0 c. title=”Java Recipes”, price=10.0 Stream the books
 * and calculate the average price of the books whose price is > 10. Change the
 * filter to books whose price is > 90. Ensure you do not get an exception.
 */

public class Q2_1809 {

	 public static void main(String[] args) {

		Book book1 = new Book("Thinking in Java", 30.0);
		Book book2 = new Book("Java in 24 hrs", 20.0);
		Book book3 = new Book("Java Recipes", 10.0);

		List<Book> books = Arrays.asList(book1, book2, book3);
		
		double val = books.stream().filter(book -> book.getPrice() > 10)		
				.mapToDouble(book -> book.getPrice())
				.average().orElse(Double.NaN);
		
		System.out.println("Average: " + val);
		
		double val2 = 
		books.stream().filter(book -> book.getPrice() > 10)
			.flatMapToDouble(book -> DoubleStream.of(
					Double.valueOf(book.getPrice())))
						.average().orElse(Double.NaN);
		
		System.out.println("Average val2: " + val2);
	}
}
