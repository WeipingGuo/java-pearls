package org.javapearls.collections.queue;


/**
 * Heap can be used to implement a priority queue
 *
 * A priority queue is a data structure for maintaining a set S of elements, each
 * with an associated value called a key.
 *
 * MAXIMUM(S) - returns the element of S with the largest key.
 * EXTRACT-MAX(S) removes and returns the element of S with the largest key.
 * INSERT(S, x)
 * INCREASE-KEY(S, x, k) -
 *
 * @author wguo
 *
 */
public class MaxPriorityQueue {

	// the number element in the heap
	private int heapSize = 0;

	private int capacity = 10;

	private Job[] a = null;

	public MaxPriorityQueue(int capacity){
		this.capacity = capacity;
		this.a = new Job[capacity];
	}

	public MaxPriorityQueue(){
		this.a = new Job[capacity];
	}

	public int getHeapSize(){
		return this.heapSize;
	}

	/**
	 * Return the maximum element
	 *
	 * @return
	 */
	public Job maximum(){
		if ( heapSize == 0){
			return null;
		}
		else{
			return a[0];
		}
	}

	public Job extractMax(){
		if (heapSize == 0){
			return null;
		}

		Job max = a[0];

		// only has one element
		if (heapSize == 1){
			heapSize = 0;
			a[0] = null;
			return max;
		}

		a[0] = a[heapSize - 1];
		heapSize--;
		maxHeapify(a, 0, heapSize);
		return max;
	}

	public void insert(Job newValue){
		heapSize++;

		// make the increaseKey method happy
		a[heapSize - 1] = newValue;

		increaseKey(heapSize - 1, newValue);
	}

	public void increaseKey(int i, Job newValue){

		// new key is less than the current key
		if (newValue.getPriority() < a[i].getPriority()){
			return;
		}

		// set the new key
		a[i] = newValue;

		// need set the parent
		while (i > 0 && a[parent(i)].getPriority() < a[i].getPriority()){

			// swap a[i] with its parent
			Job t = a[i];
			a[i] = a[parent(i)];
			a[parent(i)] = t;
			i = parent(i);
		}

	}


	/**
	 * Find the index for its left child
	 *
	 * @param index
	 * @return
	 */
	public int left(int index){
		return 2*index  + 1;
	}

	/**
	 * Find the index for its right child
	 *
	 * @param index
	 * @return
	 */
	public int right(int index){
		return (index + 1) * 2;
	}

	/**
	 * Find the index for its parent
	 *
	 * @param index
	 * @return
	 */
	public int parent(int index){
		return (index - 1)/2;
	}

	/**
	 * Maintain the max heap property for element given
	 * to root i: running time lg(n)
	 *
	 * @param a
	 * @param i
	 * @param heapSize
	 */
	public void maxHeapify(Job[] a, int i, int heapSize){

		int l = left(i);
		int r = right(i);

		int largest = i;

		// compare to its left child
		if (l < heapSize &&  a[l].getPriority() > a[r].getPriority()){
			largest = l;
		}

		// compare to the right child
		if (r < heapSize && a[r].getPriority() > a[largest].getPriority()){
			largest = r;
		}

		// swap the largest element to the root
		// recursively call
		if (largest != i){
			Job t = a[i];
			a[i] = a[largest];
			a[largest] = t;
			maxHeapify(a, largest, heapSize);
		}
	}


}
