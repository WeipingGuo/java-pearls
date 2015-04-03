package org.javapearls.cup.chapter9;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 *
 * @author wguo
 *
 */
public class Question92 {

	public static void sort(List<String> list){
		Collections.sort(list, new AnagramComparator());
	}

	public static class AnagramComparator implements Comparator<String>{

		private String sort(String s){
			char[] c = s.toCharArray();
			Arrays.sort(c);
			return new String(c);
		}

		@Override
		public int compare(String o1, String o2) {

			return sort(o1).compareToIgnoreCase(sort(o2));


//			if (isAnagrams(o1, o2)){
//				return 0;
//			}else {
//				return o1.compareTo(o2);
//			}
		}
	}

	public static boolean isAnagrams(String s1, String s2){
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		if (c1.length != c2.length){
			return false;
		}

		// convert to upper case
		for (int i = 0; i < c1.length; i++){
			c1[i] = Character.toUpperCase(c1[i]);
			c2[i] = Character.toUpperCase(c2[i]);
		}

		Arrays.sort(c1);
		Arrays.sort(c2);

		return Arrays.equals(c1, c2);
	}

}
