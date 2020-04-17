package recursion;

import java.lang.StringBuilder;

/**
 * Recursion assignment class with 3 methods:
 * 	sumOfDigits
 * 	countSmiles
 * 	toUpper
 * 
 * @author Chad Z
 *
 */
public class Recursion {
	/**
	 * Each digit within the given param will be summed with the 
	 * concurrent digits. For example, if n = 1234, then the result
	 * will be 10 because 1+2+3+4 = 10
	 * 
	 * @param n		random integer digit
	 * @return		returns sum of each digit within n
	 */
	public static int sumOfDigits(int n) {
		n = Math.abs(n);
		if(n >= 10) {
			return n%10 + sumOfDigits(n/10);
		} else {
			return n;
		}
	}
	
	/**
	 * Counts the number of colons, directly followed by a closed parenthesis
	 * to make ascii smiley faces
	 * 
	 * @param letters		char array of letters
	 * @param index			used for knowing where you are in the array while 
	 * 							using recursion
	 * @return				returns count of smiley faces
	 */
	public static int countSmiles(char[] letters, int index) {
		int len = letters.length;
		if(len < 2 || index >= len) {
			return 0;
		}
		if(letters[index] == ':' && letters[index+1] == ')') {
			return 1 + countSmiles(letters,index+=2);
		}
		return countSmiles(letters, index+=1);
	}
	
	/**
	 * Takes in a string and returns each character within that string
	 * Capitalized with a space after.
	 * 
	 * @param str		given string to capitalize
	 * @return			returns capitalized result
	 */
	public static String toUpper(String str) {		
		StringBuilder sb = new StringBuilder();
		if(str.length() == 0) {
			return sb.toString();
		}
		if(str.charAt(0) >= 'A' && str.charAt(0) <= 'Z' || 
				str.charAt(0) >= 'a' && str.charAt(0) <= 'z') {
			sb.append(Character.toUpperCase(str.charAt(0)) + " ");
			return sb+toUpper(str.substring(1));
		} else {
			sb.append(str.charAt(0));
			return sb+toUpper(str.substring(1));
		}
	}
}
