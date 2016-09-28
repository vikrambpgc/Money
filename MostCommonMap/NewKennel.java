package MostCommonMap;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;


public class NewKennel {

	public static void main(String[] args) {
		
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		
		/*
		if(args.length<1){
			System.out.println("\n    You forgot to put a filename on the command line.");
			System.exit(1);
		}

		String inFile = args[0];
		*/
		String inFile = "InputFiles/kennel1.txt";
		Scanner sc = null;
		
		try{
			sc = new Scanner(new File(inFile));
		}catch(Exception e){
			System.out.println("File not found.");
			System.exit(1);
		}
		
		String line = "";
		int lineNumber = 1;
		int validDogs = 0, inValidDogs = 0;
		boolean isFirstError = true;
		
		while(sc.hasNextLine()){
			line = sc.nextLine();
			String[] details = line.split("\t");
			
			Dog dog = new Dog();
			boolean isValid = createValidDog(dog, details, lineNumber, isFirstError);
			
			if (true == isValid) {
				validDogs++;
				
				dogs.add(dog);
				
				/**
				 **Old logic*
				 * dogs.add(new Dog(details[0], details[1], Integer.parseInt(details[2]), Integer.parseInt(details[3]),
				 * 			Integer.parseInt(details[4]), Double.parseDouble(details[5])));
				 */
				 	
			} else {
				if (true == isFirstError) {
					isFirstError = false;
				}
				inValidDogs++;
				dog = null;
			}
			
			lineNumber++;
		}
		
		System.out.println();
		System.out.println("Number of Valid dogs is " + validDogs);
		System.out.println();
		System.out.println("Number of invalid dogs is " + inValidDogs);
		System.out.println();
		
		System.out.println("Property\t\t\tName\t\t\tValue");
		
		lightestDog(dogs);
		heaviestDog(dogs);
		oldestDog(dogs);
		youngestDog(dogs);
		longestNameDog(dogs);
		shortestNameDog(dogs);
		commonName(dogs);
		commonBreed(dogs);
	}
	
	private static boolean createValidDog(Dog dog, String[] details, int lineNumber, boolean isFirstError) {
		String name = null;
		String breed = null;
		int day = 0, month = 0, year = 0;
		double weight = 0;
		
		if (dog == null || details == null) {
			return false;
		}
		
		if (details.length != 6) {
			printDetails(details, isFirstError);
			printErrorLine(lineNumber, "number of fields on line must be 6 not " + details.length);
			return false;
		}
		
		//Name validation
		name = details[0];
		
		//Breed Validation
		breed = details[1];
		
		//Month Validation
		try {
			month = Integer.parseInt(details[2]);
			
			if (month < 1 || month > 12) {
				printDetails(details, isFirstError);
				printErrorLine(lineNumber, "month must be between 1 to 12 not " + month);
				return false;	
			}
		} catch(NumberFormatException e) {
			printDetails(details, isFirstError);
			printErrorLine(lineNumber, "Enter a valid Integer for Month not " + details[2]);
			return false;
		}

		//Day validation
		try {
			day = Integer.parseInt(details[3]);
			
			if (day < 1 || day > 31) {
				printDetails(details, isFirstError);
				printErrorLine(lineNumber, "day must be between 1 to 31 not " + day);
				return false;	
			}
		} catch(NumberFormatException e) {
			printDetails(details, isFirstError);
			printErrorLine(lineNumber, "Enter a valid Integer for day not " + details[3]);
			return false;
		}
		
		try {
			year = Integer.parseInt(details[4]);
		} catch(NumberFormatException e) {
			printDetails(details, isFirstError);
			printErrorLine(lineNumber, "Enter a valid Integer for year not " + details[4]);
			return false;
		}
		
		try {
			weight = Double.parseDouble(details[5]);
		} catch(NumberFormatException e) {
			printDetails(details, isFirstError);
			printErrorLine(lineNumber, "Enter a valid Double for weight not " + details[5]);
			return false;
		}
		
		//Set the Dog Object
		dog.setName(name);
		dog.setBreed(breed);
		dog.setMonth(month);
		dog.setDay(day);
		dog.setYear(year);
		dog.setBirthdate(month + "/" + day + "/" + year);
		dog.setWeight(weight);
		
		return true;
	}
	
	private static void printDetails(String[] details, boolean isFirstError) {
		if (details == null) return;
		
		if(true == isFirstError) {
			System.out.println("Error lines detected in File:");
			System.out.println();
		}
		
		for(String detail:details) {
			System.out.print(detail + "\t");
		}
		System.out.println();
	}
	
	private static void printErrorLine(int lineNumber, String errorString) {
		System.out.println(String.format("ERROR ON LINE #%d: %s.", lineNumber, errorString));
	}

	private static void oldestDog(ArrayList<Dog> dogs) {
		Iterator<Dog> itDogs = dogs.iterator();
		Dog oldestDog = dogs.get(0);
		while(itDogs.hasNext()){
			Dog temp = itDogs.next();
			if(temp.getYear() < oldestDog.getYear()){
				oldestDog = temp;
			}else if(temp.getYear() == oldestDog.getYear()){
				if(temp.getMonth() < oldestDog.getMonth()){
					oldestDog = temp;
				}else if(temp.getMonth() == oldestDog.getMonth()){
					if(temp.getDay() < oldestDog.getDay()){
						oldestDog = temp;
					}
				}
			}
		}
		System.out.println("Oldest Dog" + "\t\t\t" + oldestDog.getName() + "\t\t\t" + oldestDog.getBirthdate());

	}
	
	private static void youngestDog(ArrayList<Dog> dogs) {
		Iterator<Dog> itDogs = dogs.iterator();
		Dog youngestDog = dogs.get(0);
		while(itDogs.hasNext()){
			Dog temp = itDogs.next();
			if(temp.getYear() > youngestDog.getYear()){
				youngestDog = temp;
			}else if(temp.getYear() == youngestDog.getYear()){
				if(temp.getMonth() > youngestDog.getMonth()){
					youngestDog = temp;
				}else if(temp.getMonth() == youngestDog.getMonth()){
					if(temp.getDay() > youngestDog.getDay()){
						youngestDog = temp;
					}
				}
			}
		}
		System.out.println("Youngest Dog" + "\t\t\t" + youngestDog.getName() + "\t\t\t" + youngestDog.getBirthdate());

	}

	private static void longestNameDog(ArrayList<Dog> dogs) {
		Iterator<Dog> itDogs = dogs.iterator();
		Dog longestName = dogs.get(0);
		while(itDogs.hasNext()){
			Dog temp = itDogs.next();
			if(temp.getName().length() > longestName.getWeight()){
				longestName = temp;
			}
		}
		System.out.println("Longest Name" + "\t\t\t" + longestName.getName() + "\t\t\t" + longestName.getName().length());
	}
	
	private static void shortestNameDog(ArrayList<Dog> dogs) {
		Iterator<Dog> itDogs = dogs.iterator();
		Dog shortestName = dogs.get(0);
		while(itDogs.hasNext()){
			Dog temp = itDogs.next();
			if(temp.getName().length() < shortestName.getWeight()){
				shortestName = temp;
			}
		}
		System.out.println("Shortest Name" + "\t\t\t" + shortestName.getName() + "\t\t\t" + shortestName.getName().length());
	}

	private static void heaviestDog(ArrayList<Dog> dogs) {
		Iterator<Dog> itDogs = dogs.iterator();
		Dog heaviest = dogs.get(0);
		while(itDogs.hasNext()){
			Dog temp = itDogs.next();
			if(temp.getWeight() > heaviest.getWeight()){
				heaviest = temp;
			}
		}
		System.out.println("Heaviest" + "\t\t\t" + heaviest.getName() + "\t\t\t" + heaviest.getWeight());
	}

	private static void lightestDog(ArrayList<Dog> dogs) {
		Iterator<Dog> itDogs = dogs.iterator();
		Dog lightest = dogs.get(0);
		while(itDogs.hasNext()){
			Dog temp = itDogs.next();
			if(temp.getWeight() < lightest.getWeight()){
				lightest = temp;
			}
		}
		System.out.println("Lightest" + "\t\t\t" + lightest.getName() + "\t\t\t" + lightest.getWeight());
	}
	
	private static void commonBreed(ArrayList<Dog> dogs) {
		Iterator<Dog> itDogs = dogs.iterator();
		//Map that maintains unique Breeds and their count.
		Map<String, Integer> breedMap = new HashMap<String, Integer>();
		String commonBreed; //final answer kept here.
		
		while(itDogs.hasNext()){
			Dog tempDog = itDogs.next();
			String tempDogBreed = tempDog.getBreed();
			
			// If Map doesn't contain a Breed, add it to Map and initialize counter to 1
			if(!breedMap.containsKey(tempDogBreed)){
				breedMap.put(tempDogBreed, 1);
			} else {
				//If Map already contains a Breed, just increment the counter.
				breedMap.put(tempDogBreed, breedMap.get(tempDogBreed) + 1);
			}
		}
		
		commonBreed = mostCommonKeyInMap(breedMap);
		
		if (commonBreed != null) {
			//Print out the most common Breed
			System.out.println("Most Common breed" + "\t\t\t" + commonBreed);
		} else {
			// Execution shouldn't come here. If it comes here either the input map is null 
			// (or) something went wrong.
			System.out.println("Couldn't find a common Breed");
		}
	}
	
	private static void commonName(ArrayList<Dog> dogs) {
		Iterator<Dog> itDogs = dogs.iterator();
		//Map that maintains unique Names and their count.
		Map<String, Integer> nameMap = new HashMap<String, Integer>();
		String commonName; //final answer kept here.
		
		while(itDogs.hasNext()){
			Dog tempDog = itDogs.next();
			String tempDogName = tempDog.getName();
			
			// If Map doesn't contain a Name, add it to Map and initialize counter to 1
			if(!nameMap.containsKey(tempDogName)){
				nameMap.put(tempDogName, 1);
			} else {
				//If Map already contains a Name, just increment the counter.
				nameMap.put(tempDogName, nameMap.get(tempDogName) + 1);
			}
		}
		
		commonName = mostCommonKeyInMap(nameMap);
		
		if (commonName != null) {
			//Print out the most common Name
			System.out.println("Most Common Name" + "\t\t\t" + commonName);
		} else {
			// Execution shouldn't come here. If it comes here either the input map is null 
			// (or) something went wrong.
			System.out.println("Couldn't find a common Name");
		}
	}
	
	//Returns the Key with highest value in a Map.
	//If there is a tie, returns the alphabetically lowest Key having highest value.
	public static String mostCommonKeyInMap(Map<String, Integer> map) {
		Set<String> keySet = map.keySet();
		Iterator<String> keyIterator = keySet.iterator(); 
		String key;
		int commonValue = 0, keyValue;
		ArrayList<String> commonArray = new ArrayList(); //Maintains a list of Keys with same highest value.
		
		while(keyIterator.hasNext()){
			
			key = keyIterator.next();
			keyValue = map.get(key);
			
			if (keyValue > commonValue) {
				commonValue = keyValue;
				
				// A more highest commonValue found.
				// Re-initialize the commonArray and add the newly found key with highest commonValue;
				commonArray = new ArrayList();
				commonArray.add(key);
				
			} else if (keyValue == commonValue) {
				//Tie occured. Add it to the list of keys having same highest commonvalue.
				commonArray.add(key);
			}	
		}
		
		if (commonArray.size() > 0) {
			//Sort the keys which have the same highest commonValue.
			Collections.sort(commonArray);
			//return the alphabetically lowest Key.
			return commonArray.get(0);
		}
		
		return null;
	}
}
