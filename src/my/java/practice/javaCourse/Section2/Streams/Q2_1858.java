package my.java.practice.javaCourse.Section2.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Given the AnotherBook class (in the zip file), declare a List typed for
 * AnotherBook namely ‘books’ with the following AnotherBook’s: a. title=”Gone
 * with the wind”, genre=”Fiction” (QID 2.1858) b. title=”Bourne Ultimatum”,
 * genre=”Thriller” c. title=”The Client”, genre=”Thriller” Declare the
 * following: List<String> genreList = new ArrayList<>(); Stream books so that
 * genreList refers to a List containing the genres of the books in the books
 * List.
 */
public class Q2_1858 {

	public static void main(String[] args) {
		
		AnotherBook book1 = new AnotherBook("Gone with the Wind", "Fiction");
		AnotherBook book2 = new AnotherBook("Bourne Ultimatum", "Thriller");
		AnotherBook book3 = new AnotherBook("The Client", "Thriller");
		
		List<String> genreList = new ArrayList<>();
		Stream.of(book1, book2, book3).forEach(book -> genreList.add(book.getGenre()));
		System.out.println(genreList);
	}
}
