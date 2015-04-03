package org.javapearls.cup.chapter1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestQuestion15 {

	@Test(expected=IllegalArgumentException.class)
	public void testEncodeNullString(){
		Question15.encode(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testEncodeEmptyString(){
		Question15.encode(new String());
	}

	@Test
	public void testEncode() {
		String s = "hello world  ";
		String t = "hello%20world%20%20";
		String r = Question15.encode(s);
		assertEquals(r, t);
	}

	@Test
	public void testReplace() {
		String s = "hello world  ";
		String t = "hello%20world%20%20";
		char[] r = Question15.replaceWhiteSpace(s.toCharArray());
		assertTrue(Arrays.equals(r, t.toCharArray()));
	}

}
