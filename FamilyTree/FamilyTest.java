package FamilyTree;
// This program tests the FamilyInfo and Person classes by reading a
// file with family information and showing the maternal line, paternal
// line and children for various people.
//
// Code extracted from Reges and Stepp, Building Java Programs
// modified by W.P. Iverson for CS211, Summer 2014

import java.io.*;
import java.util.*;
public class FamilyTest {
    public static void main (String[] args) throws FileNotFoundException {
    	// Interact with user via the console
    	Scanner console = new Scanner(System.in);   
    	
    	// Show program introduction:
        System.out.println("This program reads an input file with family");
        System.out.println("information and provides information about the");
        System.out.println("maternal line, paternal line and children of");
        System.out.println("various people.\n");
        
        // Read given family information into FamilyInfo object
        //Scanner input = new Scanner(new File("names.txt")); 
        Scanner input = new Scanner(new File("C:\\results\\names.txt"));
        System.out.println("Input file is names.txt in local project folder.");
        FamilyInfo family = new FamilyInfo();        
        family.read(input);		//  BIG method, that reads data file into object
        input.close();	// all data in file is read, so file is no longer needed
        
        // Loop main program as long as user desires:
    	String name = "Keep running";
        while(!name.equals("quit")) {
            System.out.print("\n\n\nPerson's name ('quit' to end)? ");
            name = console.nextLine();	// read line from user
            System.out.println();
            if (name.equalsIgnoreCase("quit")) break; // break loop upon quit
            Person next = family.getPerson(name);
            if (next == null) {
                System.out.println("No match.");
            } else {
                showMaternal(next);
                showPaternal(next);
                showChildren(next);
                System.out.println("\n\n\nShown as TREE (printSideways):");
                FamilyTree structure = new FamilyTree(next);
                structure.buildTree(family);
                structure.printSideways();
            }
        }
    }

    // Shows maternal ancestors for given person
    public static void showMaternal(Person current) {
        System.out.println("Maternal line:");
        int level = 1;
        while (current != null) {
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(current.getName());
            current = current.getMother();
            level++;
        }
        System.out.println();
    }

    // Shows paternal ancestors for given person
    public static void showPaternal(Person current) {
        System.out.println("Paternal line:");
        int level = 1;
        while (current != null) {
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(current.getName());
            current = current.getFather();
            level++;
        }
        System.out.println();
    }

    // Shows children for given person
    public static void showChildren(Person current) {
        System.out.println("Children:");
        if (current.numKids() == 0) {
            System.out.println("    none");
        } else {
            for (int i = 0; i < current.numKids(); i++) {
                System.out.println("    " + current.nthKid(i).getName());
            }
        System.out.println();
        }
    }
}
