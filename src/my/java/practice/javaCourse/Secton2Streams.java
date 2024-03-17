package my.java.practice.javaCourse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//intermediary - does some operation like filter
//terminal ends the stream
//a reduction processes all elements of the stream
//identity is initial value of a reduction
//accumulator combines current result with current value in stream
//stateful operator means the stream must keep track of value like count()
//mutable reduction (collect) - using the same mutable object while accumulating - StringBuilder, ArrayList
//stream.map is for transformation
//flatMap takes lists and processes them as one
//sorted can take a predicate Comparator.comparing(p -> p.age)
//short cirucit operation is like limit that kills it
//work with primitives IntStream, Doublestream etc
//mapToSomething takes a function
//Optionals are for handling null values
//Parallel streams are for concurrency
public class Secton2Streams {

	
	public static void main(String[] args) {
		
		Double[] arr = {100.0, 99.8, 10.2, 111.23, 155.0};
		List<Double> list = Arrays.asList(arr);
		AtomicInteger count1 = new AtomicInteger(0);
		AtomicInteger count2 = new AtomicInteger(0);

//		System.out.println("number of temps > 100 is: " + 
//				list.stream()
//				.peek(val -> System.out.println("value" + count1.incrementAndGet() + ": " + val))
//				.filter(val -> val > 100)
//				.peek(val -> System.out.println("filtered" + count2.incrementAndGet() + ": " + val))
//				.count());
		
		Stream<Double> stream = list.stream();
		//System.out.println(stream.count());
		System.out.println("number of temps > 100 is: " + 
				stream
				.peek(val -> System.out.println("value" + count1.incrementAndGet() + ": " + val))
				.filter(val -> val > 100)
				.peek(val -> System.out.println("filtered" + count2.incrementAndGet() + ": " + val))
				.count());
		
		
		List<String> animals = Arrays.asList("pig", "deer", "dog");
		Optional<String> opt = animals.stream().min((s1, s2) -> s1.length() - s2.length());
		opt.ifPresent(System.out::println);
		
		Stream<String> animalStream = Stream.of("pig", "deer", "dog");
		Optional<String> opt3 = animalStream.max((s1, s2) -> s1.length() - s2.length());
		opt3.ifPresent(System.out::println);
		
	//	<StringBuilder> StringBuilder java.util.stream.Stream.collect(
	//			Supplier<StringBuilder> supplier, BiConsumer<StringBuilder, ? super String> accumulator, 
	//			BiConsumer<StringBuilder, StringBuilder> combiner)
		
		
		//mutlithreaded operation (I think)
		//the Collector takes needs a supplier () -> new SB()
		//then a biconsumer - sb and string, and appends
		//biconsumer - appends multiple sbs
		StringBuilder word = Stream.of("ad", "ju", "di", "cate")
				.collect(() -> new StringBuilder(), 
						(sb, str) -> sb.append(str),
						(sb1, sb2) -> sb1.append(sb2));
		System.out.println(word);
		
		String s = Stream.of("cake", "biscuit", "tart")
				.collect(Collectors.joining(" "));
		System.out.println(s);
		
		String[] a = {"cake", "biscuit", "tart"};
		List<String> l = Arrays.asList(a);
		Map<String, Integer> map =
				l.stream()
				.collect(
						Collectors.toMap(i -> i,
								i -> i.length()))
				;
		map.forEach((k,v) -> System.out.println(k + " " + v));	
		
		//Here i'm trying to set the key as the position of the element but can't figure out how
//		String[] a = {"cake", "biscuit", "tart"};
//		List<String> l = Arrays.asList(a);
//		Map<Integer, String> map =
//				l.stream()
//				.collect(
//						Collectors.toMap(() -> count1.incrementAndGet(),
//								i -> i.length()))
//				;
					
		
		TreeMap<String, Integer> map2 = 
		Stream.of("cake", "biscuit", "tart")
		.collect(
				Collectors.toMap(
						st -> st,	//key is string
						st -> st.length(),	// value is length of string
						(len1, len2) -> len1 + len2,  // merge function
						() -> new TreeMap<String, Integer>()) // new operator
				);
		
		System.out.println(map2);
		
		List<String> result = new ArrayList<>();
		String[] temp = {"ad", "ju", "di", "cate", "ad"};
		List<String> temp2 = Arrays.asList(temp);
		temp2.stream().distinct().sorted().forEachOrdered(p -> result.add(p));
		System.out.println(result);
		
		Object[] objArr = {1, "abc", 1.25, "", "abc", "a"};
		List<String> strArr = new ArrayList<>();
		Arrays.stream(objArr).filter(p -> p instanceof String).distinct().sorted().forEach(p -> strArr.add((String) p));
		System.out.println(strArr);
		
		OptionalInt max = IntStream.of(1, 2, 3).max();
		IntConsumer print = p -> System.out.println(p);
		print.accept(max.getAsInt());
		
		//Mapping different streams types to each other
		
		IntStream stream1 = Stream.of("cake", "biscuit", "tart").mapToInt(s4 -> s4.length());
		stream1.forEach(print);
		
	}
}
