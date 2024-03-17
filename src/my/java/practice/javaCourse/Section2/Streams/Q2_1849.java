package my.java.practice.javaCourse.Section2.Streams;

import java.util.Optional;

/**
 * 10. A question about Optional. Let us look at this in parts: 
 * a. 
 * Declare an Optional, typed for Double, named ‘price’ using the
 * Optional.ofNullable(20.0). Output the Optional value for ‘price’ 3 times:
 * using ifPresent(Consumer), orElse(T) and orElseGet(Supplier).
 * 
 * b.
 * declare a new Optional, typed for Double, named ‘price2’ (or comment out (a)
 * and re-use ‘price’). Use Optional.ofNullable again but this time, pass in
 * null. i. Output ‘price2’ in a normal System.out.println(). ii. check to see
 * if price2 isEmpty() and if so output “empty”. iii. do (ii) again except this
 * time use the more functional “ifPresent(Consumer)” method. iv. initialise a
 * Double x to the return of “price2.orElse(44.0)”. Output and observe the value
 * of x. 
 *
 * c. 
 * declare a new Optional, typed for Double, named ‘price3’ (or comment
 * out (b) and re-use ‘price’). Use Optional.ofNullable passing in null. i.
 * initialise a Double z to the return of “price3.orElseThrow(() -> new
 * RuntimeException(“Bad Code”). Output and observe the value of z.
 */
public class Q2_1849 {

	public static void main(String[] args) {
		
		Optional<Double> price = Optional.ofNullable(null);
		price.ifPresent(System.out::println);
		System.out.println(price.orElse(20.0));
		System.out.println(price.orElseGet(() -> 20.0));
		
		Optional<Double> price2 = Optional.ofNullable(null);
		System.out.println(price2);
		if(price2.isEmpty())	
			System.out.println("empty");
		price2.ifPresent(System.out::println);
		double x = price2.orElse(44.4);
		System.out.println(x);
		
		Optional<Double> price3 = Optional.ofNullable(null);
		Double z = price3.orElseThrow(() -> new
				RuntimeException("Bad Code"));
		System.out.println(z);	
	}
}
