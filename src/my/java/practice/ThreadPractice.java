package my.java.practice;


/*
 * The job of the developer is not to control the scheduler put to optimize it
 * Thread priority of min to max 1-10, is only a suggestion to the scheduler
 */
class ThreadA extends Thread{
	
	public void run() {
		int i = 1;
		while(i++<=100) {
			System.out.println("Thread A" + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class ThreadB extends Thread{
	
	public void run() {
		int i = 1;
		while(i++<=100) {
			System.out.println("Thread B " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class RunnableA implements Runnable{

	@Override
	public void run() {
		
		int i = 1;
		while(i++<=100) {
			System.out.println("Thread C " + Thread.currentThread().getName());
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class Counter{

	int count =0;
	
	public int getCount() {
		return count;
	}
	
	public synchronized void increment() {
		
		count++;
	}
	
	
}


public class ThreadPractice {

	public static void main(String[] args) throws InterruptedException {
		
		ThreadA a = new ThreadA();
		ThreadB b = new ThreadB();
		
		//System.out.println("A priority " + a.getPriority());
		//System.out.println("B priority " + b.getPriority());
		
		//a.start();
		//b.start();
		
		RunnableA ra = new RunnableA();
		Thread t1 = new Thread(ra);
		//t1.start();
		
		//an Anonymous class
		Runnable anon = new Runnable() 
		{
			
			@Override
			public void run() {
				
				int i = 1;
				while(i++<=100) {
					System.out.println("Thread Anonymous " + Thread.currentThread().getName());
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		
		//anon.run();
		
		Runnable lamda = () -> {
			int i = 1;
			while (i++ <= 100) {
				System.out.println("Runnable Lamda " + Thread.currentThread().getName());
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};
		
		
		Thread lamdaThread = new Thread(lamda);
		lamdaThread.setPriority(10);
		//lamda.run();
		
		Counter c = new Counter();
		
		Runnable r1 = () ->{
			int i =0;
			while(i++<=1000) {
				c.increment();
			}
		};
		
		Runnable r2 = () -> {
			int i =0;
			while(i++<=1000) {
				c.increment();
			}
		};
		
		//Does this run syncronously? Count is correct
		//r1.run();
		//r2.run();
		//System.out.println(c.getCount());
		
		Thread tr1 = new Thread(r1);
		Thread tr2 = new Thread(r2);
		
		
		tr1.start();
		tr2.start();
		
		//telling main to wait for the threads to come back before finishing
		//Why is the value still always different?
		//the value is changing each time each thread does the 2 operations - get the count, then add 1 to it.
		//this is why mutations can end in race condition
		tr1.join();
		tr2.join();
		System.out.println(c.count);
	}
}
