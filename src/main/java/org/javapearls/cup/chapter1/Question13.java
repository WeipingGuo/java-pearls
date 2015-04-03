package org.javapearls.cup.chapter1;

import java.util.Arrays;
import java.util.BitSet;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional buffer.
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * FOLLOW UP
 * Write the test cases for this method.
 *
 * @author wguo
 *
 */
public class Question13 {

	/**
	 * Removed duplicated chars for a given string
	 *
	 * @param s
	 * @return
	 */
	public static String removeDuplicate(String s){

		// sanity check
		if (s == null || s.length() <= 1){
			return s;
		}

		StringBuilder sb = new StringBuilder();
		BitSet bs = new BitSet(256);
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if (!bs.get((int)c)) {
				sb.append(c);
				bs.set((int)c);
			}
		}

		return sb.toString();
	}

	/**
	 * For Java, once array is allocated, the length cannot be changed.
	 * The only way is to create a new array
	 *
	 * @param s
	 * @return
	 */
	public static char[] removeDuplicateChar(char[] s){

		// sanity check
		if (s == null || s.length <= 1){
			return s;
		}

		int tail = 0;
		BitSet	bs = new BitSet(256);
		for (int i = 0; i < s.length; i++){
			char c = s[i];
			if (!bs.get((int)c)){
				bs.set((int)c);
				s[tail++]= c;
			}
		}

		return Arrays.copyOfRange(s, 0, tail);
	}


	/**
	 * Remove duplicated characters without extra storage
	 *
	 * @param s
	 * @return
	 */
	public static char[] removeDuplicates(char[] s){

		if (s == null || s.length == 0){
			throw new IllegalArgumentException("Null or empty array");
		}

		if (s.length == 1){
			return s;
		}

		int tail = 0;
		for (int i = 0; i < s.length; i++){
			boolean duplicated = false;
			for (int j = 0; j < tail; j++){
				if (s[i] == s[j]){
					duplicated = true;
					break;
				}
			}

			if (!duplicated){
				s[tail++] = s[i];
			}
		}

		return Arrays.copyOfRange(s, 0, tail);
	}


}
