/*
 *
 */
package org.javapearls.cup.chapter3;

import org.javapearls.cup.chapter2.SNode;


/**
 * Stack supports pop, push and min
 *
 * @author wguo
 *
 */
public class MinSStack<K extends Comparable <K>> {

	/** The head. */
	private SNode<K> head = null;

	/** The linked list to keep the minimum element. */
	private SNode<K> min = null;


	/**
	 * Instantiates a new empty stack.
	 */
	public MinSStack(){

	}

	/**
	 * Return the minimum element in the stack
	 *
	 * @return the k
	 */
	public K min(){
		if (min == null){
			return null;
		}
		return min.element;
	}

	/**
	 * Remove the top element from the stack
	 *
	 * @return the k
	 */
	public K pop(){
		if (head == null){
			return null;
		}

		SNode<K> oldHead = head;
		head = head.next;

		oldHead.next = null;

		// if same as the min, remove the min too
		if (oldHead.element.equals(min.element)){
			min = min.next;
		}

		return oldHead.element;
	}

	/**
	 * Push an element to the stack
	 *
	 * @param element the element
	 * @return the k
	 */
	public K push(K element){
		if (head == null){
			head = new SNode<K>(element, null);
			min = new SNode<K>(element, null);
			return element;
		}

		head = new SNode<K>(element, head);

		if (head.element.compareTo(min.element) <= 0){
			min = new SNode<K>(element, min);
		}
		return element;
	}

}
