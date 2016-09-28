package CelebrityLibrary;

import java.util.*;
import java.io.*;

public class Library {
	public LinkedList<Celebrity> libraryList = new LinkedList<Celebrity>();
    public HashSet<String> celebsSet = new HashSet<String>();
    
	public static void main(String[] args) {
		Library myLibrary = new Library();
		String fileName;
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter full path of file name:");
		
		fileName = input.nextLine();
		input.close();
		
		if (fileName != null) {
			try {
				fileName = fileName.trim();
				myLibrary.readFileIntoList(fileName);
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		myLibrary.readLLIntoHashSet();
	}
	
	public void readFileIntoList(String string) throws FileNotFoundException {
		String celebrityName;
		String movieName;
		
		Scanner input;
		
		//input = new Scanner(new File(string));
		input = new Scanner(new File("InputFiles/celebrities.txt"));
		//input = new Scanner(new File("src/CelebrityLibrary/celebrities.txt"));
		
		while(input.hasNextLine()) {
			celebrityName = input.nextLine();
			movieName = input.nextLine();
			
			libraryList.add(new Celebrity(celebrityName, movieName));
			
			//Print Library list contents to debug
		}
	}
	
	public void readLLIntoHashSet() {
	    
	    if (libraryList == null) return;
	    
	    for(Celebrity celeb:libraryList) {
	        celebsSet.add(celeb.getName());
	    }
	    
	    for(String name:celebsSet) {
	        System.out.println(name);
	    }
	    
	}
}