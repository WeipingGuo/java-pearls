package org.javapearls.algorithm.oj;


/**
 * http://www.careercup.com/question?id=6287528252407808
 *
 * A k-palindrome is a string which transforms into a palindrome on removing at most k characters.
 *
 * Given a string S, and an interger K, print "YES" if S is a k-palindrome; otherwise print "NO".
 * Constraints:
 * S has at most 20,000 characters.
 * 0<=k<=30
 *
 *  Sample Test Case#1:
 *  Input - abxa 1
 *  Output - YES
 *  Sample Test Case#2:
 *  Input - abdxa 1
 *  Output - No
 *
 * @author wguo
 *
 */
public class KPalindrome {


	public static boolean isKPalindrome(String s, int k){
		return kPalindrome(s, 0, s.length()-1, k);
	}


	/**
	 * how many characters do we allow to remove
	 *
	 * @param s
	 * @param start
	 * @param end
	 * @param k
	 * @return
	 */
	private static boolean kPalindrome(String s, int start, int end, int k){

		// no more characters to remove
		if (k < 0){
			return false;
		}

		// still some characters to move, but we
		// have exhausted the whole array
		if (start >= end){
			return true;
		}

		if (s.charAt(start) == s.charAt(end)){
			return kPalindrome(s, start+1, end-1, k);
		}

		return kPalindrome(s, start+1, end, k-1) || kPalindrome(s, start, end-1, k-1) ||
			kPalindrome(s, start+1, end-1, k-2);
	}


	/**
	 * NOT WORKING EITHER
	 * @param array
	 * @param start
	 * @param end
	 * @param matches
	 * @param minMatches
	 * @param maxMatches
	 * @return
	 */
	@SuppressWarnings("unused")
	private static boolean kPalindrome(char[] array, int start, int end, int matches, int minMatches, int maxMatches){

		if (start == end){
			matches++;
		}

		if (matches >= minMatches && matches <= maxMatches){
			return true;
		}

		if (start > end){
			return false;
		}

		if (array[start] == array[end]){
			return kPalindrome(array, start + 1, end - 1, matches + 1, minMatches, maxMatches);
		}else{
			return kPalindrome(array, start + 1, end, matches, minMatches, maxMatches) ||
				kPalindrome(array, start, end - 1, matches, minMatches, maxMatches);
		}
	}


	/**
	 * Two strings: same length, how many steps required to
	 * transfer a to b by deleting or inserting
	 *
	 * NOTE: THE FOLLOWING IMPLEMENTATION IS INCORRECT
	 *
	 * Modified edit-distance problem
	 * @param a
	 * @param b
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int distance(String s, String t){

		int rows = s.length() + 1, cols = t.length() + 1;
		int[][] d = new int[rows][cols];

		// source string can be transferred to empty
		// string by removing all the characters
		for (int i = 1; i < rows; i++){
			d[i][0] = i;
		}

		// target string can be transformed from empty
		// string by adding all the characters
		for (int j = 1; j < cols; j++){
			d[0][j] = j;
		}

		for (int i = 1; i < rows; i++){
			for (int j = 1; j < cols; j++){
				if (s.charAt(i-1) == s.charAt(j-1)){
					d[i][j] = d[i-1][j-1];
				}
				else{
					d[i][j]= Math.min(d[i-1][j] + 1, d[i][j-1] + 1);
				}
			}
		}

		return d[rows-1][cols-1];
	}

}
