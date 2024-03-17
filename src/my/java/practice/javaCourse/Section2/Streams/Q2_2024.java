package my.java.practice.javaCourse.Section2.Streams;

import java.util.stream.DoubleStream;

/**
 * 12. There are two parts: 
 * 
 * a. Generate a DoubleStream using the of() method
 * consisting of the numbers 0, 2 and 4. Note that this stream is a stream of
 * primitives and not a stream of types. Filter in odd numbers only and sum the
 * remaining stream. You should get 0. (QID 2.2024) 
 * 
 * b. Using 1.0 and 3.0,
 * generate a stream of Double’s. Map them to primitive double’s. Filter in even
 * numbers only and calculate the average. Output the result without running the
 * risk of generating an exception.
 */
public class Q2_2024 {

	public static void main(String[] args) {
		
		DoubleStream stream = DoubleStream.of(0,2,4);
		System.out.println(stream.filter(num -> (num%2 != 0)).sum());
		
		DoubleStream stream1 = DoubleStream.of(1.0,3.0);
		System.out.println(stream1.filter(num -> (num%2 == 0)).average().orElse(Double.NaN));
	}
}
