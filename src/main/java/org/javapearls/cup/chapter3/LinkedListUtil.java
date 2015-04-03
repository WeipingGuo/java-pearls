/*
 *
 */
package org.javapearls.cup.chapter3;

import org.javapearls.cup.chapter2.SNode;
import org.javapearls.cup.chapter2.RNode;

public class LinkedListUtil {

	/**
	 * Sort a single-linked list
	 *
	 * @param <K> the key type
	 * @param head the head
	 */
	public static <K extends Comparable<K>> void sort(SNode<K> head){

		SNode<K> p1 = head;
		SNode<K> p2 = head.next;

		while (p1 != null){

			p2 = p1.next;
			while (p2 != null){
				// swap or keep track the minimum element
				if (p1.element.compareTo(p2.element) > 0 ){
					K temp = p1.element;
					p1.element = p2.element;
					p2.element = temp;
				}
				p2 = p2.next;
			}

			p1 = p1.next;
		}
	}


	/**
	 * Sort a linked list using nlgn and without extra space.
	 *
	 * @param <K> the key type
	 * @param head the head
	 */
	public static <K extends Comparable<K>> void mergeSort(SNode<K> head){

	}



	/**
	 * Gets the node which is half way of a given linked list
	 *
	 * @param <K> the key type
	 * @param head the head
	 * @return the median
	 */
	public static <K> SNode<K> getMedian(SNode<K> head){

		if (head == null){
			return null;
		}

		SNode<K> p1 = head;
		SNode<K> p2 = head;
		while (p2.next != null && p2.next.next != null){
			p1 = p1.next;
			p2 = p2.next.next;
		}

		return p1;
	}

	public static <E> SNode<E> partition(SNode<E> header){

	    if (header == null) {
	        return null;
	    }

	    SNode<E> slow = header;
	    SNode<E> fast = header;
	    while (fast.next != null && fast.next.next != null){
	        slow = slow.next;
	        fast = fast.next.next;
	    }

	    // slow is the new header
	    slow.next = null;
	    return slow;
	}

	/**
	 * Prints a linked list
	 *
	 * @param <K> the key type
	 * @param head the head
	 */
	public static <K> void print(SNode<K> head){

		SNode<K> p = head;
		while (p != null){
			System.out.print(p.element + ",");
			p = p.next;
		}
		System.out.print("\n");
	}


	public static <E> SNode<E> reverse(SNode<E> head){
	    if (head == null) {
	        return null;
	    }
	    if (head.next == null){
	        return head;
	    }
	    SNode<E> runner = head.next;
	    SNode<E> previous = head;
	    previous.next = null;
	    while (runner != null){
	        SNode<E> tmp = runner.next;
	        runner.next = previous;
	        previous = runner;
	        runner = tmp;
	    }
	    return previous;
	}


	public static <E> SNode<E> duplicate(SNode<E> header){
	    if (header == null) {
	        return header;
	    }

	    SNode<E> newHeader = new SNode<E>(header.element, null);
	    SNode<E> runner = newHeader;

	    while (header.next != null ){
	        SNode<E> newNode =
	        	new SNode<E>(header.next.element, null);

	        runner.next = newNode;
	        runner = runner.next;

	        header = header.next;
	    }

	    return newHeader;
	}


	public static <E> RNode<E> duplicate(RNode<E> header){

		if (header == null){
			return null;
		}

		// duplicate the linked list
		RNode<E> current = header;
		while (current != null){
			RNode<E> newNode = new RNode<E>(current.data);
			newNode.next = current.next;
			current.next = newNode;
			current = current.next.next;
		}

		// update the 'other' node
		current = header;
		while (current != null && current.next != null){
			current.next.other = current.other.next;
			current = current.next.next;
		}

		// seperate two list
		current = header;
		RNode<E> newHeader = current.next;
		while (current.next.next != null){
			RNode<E> tmp = current.next.next;
			current.next.next = tmp.next;
			current.next = tmp;
			current = tmp;
		}

		current.next = null;
		return newHeader;
	}

	public static <E> SNode<E> n2last(SNode<E> header, int n) {

		if (header == null)
			return null;

		SNode<E> current = header;
		SNode<E> runner = header;
		while (n > 0) {

			// not found
			if (runner == null) {
				return null;
			}

			runner = runner.next;
			n--;
		}

		if (runner == null) {
			return null;
		}

		while (runner.next != null) {
			current = current.next;
			runner = runner.next;
		}
		return current;

	}

	public static <E> SNode<E> reverseR(SNode<E> a) {

		if (a == null) {
			return null;
		}
		if (a.next == null) {
			return a;
		}

		SNode<E> node = reverseR(a.next);

		// a->b ==> b-> a
		a.next.next = a;
		a.next = null;

		return node;
	}

	public static SNode<Integer> sum(SNode<Integer> a, SNode<Integer> b){

	    // sanity check
	    if (a == null && b == null) return null;
	    if (a == null && b != null) return b;
	    if (a != null && b == null) return a;

	    int value = a.element + b.element;
	    int carryOver = 0;
	    if (value >= 10){
	        value -= 10;
	        carryOver = 1;
	    }

	    SNode<Integer> current = new SNode<Integer>(value);
	    SNode<Integer> newHeader = current;

	    SNode<Integer> p = a.next;
	    SNode<Integer> q = b.next;
	    while (p != null && q != null){

	        value = p.element + q.element + carryOver;

	        if (value >= 10){
	            value -= 10;
	            carryOver = 1;
	        }else{
	            carryOver = 0;
	        }

	        SNode<Integer> node = new SNode<Integer>(value);
	        current.next = node;
	        current = current.next;

	        p = p.next;
	        q = q.next;
	    }

	    // remaining
	    SNode<Integer> node = (p == null)? q : p;
	    while (node != null){
	        value = node.element + carryOver;
	        if (value >= 10){
	            value -= 10;
	            carryOver = 1;
	        }
	        else{
	            carryOver = 0;
	        }
	        current.next = new SNode<Integer>(value);
	        current = current.next;
	        node = node.next;
	    }

	    return newHeader;

	}

	/**
	 * recursive version
	 *
	 * @param a
	 * @param b
	 * @param carryOver
	 * @return
	 */
	public static SNode<Integer> add(SNode<Integer> a, SNode<Integer> b, int carryOver){

	    if (a == null  && b == null) return null;

	    int value = carryOver;
	    if (a != null){
	        value += a.element;
	    }
	    if (b != null){
	        value += b.element;
	    }

	    if (value >= 10){
	        value -= 10;
	        carryOver = 1;
	    }else {
	        carryOver = 0;
	    }

	    SNode<Integer> node = new SNode<Integer>(value);
	    SNode<Integer> next = add((a == null) ? null : a.next, (b == null) ? null : b.next, carryOver);
	    node.next = next;

	    return node;

	}

}
