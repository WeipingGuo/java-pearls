package org.javapearls.cup.chapter2;

import java.util.Stack;

/**
 * Implement an algorithm to find the nth to last element of a singly linked list
 *
 * @author wguo
 *
 */
public class Question22 {

	/**
	 * find the nth to the last element using a stack.
	 *
	 * @param <K> the key type
	 * @param header the header
	 * @param rank the rank
	 * @return the k
	 */
	public static <K> K nthElement(SNode<K> header, int rank){

		Stack<K> s = new Stack<K>();

		// push everything into the stack
		while (header != null){
			s.push(header.element);
			header = header.next;
		}

		// find out the nth element
		while (rank > 0 && !s.isEmpty()){
			s.pop();
			rank--;
		}

		if (s.isEmpty()){
			return null;
		}

		return s.pop();
	}

	/**
	 * Find the nth element to the last element, using window slide.
	 *
	 * @param <K> the key type
	 * @param header the header
	 * @param n the n
	 * @return the k
	 */
	public static <K> K nth2Last(SNode<K> header, int n){

		if (header == null){
			return null;
		}

		// using window slide
		SNode<K> p1 = header;
		SNode<K> p2 = header;

		int distance = 0;
		while (distance < n){
			p2 = p2.next;
			if (p2 == null){
				throw new IllegalStateException("the linked list does not contain " + (n+1) + " nodes");
			}
			distance++;
		}

		// the distance between p1 and p2  == n
		// keep the window, move p2 to the tail
		while (p2.next != null){
			p2 = p2.next;
			p1 = p1.next;
		}

		return p1.element;
	}

}
