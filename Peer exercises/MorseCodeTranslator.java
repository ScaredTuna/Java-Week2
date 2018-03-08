import java.util.HashMap;

public class MorseCodeTranslator {

	private final HashMap<String, String> translator = new HashMap<>();

	public MorseCodeTranslator() {
		super();
		translator.put(".-", "a");
		translator.put("-...", "b");
		translator.put("-.-.", "c");
		translator.put("-..", "d");
		translator.put(".", "e");
		translator.put("..-.", "f");
		translator.put("--.", "g");
		translator.put("....", "h");
		translator.put("..", "i");
		translator.put(".---", "j");
		translator.put("-.-", "k");
		translator.put(".-..", "l");
		translator.put("--", "m");
		translator.put("-.", "n");
		translator.put("---","o");
		translator.put(".--.", "p");
		translator.put("--.-", "q");
		translator.put(".-.", "r");
		translator.put("...", "s");
		translator.put("-", "t");
		translator.put("..-", "u");
		translator.put("...-", "v");
		translator.put(".--", "w");
		translator.put("-..-", "x");
		translator.put("-.--", "y");
		translator.put("--..", "z");
		translator.put("a", ".-");
		translator.put("b", "-...");
		translator.put("c", "-.-.");
		translator.put("d", "-..");
		translator.put("e", ".");
		translator.put("f", "..-.");
		translator.put("g", "--.");
		translator.put("h", "....");
		translator.put("i", "..");
		translator.put("j", ".---");
		translator.put("k", "-.-");
		translator.put("l", ".-..");
		translator.put("m", "--");
		translator.put("n", "-.");
		translator.put("o","---");
		translator.put("p", ".--.");
		translator.put("q", "--.-");
		translator.put("r", ".-.");
		translator.put("s", "...");
		translator.put("t", "-");
		translator.put("u", "..-");
		translator.put("v", "...-");
		translator.put("w", ".--");
		translator.put("x", "-..-");
		translator.put("y", "-.--");
		translator.put("z", "--..");
	}
	
	public String translateLetter(String letter) {
		return translator.get(letter);
	}
	
}
