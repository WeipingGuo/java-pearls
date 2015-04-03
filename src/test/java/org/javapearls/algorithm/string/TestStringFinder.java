package org.javapearls.algorithm.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringFinder {

	@Test
	public void testFindLongestSubstringMultiAppearce() {

		String s = "abcabcaacb";
		String result = StringFinder.findLongestSubstringMultiAppearce(s);
		System.out.println("longest substring: " + result);
		assertTrue(result.equals("abca"));

		String s2 = "aababa";
		result = StringFinder.findLongestSubstringMultiAppearce(s2);
		System.out.println("longest substring: " + result);
		assertTrue(result.equals("aba"));
	}

	@Test
	public void testFirstNoDuplicatedCharacter(){

		assertNull(StringFinder.firstNonDuplicatedChar(null));

		String s = "";
		assertNull(StringFinder.firstNonDuplicatedChar(s));

		s = "abcdefghijkw";
		assertTrue(StringFinder.firstNonDuplicatedChar(s) == 'a');

		s = "abcdabcdzefggf";
		assertTrue(StringFinder.firstNonDuplicatedChar(s) == 'z');


	}


}
