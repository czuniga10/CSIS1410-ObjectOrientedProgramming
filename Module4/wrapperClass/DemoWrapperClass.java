package wrapperClass;

import java.util.Arrays;
import java.util.Random;

/**
 * Demo Class for the Wrapper Class Lab
 * 
 * @author Chad Z
 */
public class DemoWrapperClass {
	static Random rand = new Random();
	
	/**
	* Demonstrates the functionality provided in class DemoWrapperClass.
	*
	*/
	public static void main(String[] args) {

	// Method minMax:
	System.out.println(minMax());
	System.out.println();


	// Method numberRepresentations:
	int[] numbers = { 9, 17, getRandomThreeDigitNumber(), 9876, 12345};

	System.out.printf("%-7s %-7s %-6s %s%n", "Base 10", "Base 16", "Base 8", "Base 2");
	System.out.printf("%-7s %-7s %-6s %s%n", "-------", "-------", "------", "------");
	for(int n : numbers) {
	System.out.println(numberRepresentations(n));
	}
	System.out.println();

	// Method charProperties:
	char[] characters = {'8', ' ', '#', 'a', 'M', getRandomLetter()};

	for(char c : characters) {
	System.out.println(charProperties(c));
	}
	System.out.println();

	// Method parse:
	String[] numberArray = {"1.1", "2.5", "3.14","40.04", "5.325", "63.5"};

	String[] wholeNumbers = new String[10];
	for(int i = 0; i < wholeNumbers.length; i++) {
	wholeNumbers[i] = "" + (rand.nextInt(90) + 10);
	}

	System.out.println(Arrays.deepToString(numberArray)
	+ " .. sum = " + parseSum(numberArray));

	}
	
	/**
	 * Returns Min/Max values of each of the Primitive types.
	 * 
	 * @return		Returns String of min/max values.
	 */
	public static String minMax() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Byte   : [%s , %s]%n", 
				Byte.MIN_VALUE,Byte.MAX_VALUE));
		sb.append(String.format("Short  : [%s , %s]%n", 
				Short.MIN_VALUE,Short.MAX_VALUE));
		sb.append(String.format("Integer: [%s , %s]%n", 
				Integer.MIN_VALUE,Integer.MAX_VALUE));
		sb.append(String.format("Long   : [%s , %s]%n", 
				Long.MIN_VALUE,Long.MAX_VALUE));
		sb.append(String.format("Float  : [%s , %s]%n", 
				Float.MIN_VALUE,Float.MAX_VALUE));
		sb.append(String.format("Double : [%s , %s]", 
				Double.MIN_VALUE,Double.MAX_VALUE));
		return sb.toString();
	}
	
	/**
	 * Formats and returns a string of a given number represented in base 10,
	 * 16,8, and 2.
	 * 
	 * @param x		Number to show base x representation.
	 * @return		Returns String of numberRepresentations result.
	 */
	public static String numberRepresentations(int x) {
		return String.format("%-7s  %-7s  %-7s %-7s", Integer.toString(x, 10),
													  Integer.toHexString(x),
													  Integer.toOctalString(x),
													  Integer.toBinaryString(x));
	}
	
	/**
	 * Formats and returns a string of a given char and if its an Upper, Lower,
	 * whitespace or a number.
	 * 
	 * @param c		Char to return if its Upper,Lower,whitespace, or a number.
	 * @return		Returns String of char plus if its Upper,Lower,
	 * whitespace, or a number.
	 */
	public static String charProperties(char c) {
		StringBuilder sb = new StringBuilder();
		sb.append(c+" ");
		if(Character.isLowerCase(c)) {
			sb.append("lowercase letter");
		}
		if(Character.isUpperCase(c)) {
			sb.append("uppercase letter");
		}
		if(Character.isWhitespace(c)) {
			sb.append("white space");
		}
		if(Character.isDigit(c)) {
			sb.append("number");
		}
		return sb.toString();
	}
	
	/**
	 * Converts the String array items to doubles and returns the sum.
	 * 
	 * @param arr		Array of Doubles in String format.
	 * @return			Returns sum of the doubles in arr
	 */
	public static double parseSum(String[] arr) {
		double result = 0;
		for(String el:arr) {
			result += Double.parseDouble(el);
		}
		return result;
	}

	/**
	 * Returns random int value: 100 > 999
	 * 
	 * @return		Random Int value.
	 */
	public static int getRandomThreeDigitNumber() {
		return rand.nextInt(900) + 100;
	}
	
	/**
	 * Returns random char between (A-Z,a-z).
	 * 
	 * @return		Random Char value.
	 */
	public static char getRandomLetter() {
		int random = rand.nextInt(57)+'A';
		while(random > 'Z' && random < 'a') {
			random = rand.nextInt(57)+'A';
		}
		return Character.toChars(random)[0];
	}
}
