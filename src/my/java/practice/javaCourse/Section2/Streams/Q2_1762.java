package my.java.practice.javaCourse.Section2.Streams;


import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Given the Item class (in the zip file), declare a List typed for Item with
 * the following Item’s: a. id=1 name=”Screw” b. id=2 name=”Nail” c. id=3
 * name=”Bolt” 
 * Stream the list and sort it so that it outputs “BoltNailScrew”
 * i.e. alphabetic name order. Use Stream’s forEach method to output the names
 * (use the method reference version for the required Consumer lambda).
 */
public class Q2_1762 {

	
	
	public static void main(String[] args) {
		
		Item screw = new Item(1, "Screw");
		Item name = new Item(2, "Nail");
		Item bolt = new Item(3, "Bolt");
		
		Stream<Item> items = Stream.of(screw, name, bolt);
		items.sorted(Comparator.comparing(Item-> Item.getName()))
			.forEach(p -> System.out.print(p.getName()));
	}
}
