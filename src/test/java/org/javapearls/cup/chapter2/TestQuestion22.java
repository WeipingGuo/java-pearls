package org.javapearls.cup.chapter2;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestQuestion22 {


	@Rule
	public ExpectedException exception = ExpectedException.none();

	@Test
	public void testNthElement() {

		SNode<String> s1 = new SNode<String>("one", null);
		SNode<String> s2 = new SNode<String>("two", s1);
		SNode<String> s3 = new SNode<String>("three", s2);
		SNode<String> s4 = new SNode<String>("four", s3);
		SNode<String> s5 = new SNode<String>("five", s4);

		String s = Question22.nthElement(s5, 0);
		assertEquals(s, "one");

		assertEquals(Question22.nthElement(s5, 1), "two");
		assertEquals(Question22.nthElement(s5, 2), "three");
		assertEquals(Question22.nthElement(s5, 3), "four");
		assertEquals(Question22.nthElement(s5, 4), "five");
		assertNull(Question22.nthElement(s5, 5));
	}

	@Test
	public void testNth2Last(){

		SNode<String> s1 = new SNode<String>("one", null);
		SNode<String> s2 = new SNode<String>("two", s1);
		SNode<String> s3 = new SNode<String>("three", s2);
		SNode<String> s4 = new SNode<String>("four", s3);
		SNode<String> s5 = new SNode<String>("five", s4);

		assertEquals(Question22.nth2Last(s5, 0), "one");
		assertEquals(Question22.nth2Last(s5, 1), "two");
		assertEquals(Question22.nth2Last(s5, 2), "three");
		assertEquals(Question22.nth2Last(s5, 3), "four");
		assertEquals(Question22.nth2Last(s5, 4), "five");

		exception.expect(IllegalStateException.class);
		Question22.nth2Last(s5, 5);
	}

}
