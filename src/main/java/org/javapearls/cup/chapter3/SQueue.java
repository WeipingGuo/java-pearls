package org.javapearls.cup.chapter3;

import org.javapearls.cup.chapter2.SNode;


/**
 * A simple queue implementation using linked list.
 *
 * @param <K> the key type
 * @author wguo
 */
public class SQueue<K> {

	private SNode<K> head = null;
	private SNode<K> tail = null;

	/**
	 * Instantiates an empty queue.
	 */
	public SQueue(){

	}

	/**
	 * Enqueue.
	 *
	 * @param element the element
	 * @return the k
	 */
	public K enqueue(K element){

		// if tail is null, head must be null too
		if (tail == null){
			tail = new SNode<K>(element, null);
			head = tail;
			return element;
		}

		tail.next = new SNode<K>(element, null);
		tail = tail.next;
		return element;
	}

	/**
	 * Dequeue.
	 *
	 * @return the k
	 */
	public K dequeue(){

		if (head == null){
			return null;
		}

		SNode<K> oldHead = head;
		head = head.next;

		// single element? head and tail point to the same node
		if (tail == oldHead){
			tail = null;
		}

		oldHead.next = null;
		return oldHead.element;
	}


	/**
	 * Checks if is empty.
	 *
	 * @return true, if is empty
	 */
	public boolean isEmpty(){
		return (head == null) && (tail == null);
	}

}
