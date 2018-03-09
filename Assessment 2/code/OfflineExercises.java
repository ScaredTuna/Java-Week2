package code;

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;

public class OfflineExercises {

	// Given a string, return a string where
	// for every char in the original,
	// there are two chars.

	// doubleChar("The") → "TThhee"
	// doubleChar("AAbb") → "AAAAbbbb"
	// doubleChar("Hi-There") → "HHii--TThheerree"

	public String doubleChar(String input) {
		String[] letters = input.split("");
		String output = "";
		for(String letter:letters){
		    output += letter + letter;
        }
		return output;
	}
	//
	// A sandwich is two pieces of bread with something in between. Return the
	// string that is between the first and last appearance of "bread" in the
	// given string, or return the empty string "" if there are not two pieces
	// of bread.

	// getSandwich("breadjambread") → "jam"
	// getSandwich("xxbreadjambreadyy") → "jam"
	// getSandwich("xxbreadyy") → ""

	public String getSandwich(String input) {
		String output = "";
		String bread = "bread";
		String postBread = input.substring(input.indexOf(bread) + bread.length(), input.length());
		if(postBread.contains(bread)) {
			output = postBread.substring(0, postBread.indexOf(bread));
		}
		return output;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large.

	// evenlySpaced(2, 4, 6) → true
	// evenlySpaced(4, 6, 2) → true
	// evenlySpaced(4, 6, 3) → false

	public boolean evenlySpaced(int a, int b, int c) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		values.add(a);
		values.add(b);
		values.add(c);
		Collections.sort(values);
		if(values.get(1) - values.get(0) == values.get(2) - values.get(1)) {
			return true;
		} else {
			return false;
		}
	}

	// Given a string and an int n, return a string made of the first and last n
	// chars from the string. The string length will be at least n.

	// nTwice("Hello", 2) → "Helo"
	// nTwice("Chocolate", 3) → "Choate"
	// nTwice("Chocolate", 1) → "Ce"

	public String nTwice(String input, int a) {
		return input.substring(0, a) + input.substring(input.length() - a, input.length());
	}

	// Given a string, return true if it ends in "ly".

	// endsLy("oddly") → true
	// endsLy("y") → false
	// endsLy("oddy") → false

	public boolean endsly(String input) {
		String endsWith = "";
		if(input.length() > 1) {
			endsWith = input.substring(input.length() - 2, input.length());
		}
		if(endsWith.equalsIgnoreCase("ly")) {
			return true;
		} else {
			return false;
		}
	}

	// Given a string, return recursively a "cleaned" string where adjacent
	// chars that are the same have been reduced to a single char. So "yyzzza"
	// yields "yza".

	// stringClean("yyzzza") → "yza"
	// stringClean("abbbcdd") → "abcd"
	// stringClean("Hello") → "Helo"
	public String stringClean(String input) {
		String cleanedString = "";
		String trimmedString = "";
		if(input.length() > 1) {
			trimmedString = input.substring(1, input.length());
		}
		if(input.length() > 1 && input.charAt(0) == input.charAt(1)) {
			cleanedString += stringClean(trimmedString);
		} else if(input.length() > 1){
			cleanedString += input.charAt(0) + stringClean(trimmedString);	
		} else {
			cleanedString += input;
		}
		return cleanedString;
	}

	// The fibonacci sequence is a famous bit of mathematics, and it happens to
	// have a recursive definition. The first two values in the sequence are 0
	// and 1 (essentially 2 base cases). Each subsequent value is the sum of the
	// previous two values, so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13,
	// 21 and so on. Define a recursive fibonacci(n) method that returns the nth
	// fibonacci number, with n=0 representing the start of the sequence.

	// fibonacci(0) → 0
	// fibonacci(1) → 1
	// fibonacci(2) → 1

	public int fibonacci(int input) {
		int sequenceValue = 0;
		if(input > 1) {
			sequenceValue += fibonacci(input - 1) + fibonacci(input - 2);
		} else if(input == 1) {
			sequenceValue++;
		}
		return sequenceValue;
	}

	// We have a number of bunnies and each bunny has two big floppy ears. We
	// want to compute the total number of ears across all the bunnies
	// recursively (without loops or multiplication).
	//
	// bunnyEars(0) → 0
	// bunnyEars(1) → 2
	// bunnyEars(2) → 4

	public int bunnyEars(int input) {
		int numEars = 0;
		if(input > 0) {
			numEars += 2 + bunnyEars(input - 1);
		}
		return numEars;
	}

}
