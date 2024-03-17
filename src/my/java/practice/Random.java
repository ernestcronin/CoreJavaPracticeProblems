package my.java.practice;



import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;

/**
 * Random questions I've been asked over time
 */
public class Random {

//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Getter
//    @Setter
//    @ToString
    class Employee {
        private Integer id;

        private String name;

        private Double salary;
        
        
       
        public Employee(Integer id, String name, Double salary) {
			super();
			this.id = id;
			this.name = name;
			this.salary = salary;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

		public void incrementSalary(Double value) {
            this.salary = salary + value;
        }
    }


    public Employee createEmployee(Integer id, String name, Double salary) {
        return new Employee(id, name, salary);
    }
    
    //are two string an anagram
    public static boolean areStringAnagram(String str1, String str2) {
    	
    	Map<Integer, String> map1 = new HashMap<>();
    	Map<Integer, String> map2 = new HashMap<>();
    	
    	String[] arr1 = str1.split("");
    	String[] arr2 = str2.split("");
    	
    	AtomicInteger ai1 = new AtomicInteger(0);
    	AtomicInteger ai2 = new AtomicInteger(0);
  	
    	Arrays.stream(arr1).forEach(p -> map1.put(ai1.incrementAndGet(), p));
    	Arrays.stream(arr2).forEach(p -> map2.put(ai2.incrementAndGet(), p));
    	
    	if(map1.size() != map2.size())
    		return false;
    	
    	for(int i = 1; i <= arr1.length; i++) {
    		
    		String curr = map1.get(i);
    		if(!map2.containsValue(curr))
    			return false;
    	}
    		
    	return true;
    }
    


    public static void main(String[] args) {
        
    	List<String> strs = new LinkedList<>();
    	String[] arr = {"str1", "str2", "str3"};
    	Collections.addAll(strs, arr);
    	LinkedList<String> rev = reverseLinkedList((LinkedList)strs);
    	rev.stream().forEach(p -> System.out.println(p));
    	
    	String str1 = "string";
    	String str2 = "string";
    	String str3 = new String("string");
    	str1 = "hi";
    	System.out.println(str1);
    	
//    	String str1 = "cronin Ernest!";
//    	String str2 = "Ernest Cronin!";
//    	
//    	System.out.println(areStringAnagram(str1.toLowerCase(), str2.toLowerCase()));
  
    }

    public static void ternaryAssignment() {
        Random test = new Random();

        Employee e1 = test.createEmployee(1, "ernest", 1d);
        Employee e2 = test.createEmployee(2, "mike", 2d);
        boolean same = Objects.equals(e1.id, e2.id);
        System.out.println(same);

    }

    //** function to find a prime number
    public static boolean isPrimeNumber(int number) {

        int[] list = {-2, -1, 0, 1, 2};
        for (int i = 0; i < list.length; i++) {
            if (list[i] == number) return false;
        }

        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= (number / 2); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    //using stream
    public static void stream() {

        Random test = new Random();

        Employee[] arrayOfEmps = {test.createEmployee(1, "Jeff Bezos", 100000.0), test.createEmployee(2, "Bill Gates",
                200000.0), test.createEmployee(3, "Mark Zuckerberg", 300000.0)};

        Stream<Employee> stream = Stream.of(arrayOfEmps);
        stream.forEach(e -> e.incrementSalary(50.0));

        Stream<Employee> stream2 = Stream.of(arrayOfEmps);
        stream2.forEach(e -> System.out.println(e.toString()));
    }

    //iterate over a map
    public static void iterateMap() {

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "sandy");
        map.put(2, "dylan");
        map.put(3, "ernest");

        Iterator<Entry<Integer, String>> it = map.entrySet()
                .iterator();
        while (it.hasNext()) {
            Entry<Integer, String> entry = it.next();
            System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
        }
    }

    //problem to count unique words in a string
    public static int countWords(String str) {

        Map<Integer, String> map = new HashMap<>();
        String[] words = str.split(" ");
        
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);
        
        for (int i = 0; i < words.length; i++) {
            if (!map.containsValue(words[i])) {
                map.put(i, words[i]);
            }
        }
        return map.size();
    }

    //swap with 3 vars
    public static void swap(int x, int y) {
        int sum = x + y;
        x = y;
        y = sum - x;
        System.out.println("x " + x + " y " + y);
    }

    //swap with 2 vars
    public static void swap2(int x, int y) {

        x = y + x;
        y = x - y;
        x = x - y;
        System.out.println("x " + x + " y " + y);
    }

    
    //reverse a string
    //stringBuffer is no longer preferred due to synchronization
    public static String reverse(String str) {
        StringBuilder buffer = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            buffer.append(str.charAt(i));
        }
        buffer.toString();

        //OR

        StringBuilder build = new StringBuilder();
        build.append(str);
        return build.reverse()
                .toString();
    }
    
    
    public static int xn(int value, int x, int n) {
        if ((x == 1 && value == 0) || (n == 0 && value == 0)) return 1;
        if (n == 1) return value;
        if (value == 0) value = x * x;
        else {
            value = value * x;
        }
        return xn(value, x, n - 1);
    }


    //find fibannaci seq
    public static int getFibNumb(int limit) {
        int first = 0;
        int second = 1;
        int x = 0;

        if (limit == 0) {
            return first;
        } else if (limit == second) {
            return second;
        }

        for (int i = 3; i <= limit; i++) {
            x = first + second;
            first = second;
            second = x;
        }
        return x;
    }

    //count number of char in digit
    public static int countDigits(int number) {

        String numb = String.valueOf(number);
        return numb.length();

    }
   

    //print sum of rows in a 2D array
    public static void printSumOfRows2DArray(int[][] array) {

        int row = array.length;
        int col = array[0].length;

        for (int i = 0; i < row; i++) {
            int sum = 0;
            for (int j = 0; j < col; j++) {

                sum += array[i][j];
            }
            System.out.println("Sum of row " + (i + 1) + " is: " + sum);
        }
    }

    //print sum of cols in a 2D array
    public static void printSumOfCols2DArray(int[][] array) {

        int row = array.length;
        int col = array[0].length;

        for (int i = 0; i < col; i++) {
            int sum = 0;
            for (int j = 0; j < row; j++) {

                sum += array[j][i];
            }
            System.out.println("Sum of col " + (i + 1) + " is: " + sum);
        }
    }

    //print largest value in each row of a 2d array
    public static void printLargestValOfEachRow(int[][] array) {

        int row = array.length;
        int col = array[0].length;

        for (int i = 0; i < row; i++) {
            int largest = 0;
            for (int j = 0; j < col; j++) {

                if (j == 0) {
                    largest = array[i][j];
                } else {
                    if (largest < array[i][j]) {
                        largest = array[i][j];
                    }
                }
            }
            System.out.println("Largest value in row " + (i + 1) + " is: " + largest);
        }
    }
    
    public static LinkedList<String> reverseLinkedList(LinkedList<String> strings) {
    	
    	List<String> reversed = new LinkedList<>();
    	Iterator<String> it = strings.descendingIterator();
    	while(it.hasNext())
    		reversed.add(it.next());
    	return (LinkedList<String>)reversed;
    }
    
    public static boolean print() {
    	
    	int[] x = {1, 1, 2, 2, 3, 3, 3};
    	int[] y = {1, 1, 2, 2, 3, 3, 3};
    	
    	List<Integer> list1 = Arrays.stream(x).boxed().toList();
    	List<Integer> list2 = Arrays.stream(y).boxed().toList();
    	List<Integer> list3 = Arrays.asList(1,2,3,4);
    	
    	Map<Integer, Integer> map1 = new HashMap<>();
    	Map<Integer, Integer> map2 = new HashMap<>();
    	
    	for(int i = 0; i< list1.size(); i++) {
    		int count = 1;
    		map1.put(count++, list1.get(i));
    	}
    	for(int i = 0; i< list2.size(); i++) {
    		int count = 1;
    		map2.put(count++, list2.get(i));
    	}
    	
    	if(map2.size() != map1.size())
    		return false;
    	
    	Iterator<Entry<Integer, Integer>> it = map1.entrySet().iterator();
    	while(it.hasNext()) {
    		Integer value = it.next().getValue();
    		
    		if(!map2.containsValue(value))
    			return false;
    	}
    	return true;
    }
}
