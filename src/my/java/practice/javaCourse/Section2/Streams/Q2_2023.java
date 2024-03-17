package my.java.practice.javaCourse.Section2.Streams;

import java.util.stream.IntStream;

/**
 * Stream a list of int primitives between the range of 0 (inclusive) and 5
 * (exclusive). Calculate and output the average.
 */
public class Q2_2023 {

	public static void main(String[] args) {
		
		IntStream stream = IntStream.range(0, 5);
		int sum = stream.reduce(0, (val1, val2) -> val1 + val2 );
		System.out.println(sum);
		double avg = sum/5;
		System.out.println(avg);
		
		
		stream = IntStream.range(0, 5);
		double d = stream.average().orElse(0);
		System.out.println(d);
		
	}
}
