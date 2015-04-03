package org.javapearls.foundation;

import static org.junit.Assert.*;


import java.util.Arrays;

import org.junit.Test;

public class TestString {

	@Test
	public void testNewString(){

		String x = "hello";
		String y = "hello";

		assertTrue(x == y);

		int[] a = {10,11,12,15,20};
		int[] b = Arrays.copyOf(a, a.length);
		System.out.println(b);
	}

}
