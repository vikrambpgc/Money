package MostCommonMap;

public class OneName {
	private String name;
	private char sex;
	private Integer count;
	
	public OneName(String name, char Gender, int count) throws IllegalArgumentException {
		this.setName(name);
		this.setSex(Gender);
		this.setCount(count);
	}
	
	public void setName(String name) throws IllegalArgumentException {
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Please don't enter a empty name for setName setter method");
		}
		
		this.name = name;
	}
	
	public void setSex(char sex) throws IllegalArgumentException {
		if (sex == 'M' || sex == 'F') {
			this.sex = sex;
		} else {
			throw new IllegalArgumentException(String.format("Please enter only M or F for setSex setter method not \'%c\' for name \'%s\'", sex, this.getName()));
		}
		
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	public String getName() {
		return this.name;
	}
	
	public char getSex() {
		return this.sex;
	}
	
	public int getCount() {
		return this.count;
	}
	
	@Override
	public String toString() {
		return this.getName() + "," + this.getSex() + "," + this.getCount();
	}
}
