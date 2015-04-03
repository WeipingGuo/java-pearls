package org.javapearls.cup.chapter5;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuestion54 {

	@Test(expected=IllegalArgumentException.class)
	public void testIsPowerOf2Negative(){
		Question54.isPowerOf2(-100);
	}

	@Test
	public void testIsPowerOf2() {
		assertTrue(Question54.isPowerOf2(0));
		assertTrue(Question54.isPowerOf2(8));
		assertFalse(Question54.isPowerOf2(6));
		assertFalse(Question54.isPowerOf2(13));
	}

	@Test
	public void testAbsoute() {
		assertTrue(Question54.absolute(0) == 0);
		assertTrue(Question54.absolute(100) == 100);
		assertTrue(Question54.absolute(-100) == 100);
		assertTrue(Question54.absolute(Integer.MAX_VALUE) == Integer.MAX_VALUE);
		assertTrue(Question54.absolute(Integer.MIN_VALUE) == Integer.MAX_VALUE);
	}

}
