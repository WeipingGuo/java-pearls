package org.javapearls.cup.chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuestion11 {

	@Test(expected=IllegalArgumentException.class)
	public void testContainsUniqueCharsNullString() {
		Question11.containsUniqueChars(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testContainsUniqueCharsEmptyString() {
		Question11.containsUniqueChars(new String());
	}

	@Test
	public void testContainsUniqueCharsSingleElement() {
		assertTrue(Question11.containsUniqueChars(new String("a")));
	}

	@Test
	public void testContainsUniqueCharsMultipleChars() {
		String s = new String("Hello world");
		assertFalse(Question11.containsUniqueChars(s));
	}

	@Test
	public void testContainsUniqueCharsRepeatedChars(){
		String s = new String("aabb");
		assertFalse(Question11.containsUniqueChars(s));
	}

	@Test
	public void testContainsUnqiueChars(){
		String s = new String("abcdefg hijk");
		assertTrue(Question11.containsUniqueChars(s));
	}


	/**
	 * Testing unique char based on BitSet
	 *
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testContainsUniqueChars2NullString() {
		Question11.containsUniqueChars2(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testContainsUniqueChars2EmptyString() {
		Question11.containsUniqueChars2(new String());
	}

	@Test
	public void testContainsUniqueChars2SingleElement() {
		assertTrue(Question11.containsUniqueChars2(new String("a")));
	}

	@Test
	public void testContainsUniqueChars2MultipleChars() {
		String s = new String("Hello world");
		assertFalse(Question11.containsUniqueChars2(s));
	}

	@Test
	public void testContainsUniqueChars2RepeatedChars(){
		String s = new String("aabb");
		assertFalse(Question11.containsUniqueChars2(s));
	}

	@Test
	public void testContains2UnqiueChars(){
		String s = new String("abcdefg hijk");
		assertTrue(Question11.containsUniqueChars2(s));
	}

	/*
	 * Testing Naive algorithm
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testcontainsUniqueCharsNaiveNullString() {
		Question11.containsUniqueCharsNaive(null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testcontainsUniqueCharsNaiveEmptyString() {
		Question11.containsUniqueCharsNaive(new String());
	}

	@Test
	public void testcontainsUniqueCharsNaiveSingleElement() {
		assertTrue(Question11.containsUniqueCharsNaive(new String("a")));
	}

	@Test
	public void testcontainsUniqueCharsNaiveMultipleChars() {
		String s = new String("Hello world");
		assertFalse(Question11.containsUniqueCharsNaive(s));
	}

	@Test
	public void testcontainsUniqueCharsNaiveRepeatedChars(){
		String s = new String("aabb");
		assertFalse(Question11.containsUniqueCharsNaive(s));
	}

	@Test
	public void testcontainsUniqueCharsNaive(){
		String s = new String("abcdefg hijk");
		assertTrue(Question11.containsUniqueCharsNaive(s));
	}


}
