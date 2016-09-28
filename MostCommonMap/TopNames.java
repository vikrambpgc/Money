package MostCommonMap;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class TopNames {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IllegalArgumentException, FileNotFoundException {
		int year;
		NameYear yearData;
		
		//Take Input from console
		Scanner sc = new Scanner(System.in);
		
		try {
			//Read it as integer.
			year = sc.nextInt();
			
			//Load the baby names from the file corresponding to the year into an ArrayList in NameYear.
			yearData = new NameYear(year);
			
			//Print out bottom 10 and top 10 OneNames.
			System.out.println("\nBottom 10 Name Entries:\n\n" + yearData.bottom(10));
			System.out.println("\nTop 10 Name Entries:\n\n" + yearData.top(10));
			
			
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("Please enter only an Integer for year");
		}
		
		sc.close();
	}
}
