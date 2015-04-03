package org.javapearls.cup.chapter3;

import static org.junit.Assert.*;

import org.javapearls.cup.chapter2.SNode;
import org.junit.Test;

public class TestLinkeListUtil {

	@Test
	public void testSort() {

		SNode<Integer> s0 = new SNode<Integer>(10, null);
		SNode<Integer> s1 = new SNode<Integer>(30, s0);
		SNode<Integer> s2 = new SNode<Integer>(5, s1);
		SNode<Integer> s3 = new SNode<Integer>(23, s2);
		SNode<Integer> s4 = new SNode<Integer>(15, s3);
		SNode<Integer> s5 = new SNode<Integer>(7, s4);

		LinkedListUtil.print(s5);
		LinkedListUtil.sort(s5);
		LinkedListUtil.print(s5);
	}

	@Test
	public void testHalfWay(){

		SNode<Integer> s0 = new SNode<Integer>(10, null);
		SNode<Integer> s1 = new SNode<Integer>(30, s0);
		SNode<Integer> s2 = new SNode<Integer>(5, s1);
		SNode<Integer> s3 = new SNode<Integer>(23, s2);
		SNode<Integer> s4 = new SNode<Integer>(15, s3);
		SNode<Integer> s5 = new SNode<Integer>(7, s4);

		SNode<Integer> m = LinkedListUtil.getMedian(s5);
		assertTrue(m == s3);

		SNode<Integer> s6 = new SNode<Integer>(7, s5);
		m = LinkedListUtil.getMedian(s6);
		assertTrue(m == s3);
	}

	@Test
	public void testReverseLinkedList(){
		SNode<String> s1 = new SNode<String>("one", null);
		SNode<String> s2 = new SNode<String>("two", s1);
		SNode<String> s3 = new SNode<String>("three", s2);
		SNode<String> s4 = new SNode<String>("four", s3);
		SNode<String> s5 = new SNode<String>("five", s4);

		s5.print();
		SNode<String> newHeader = LinkedListUtil.reverse(s5);
		newHeader.print();
	}

	@Test
	public void testListDuplication(){
		SNode<String> s1 = new SNode<String>("one", null);
		SNode<String> s2 = new SNode<String>("two", s1);
		SNode<String> s3 = new SNode<String>("three", s2);
		SNode<String> s4 = new SNode<String>("four", s3);
		SNode<String> s5 = new SNode<String>("five", s4);

		s5.print();
		SNode<String> dup = LinkedListUtil.duplicate(s5);
		dup.print();
	}

	@Test
	public void testReverseLinkedListR(){
		SNode<String> s1 = new SNode<String>("one", null);
		SNode<String> s2 = new SNode<String>("two", s1);
		SNode<String> s3 = new SNode<String>("three", s2);
		SNode<String> s4 = new SNode<String>("four", s3);
		SNode<String> s5 = new SNode<String>("five", s4);

		s5.print();
		SNode<String> newHeader = LinkedListUtil.reverseR(s5);
		newHeader.print();
	}

	@Test
	public void testLinkedListSum(){
		SNode<Integer> a2 = new SNode<Integer>(5);
		SNode<Integer> a1 = new SNode<Integer>(1, a2);
		SNode<Integer> a0 = new SNode<Integer>(3, a1);

		SNode<Integer> b2 = new SNode<Integer>(2);
		SNode<Integer> b1 = new SNode<Integer>(9, b2);
		SNode<Integer> b0 = new SNode<Integer>(5, b1);

		a0.print();
		b0.print();

		SNode<Integer> result = LinkedListUtil.sum(a0, b0);
		result.print();

		SNode<Integer> res = LinkedListUtil.add(a0, b0, 0);
		res.print();
	}




}
