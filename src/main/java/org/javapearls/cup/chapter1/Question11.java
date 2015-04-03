package org.javapearls.cup.chapter1;

import java.util.BitSet;
import java.util.HashMap;


/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 * @author wguo
 *
 */
public class Question11 {


	/**
	 * Check whether a string contains unique characters only
	 *
	 * @param s
	 * @return
	 */
	public static boolean containsUniqueChars(String s){

		// sanity check
		if (s == null || s.isEmpty()){
			throw new IllegalArgumentException("String is null or empty");
		}

		// single element string return 'true' right away
		if (s.length() == 1){
			return true;
		}

		HashMap<Character, Integer> map =
			new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++){
			if (map.containsKey(s.charAt(i))){
				return false;
			}
			map.put(s.charAt(i), 1);
		}

		return true;
	}


	/**
	 * Use a BitSet
	 * @param s
	 * @return
	 */
	public static boolean containsUniqueChars2(String s){

		if (s == null || s.isEmpty()){
			throw new IllegalArgumentException("Null or empty string");
		}

		if (s.length() == 1){
			return true;
		}

		BitSet bs = new BitSet(256);
		for (int i = 0; i < s.length(); i++){
			int k = s.charAt(i);
			if (bs.get(k)){
				return false;
			}
			else {
				bs.set(k);
			}
		}

		return true;
	}

	/**
	 * Naive algorithm: check every char: n^2
	 *
	 * @param s
	 * @return
	 */
	public static boolean containsUniqueCharsNaive(String s){

		if (s == null || s.isEmpty()){
			throw new IllegalArgumentException("Null or empty string");
		}

		if (s.length() == 1){
			return true;
		}

		for (int i = 0; i < s.length() - 1; i++){
			if (containsChar(s, s.charAt(i), i+1, s.length()-1)){
				return false;
			}
		}
		return true;
	}

	private static boolean containsChar(String s, char c, int fromIndex, int toIndex){
		for (int i = fromIndex; i <= toIndex; i++){
			if (s.charAt(i) == c){
				return true;
			}
		}
		return false;
	}

}
