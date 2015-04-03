package org.javapearls.algorithm.dp.basic;

import static org.junit.Assert.*;

import org.javapearls.algorithm.dp.basic.LongestCommonSubstring;
import org.junit.Test;

public class TestLongestSubstr {

	@Test
	public void testLcsubstr(){
		String a = "ABABC";
		String b = "BABCA";
		String lsubstr = LongestCommonSubstring.lcsubstr(a, b);
		assertEquals(lsubstr, "BABC");


		a = "helloworld10";
		b = "whathello2world1";
		lsubstr = LongestCommonSubstring.lcsubstr(a, b);
		assertEquals(lsubstr, "world1");
	}

}
