package org.javapearls.cup.chapter2;

import java.util.HashSet;
import java.util.Set;

import org.javapearls.datastructure.linkedlist.SLinkedList;

/**
 * Write code to remove duplicates from an unsorted linked list
 *
 * How would you solve this problem if a temporary buffer is not allowed?
 *
 * @author wguo
 *
 */
public class Question21 {


	/**
	 * Algorithm:
	 * (1)remove the header element;
	 * (2)find the duplicate in the remaining list. if found, remove it from the list
	 * (3)add the header to the tail
	 * (4)stop when tail is the same as the original header
	 *
	 * @param origList
	 */
	public static void removeDuplicate(SLinkedList<String> origList){

		if (origList == null || origList.getSize() == 0){
			return;
		}

		String head = origList.removeFirst();
		String tailed = null;

		while (head != null && head != tailed){

			String found = origList.find(head);

			// if duplicate found, remove it and try again.
			// if no found, add 'header' to the tail
			if (found != null){
				origList.remove(found);
			}
			else {
				origList.addTail(head);

				// remember the original header
				if (tailed == null){
					tailed = head;
				}

				// we have finish whole list
				if (origList.getFirst() == tailed){
					break;
				}

				head = origList.removeFirst();
			}
		}
	}


	/**
	 * Remove duplication using a set
	 *
	 * @param <E>
	 * @param header
	 */
	public static <E> void removeDup(SNode<E> header){

		if (header == null || header.next == null){
			return;
		}

		Set<E> set = new HashSet<E>();
		SNode<E> previous = null;
		while (header != null){
			if (set.contains(header.element)){
				previous.next = header.next;
			}else{
				set.add(header.element);
				previous = header;
			}
			header = header.next;
		}
	}

	public static <E> void removeDup3(SNode<E> header){

		if (header == null || header.next == null){
			return;
		}

		SNode<E> prev = header;
		SNode<E> current = header.next;

		while(current != null){

			SNode<E> p = header;
			while (p != current){

				// remove the current
				if (p.element.equals(current.element)){
					SNode<E> tmp = current.next;
					prev.next = tmp;
					current = tmp;
					break;
				}
				p = p.next;
			}

			if (p == current){
				prev = current;
				current = current.next;
			}

		}
	}

	public static <E> SNode<E> mergeSort(SNode<E> a){

		if (a == null || a.next == null){
			return a;
		}

		// split linked list to two
		SNode<E> middle = getMiddle(a);
		SNode<E> half = middle.next;
		middle.next = null;

		SNode<E> result = merge(mergeSort(a), mergeSort(half));

		return result;
	}

	@SuppressWarnings("unchecked")
	public static <E> SNode<E> merge(SNode<E> a, SNode<E> b){

		SNode<E> newHeader = new SNode<E>(null,null);
		SNode<E> current = newHeader;

		while (a != null && b != null){
			if (((Comparable<E>)a.element).compareTo(b.element) <= 0 ){
				current.next = a;
				a = a.next;
			}
			else{
				current.next = b;
				b = b.next;
			}
			current = current.next;
		}

		current.next = (a == null) ? b : a;
		return newHeader.next;
	}

	/**
	 * return half way of the linkedlist
	 * @param <E>
	 * @param header
	 * @return
	 */
	public static <E> SNode<E> getMiddle(SNode<E> header){

		SNode<E> slow = header;
		SNode<E> faster = header;
		while (faster.next != null && faster.next.next != null){
			faster = faster.next.next;
			slow = slow.next;
		}
		return slow;
	}

	public static <E> SNode<E> reverse(SNode<E> a){
		if (a == null || a.next == null){
			return a;
		}

		SNode<E> prev = a;
		SNode<E> next = prev.next;
		SNode<E> temp = null;

		a.next = null;

		while (next != null){
			temp = next.next;
			next.next = prev;
			prev = next;
			next = temp;
		}

		return prev;
	}



}
