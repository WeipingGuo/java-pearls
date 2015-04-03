package org.javapearls.cup.chapter2;


/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
 * EXAMPLE
 * Input: the node c from the linked list a->b->c->d->e
 * Result: nothing is returned, but the new linked list looks like a->b->d->e
 *
 * @author wguo
 *
 */
public class Question23 {


	/**
	 * Delete particular node from the single linked list given
	 * only have access to this particular node
	 *
	 * Alg: copy the next element to the current one and
	 * delete the next node.
	 *
	 * @param <K> the key type
	 * @param n the n
	 */
	public static <K> void delete(SNode<K> n){

		if (n == null){
			return;
		}

		if (n.next == null){
			throw new IllegalStateException("cannot delete the last element in the list");
		}

		SNode<K> next = n.next;
		n.element = next.element;
		next.element = null;
		n.next = next.next;
	}

}
