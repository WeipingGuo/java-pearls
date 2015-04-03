package org.javapearls.cup.chapter1;


/**
 * Write a method to replace all spaces in a string with "%20".
 *
 * @author wguo
 *
 */
public class Question15 {

	/** The Constant ENCODED_SPACE. */
	private static final String ENCODED_SPACE = "%20";

	/**
	 * Encode white space using '%20'
	 *
	 * @param s
	 * @return
	 */
	public static String encode(String s){

		// sanity check
		if (s == null || s.length() == 0){
			throw new IllegalArgumentException("Null or empty string.");
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++){
			if (Character.isWhitespace(s.charAt(i))){
				sb.append(ENCODED_SPACE);
			}
			else {
				sb.append(s.charAt(i));
			}
		}

		return sb.toString();
	}

	/**
	 * Replace whitespace with '%20'
	 *
	 * @param s
	 * @return
	 */
	public static char[] replaceWhiteSpace(char[] s){

		if (s == null || s.length == 0){
			throw new IllegalArgumentException("Null or empty char array.");
		}

		return replace(s, ' ', new char[]{'%', '2', '0'});
	}

	/**
	 * Replace.
	 *
	 * @param s the s
	 * @param c the c
	 * @param replaced the replaced
	 * @return the char[]
	 */
	private static char[] replace(char[] s, char c, char[] replaced){

		// count how many char 'c' in the original array
		int occurance = 0;
		for (int i = 0; i < s.length; i++){
			if (s[i] == c){
				occurance++;
			}
		}

		// create a new array
		int newLength = s.length + occurance *(replaced.length - 1);
		char[] newArray = new char[newLength];

		int j = 0;
		int i = 0;
		while (i < s.length){
			if (s[i] == c){
				// replace with designated char array
				for (int w = 0; w < replaced.length; w++){
					newArray[j++] = replaced[w];
				}
			}
			else{
				newArray[j++] = s[i];
			}
			i++;
		}

		return newArray;
	}

}
