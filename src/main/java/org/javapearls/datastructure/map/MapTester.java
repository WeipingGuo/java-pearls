package org.javapearls.datastructure.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTester {

	public static void main(String[] args){

		MapTester tester = new MapTester();
		tester.testLinkedHashMap();
	}

	/**
	 * LinkedHashMap insertion order be conserved
	 *
	 */
	public void testLinkedHashMap(){

		String str = "this is a good day. we can go out and play around.";
		Map<Character, Integer> map =
			new LinkedHashMap<Character, Integer>();

		// count the occurrence of each character
		for (int i = 0; i < str.length(); i++){
			char c = str.charAt(i);
			Integer count = map.get(c);
			if (count == null){
				map.put(c, Integer.valueOf(1));
			}else{
				map.put(c, Integer.valueOf(++count));
			}
		}

		// was the insertion order kept
		for (Map.Entry<Character, Integer> entry : map.entrySet()){
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}
