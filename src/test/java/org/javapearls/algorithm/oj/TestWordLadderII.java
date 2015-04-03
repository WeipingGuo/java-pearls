package org.javapearls.algorithm.oj;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class TestWordLadderII {

	@Test
	public void testWordLadderII(){
		String start = "hit", end = "cog";
		String[] strings = {"hot","dot","dog","lot","log"};
		Set<String> dict = new HashSet<String>();
		for (int i = 0; i < strings.length; i++){
			dict.add(strings[i]);
		}

		List<LinkedList<String>> res =
			WordLadderII.transform(start, end, dict);

		System.out.println("There are " + res.size() +
				" paths from '" + start + "' to '" + end + "'.");

		for (LinkedList<String> list : res){
			print(list, end);
		}
	}

	private void print(LinkedList<String> list, String end){

		for (String s : list){
			if (s == end || s.equals(end)){
				System.out.print(s);
				System.out.println();
			}
			else {
				System.out.print(s + "-->");
			}
		}
	}
}
