package org.javapearls.algorithm.dp.basic;

import static org.junit.Assert.*;

import org.javapearls.algorithm.dp.basic.LongestCommonSequence;
import org.junit.Test;

public class TestLCS {

	@Test
	public void testLCSLength(){
		String a = "XMJYAUZ";
		String b = "MZJAWXU";
		assertEquals(LongestCommonSequence.lcsLen(a, b), 4);

		a = "AGCAT";
		b = "GAC";
		assertEquals(LongestCommonSequence.lcsLen(a, b), 2);
	}

	@Test
	public void testLcsLenCompact(){
		String a = "XMJYAUZ";
		String b = "MZJAWXU";
		assertEquals(LongestCommonSequence.lcsLenCompact(a, b), 4);

		a = "AGCAT";
		b = "GAC";
		assertEquals(LongestCommonSequence.lcsLenCompact(a, b), 2);
	}

	@Test
	public void testLCSBackTrack(){
		String a = "XMJYAUZ";
		String b = "MZJAWXU";
		String lcs = LongestCommonSequence.lcsBackTrack(a, b);
		System.out.println(lcs);
	}



}
