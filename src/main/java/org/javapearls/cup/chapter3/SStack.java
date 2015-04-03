package org.javapearls.cup.chapter3;

import org.javapearls.cup.chapter2.SNode;


/**
 * Simple stack implementation using a linked list
 *
 * @author wguo
 *
 * @param <K>
 */
public class SStack<K> {

	private SNode<K> top = null;
	private transient int size = 0;

	/**
	 * Instantiates a new empty stack.
	 */
	public SStack(){

	}

	/**
	 * Peek the top element
	 *
	 * @return the k
	 */
	public K peek(){
		if (top == null){
			return null;
		}
		return top.element;
	}

	/**
	 * Remove the top element
	 *
	 * @return the k
	 */
	public K pop(){
		if (top == null){
			return null;
		}

		SNode<K> r = top;
		top = top.next;
		size--;

		r.next = null;
		return r.element;
	}

	/**
	 * Push an element to the stack
	 *
	 * @param element the element
	 */
	public void push(K element){
		if (top == null){
			top = new SNode<K>(element, null);
			size++;
			return;
		}
		top = new SNode<K>(element, top);
		size++;
	}

	/**
	 * The total number elements in the stack
	 *
	 * @return the int
	 */
	public int size(){
		return size;
	}

}
