package org.javapearls.cup.chapter2;

/**
 * The Class DNode.
 *
 * @param <K> the key type
 */
public class DNode<K> {

	/** The element. */
	K element;

	/** The previous node. */
	DNode<K> prev;

	/** The next node. */
	DNode<K> next;


	/**
	 * Instantiates a new double-linked node.
	 *
	 * @param element the element
	 * @param prev the prev
	 * @param next the next
	 */
	public DNode(K element, DNode<K> prev, DNode<K> next){
		this.element = element;
		this.prev = prev;
		this.next = next;
	}

}
