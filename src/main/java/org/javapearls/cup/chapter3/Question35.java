package org.javapearls.cup.chapter3;

import java.util.Stack;

/**
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class Question35 {


	public static class MyQueue<E> {

		private Stack<E> in;
		private Stack<E> out;

		public MyQueue() {
			in = new Stack<E>();
			out = new Stack<E>();
		}

		public void add(E e) {
			in.push(e);
		}

		public E remove() {
			if (!out.isEmpty()) {
				return out.pop();
			}

			// copy over
			while (!in.isEmpty()) {
				out.push(in.pop());
			}

			if (!out.isEmpty()) {
				return out.pop();
			}
			return null;
		}

		public E peek() {
			if (!out.isEmpty()) {
				return out.peek();
			}

			while (!in.isEmpty()) {
				out.push(in.pop());
			}

			if (!out.isEmpty()) {
				return out.peek();
			}
			return null;
		}

	}


}
