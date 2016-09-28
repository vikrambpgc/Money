package MorseTranslator;

import java.util.HashMap;

public class MorseInfo {
	private enum MorseCode {
		A('A', "doda"),
		B('B', "dadododo"),
		C('C', "dadodado"),
		D('D', "dadodo"),
		E('E', "do"),
		F('F', "dododado"),
		G('G', "dadado"),
		H('H', "dodododo"),
		I('I', "dodo"),
		J('J', "dodadada"),
		K('K', "dadoda"),
		L('L', "dodadodo"),
		M('M', "dada"),
		N('N', "dado"),
		O('O', "dadada"),
		P('P', "dodadado"),
		Q('Q', "dadadoda"),
		R('R', "dodado"),
		S('S', "dododo"),
		T('T', "da"),
		U('U', "dododa"),
		V('V', "dodododa"),
		W('W', "dodada"),
		X('X', "dadododa"),
		Y('Y', "dadodada"),
		Z('Z', "dadadodo"),
		ONE('1', "dodadadada"),
		TWO('2', "dododadada"),
		THREE('3', "dodododada"),
		FOUR('4', "dododododa"),
		FIVE('5', "dododododo"),
		SIX('6', "dadodododo"),
		SEVEN('7', "dadadododo"),
		EIGHT('8', "dadadadodo"),
		NINE('9', "dadadadado"),
		ZERO('0', "dadadadada"),
		PERIOD('.', "dodadodadoda"),
		COMMA(',', "dadadododada"),
		QUESTION_MARK('?', "dododadadodo"),
		FORWARD_SLASH('/', "dadododado"),
		AT_THE_RATE('@', "dodadadodado");
		
		private char letter;
		private String morseEquivalent;
		
		private MorseCode(char letter, String morseEquivalent) {
			this.letter = letter;
			this.morseEquivalent = morseEquivalent;
		}
		
		public char getCharacter() {
			return this.letter;
		}
		
		public String getMorseEquivalant() {
			return this.morseEquivalent;
		}
	}
	
	public static HashMap<Character, String> forwardMap; //char to Morse Code Hashmap
	public static HashMap<String, Character> reverseMap; //MorseCode to char Hashmap
	
	static {
		forwardMap = new HashMap<Character, String>();
		reverseMap = new HashMap<String, Character>();
		
		for (MorseCode temp: MorseCode.values()) {
			forwardMap.put(temp.getCharacter(), temp.getMorseEquivalant());
			reverseMap.put(temp.getMorseEquivalant(), temp.getCharacter());
		}
	}
}
