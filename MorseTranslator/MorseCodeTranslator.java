package MorseTranslator;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class MorseCodeTranslator {
	
	/**
	 * boolean that denotes if Program should translate
	 * from Morse to English (or) vice versa.
	 */
	private boolean translateMorseToEnglish;
	
	
	public MorseCodeTranslator() {
		translateMorseToEnglish = true;
	}
	
	public String translate(String input) {
		String output = "";
		
		
		 //If the input is Morse code, 'decodedMorseText' will have the English output.
		ArrayList<Character> decodedMorseText =  new ArrayList<Character>();
		
		if (input != null) {
			//The decision to whether Morse->English (or) English->Morse is decided
			//in processInput itself. If it is Morse->English 'decodedMorseText' will
			//have the English output.

			translateMorseToEnglish = processInput(input, decodedMorseText);
		}
		
		if (translateMorseToEnglish == true) {
			//Decode(d) Morse to English. (Decoding done in processsInput itself).
			//Process the decoded output here.
			
			output = processDecodedMorse(decodedMorseText);	
		} else {
			//Encode English to Morse
			
			output = encodeToMorse(input);
		}

		return output;
	}
	
	/**
	 * Decides whether to translate Morse->English (or) English->Morse.
	 * If it is Morse->English 'decodedMorseText' will have the English output.
	 */
	private boolean processInput(String input, ArrayList<Character> decodedMorseText) {
		String[] wordEquivalents; //Morse equivalents of a word.
		String[] letterEquivalents; //Say letter is 'S', "dododo" is letter equivalent.
		Character tempChar;
		
		//First, split 'Morse code' string, word equivalent by word equivalent
		wordEquivalents = input.split("spspsp");
		
		for(String tokenWord:wordEquivalents) {
			if (false == tokenWord.isEmpty()) {
				letterEquivalents = tokenWord.split("sp");
				
				//Split 'Morse code' word, letter equivalent by letter equivalent.
				for(String tokenLetter:letterEquivalents) {
					tempChar = MorseInfo.reverseMap.get(tokenLetter);
					if (tempChar != null) {
						//The letter equivalent is present in Morse code dictionary.So valid letter.
						//Add to the output.
						decodedMorseText.add(tempChar);
					} else {
						//If the letter equivalent is not there in Morse Dictionary,
						//it means, this is not morse code and hence input is in English.
						//So return false.
						
						return false;
					}
				}
				
				//After each processed word add an Empty space.
				decodedMorseText.add(' ');
			}
		}
		
		//We have processed valid morse code.So translate from Morse->English.Return true.
		return true;
	}

	/**
	 * Process the Morse to English decoded output here.
	 * @param decodedMorseText
	 * @return
	 */
	private String processDecodedMorse(ArrayList<Character> decodedMorseText) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for(Character token: decodedMorseText) {
			stringBuilder.append(token);
		}
		
		return stringBuilder.toString().trim();
	}
	
	/**
	 * Encodes English to Morse Code.
	 */
	private String encodeToMorse(String input) {
		
		char[] inputCharArray = input.toCharArray();
		StringBuilder stringBuilder = new StringBuilder();
		
		int arrayLength = inputCharArray.length;
		
		for(int i = 0;i < arrayLength; i++) {
			if (inputCharArray[i] != ' ') {
				//Get the Morse equivalent of character.
				stringBuilder.append(MorseInfo.forwardMap.get(inputCharArray[i]));
				
				//Unless the character is last letter of the sentence (or) word,
				// add "sp" to each encoded letter.
				if ((i+1 < arrayLength) && (inputCharArray[i+1] != ' ')) {
					stringBuilder.append("sp");
				}
			} else {
				//If the character is empty space, append "spspsp"
				stringBuilder.append("spspsp");
			}
		}
		
		return stringBuilder.toString().trim();
	}
	
	public static void main(String[] args) {
		String inputSentence = "";
		String outputSentence = "";
		MorseCodeTranslator morseCodeTranslator = new MorseCodeTranslator();

		String inputFile = "MorseCodeInput.txt";
		String outputFile = "MorseCodeOutput.txt";
		
		Scanner sc = null;
		
		try{
			sc = new Scanner(new File(inputFile));
		}catch(Exception e){
			System.out.println("File not found.");
			System.exit(1);
		}
		
		if (sc.hasNextLine()) {
			inputSentence = sc.nextLine();
		} else {
			System.out.println("Empty file.");
			System.exit(1);
		}
		//End of reading input.
		//----------------------------------------------
		
		//Translate
		outputSentence = morseCodeTranslator.translate(inputSentence);
		
        //----------------------------------------------
		//Write output to the "outputFile"
		File file = new File(outputFile);

		try {
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(outputSentence);
			bw.close();
		} catch(Exception e) {
			System.out.println("Couldn't write output to file!!");
			System.out.println("However, output is" + outputSentence);
		}	
	}
}