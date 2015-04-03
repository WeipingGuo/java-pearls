package org.javapearls.cup.chapter1;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestQuestion14 {

	@Test(expected=IllegalArgumentException.class)
	public void testIsAnagramsNullString() {
		Question14.isAnagrams(null, null);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIsAnagramsEmptyString() {
		Question14.isAnagrams(new String(), new String());
	}

	@Test
	public void testIsAnagramsSingleChar(){
		String s = "a";
		String t = "     a ";
		assertTrue(Question14.isAnagrams(s, t));
	}

	@Test
	public void testIsAnagramsYes(){
		String s = "Clint Eastwood";
		String t = "Old West action";
		assertTrue(Question14.isAnagrams(s, t));
	}

	@Test
	public void testIsAnagramsSingleword(){
		String s = "orchestra";
		String t = "carthorse";
		assertTrue(Question14.isAnagrams(s, t));
	}

	@Test
	public void testIsAnagramsSentences(){
		String s = "The best things in life are free";
		String t = "Nail-biting refreshes the feet";
		assertTrue(Question14.isAnagrams(s, t));
	}

	@Test
	public void testIsAnagramFalse(){
		String s = "The best things in life are free";
		String t = "Nail-biting refreshes the feet with extra";
		assertFalse(Question14.isAnagrams(s, t));
	}

	@Test
	public void testIsAnagramsPhrases(){
		String s = "The best things in life are free";
		String t = "Nail-biting refreshes the feet";
		assertFalse(Question14.anagram(s, t));
	}

}
