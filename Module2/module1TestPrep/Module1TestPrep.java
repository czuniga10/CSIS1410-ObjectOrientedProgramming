package module1TestPrep;

import java.lang.StringBuilder;

/**
 * Coding Exercise to prepare for Module 1 test
 * 
 * @author Chad Z
 *
 */
public class Module1TestPrep {

	/**
	 * Removes leading and trailing spaces and
	 * duplicates every other letter starting with the first letter.
	 * Example: "abcde" => "aabccdee"
	 * Example: "   abcd" => "aabccd"
	 *
	 * 
	 * @param 	word string that will be modified
	 * @return	the modified string
	 */
	public static String modify(String str) {
		String word = str.trim();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			sb.append(c);
			
			if(i % 2 == 0) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
