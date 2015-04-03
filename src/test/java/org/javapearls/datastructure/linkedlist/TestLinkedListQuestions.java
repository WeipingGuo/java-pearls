package org.javapearls.datastructure.linkedlist;


import org.javapearls.cup.chapter2.SNode;
import org.junit.Before;
import org.junit.Test;

public class TestLinkedListQuestions {

	private SNode<Integer> a1, a2, a3, a4,a5, a6;

	@Before
	public void createLinkedList(){
		a6 = new SNode<Integer>(6);
		a5 = new SNode<Integer>(5, a6);
		a4 = new SNode<Integer>(4, a5);
		a3 = new SNode<Integer>(3, a4);
		a2 = new SNode<Integer>(2, a3);
		a1 = new SNode<Integer>(1, a2);
	}

	@Test
	public void testReverseLinkedListMN(){

		System.out.println("before reverse 2 - 4:" );
		a1.print();
		SNode<Integer> newHeader = LinkedListQuestions.reverse(a1, 2, 4);

		System.out.println("after reverse 2 - 4:" );
		newHeader.print();

		System.out.println("after reverse 1 - 6");
		newHeader = LinkedListQuestions.reverse(a1, 1, 6);
		newHeader.print();

	}

	@Test(expected=IllegalArgumentException.class)
	public void testSwapLinkedList(){
		LinkedListQuestions.reverse(a1, 4, 2);
	}

	@Test
	public void testMergeLinkedListIteration(){

		SNode<Integer> b6 = new SNode<Integer>(10);
		SNode<Integer> b5 = new SNode<Integer>(7, b6);
		SNode<Integer> b4 = new SNode<Integer>(5, b5);
		SNode<Integer> b3 = new SNode<Integer>(3, b4);

		System.out.print("first sorted linked list: ");
		a1.print();
		System.out.print("seconde sorted linked list:");
		b3.print();
		SNode<Integer> c0 = LinkedListQuestions.merge(a1, b3);
		System.out.print("merged linked list:");
		c0.print();
	}

	@Test
	public void testMergeLinkedListIteration2(){

		SNode<Integer> b6 = new SNode<Integer>(10);
		SNode<Integer> b5 = new SNode<Integer>(7, b6);
		SNode<Integer> b4 = new SNode<Integer>(5, b5);
		SNode<Integer> b3 = new SNode<Integer>(3, b4);

		System.out.print("first sorted linked list: ");
		a1.print();
		System.out.print("seconde sorted linked list:");
		b3.print();
		SNode<Integer> c0 = LinkedListQuestions.merge2(a1, b3);
		System.out.print("merged linked list:");
		c0.print();
	}

	@Test
	public void testMergeLinkedListRecursion(){
		SNode<Integer> b6 = new SNode<Integer>(10);
		SNode<Integer> b5 = new SNode<Integer>(7, b6);
		SNode<Integer> b4 = new SNode<Integer>(5, b5);
		SNode<Integer> b3 = new SNode<Integer>(3, b4);

		System.out.print("first sorted linked list: ");
		a1.print();
		System.out.print("seconde sorted linked list:");
		b3.print();
		SNode<Integer> c0 = LinkedListQuestions.mergeR(a1, b3);
		System.out.print("merged linked list:");
		c0.print();

	}

	@Test
	public void testRemoveDuplicatesNoDuplicates(){
		a1.print();
		SNode<Integer> newHeader = LinkedListQuestions.removeDuplicates(a1);
		newHeader.print();
	}

	@Test
	public void testRemoveDuplicatesMiddleDuplicated(){
		SNode<Integer> b8 = new SNode<Integer>(5);
		SNode<Integer> b7 = new SNode<Integer>(4, b8);
		SNode<Integer> b6 = new SNode<Integer>(4, b7);
		SNode<Integer> b5 = new SNode<Integer>(3, b6);
		SNode<Integer> b4 = new SNode<Integer>(3, b5);
		SNode<Integer> b3 = new SNode<Integer>(2, b4);
		SNode<Integer> b2 = new SNode<Integer>(1, b3);

		b2.print();
		SNode<Integer> newHeader = LinkedListQuestions.removeDuplicates(b2);
		newHeader.print();
		b2.print();
	}

	@Test
	public void testRemoveDuplicatesHeaderDuplicated(){
		SNode<Integer> b8 = new SNode<Integer>(5);
		SNode<Integer> b7 = new SNode<Integer>(4, b8);
		SNode<Integer> b6 = new SNode<Integer>(4, b7);
		SNode<Integer> b5 = new SNode<Integer>(3, b6);
		SNode<Integer> b4 = new SNode<Integer>(1, b5);
		SNode<Integer> b3 = new SNode<Integer>(1, b4);
		SNode<Integer> b2 = new SNode<Integer>(1, b3);

		b2.print();
		SNode<Integer> newHeader = LinkedListQuestions.removeDuplicates(b2);
		newHeader.print();
		b2.print();
	}

	@Test
	public void testPartition(){
		//1->4->3->2->5->2 and x = 3,
		SNode<Integer> b7 = new SNode<Integer>(2);
		SNode<Integer> b6 = new SNode<Integer>(5, b7);
		SNode<Integer> b5 = new SNode<Integer>(2, b6);
		SNode<Integer> b4 = new SNode<Integer>(3, b5);
		SNode<Integer> b3 = new SNode<Integer>(4, b4);
		SNode<Integer> b2 = new SNode<Integer>(1, b3);

		b2.print();
		SNode<Integer> newHeader = LinkedListQuestions.partition(b2, 3);
		newHeader.print();
	}

	@Test
	public void testPartition2(){
		//1->4->3->2->5->2 and x = 3,
		SNode<Integer> b7 = new SNode<Integer>(2);
		SNode<Integer> b6 = new SNode<Integer>(5, b7);
		SNode<Integer> b5 = new SNode<Integer>(2, b6);
		SNode<Integer> b4 = new SNode<Integer>(3, b5);
		SNode<Integer> b3 = new SNode<Integer>(4, b4);
		SNode<Integer> b2 = new SNode<Integer>(1, b3);

		b2.print();
		SNode<Integer> newHeader = LinkedListQuestions.partition2(b2, 3);
		newHeader.print();
	}

}
