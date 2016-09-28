package EmployeeManagement;

import java.text.NumberFormat;
import java.util.Scanner;

public class EmployeeTest {
	
	private static int employeeCount = 0;
	private static double totalSalary = 0;
	
	public static void main (String [] args) {
		
		String Name;
		String garbage;
		int ID;
		int salary;
		Gender gender = null;
		double hours;
	
	  // Inputting first employee's information
	  Scanner scan = new Scanner(System.in);
	  
	  System.out.println("Enter First Employee Name: ");
	  Name = scan.nextLine( );
	  
	  System.out.println( "Please Enter an ID > " );
	  while (!scan.hasNextInt()) {
		  System.out.println( "Please Enter an integer > " );
		  garbage = scan.nextLine();
	  }
	  ID = scan.nextInt( );
	
	  System.out.println("Please Enter a Salary: ");
	  while (!scan.hasNextInt()) {
		  System.out.println( "Please Enter an integer > " );
		  garbage = scan.nextLine();
	  }  
	  salary = scan.nextInt( );
	  garbage = scan.nextLine();
	  
	  System.out.println("Enter the employee's gender: (m)ale or (f)emale > "); 
	  while (scan.hasNextLine()) {
		  String genderInput = scan.nextLine();
		  if (genderInput.equalsIgnoreCase("M")) {
			  gender = Gender.MALE;
			  break;
		  } else if (genderInput.equalsIgnoreCase("F")) {
			  gender = Gender.FEMALE;
			  break;
		  } else {
			  System.out.println( "Enter m or f > " );
		  }	 
	  }
	
	  // Outputting first employee's information
	  Employee e1 = new Employee(Name, ID, salary, gender);
	  employeeCount++;
	  totalSalary += e1.getSalary();
	  
	  System.out.println(e1);
	  System.out.println("Please the number of hours: ");
	  hours = scan.nextDouble( );
	  System.out.println(e1.getPayString(hours));
	  garbage = scan.nextLine();
	
	  // Inputting second employee's information
	  System.out.println("Enter Second Employee name: ");
	  Name = scan.nextLine( );
	
	  System.out.println( "Please Enter an ID > " );
	  while (!scan.hasNextInt()) {
		  System.out.println( "Please Enter an integer > " );
		  garbage = scan.nextLine();
	  }
	  ID = scan.nextInt( );
	
	  System.out.println("Please Enter a Salary: ");
	  while (!scan.hasNextInt()) {
		  System.out.println( "Please Enter an integer > " );
		  garbage = scan.nextLine();
	  } 
	  salary = scan.nextInt( );
	  garbage = scan.nextLine();
	  
	  System.out.println("Enter the employee's gender: (m)ale or (f)emale > "); 
	  while (scan.hasNextLine()) {
		  String genderInput = scan.nextLine();
		  if (genderInput.equalsIgnoreCase("M")) {
			  gender = Gender.MALE;
			  break;
		  } else if (genderInput.equalsIgnoreCase("F")) {
			  gender = Gender.FEMALE;
			  break;
		  } else {
			  System.out.println( "Enter m or f > " );
		  }	 
	  }
		
	  // Outputting second employee's information
	  Employee e2 = new Employee(Name, ID, salary, gender);
	  employeeCount++;
	  totalSalary += e2.getSalary();
	  
	  System.out.println(e2);
	  System.out.println("Please the number of hours: ");
	  hours = scan.nextDouble( );
	  System.out.println(e2.getPayString(hours));
	  
	  if (e1.equals( e2)) {
		  System.out.println("They are the same");
	  } else {
		  System.out.println("They are different");
	  }
	  
	  //Static varible outputs
	  NumberFormat currency = NumberFormat.getCurrencyInstance();
	  System.out.println("There are " + employeeCount +" employees");
	  System.out.println("They make a total of " + currency.format(totalSalary) + " a year.");
	  System.out.println("The average salary is " + currency.format(totalSalary / (double) employeeCount)+" a year.");
	}
}
