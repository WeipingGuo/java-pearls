package org.javapearls.algorithm.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Strings {

	public static final String EMPTY_STRING	= "";

	/**
	 * search a string from a sorted string array. the array
	 * may contain multiple empty string.
	 *
	 * @param array
	 * @param target
	 * @return
	 */
	public static int search(String[] array, String target){

		if (array == null || array.length == 0 || target== null){
			return -1;
		}

		// target string also an empty string
		if (target.equals("")){
			for (int i = 0; i < array.length; i++){
				if (array[i].equals("")){
					return i;
				}
			}
			return -1;
		}

		return searchIter(array, 0, array.length - 1, target);
		//return search(array, 0, array.length - 1, target);
	}

	@SuppressWarnings("unused")
	private static int search(String[] array, int left, int right, String target){

		if (left > right){
			return -1;
		}

		int middle = (left + right)/2;
		if (array[middle].equals(target)){
			return middle;
		}

		// check the left side, skip empty string
		int leftRunner = middle;
		while (leftRunner >= left &&  array[leftRunner].equals("")){
			leftRunner--;
		}

		// there are some nonempty string on the left side
		if (leftRunner >= left){
			int cmp = array[leftRunner].compareTo(target);
			if (cmp == 0){
				return leftRunner;
			}else if (cmp > 0){
				return search(array, left, leftRunner - 1, target);
			}
		}

		// check the right side
		while (middle <= right && array[middle].equals("")){
			middle++;
		}

		// end of array, still not found
		if (middle > right){
			return -1;
		}
		int cmp = array[middle].compareTo(target);
		if (cmp == 0){
			return middle;
		}else if (cmp < 0){
			return search(array, middle + 1, right, target);
		}

		// not found
		return -1;
	}

	private static int searchIter(String[] strings, int left, int right, String target){

		while (left <= right){

			// skip empty string from the right side
			while (left <= right && strings[right].equals(EMPTY_STRING)){
				right--;
			}

			// no more non-empty string
			if (left > right){
				return -1;
			}

			int middle = (left + right)>>1;
			while (strings[middle].equals(EMPTY_STRING)){
				middle++;
			}
			int cmp = strings[middle].compareTo(target);
			if (cmp == 0){
				return middle;
			}else if (cmp > 0){
				right = middle - 1;
			}else{
				left = middle + 1;
			}
		}
		return -1;
	}


	public static Set<String> permutation(String word){

		Set<String> res = new HashSet<String>();
		if (word == null || word.isEmpty()){
			return res;
		}
		if (word.length() == 1){
			res.add(word);
			return res;
		}

		// get the permutations of the remaining string
		Set<String> ps = permutation(word.substring(1));
		char c = word.charAt(0);
		for (String s : ps){
			res.add(c + s);
			for (int i = 1; i < s.length(); i++){
				res.add(s.substring(0,i) + c + s.substring(i));
			}
			res.add(s + c);
		}

		return res;
	}

	/**
	 * print all valid combination of n-pairs of parentheses
	 *
	 */
	public static void printPar(int count){
		char[] str = new char[count * 2];
		printPar(count, count, str, 0);
	}

	public static void printPar(int left, int right, char[] str, int count){
		if (left < 0 || right < left ) return;
		if (left == 0 && right == 0){
			System.out.println(str);
		}else{
			if (left > 0){
				str[count] = '(';
				printPar(left - 1, right, str, count + 1);
			}
			if (right > left){
				str[count] = ')';
				printPar(left, right - 1, str, count + 1);
			}
		}
	}

	/**
	 * A string consists of 0, 1, ?, ? can match either 0 or 1.
	 * return all the matching strings.
	 * input : 1??
	 * output: {100, 101, 110, 111}.
	 * input: 100100?00?
	 * output: {1001000000,1001000001,1001001000,1001001001}
	 * @param s
	 * @return
	 */
	public static List<String> match(String s){
		List<String> res = new ArrayList<String>();
		match(s.toCharArray(), 0, res);
		return res;
	}

	private static void match(char[] array, int start, List<String> res){

		// search the first '?'
		while (start < array.length && array[start] != '?'){
			start++;
		}

		// no more '?', done
		if (start == array.length){
			res.add(new String(array));
			return;
		}

		// replace '?' with 0 and 1
		array[start] = '0';
		match(array, start+1, res);

		array[start] = '1';
		match(array, start+1, res);

		// restore '?'
		array[start] = '?';
	}


	/**
	 * convert abcd1234 --> a1b2c3d4
	 * @param str
	 * @return
	 */
	public static String convert(String str){

		if (str == null || str.length() == 0){
			throw new IllegalArgumentException("null or empty string");
		}
		if (str.length() % 2 != 0){
			throw new IllegalArgumentException("input string is not well formatted");
		}

		char[] array = str.toCharArray();
		char[] newArray = new char[array.length];
		int middle = array.length >>> 1;

		int lo = 0; int hi = middle;  int k = 0;
		while (lo < middle && hi < array.length){
			newArray[k++] = array[lo++];
			newArray[k++] = array[hi++];
		}

		return new String(newArray);
	}
	
	/**
	 *  remove all the white space from a given string
	 *
	 */
	public static String trim(String s){
	    
	    if (s == null){
	        throw new IllegalArgumentException("null string");
	    }
	    if (s.length() == 0){
	        return s;
	    }
	    
	    char[] a = new char[s.length()];
	    int j = 0;
	    for (int i = 0; i < s.length(); i++){
	        if (s.charAt(i) != ' '){
	            a[j++] = s.charAt(i);
	        }
	    }
	    return new String(a, 0, j);
	}

}
