package MostCommonMap;

public class Dog {
	
	private String name;
	private String breed;
	private int day, month, year;
	private String birthdate;
	private double weight;
	
	Dog(String name, String breed, int month, int day, int year, double weight) {
		this.name = name;
		this.breed = breed;
		this.setMonth(month);
		this.setDay(day);
		this.setYear(year);
		this.weight = weight;
		this.birthdate = month + "/" + day + "/" + year;
	}
	
	Dog() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String toString(){
		return "I am " + this.name + ", of the breed " + this.breed + ", born on " + this.birthdate + " and weigh " + this.weight + ".";
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
