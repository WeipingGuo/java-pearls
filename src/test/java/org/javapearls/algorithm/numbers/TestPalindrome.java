package org.javapearls.algorithm.numbers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPalindrome {

	@Test
	public void testIsPalindromeInt() {
		assertTrue(Palindrome.isPalindrome(-22));
		assertTrue(Palindrome.isPalindrome(5));
		assertFalse(Palindrome.isPalindrome(12));
		assertTrue(Palindrome.isPalindrome(121));

		System.out.println("45 >> 1 = " + (45>>1));
	}

	@Test
	public void testIsPalindromeIntByReverse(){
		assertTrue(Palindrome.isPalindrome(-22));
		assertTrue(Palindrome.isPalindrome(5));
		assertFalse(Palindrome.isPalindrome(12));
		assertTrue(Palindrome.isPalindrome(121));
	}
	@Test
	public void testisPalindromeCompareDigits(){
		assertTrue(Palindrome.isPalindromeCompareDigits(5));
		assertFalse(Palindrome.isPalindromeCompareDigits(12));
		assertTrue(Palindrome.isPalindromeCompareDigits(121));
		assertTrue(Palindrome.isPalindromeCompareDigits(123321));
		assertFalse(Palindrome.isPalindromeCompareDigits(12387321));

	}

	@Test
	public void testIntReverse(){
		assertEquals(123, Palindrome.reverse(321));
		assertEquals(5, Palindrome.reverse(5));
	}

	@Test
	public void testIsPalindromeString() {
		assertTrue(Palindrome.isPalindrome("abcddcba"));
		assertTrue(Palindrome.isPalindrome("a"));
		assertFalse(Palindrome.isPalindrome("12"));
	}

}
