package org.javapearls.cup.chapter14;

import java.util.Iterator;

public class CircularArray<E> {

	private volatile int size;
	private Node<E> header;

	public CircularArray(){
		header = new Node<E>(null);
		header.next = header.prev = header;
	}

	public void add(E e){
		Node<E> node = new Node<E>(e);

		Node<E> tmp = header.next;
		header.next = node;
		node.next = tmp;
		node.prev = header;
		tmp.prev = node;

		size++;
	}

	public void rotate(){

	}


	@SuppressWarnings("unused")
	private static class Node<E>{
		Node<E> prev = null;;
		Node<E> next = null;;
		E data;

		public Node(E data){
			this.data = data;
		}
		public Node(E data, Node<E> prev, Node<E> next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}

	public class MyIterator implements Iterator<E>{

		private Node<E> current;

		public MyIterator(Node<E> start){
			this.current = start;
		}

		@Override
		public boolean hasNext() {
			if (current.next != current){
				return true;
			}
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}
}
