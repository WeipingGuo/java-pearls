package org.javapearls.collections.queue;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Implementation using a heap. For a heap, for every node x with parent p,
 * the element of p must smaller or equal to x
 *
 * All nodes are either greater than or equal to or less than or equal to each of its children,
 * according to a comparison predicate defined for the heap.
 *
 * @author wguo
 *
 * @param <E>
 */
public class MyPriorityQueue <E> {

	private int size;
	private Object[] array;
	private final Comparator<? super E> comparator;

	public MyPriorityQueue(int capacity){
		this.array = new Object[capacity];
		this.size = 0;
		this.comparator = null;
	}

	public boolean add(E e){
		return offer(e);
	}

	public boolean offer(E e){

		if (e == null){
			throw new IllegalArgumentException("null element is disallowed");
		}

		int i = size;
		if (size >= array.length){
			// grow the array
			System.out.println("increase the array size!");
			array = Arrays.copyOf(array, size * 2);
		}
		size++;

		// first element
		if (i == 0){
			array[0] = e;
		}else{
			siftUp(i, e);
		}

		return true;
	}

	/**
	 * Remove the minimum element
	 *
	 * @return
	 */
	public boolean remove(){
		if (size <= 0){
			return false;
		}
		removeAt(0);
		return true;
	}

	public boolean remove(Object o){
		int index = indexOf(o);
		if (index == -1){
			return false;
		}else{
			removeAt(index);
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	private void removeAt(int k){

		int s = --size;
		if (s == k){ // the last element
			array[s] = null;
		} else {
			// move the last element
			E moved = (E)array[s];
			array[s] = null;
			siftDown(k, moved);

			if (array[k] == moved){
				siftUp(k, moved);
			}
		}

	}

	private void siftDown(int k, E e){
		if (comparator != null){
			siftDownComparator(k, e);
		} else {
			siftDownComparable(k, e);
		}
	}

	private void siftDownComparator(int k, E e){

	}

	@SuppressWarnings("unchecked")
	private void siftDownComparable(int k, E e){

		Comparable<? super E> key = (Comparable<? super E>)e;
		int half = size >>> 1;

		while (k < half){

			// pick up the smaller one from the child

			// left child
			int child = (k << 1) + 1;
			Object c = array[child];
			// the right child
			int right = child + 1;
			if (right < size &&
					((Comparable<? super E>)c).compareTo((E)array[right]) > 0){
				c = array[child = right]; // pick the right child
			}

			// find its position already
			if (key.compareTo((E) c) <= 0){
				break;
			}

			array[k] = c;
			k = child;
		}

		array[k] = key;

	}


	private void siftUp(int k, E e){
		if (comparator != null){
			siftUpWithComparator(k, e);
		}else{
			siftUpComparable(k, e);
		}

	}

	@SuppressWarnings("unchecked")
	private void siftUpComparable(int k, E e){

		Comparable<? super E> key = (Comparable<? super E>)e;

		// find the position of the new element
		while (k > 0){

			// find the parent
			int parent = (k - 1) >>> 1;
			Object o = array[parent];

			// the key is >= its parent, done
			if (key.compareTo((E)o) >= 0){
				break;
			}

			// put the parent element into k
			array[k] = o;
			k = parent;
		}

		array[k] = key;
	}

	@SuppressWarnings("unchecked")
	private void siftUpWithComparator(int k, E e){

		while (k > 0){
			int parent = (k - 1) >>> 1;
			Object o = array[parent];
			if (comparator.compare(e, (E)o) >= 0){
				break;
			}
			array[k] = o;
			k = parent;
		}
		array[k] = e;
	}

	private int indexOf(Object o){

		for (int i = 0; i < size; i++){
			if (o.equals(array[i])){
				return i;
			}
		}

		return -1;
	}

	public void print(){
		System.out.print("array[");
		for (int i = 0; i < size; i++){
			if (array[i] == null){
				System.out.print("n/a" + ",");
			}else{
				System.out.print(array[i].toString() + ",");
			}
		}
		System.out.print("]\n");
	}
}
