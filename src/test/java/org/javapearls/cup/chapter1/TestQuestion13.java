package org.javapearls.cup.chapter1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;


public class TestQuestion13 {

	@Test
	public void testRemoveDuplicateCharsNull(){
		String s = Question13.removeDuplicate(null);
		assertNull(s);
	}

	@Test
	public void testRemoveDuplicateCharsEmptyString(){
		String s = "";
		String t = Question13.removeDuplicate(s);
		assertTrue(s == t);
	}

	@Test
	public void testRemoveDuplicateCharsSingle(){
		String s = "a";
		String t = Question13.removeDuplicate(s);
		assertTrue(s == t);
	}

	@Test
	public void testRemoveDuplicateChars(){
		String s = "ababab";
		String t = Question13.removeDuplicate(s);
		assertTrue(t.equals("ab"));
	}

	@Test
	public void testRemoveDuplicateChars2(){
		String s = "aaabbb";
		String t = Question13.removeDuplicate(s);
		assertTrue(t.equals("ab"));
	}

	@Test
	public void testRemoveDuplicateAllDuplicates(){
		String s = "aaaaaaaaaa";
		String t = Question13.removeDuplicate(s);
		assertTrue(t.equals("a"));
	}

	@Test
	public void testRemoveDuplicateCharsNoDuplicateChars(){
		String s = "abcdefg";
		String t = Question13.removeDuplicate(s);
		assertTrue(t.equals(s));
	}


	/////////////////////////////////////////////////

	@Test
	public void testremoveDuplicateCharNull(){
		Question13.removeDuplicateChar(null);
	}

	@Test
	public void testremoveDuplicateCharEmpty(){
		char[] s ={};
		Question13.removeDuplicateChar(s);
		assertTrue(s.length == 0);
	}

	@Test
	public void testremoveDuplicateCharSingle(){
		char[] s = {'a'};
		Question13.removeDuplicateChar(s);
		assertTrue(s.length == 1);
	}

	@Test
	public void testRemoveDuplicateCharsDuplicated(){
		String s = "ababab";
		char[] t = s.toCharArray();
		char[] w = {'a','b'};
		t = Question13.removeDuplicateChar(t);
		assertTrue(Arrays.equals(t, w));
	}

	@Test
	public void testRemoveDuplicateCharsDuplicated2(){
		String s = "aaabbb";
		char[] t = s.toCharArray();
		char[] w = Question13.removeDuplicateChar(t);
		assertTrue(w[0] == 'a');
		assertTrue(w[1] == 'b');
		assertTrue(w.length == 2);
	}

	@Test
	public void testRemoveDuplicateAllDuplicates2(){
		String s = "aaaaaaaaaa";
		char[] t = s.toCharArray();
		char[] r = Question13.removeDuplicateChar(t);
		assertTrue(r.length == 1);
		assertTrue(r[0] == 'a');
	}

	@Test
	public void testRemoveDuplicateCharsNoDuplicateChars2(){
		String s = "abcdefg";
		char[] t = s.toCharArray();
		char[] w = Question13.removeDuplicateChar(t);
		assertTrue(Arrays.equals(t,w));
	}




	////////////////////////////////////////////
	@Test
	public void testremoveDupsCharSingle(){
		char[] s = {'a'};
		Question13.removeDuplicates(s);
		assertTrue(s.length == 1);
	}

	@Test
	public void testRemoveDupsDuplicated(){
		String s = "ababab";
		char[] t = s.toCharArray();
		char[] w = {'a','b'};
		t = Question13.removeDuplicates(t);
		assertTrue(Arrays.equals(t, w));
	}

	@Test
	public void testRemoveDupsCharsDuplicated2(){
		String s = "aaabbb";
		char[] t = s.toCharArray();
		char[] w = Question13.removeDuplicates(t);
		assertTrue(w[0] == 'a');
		assertTrue(w[1] == 'b');
		assertTrue(w.length == 2);
	}

	@Test
	public void testRemoveDuplicateAllDups(){
		String s = "aaaaaaaaaa";
		char[] t = s.toCharArray();
		char[] r = Question13.removeDuplicates(t);
		assertTrue(r.length == 1);
		assertTrue(r[0] == 'a');
	}

	@Test
	public void testRemoveDuplicateCharsNoDups(){
		String s = "abcdefg";
		char[] t = s.toCharArray();
		char[] w = Question13.removeDuplicates(t);
		assertTrue(Arrays.equals(t,w));
	}

}
