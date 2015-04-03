package org.javapearls.cup.chapter2;

/**
 * special nodes with two nodes: next and other
 *
 * @author wguo
 *
 * @param <E>
 */
public class RNode<E> {

	public RNode<E> next;
	public RNode<E> other;
	public E data;

	public RNode(){

	}

	public RNode(E e){
		this.data = e;
	}

}
