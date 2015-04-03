package org.javapearls.datastructure.linkedlist;

import org.javapearls.cup.chapter2.SNode;

public class LinkedListQuestions {

	/**
	 * Reverse a linked list from position m to n.
	 * Do it in-place and in  one-pass.
	 *
	 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * return  1->4->3->2->5->NULL.
	 * Note: Given m, n satisfy the following condition:
	 * 1≤ m ≤ n ≤ length of list.
	 */
	public static <E> SNode<E> reverse(SNode<E> header, int m, int n) {

		if (m > n) {
			throw new IllegalArgumentException("n must greater than m");
		}

		if (m == n) {
			return header;
		}

		// using a dummy header to hold the start
		SNode<E> dummy = new SNode<E>(header.element, header);
		SNode<E> pre = dummy, current = header, preM = null;
		for (int i = 1; i < n; i++){

			if (i == m) preM = pre;

			// reverse the nodes between m - n
			// pre->current
			if (i > m){
				SNode<E> tmp = current.next;
				current.next = pre;
				pre = current;
				current = tmp;
			}else {
				pre = current;
				current = current.next;
			}
		}

		// current node is the n-node
		// m-node.next --> n-node.next
		// n-node.next --> pre
		preM.next.next = current.next;
		preM.next = current;
		current.next = pre;

		return header = dummy.next;
	}


	/**
	 * merge two sorted linked list
	 * iteration way:
	 */
	public static <E extends Comparable<E>> SNode<E> merge(SNode<E> a, SNode<E> b) {

		if (a == null)	return b;
		if (b == null)	return a;
		if (a == b) return a;

		SNode<E> header = null;
		if (a.element.compareTo(b.element) < 0) {
			header = a;
			a = a.next;
		} else {
			header = b;
			b = b.next;
		}

		SNode<E> current = header;
		while (a != null && b != null) {

			if (a.element.compareTo(b.element) < 0) {
				current.next = a;
				a = a.next;
			} else {
				current.next = b;
				b = b.next;
			}
			current = current.next;
		}

		// point to the remaining
		if (a != null) {
			current.next = a;
		}
		if (b != null) {
			current.next = b;
		}

		return header;
	}

	public static <E extends Comparable<E>> SNode<E> mergeR(SNode<E> a, SNode<E> b){

		if (a == null) return b;
	    if (b == null) return a;
	    if (a == b) return a;

	    SNode<E> header = null;
	    if (a.element.compareTo(b.element) < 0){
	        header = a;
	        header.next = merge(a.next, b);
	    }else{
	        header = b;
	        header.next = merge(a, b.next);
	    }

	    return header;

	}

	/**
	 * merge two sorted linked list
	 * iteration way:
	 */
	public static <E extends Comparable<E>> SNode<E> merge2(SNode<E> a, SNode<E> b) {

		if (a == null)	return b;
		if (b == null)	return a;
		if (a == b) return a;

		// introduce a dummy header to make code cleaner
		SNode<E> header = new SNode<E>(null);
		SNode<E> current = header;

		while (a != null && b != null) {

			if (a.element.compareTo(b.element) < 0) {
				current.next = a;
				a = a.next;
			} else {
				current.next = b;
				b = b.next;
			}
			current = current.next;
		}

		// point to the remaining
		if (a != null) {
			current.next = a;
		}
		if (b != null) {
			current.next = b;
		}

		return header.next;
	}

	public static <E> boolean isCycle(SNode<E> header){
	    if (header == null) return true;

	    SNode<E> slow = header, faster = header;
	    while (faster.next != null && faster.next.next != null){
	        slow = slow.next;
	        faster = faster.next.next;
	        if (slow == faster){
	            return true;
	        }
	    }
	    return false;
	}

	/**
	 *Given a sorted linked list, delete all nodes that have duplicate numbers,
	 * leaving only distinct numbers from the original list.
	 * For example,
	 * Given 1->2->3->3->4->4->5, return 1->2->5.
	 * Given 1->1->1->2->3, return 2->3.
	 */
	public static SNode<Integer> removeDuplicates(SNode<Integer> header){

	    if (header == null || header.next == null){
	        return header;
	    }

	    // a dummy node to track the header of new linked list
	    SNode<Integer> dummy = new SNode<Integer>(null);
	    dummy.next = header;
	    SNode<Integer> prev = dummy, current = dummy.next, runner = current.next;

	    while (runner != null){

	    	boolean found = false;
	        while (runner != null && runner.element == current.element){
	        	// clean up reference
	        	current.next = null;

	        	SNode<Integer> tmp = runner.next;
	        	runner.next = null;
	            runner = tmp;
	            found = true;
	        }

	        // found the duplicate, change 'prev' next
	        if (found == true){
	            prev.next = runner;
	        }
	        else{
	            prev = current;
	        }
	        current = runner;
	        if (runner != null){
	            runner = runner.next;
	        }
	    }

	    return dummy.next;
	}

	/**
	 * Given a linked list and a value x, partition it such that all nodes less than x come
	 * before nodes greater than or equal to x.
	 * You should preserve the original relative order of the nodes in each of the two partitions.
	 * For example,
	 * Given 1->4->3->2->5->2 and x = 3,
	 * return 1->2->2->4->3->5.
	 *
	 * @param <E>
	 * @param header
	 * @return
	 */
	public static SNode<Integer> partition(SNode<Integer> header, int x){

		if (header == null || header.next == null) return header;

		// split into two linked list from the middle
		SNode<Integer> middle = split(header);

		SNode<Integer> first = partition(header, x);
		SNode<Integer> second = partition(middle, x);

		// merge two together
		SNode<Integer> dummy = new SNode<Integer>(null);
		SNode<Integer> current = dummy;
		while (first != null && second != null){
			if (first.element >= x && second.element >= x){
				break;
			}
			if (first.element < x){
				current.next = first;
				first = first.next;
				current = current.next;
			}
			if (second.element < x){
				current.next = second;
				second = second.next;
				current = current.next;
			}
		}

		while (first != null){
			current.next = first;
			current = current.next;
			first = first.next;
		}
		while (second != null){
			current.next = second;
			current = current.next;
			second = second.next;
		}

		return dummy.next;
	}

	public static SNode<Integer> split(SNode<Integer> header){

		SNode<Integer> slow = header;
		SNode<Integer> faster = header;
		while (faster.next != null && faster.next.next != null){
			slow = slow.next;
			faster = faster.next.next;
		}

		SNode<Integer> newHeader = slow.next;
		slow.next = null;
		return newHeader;
	}

	public static SNode<Integer> partition2(SNode<Integer> header, int x){
		if (header == null || header.next == null) return header;

		SNode<Integer> dummy = new SNode<Integer>(null);
		dummy.next = header;
		SNode<Integer> pivot = new SNode<Integer>(x);

		SNode<Integer> prev = dummy, current = dummy.next, pivotTracker = pivot;

		while (current != null){
			if (current.element >= x){
				prev.next = current.next;
				pivotTracker.next = current;
				current.next = null;
				pivotTracker = pivotTracker.next;
				current = prev.next;
			}else{
				prev = current;
				current = current.next;
			}
		}
		prev.next = pivot.next;

		return dummy.next;
	}

}
