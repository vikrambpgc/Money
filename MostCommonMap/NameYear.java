package MostCommonMap;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NameYear {
	//Enter the path where the babyNames files exist. 
	String fileName = "InputFiles" + "/yob%d.txt";
	File yobFile;
	ArrayList<OneName> list = new ArrayList<OneName>(); //list that keeps track of the OneNames.
	
	
	public NameYear(int year) throws IllegalArgumentException, FileNotFoundException {
		String singleLine ="";
		String[] tokens = new String[3];
		
		if (year < 1880 || year > 2013) {
			throw new IllegalArgumentException("Year must be between 1880-2013 inclusive not " + year);
		}
		
		yobFile = new File(String.format(fileName, year));
		if (false == yobFile.exists()) {
			throw new FileNotFoundException(String.format("File \'%s\' doesn't exist", yobFile.toString()));
	    }
		
		Scanner sc = new Scanner(yobFile);
		
		//Loop through file and load each line as an OneName into the list.
		while(sc.hasNext()) {
			singleLine = sc.nextLine();
			tokens = singleLine.split(",");
			
			try {
				if (tokens[1].length() != 1) {
					throw new IllegalArgumentException(String.format("Enter M or F for Gender in entry \'%s\' not \'%s\'", singleLine, tokens[1]));
				}
				
				//create a oneName object and add it to the list.
				list.add(new OneName(tokens[0], tokens[1].charAt(0), Integer.parseInt(tokens[2])));
				
			} catch (NumberFormatException e) {
				throw new IllegalArgumentException(String.format("Enter an Integer for count in entry %s not \'%s\'", singleLine, tokens[2]));
			}
		}
		
		sc.close();	
	}
	
	/**
	 * Print out top 10 OneNames in the file.
	 * @param many
	 * @return
	 */
	public String top(int many) {
		StringBuilder str = new StringBuilder();
		int listSize = list.size();
		
		for(int i = 0; i<many && i<listSize; i++) {
			str.append(list.get(i).toString() + "\n");
		}
		
		return str.toString();
	}
	
	/**
	 * Print out bottom 10 names in the file.
	 * @param many
	 * @return
	 */
	public String bottom(int many) {
		StringBuilder str = new StringBuilder();
		int listSize = list.size();
		
		for(int i = listSize - many; i >= 0 && i < listSize;i++) {
			str.append(list.get(i).toString() + "\n");
		}
		
		return str.toString();
	}
}
