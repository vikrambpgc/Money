package EmployeeManagement;

//Khizar Alvi

import java.util.Scanner;
import java.text.NumberFormat;

public class Employee {

//instance variables
private String Name;
private int ID;
private int salary;
private Gender gender;

  // Accessor
public String getName( ) {
	  return Name;
 }
  // Mutator
public void setName(String Name) {
	  this.Name = Name;
 }

  // Accessor
public int getID() { 
	  return ID;
}
// Mutator
public void setID(int ID) {
	  this.ID = ID;
}

// Accessor
public double getSalary() {
	  return salary;
}

// Mutator
public void setSalary(int salary) {
	  this.salary = salary;
}

//Accessor
public Gender getGender() {
	return this.gender;
}

//Mutator
public void setGender(Gender gender) {
	this.gender = gender;
}


//constructor
 public Employee( String Name, int ID, int salary, Gender gender) {  
    setName(Name);
    setID(ID);
    setSalary(salary);
    setGender(gender);
}

 //ToString Method
 public String toString() {
	   NumberFormat currency = NumberFormat.getCurrencyInstance();
	   return "name: " + getName() + ", salary: "+ currency.format(getSalary()) +
			   ", ID: " + getID() + ", gender: " + getGender();
 }

 public double getPay(double hours) {
	   if (hours < 40) return (salary/2080.00 * hours);
	   else return (salary/2080.00 * (40 + (hours-40)*1.5));
 }

 public String getPayString(double hours) {
	  NumberFormat currency = NumberFormat.getCurrencyInstance();
	  return currency.format(getPay(hours));
 }
}
