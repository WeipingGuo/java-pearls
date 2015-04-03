package org.javapearls.cup.chapter1;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using
 * only one call to isSubstring (i.e., 'waterbottle' is a rotation of 'erbottlewat').
 *
 * @author wguo
 *
 */
public class Question18 {



	/**
	 * check whether s2 is rotation of s1
	 *
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isRotation(String s1, String s2){

		if (s1.length() != s2.length()){
			return false;
		}

		return isSubString(s2, s1 + s1);
	}

	/**
	 * whether s2 is substring of s1
	 *
	 * @param s2
	 * @param s1
	 * @return
	 */
	public static boolean isSubString(String s2, String s1){
		int index = s1.indexOf(s2);
		if (index == -1){
			return false;
		}else{
			return true;
		}
	}




}
