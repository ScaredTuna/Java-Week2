
public class TranslatorLogic {
	
	MorseCodeTranslator translator = new MorseCodeTranslator();
	MorseCodeHandler handler = new MorseCodeHandler();
	
	public String translateFromMorse(String message) {
		String[] words = handler.sentenceSplitter(message);
		for(int i = 0; i < words.length; i++) {
			String[] letters = handler.wordSplitter(words[i]);
			letters = handler.getWordTranslator(letters, translator);
			words[i] = handler.letterCombiner(letters);
		}
		message = handler.wordCombiner(words);
		return message;
	}
	
	public String translateToMorse(String message) {
		String[] words = handler.characterSentenceSplitter(message);
		for(int i = 0; i < words.length; i++) {
			String[] letters = handler.characterWordSplitter(words[i]);
			letters = handler.getWordTranslator(letters, translator);
			words[i] = handler.morseLetterCombiner(letters);
		}
		message = handler.morseWordCombiner(words);
		return message;
	}

}


