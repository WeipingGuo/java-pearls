package org.javapearls.datastructure.linkedlist;

import java.util.HashSet;

/**
 * A simple implementation of Single-linked list
 *
 *
 */
public class SLinkedList<E> {

	private Entry<E> header = null;
	private int size = 0;

	public SLinkedList(){

	}

	public int getSize(){
		return this.size;
	}

	public void addHeader(E e){
		if (header == null){
			header = new Entry<E>(e, null);
			size++;
			return;
		}

		Entry<E> newHeader = new Entry<E>(e, header);
		header = newHeader;
		size++;
	}

	public void addTail(E e){

		if (header == null){
			header = new Entry<E>(e, null);
			size++;
			return;
		}

		// find the tail
		Entry<E> next = header;
		while (next.next != null){
			next = next.next;
		}

		next.next = new Entry<E>(e, null);
		size++;
	}

	public E removeFirst(){
		if (header == null){
			return null;
		}

		Entry<E> oldHeader = header;
		header = header.next;

		size--;

		return oldHeader.data;
	}

	public E getFirst(){
		if (header != null){
			return header.data;
		}
		return null;
	}

	public E getLast(){
		if (header == null){
			return null;
		}

		Entry<E> next = header;
		while (next.next != null){
			next = next.next;
		}

		return next.data;
	}

	public E find(E e){

		if (header == null){
			return null;
		}

		if (header.data.equals(e)){
			return header.data;
		}

		Entry<E> next = header.next;
		while (next != null){
			if (next.data.equals(e)){
				return next.data;
			}
			next = next.next;
		}

		return null;
	}

	public void remove(E e){
		if (header == null){
			return;
		}

		if (header.data.equals(e)){
			header.data = null;
			header = header.next;
			size--;
			return;
		}

		// locate the element
		Entry<E> current = header;
		Entry<E> next = current.next;
		while (next != null){
			if (next.data.equals(e)){
				break;
			}
			current = next;
			next = next.next;
		}

		// not found
		if (next == null){
			return;
		}

		current.next = next.next;
		next.data = null;
		next.next = null;
		size--;
	}

	public void removeDuplicate(){

		if (size <= 1){
			return;
		}

		HashSet<E> set = new HashSet<E>();

		// need keep track two variables.
		Entry<E> next = header;
		Entry<E> previous = null;
		while (next != null){
			// set contains the unique element
			if (set.contains(next.data)){
				previous.next = next.next;
				next.data = null;
				next = previous.next;
				size--;
			}else{
				set.add(next.data);
				previous = next;
				next = next.next;
			}
		}

	}

	public void clear(){
		if (header == null){
			return;
		}

		Entry<E> next = header.next;
		while (next != null){
			next.data = null;
			next.next = null;
			next = next.next;
		}

		header.data = null;
		header.next = null;
		header = null;
		size = 0;
	}


	private static class Entry<E>{
		Entry<E> next;
		E data;

		public Entry(E e, Entry<E> next){
			this.data = e;
			this.next = next;
		}
	}

}
