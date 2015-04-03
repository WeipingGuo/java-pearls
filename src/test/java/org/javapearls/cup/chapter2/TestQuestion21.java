package org.javapearls.cup.chapter2;

import static org.junit.Assert.*;

import java.util.Set;

import org.javapearls.datastructure.linkedlist.SLinkedList;
import org.junit.Test;

public class TestQuestion21 {

	@Test
	public void testRemoveDuplicate() {

		SLinkedList<String> myList = new SLinkedList<String>();

		myList.addHeader("One");
		myList.addHeader("Two");
		myList.addHeader("Three");
		myList.addHeader("One");
		myList.addHeader("One");

		assertTrue(myList.getSize() == 5);
		Question21.removeDuplicate(myList);

		assertTrue(myList.getSize() == 3);



		myList.addHeader("Two");
		myList.addHeader("Two");
		myList.addHeader("Two");

		assertTrue(myList.getSize() == 6);
		myList.removeDuplicate();
		assertTrue(myList.getSize() == 3);

	}


	@Test
	public void testReverseLinkedlist(){

		SNode<String> s1 = new SNode<String>("one", null);
		SNode<String> s2 = new SNode<String>("two", s1);
		SNode<String> s3 = new SNode<String>("three", s2);
		SNode<String> s4 = new SNode<String>("four", s3);
		SNode<String> s5 = new SNode<String>("five", s4);

		s5.print();
		SNode<String> newHeader = Question21.reverse(s5);
		assertTrue(newHeader.element.equalsIgnoreCase("one"));

		newHeader.print();
	}

	@Test
	public void testMergeSortLinkedList(){
		SNode<String> s1 = new SNode<String>("one", null);
		SNode<String> s2 = new SNode<String>("two", s1);
		SNode<String> s3 = new SNode<String>("three", s2);
		SNode<String> s4 = new SNode<String>("four", s3);
		SNode<String> s5 = new SNode<String>("five", s4);

		s5.print();

		SNode<String> newHeader = Question21.mergeSort(s5);
		newHeader.print();
	}

	@Test
	public void testWildCardParameter(){


	}

	@Test
	public void testReverseLinkedList(){
		SNode<String> s1 = new SNode<String>("one", null);
		SNode<String> s2 = new SNode<String>("two", s1);
		SNode<String> s3 = new SNode<String>("three", s2);
		SNode<String> s4 = new SNode<String>("four", s3);
		SNode<String> s5 = new SNode<String>("five", s4);

		s5.print();
		SNode<String> newHeader = Question21.reverse(s5);
		newHeader.print();
	}



	// cannot add other thing than null to collection<?>
	// it is useful for non-modification operation.
	// basically the following method cannot modify
	// the collection
	public void addToSet(Set<?> set){
		//set.add("something");

		set.add(null);

	}

}
