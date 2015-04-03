package org.javapearls.algorithm.oj;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestKPalindrome {

	@Test
	public void  testKPalindrome(){

		assertTrue(KPalindrome.isKPalindrome("abxa", 1));
		assertFalse(KPalindrome.isKPalindrome("abdxa", 1));
		assertTrue(KPalindrome.isKPalindrome("abaxbabax",2));
	}

}
