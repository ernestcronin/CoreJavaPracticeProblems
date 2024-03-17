package my.java.practice;

public abstract class Bike {

	private String type;
	private String year;
	
	public Bike(String type, String year) {
		super();
		this.type = type;
		this.setYear(year);
	}
	
	public abstract boolean isGood();
	
	public double calculateValue() {
		
		return 100;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
}

