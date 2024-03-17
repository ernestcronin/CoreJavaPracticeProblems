package my.java.practice.javaCourse.Section2.Streams;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * 14. Examine the following code. Note that an AtomicInteger is a version of
 * Integer that is safe to use in concurrent (multi-threaded) environments. The
 * method incrementAndGet() is similar to ++ai a) Why is the value of ai at the
 * end 0 (and not 4)?
 */
public class Q2_1841 {

	public static void main(String[] args) {
		
		AtomicInteger ai = new AtomicInteger();
		Stream.of(11, 11, 22, 33)
			.parallel()
			.filter(n -> {
				ai.incrementAndGet();
				return n % 2 == 0;
			});
		
		System.out.println(ai);
		
		AtomicInteger ai1 = new AtomicInteger();
		Stream.of(11, 11, 22, 33)
			.parallel()
				.filter(n -> {
					ai1.incrementAndGet();
					return n % 2 == 0;
				}).forEach(System.out::println);
		
		System.out.println(ai1);
	}
}
