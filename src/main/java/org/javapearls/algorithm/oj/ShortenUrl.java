package org.javapearls.algorithm.oj;

import java.util.Stack;

/**
 * The long URL is put into a database and generate an unique ID.
 *
 * encode the URL to short one using this ID, and
 * convert it back.
 *
 * 'convert number to string'
 * assume we use [a-zA-Z0-9] 62 letters as encode.
 *
 *
 * @author wguo
 *
 */
public class ShortenUrl {


	private static String ALP_NUM = "abcdefghijkmnpqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ23456789";
	private static int BASE= ALP_NUM.length();

	public static String encode0(int id){

		StringBuilder sb = new StringBuilder();
		while (id > 0){
			sb.append(ALP_NUM.charAt(id % BASE));
			id /= BASE;
		}

		return sb.reverse().toString();
	}
	public static int decode0(String url){

		int result = 0;
		for (int i = 0; i < url.length(); i++){
			result = result * BASE + ALP_NUM.indexOf(url.charAt(i));
		}
		return result;
	}

	// look up table, bijection function
	// may need remove some character such as '0' 'o','l', '1'
	// to make it less confusing
	private static char[] TABLE = {
		'a','b','c','d','e','f','g','h','i','j','k','l','m',
		'n','o','p','q','r','s','t','u','v','w','x','y','z',
		'A','B','C','D','E','F','G','H','I','J','K','L','M',
		'N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
		'0','1','2','3','4','5','6','7','8','9'
	};

	// 62 base
	private static int BASE_62	= TABLE.length;

	/**
	 * encode id to a string using 62-base
	 *
	 * @param id
	 * @return
	 */
	public static String encode(int id){

		int[] base = covert(id, BASE_62);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < base.length; i++){
			sb.append(TABLE[base[i]]);
		}

		return sb.toString();
	}

	/**
	 *
	 * @param url
	 * @return
	 */
	public static int decode(String url){

		// sanity check
		if (!validate(url)){
			throw new IllegalArgumentException("invalid url to encode: " + url);
		}

		int sum = 0;
		for (int i = 0; i < url.length(); i++){
			int val = lookup(url.charAt(i));
			sum = sum * BASE_62 + val;
		}

		return sum;
	}

	private static boolean validate(String url){
		for (int i = 0; i < url.length(); i++){
			char c = url.charAt(i);
			if (!Character.isLetter(c) && !Character.isDigit(c)){
				return false;
			}
		}
		return true;
	}

	private static int lookup(char c){
		for (int i = 0; i < TABLE.length; i++){
			if (TABLE[i] == c){
				return i;
			}
		}
		return -1;
	}


	/**
	 * convert an 10-based integer to 62 based integer array
	 */
	private static int[] covert(int id, int base){

		Stack<Integer> res = new Stack<Integer>();

		while (id > 0){
			res.push(id % base);
			id /= base;
		}

		int[] array = new int[res.size()];
		int i = 0;
		while (!res.isEmpty()){
			array[i++] = res.pop();
		}
		return array;
	}


}
