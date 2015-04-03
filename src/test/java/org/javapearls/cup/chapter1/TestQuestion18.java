package org.javapearls.cup.chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuestion18 {

	@Test
	public void testStringRotation(){
		assertTrue(Question18.isRotation("waterbottle", "erbottlewat"));
		assertFalse(Question18.isRotation("abcd", "abc"));
		assertTrue(Question18.isRotation("abcd", "cdab"));
	}

}
