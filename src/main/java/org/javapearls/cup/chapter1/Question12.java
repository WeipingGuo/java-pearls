package org.javapearls.cup.chapter1;

/**
 * Write code to reverse a C-Style String
 *
 * @author wguo
 *
 */
public class Question12 {

	/**
	 * Reverse a string
	 *
	 * @param s
	 * @return
	 */
	public static String reverse(String s){

		if (s== null || s.isEmpty()){
			throw new IllegalArgumentException("Null or empty string");
		}

		if (s.length() == 1){
			return s;
		}

		// convert to char array
		char[] schar = s.toCharArray();
		int i = 0;
		int j = schar.length - 1;
		while (i < j){
			char t = schar[j];
			schar[j--] = schar[i];
			schar[i++] = t;
		}

		return new String(schar);
	}

	public static String reverse2(String s){
		return new StringBuffer(s).reverse().toString();
	}

}
