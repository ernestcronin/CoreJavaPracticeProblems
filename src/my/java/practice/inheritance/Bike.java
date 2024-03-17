package my.java.practice.inheritance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface Bike {

	public String getMode();
	
	public static void main(String[] args) {
		
		Object[] arr = {3, "ab", 1};
		
		List<Integer> list = new ArrayList<>();
		
		for(Object obj : arr) {
			
			if(obj instanceof Integer) {
				list.add((Integer)obj);
			}
		}
		
		Collections.sort(list);
		//Collections.sort(list, Comparator.comparing(input -> input));
		
		list.stream().forEach(System.out::println);
	}
}
