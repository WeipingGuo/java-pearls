package org.javapearls.cup.chapter2;


import org.junit.Test;

public class TestQuestion24 {

	@Test
	public void testSum() {

		SNode<Integer> s13 = new SNode<Integer>(5, null);
		SNode<Integer> s12 = new SNode<Integer>(1, s13);
		SNode<Integer> s11 = new SNode<Integer>(3, s12);

		SNode<Integer> s23 = new SNode<Integer>(2, null);
		SNode<Integer> s22 = new SNode<Integer>(9, s23);
		SNode<Integer> s21 = new SNode<Integer>(5, s22);

		SNode<Integer> sum = Question24.sum(s11, s21);

		s11.print();
		s21.print();
		sum.print();
	}


	@Test
	public void testLinkSumSingleLink1(){
		SNode<Integer> s13 = new SNode<Integer>(5, null);
		SNode<Integer> s12 = new SNode<Integer>(1, s13);
		SNode<Integer> s11 = new SNode<Integer>(3, s12);

		SNode<Integer> sum = Question24.sum(s11, null);

		s11.print();
		sum.print();
	}

	@Test
	public void testLinkSumSingleLink2(){
		SNode<Integer> s23 = new SNode<Integer>(2, null);
		SNode<Integer> s22 = new SNode<Integer>(9, s23);
		SNode<Integer> s21 = new SNode<Integer>(5, s22);

		SNode<Integer> sum = Question24.sum(s21, null);

		s21.print();
		sum.print();
	}

	@Test
	public void testLinkSumLongerLink1(){
		SNode<Integer> s13 = new SNode<Integer>(5, null);
		SNode<Integer> s12 = new SNode<Integer>(4, s13);
		SNode<Integer> s11 = new SNode<Integer>(9, s12);
		SNode<Integer> s10 = new SNode<Integer>(9, s11);
		SNode<Integer> s09 = new SNode<Integer>(9, s10);


		SNode<Integer> s23 = new SNode<Integer>(2, null);
		SNode<Integer> s22 = new SNode<Integer>(9, s23);
		SNode<Integer> s21 = new SNode<Integer>(5, s22);

		SNode<Integer> sum = Question24.sum(s09, s21);

		s09.print();
		s21.print();
		sum.print();
	}

	@Test
	public void testLinkSumLongerLink2(){
		SNode<Integer> s13 = new SNode<Integer>(5, null);
		SNode<Integer> s12 = new SNode<Integer>(4, s13);
		SNode<Integer> s11 = new SNode<Integer>(9, s12);

		SNode<Integer> s23 = new SNode<Integer>(9, null);
		SNode<Integer> s22 = new SNode<Integer>(9, s23);
		SNode<Integer> s21 = new SNode<Integer>(5, s22);
		SNode<Integer> s20 = new SNode<Integer>(4, s21);

		SNode<Integer> sum = Question24.sum(s11, s20);

		s11.print();
		s20.print();
		sum.print();
	}

	@Test
	public void testAddLinkedList(){
		SNode<Integer> s13 = new SNode<Integer>(5, null);
		SNode<Integer> s12 = new SNode<Integer>(4, s13);
		SNode<Integer> s11 = new SNode<Integer>(9, s12);

		SNode<Integer> s23 = new SNode<Integer>(9, null);
		SNode<Integer> s22 = new SNode<Integer>(9, s23);
		SNode<Integer> s21 = new SNode<Integer>(5, s22);
		SNode<Integer> s20 = new SNode<Integer>(4, s21);

		SNode<Integer> sum = Question24.add(s11, s20);

		s11.print();
		s20.print();
		sum.print();
	}

	@Test
	public void testAddLinkedListRec(){
		SNode<Integer> s13 = new SNode<Integer>(5, null);
		SNode<Integer> s12 = new SNode<Integer>(4, s13);
		SNode<Integer> s11 = new SNode<Integer>(9, s12);

		SNode<Integer> s23 = new SNode<Integer>(9, null);
		SNode<Integer> s22 = new SNode<Integer>(9, s23);
		SNode<Integer> s21 = new SNode<Integer>(5, s22);
		SNode<Integer> s20 = new SNode<Integer>(4, s21);

		SNode<Integer> sum = Question24.sum(s11, s20, 0);

		s11.print();
		s20.print();
		sum.print();
	}




}
