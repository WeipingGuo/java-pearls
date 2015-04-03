package org.javapearls.cup.chapter1;

/**
 * Write a method to decide if two strings are anagrams or not.
 *
 * Definition of anagrams: An anagram is a rearrangement of the letters of
 * one word or phrase to form another word or phrase
 *
 * @author wguo
 *
 */
public class Question14 {


	public static boolean isAnagrams(String s, String t){

		// sanity check
		if (s == null || t == null || s.length() == 0 || t.length() == 0){
			throw new IllegalArgumentException("Null or empty strings");
		}

		// assume string contains alphabet only
		// and no difference for upper and lower cases
		int[] count = new int[26];

		// count the appearance of each letter
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);

			// skip non-letter
			if (!Character.isLowerCase(c) && !Character.isUpperCase(c)){
				continue;
			}
			count[Character.toLowerCase(c) - 'a']++;
		}

		// go through the second string
		for (int j = 0; j < t.length(); j++){
			char c = t.charAt(j);

			if (!Character.isLowerCase(c) && !Character.isUpperCase(c)){
				continue;
			}
			count[Character.toLowerCase(c) - 'a']--;
		}

		for (int i = 0; i < 26; i++){
			if (count[i] != 0){
				return false;
			}
		}

		return true;
	}



	/**
	 * The solution from the book. This would fail for the following:
	 *  String s = "The best things in life are free";
	 *	String t = "Nail-biting refreshes the feet";
	 * Therefore, it really depends on how strictly we define anagram
	 *
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean anagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] letters = new int[256];
		int num_unique_chars = 0;
		int num_completed_t = 0;
		char[] s_array = s.toCharArray();
		for (char c : s_array) { // count number of each char in s.
			if (letters[c] == 0)
				++num_unique_chars;
			++letters[c];
		}
		for (int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			if (letters[c] == 0) { // Found more of char c in t than in s.
				return false;
			}
			--letters[c];
			if (letters[c] == 0) {
				++num_completed_t;
				if (num_completed_t == num_unique_chars) {
					// it's a match if t has been processed completely
					return i == t.length() - 1;
				}
			}
		}
		return false;
	}

}
