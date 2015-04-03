package org.javapearls.algorithm.string;

import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class StringQuestions {


	/**
	 * Whether a string contains unique characters
	 *
	 * @param s
	 * @return
	 */
	public static boolean uniqueChars(String s){
	    if (s == null || s.isEmpty()) return true;

	    BitSet bs = new BitSet();
	    for (int i = 0; i < s.length(); i++){
	        if (bs.get(s.charAt(i))){
	            return false;
	        }else{
	            bs.set(s.charAt(i));
	        }
	    }
	    return true;
	}

	public static boolean containUniqueChars(String s){
	    if (s == null || s.isEmpty()) return true;
	    if (s.length() > 256) return false;

	    boolean[] charSet = new boolean[256];
	    for (int i = 0; i < s.length(); i++){
	        int val = s.charAt(i);
	        if (charSet[val] == true){
	            return false;
	        }
	        charSet[val] = true;
	    }
	    return true;
	}

	/**
	 * reverse string
	 *
	 * @param s
	 * @return
	 */
	public static String reverse(String s){
	    if (s == null) return null;
	    return new StringBuilder(s).reverse().toString();
	}

	public static String reverse2(String s){
	    if (s == null) return null;

	    char[] reversed = new char[s.length()];
	    int i = s.length() - 1, j = 0;
	    while (i >= 0){
	        reversed[j++] = s.charAt(i--);
	    }
	    return new String(reversed);
	}

	/**
	 * Given two strings, check whether they are permutation of
	 * each other
	 * count frequency of each character
	 * ignore white space
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isPermutation(String a, String b){
	    if (a == null && b == null) return true;
	    if (a == null || b == null) return false;

	    Map<Character, Integer> freqs =
	        new HashMap<Character, Integer>();

	    // count the frequency of each char
	    // skip white space
	    for (int i = 0; i < a.length(); i++){
	        if (a.charAt(i) == ' '){
	            continue;
	        }
	        Integer count = freqs.get(a.charAt(i));
	        if (count == null){
	            freqs.put(a.charAt(i), 1);
	        }
	        else{
	            freqs.put(a.charAt(i), ++count);
	        }
	    }

	    // check the second string
	    for (int j = 0; j < b.length(); j++){
	        if (b.charAt(j) == ' '){
	            continue;
	        }
	        Integer count = freqs.get(b.charAt(j));
	        if (count == null || count <= 0){
	            return false;
	        }
	        else {
	            freqs.put(b.charAt(j), --count);
	        }
	    }

	    // check the frequency map again.
	    for (Map.Entry<Character, Integer> entry : freqs.entrySet()){
	        if (entry.getValue() > 0){
	            return false;
	        }
	    }

	    return true;
	}

	public static String sort(String a){
	    if (a == null) return null;

	    char[] arr = a.toCharArray();
	    Arrays.sort(arr);
	    return new String(arr);
	}

	/**
	 * whether two strings are permutations of each other:
	 * sort two strings, then compare them
	 *
	 * @param a
	 * @param b
	 * @return
	 */
	public static boolean isPermutations(String a, String b){

		if (a == null && b == null){
	    	return true;
	    }
	    if (a == null || b == null) {
	    	return false;
	    }

	    a = a.replace(" ", "");
	    b = b.replace(" " , "");
	    return sort(a).equals(sort(b));
	}

	public static boolean isPermut(String a, String b){

	    if (a == null && b == null){
	        return true;
	    }
	    if (a == null || b == null){
	        return false;
	    }

	    // count the frequency of each character
	    int[] freq = new int[256];
	    for (int i = 0; i < a.length(); i++){
	        if (a.charAt(i) == ' '){
	            continue;
	        }
	        freq[(int)a.charAt(i)]++;
	    }

	    for (int j = 0; j < b.length(); j++){
	        if (b.charAt(j) == ' '){
	            continue;
	        }
	        if (--freq[(int)b.charAt(j)] < 0){
	            return false;
	        }
	    }

	    for (int i = 0; i < 256; i++){
	    	if (freq[i] > 0){
	    		return false;
	    	}
	    }
	    return true;
	}


	/**
	 * replace white space with %20
	 */
	public static void encode(char[] a, int len){

	    // count how many white space do we have
	    int total = 0;
	    for (int i = 0; i < len; i++){
	        if (a[i] == ' '){
	            total++;
	        }
	    }

	    // how many extra space do we need
	    int newLen = len + total * 2;
	    while (--len >= 0){
	        if (a[len] == ' '){
	            a[--newLen] = '0';
	            a[--newLen] = '2';
	            a[--newLen] = '%';
	        }
	        else{
	            a[--newLen] = a[len];
	       }
	    }
	}

	/**
	 * compress string, aabccccaaa==>a2b1c4a3
	 */
	public static String compress(String s){
	    if (s == null || s.length() == 1) return s;

	    StringBuilder sb = new StringBuilder();
	    int i = 0;
	    while (i < s.length()){
	        char c = s.charAt(i);
	        int count = 1;
	        while (++i <s.length() && s.charAt(i) == c){
	            count++;
	        }
	        sb.append(c);
	        sb.append(count);
	    }

	    String compressed = sb.toString();
	    if (compressed.length() >= s.length()){
	        return s;
	    }else{
	        return compressed;
	    }
	}

	/**
	 * Given two words (start and end), and a dictionary,
	 * find the length of shortest transformation sequence from start to end, such that:
	 *
	 * Only one letter can be changed at a time
	 * Each intermediate word must exist in the dictionary
	 * For example,
	 * Given:
	 * start = "hit"
	 * end = "cog"
	 * dict = ["hot","dot","dog","lot","log"]
	 *
	 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	 * return its length 5.
	 * Note:
	 * Return 0 if there is no such transformation sequence.
	 * All words have the same length.
	 * All words contain only lowercase alphabetic characters.
	 */
	public static void wordLadder(){

	}

	/**
	 * Given a string S, find the longest palindromic substring in S.
	 *
	 * The following code IS NOT CORRECTLY IMPLEMENTED
	 *
	 * @param s
	 * @return
	 */
	public static String longestPalindrom(String s){
		if (s == null || s.length() == 1){
			return s;
		}
		char[] charArray = s.toCharArray();
		return new String(longestPalindrom(charArray, 0, charArray.length - 1));
	}
	public static char[] longestPalindrom(char[] array, int left, int right){
		if (left >= right) return array;

		int middle = (left + right)/2;
		char[] longestL = longestPalindrom(array, left, middle);
		char[] longestR = longestPalindrom(array, middle + 1, right);

		// longest cross middle point
		int i = middle - 1, j = middle + 1;
		StringBuilder sb = new StringBuilder();
		while (i >= left && j <= right){
			if (array[i] == array[j]){
				i--;
				j++;
				sb.append(array[i]);
			}else{
				break;
			}
		}

		String longestMiddle = sb.toString();
		longestMiddle = sb.reverse().toString() + array[middle] + longestMiddle;
		char[] longestM = longestMiddle.toCharArray();

		if (longestL.length > longestR.length){
			if (longestL.length > longestM.length){
				return longestL;
			}else{
				return longestM;
			}
		}else {
			if (longestR.length > longestM.length){
				return longestR;
			}else{
				return longestM;
			}
		}

	}


}
