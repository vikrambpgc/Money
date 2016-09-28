package Compression;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * Guiding on only the core functions compress & decompress.
 * This written lesson is only for your guidance and not for doing the whole work for you.
 * Please let me know if you need guidance on how to take arguments from command line and read/write to file.
 */

public class Compression {
	public static void main(String[] args) {
		String input = "aaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
		String output = "";
		
		//Compress the input
		output = compress(input);
		System.out.println("Compressed string:" + output + "\n");
		
		//Decompress the above output and verify if the decompressed string matches input.
		System.out.println("       Input String: " + input);
		output = decompress(output);
		System.out.println("Decompressed String: " + output + "\n");
		
		if (input.equals(output)) {
			System.out.println("Compression & Decompression happened successfully");
		} else {
			System.out.println("Compressions (or) Decompression failed");
		}
	}
	
	/**
	 * Compress the input string.
	 */
	public static String compress(String input) {
		StringBuilder output = new StringBuilder();
		char[] inputArray = input.toCharArray();
		
		//Preserves the order of characters in the string, and, at the same time keeps track of count of each character.
		//It's like if 'a' occurs 10 times, 'b' occurs 36 times, map will have in order, ('a', 10) & ('b', 36) like that.
		LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		
		//Construct the map and set the count for each character.
		for(Character character: inputArray) {
			if (true == map.containsKey(character)) {
				map.put(character, map.get(character) + 1);
			} else {
				map.put(character, 1);
			}
		}
		
		
		Set<Character> set = map.keySet();
		for(Character character:set) {		
			//Below statement, if commented out, gives count of each Character in Input. (For debugging purposes)
			//System.out.println(character + ":" + map.get(character));
			
			//create the compressed string for each Entry in the map and append it to the final output.
			//That is if an entry is ('a', 9) it returns 'a9' which gets appended to the final output.
			output.append(encodeCountToString(character, map.get(character)));
		}
		
		return output.toString();
	}
	
	/*
	 * Encodes each character run
	 * That is if an entry is ('a', 9) it returns 'a9' which gets appended to the final output.
	 */
	public static String encodeCountToString(Character character, int count) {
		String output = "";

		if (count >0 && count <=9) {
			//Deals with the case of count is 0-9
			output = character.toString() + Integer.toString(count);
		} else if (count > 9 && count <= 35) {
			//Deals with the case of count 10-35 (Outputs 'A'(~10 count)-'Z'(~35 count)
			//that is if 'a' appeared 10 times, output will be "aA"
			output = character.toString() + (char) ('A' + (count - 9) - 1);
		} else if (count > 35 && count <=61) {
		    //Deals with the case of count 36-61 (Outputs 'a'(~36 count)-'z'(~61 count)
			//that is if 'a' appeared 37 times, output will be "ab"
			output = character.toString() + (char) ('a' + (count - 35) - 1);
		} else if (count > 61) {
			//If the count is more than 61, append the 'z' and recursively solve for the extra count.
			//that is if 'a' appeared 62 times, output will be "aza1"
			output = character.toString() + 'z' + encodeCountToString(character, count - 61);
		}
		
		return output;
	}
	
	//Decompress the compressed string
	public static String decompress(String input) {
		StringBuilder output = new StringBuilder();
		char[] inputArray = input.toCharArray();
		int inputArrayLength = inputArray.length;
		
		Character character = ' ';
		int characterCount = 0;
		
		//Read 2 characters at a time from the input string.
		for(int i = 0; i < inputArrayLength; i = i + 2) {
			character = inputArray[i];
			
			//Get the count from the second character of the pair.
			characterCount = decodeCharacterToCount(inputArray[i+1]);
			
			//Below statement, if commented out, gives count of each Character in compressed string. (For debugging purposes)
			//System.out.println(character.toString() + ":" + characterCount);
			
			//Add 'character', 'characterCount' times to the Output.
			for (int j = 0; j < characterCount; j++) {
				output.append(character);
			}	
		}
		
		return output.toString();
	}
	
	//turn a character to count according to rules.
	//that is, 1-9 ~ 1-9, A-Z to 10-35, a-z to 36-61
	public static int decodeCharacterToCount(Character character) {
		int count = 0;
		
		if (Character.isDigit(character)) {
			count = Integer.parseInt(character.toString());			
		} else if (Character.isUpperCase(character)) {
			count = 9 + character - 'A' + 1;
		} else if (Character.isLowerCase(character)) {
			count = 35 + character - 'a' + 1;
		}
		
		return count;
	}
	
	public static void usage() {
		//Usage here
	}
}
