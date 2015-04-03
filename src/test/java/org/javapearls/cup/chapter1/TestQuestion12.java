package org.javapearls.cup.chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuestion12 {


	@Test(expected=IllegalArgumentException.class)
	public void testReverseNullString(){
		Question12.reverse(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testReverseEmptyString(){
		Question12.reverse(new String());
	}

	@Test
	public void testReverseSingleElement(){
		String s = new String("a");
		String t = Question12.reverse(s);
		assertEquals(s, t);
		assertSame(s, t);
	}

	@Test
	public void testReverseRepeatedElements(){
		String s = new String("aa");
		String t = Question12.reverse(s);
		assertEquals(s,t);
	}

	@Test
	public void testReverse() {
		String s = new String("123456789");
		String t = new String("987654321");
		assertEquals(t, Question12.reverse(s));
	}

}
