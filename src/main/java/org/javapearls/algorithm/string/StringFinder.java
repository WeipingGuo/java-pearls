package org.javapearls.algorithm.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringFinder {

	/**
	 * for a given string, find the longest substring which appears more than once
	 * eg: "abcabcaacb" -> "abc"
	 * eg: "aababa" -> "aba"
	 *
	 * Solution: trie for each char
	 */
	public static String findLongestSubstringMultiAppearce(String orig){

		if (orig == null || orig.isEmpty()){
			throw new IllegalArgumentException("Null or empty string");
		}


		HashMap<String,Integer> map = new HashMap<String, Integer>();
		for (int i=0; i <= orig.length(); i++){
			for (int j=i+1; j <= orig.length(); j++){
				String s = orig.substring(i, j);
				Integer count = map.get(s);
				if (count == null){
					map.put(s, Integer.valueOf(1));
				}
				else{
					map.put(s, Integer.valueOf(count.intValue()+ 1));
				}
			}
		}

		String result = "";
		for (Map.Entry<String, Integer> entry : map.entrySet()){
			if (entry.getValue().intValue() <= 1)
				continue;
			String s = entry.getKey();
			if (s.length() > result.length()){
				result = s;
			}
		}

		return result;
	}


	/**
	 * Given a string, find the first character which is not repeated
	 *
	 * @param s	input stream
	 * @return
	 */
	public static Character firstNonDuplicatedChar(String s){

		// sanity check
		if (s == null || s.length() == 0){
			return null;
		}

		// count over the occurrence of each char
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			Integer count = map.get(c);
			if (count == null){
				map.put(c, Integer.valueOf(1));
			}else{
				map.put(c, Integer.valueOf(++count));
			}
		}

		// iterator over the map
		for (Map.Entry<Character, Integer> entry : map.entrySet()){
			if (entry.getValue() == 1){
				return entry.getKey();
			}
		}

		// all duplicated
		return null;
	}

}
