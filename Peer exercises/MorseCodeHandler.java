
public class MorseCodeHandler {
	
	
	public String[] sentenceSplitter(String message) {
		String [] wordArray = message.split(" / ");
		return wordArray;	
	}
	
	public String[] wordSplitter(String word) {
		String [] letterArray = word.split(" ");
		return letterArray;
	}
	
	public String [] getWordTranslator(String [] letterArray, MorseCodeTranslator translator) {
		for(int i = 0; i < letterArray.length; i++) {
			letterArray[i] = translator.translateLetter(letterArray[i]);
		}
		return letterArray;
	}
	
	public String letterCombiner(String[] letterArray) {
		String word ="";
		for(String letter: letterArray) {
			word += letter;
		}
		return word;
	}
	
	public String wordCombiner(String[] wordArray) {
		String message = "";
		for(String word: wordArray) {
			message += word + " ";
		}
		return message;
	}
	
	public String[] characterSentenceSplitter(String message) {
		String [] wordArray = message.split(" ");
		return wordArray;	
	}
	
	public String[] characterWordSplitter(String word) {
		String [] letterArray = word.split("");
		return letterArray;
	}
	
	public String morseLetterCombiner(String[] letterArray) {
		String word ="";
		for(String letter: letterArray) {
			word += letter + " ";
		}
		return word;
	}
	
	public String morseWordCombiner(String[] wordArray) {
		String message = "";
		for(String word: wordArray) {
			message += word + " / ";
		}
		return message;
	}

}
