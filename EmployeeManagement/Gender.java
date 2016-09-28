package EmployeeManagement;

public enum Gender {
	MALE("Male"), FEMALE("Female");
	
	private String genderString;
	
	Gender(String genderString) {
		this.genderString = genderString;
	}
	
	@Override
	public String toString() {
		return genderString;
	}
}
