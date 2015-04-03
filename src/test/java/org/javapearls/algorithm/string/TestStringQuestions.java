package org.javapearls.algorithm.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringQuestions {

	@Test
	public void testUniqueChars(){
		assertTrue(StringQuestions.uniqueChars(""));
		assertTrue(StringQuestions.uniqueChars("2"));
		assertFalse(StringQuestions.uniqueChars("abcdefgabc"));
		assertFalse(StringQuestions.uniqueChars("12345678901"));
		assertTrue(StringQuestions.uniqueChars("abcdefghijZA"));
	}

	@Test
	public void testUniqueCharacters(){
		assertTrue(StringQuestions.containUniqueChars(""));
		assertTrue(StringQuestions.containUniqueChars("2"));
		assertFalse(StringQuestions.containUniqueChars("abcdefgabc"));
		assertFalse(StringQuestions.containUniqueChars("12345678901"));
		assertTrue(StringQuestions.containUniqueChars("abcdefghijA"));
	}

	@Test
	public void testStringReverse(){
		String orig = "hello world";
		String reversed = StringQuestions.reverse2(orig);
		String reversed2 = StringQuestions.reverse(orig);
		assertEquals(reversed, new StringBuilder(orig).reverse().toString());
		assertEquals(reversed, reversed2);
	}

	@Test
	public void testStringPermutation(){
		String orig = "Today is  the day";
		String perm = "Today the is yad";
		assertTrue(StringQuestions.isPermutation(orig, perm));

		String s2 = perm + "a";
		assertFalse(StringQuestions.isPermutation(orig, s2));

		String a1 = "abcdabcd";
		String a2 = "abcdabc";
		assertFalse(StringQuestions.isPermutation(a1,a2));
	}

	@Test
	public void testStringPermutationEmptyString(){
		assertFalse(StringQuestions.isPermutation("ab", null));
		assertFalse(StringQuestions.isPermutation(null, "ok"));
		assertTrue(StringQuestions.isPermutation(" ", " "));
		assertTrue(StringQuestions.isPermutation(null, null));
	}

	@Test
	public void testStringPermutationBySorting(){
		String orig = "Today is  the day";
		String perm = "Today the is yad";
		System.out.println(StringQuestions.sort(orig));
		System.out.println(StringQuestions.sort(perm));
		assertTrue(StringQuestions.isPermutations(orig, perm));

		String s2 = perm + "a";
		assertFalse(StringQuestions.isPermutations(orig, s2));

		String a1 = "abcdabcd";
		String a2 = "abcdabc";
		assertFalse(StringQuestions.isPermutations(a1,a2));
	}

	@Test
	public void testStringPermutationByCounting(){
		String orig = "Today is  the day";
		String perm = "Today the is yad";
		assertTrue(StringQuestions.isPermut(orig, perm));

		String s2 = perm + "a";
		assertFalse(StringQuestions.isPermut(orig, s2));

		String a1 = "abcdabcd";
		String a2 = "abcdabc";
		assertFalse(StringQuestions.isPermut(a1,a2));
	}

	@Test
	public void testEncode(){
		String a = "a b c       ";
		char[] array = a.toCharArray();
		StringQuestions.encode(array, 5);

		String b = "a%20b%20c";
		assertTrue(new String(array).startsWith(b));
	}

	@Test
	public void testCompress(){
		String a = "aabccccaaa";
		String compressed = StringQuestions.compress(a);
		assertEquals(compressed, "a2b1c4a3");
	}
	@Test
	public void testCompressInvalid(){
		String a = "abcdedfg";
		String compressed = StringQuestions.compress(a);
		assertTrue(a == compressed);
	}

}
