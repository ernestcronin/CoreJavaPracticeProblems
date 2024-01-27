package my.java.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

	// binary search
	public static int runBinarySearchRecursively(int[] sortedArray, int key, int low, int high) {
		
		int middle = low + ((high - low) / 2);

		if (high < low) {
			return -1;
		}

		if (key == sortedArray[middle]) {
			return middle;
		} else if (key < sortedArray[middle]) {
			return runBinarySearchRecursively(sortedArray, key, low, middle - 1);
		} else {
			return runBinarySearchRecursively(sortedArray, key, middle + 1, high);
		}
	}

	// iterative search
	public static int runBinarySearchIteratively(int[] sortedArray, int key, int low, int high) {
		
		int index = Integer.MAX_VALUE;

		while (low <= high) {
			int mid = low + ((high - low) / 2);
			if (sortedArray[mid] < key) {
				low = mid + 1;
			} else if (sortedArray[mid] > key) {
				high = mid - 1;
			} else if (sortedArray[mid] == key) {
				index = mid;
				break;
			}
		}
		return index;
	}

	// use array class
	public static int arrayFunc(int[] sortedArray, int key) {

		int index = Arrays.binarySearch(sortedArray, key);
		return index;
	}
	
	//use collection utils
	public static int collectionFunc(List<Integer> sortedList, int key) {
		
		int index = Collections.binarySearch(sortedList, key);
		return index;
	}

	public static void main(String[] args) {
		
		int[] arr = {1,2,2,3,5,5,6,7,10,11,11,15,19,20,21,21,25,27,29,30,31,33};
		List<Integer> list = Arrays.stream(arr).boxed().toList();
		int k = 25;
		
		System.out.println("recursion: " + runBinarySearchRecursively(arr, k, 0, arr.length-1));
		System.out.println("iterative: " + runBinarySearchIteratively(arr, k, 0, arr.length-1));
		System.out.println("array function: " + arrayFunc(arr, k));
		System.out.println("collection function: " + collectionFunc(list, k));
	}
}
