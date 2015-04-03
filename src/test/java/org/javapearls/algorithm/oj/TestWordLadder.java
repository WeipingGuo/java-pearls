package org.javapearls.algorithm.oj;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import org.junit.Test;

public class TestWordLadder {

	@Test
	public void testWordLadder(){

		String start = "hit", end = "cog";
		String[] strings = {"hot","dot","dog","lot","log"};
		Set<String> dict = new HashSet<String>();
		for (int i = 0; i < strings.length; i++){
			dict.add(strings[i]);
		}

		LinkedList<String> shorted = WordLadder.shortestTranform(start, end, dict);
		for(String s : shorted){
			System.out.print(s + "->");
		}
		assertEquals(shorted.size(), 5);

		int shortedLen = WordLadder.transform(start, end, dict);
		assertEquals(shortedLen, 5);
	}

}
