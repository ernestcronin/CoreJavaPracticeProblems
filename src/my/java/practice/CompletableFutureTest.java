package my.java.practice;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

class Counter1{
	
	int count = 0;
	
	public Counter1(int count) {
		this.count = count;
	}
	
	public void increment() {
		
		for(int i =0; i < 100000; i++) {
			count++;
		}
	}
	
	void setCount(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return this.count;
	}
}


public class CompletableFutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		CompletableFuture<Counter1> cf1 = new CompletableFuture<>();
		cf1.get();
		cf1.complete(new Counter1(-1));
		//cf1.complete("completing thread manually");
	}
}
