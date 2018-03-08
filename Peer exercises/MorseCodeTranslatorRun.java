
public class MorseCodeTranslatorRun {

	public static void main(String[] args) {
		TranslatorLogic translator = new TranslatorLogic();
		String message = ".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.--";
		System.out.println(translator.translateFromMorse(message));
		message = "this is a test sentence to morse code";
		System.out.println(translator.translateToMorse(message));
	}

}
