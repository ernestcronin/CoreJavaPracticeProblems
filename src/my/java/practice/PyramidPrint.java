package my.java.practice;

public class PyramidPrint {

	public static void print(int rows) {
		
		for(int i = 1; i<=rows; i++) {
			
			for(int j=i; j<rows; j++) {
				System.out.print(" ");
			}
			for(int j=1; j<=i; j++) {
				System.out.print(i);
			}
			
			for(int j=1; j<rows; j++) {
				System.out.print("a");
			}
			System.out.println("");
			
		}
	}
	
	public static void main(String[] args) {
		print(5);
	}
}
