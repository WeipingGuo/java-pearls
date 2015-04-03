/*
 *
 */
package org.javapearls.datastructure.linkedlist;

import org.javapearls.foundation.annotation.NotThreadSafe;

/**
 * A simple implementation of Double-linked liist.
 *
 * @param <E> the element type
 * @author wguo
 */
@NotThreadSafe
public class DLinkedList<E> {


	/** The header. */
	private transient Entry<E> header = null;

	/**
	 * Instantiates an empty linked list.
	 */
	public DLinkedList(){

	}

	/**
	 * Gets the header element
	 *
	 * @return the first
	 */
	public E getFirst(){
		if (header != null){
			return header.element;
		}
		return null;
	}

	/**
	 * Gets the tail element
	 *
	 * @return the last
	 */
	public E getLast(){
		if (header != null && header.prev != null){
			return header.prev.element;
		}
		return null;
	}

	/**
	 * Insert at the head.
	 *
	 * @param e the e
	 */
	public void insertHead(E e){

		if (header == null){
			header = new Entry<E>(e, null, null);
			header.prev = header;
			header.next = header;
			return;
		}

		Entry<E> oldHeader = header;
		header = new Entry<E>(e, oldHeader.prev, oldHeader);

		// old tail point to new header
		oldHeader.prev.next = header;

		oldHeader.prev = header;
	}

	/**
	 * Insert at the tail.
	 *
	 * @param e the e
	 */
	public void insertTail(E e){

		if (header == null){
			header = new Entry<E>(e, null, null);
			header.prev = header;
			header.next = header;
			return;
		}

		Entry<E> oldTail = header.prev;
		Entry<E> newTail = new Entry<E>(e, oldTail, header);

		oldTail.next = newTail;
		header.prev = newTail;
	}


	/**
	 * Find an element
	 *
	 * @param e the e
	 * @return the e
	 */
	public E find(E e){

		if (header == null){
			return null;
		}

		if (header.element.equals(e)){
			return header.element;
		}

		Entry<E> entry = header.next;
		while (entry != header){
			if (entry.element.equals(e)){
				return entry.element;
			}
			entry = entry.next;
		}

		return null;
	}

	/**
	 * Removes an element from the list.
	 *
	 * @param e the e
	 */
	public void remove(E e){

		if (header == null){
			return;
		}

		if (header.element.equals(e)){
			clear(header);
			header = null;
			return ;
		}

		Entry<E> next = header.next;
		Entry<E> entry = null;
		while (next != header){
			if (next.element.equals(e)){
				entry = next;
				break;
			}
			next = next.next;
		}

		// not found
		if (entry == null){
			return;
		}

		entry.prev.next = entry.next;
		entry.next.prev = entry.prev;

		clear(entry);
		entry = null;
	}

	/**
	 * Remove all the elements from the list
	 */
	public void clear(){
		if (header == null){
			return;
		}

		Entry<E> entry = header.next;
		while (entry != header){
			Entry<E> next = entry.next;
			entry.prev.next = next;
			next.prev = entry.prev;

			clear(entry);
			entry = next;
		}
		clear(header);
		header = null;
	}

	/**
	 * Clear up an element
	 *
	 * @param e
	 */
	private void clear(Entry<E> e){
		e.element = null;
		e.prev = e.next = null;
	}


	/**
	 * Static inner class present each node.
	 *
	 * @param <E> the element type
	 * @author wguo
	 */
	private static class Entry<E>{

		/** The element. */
		E element;

		/** The prev. */
		Entry<E> prev;

		/** The next. */
		Entry<E> next;

		/**
		 * Instantiates a new entry.
		 *
		 * @param e the e
		 * @param p the p
		 * @param n the n
		 */
		public Entry(E e, Entry<E> p, Entry<E> n){
			this.element = e;
			this.prev = p;
			this.next = n;
		}
	}

}
