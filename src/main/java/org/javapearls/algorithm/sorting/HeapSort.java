package org.javapearls.algorithm.sorting;

/**
 * Heap: binary heap is a complete binary tree
 *
 * A:length - gives the number of elements in the array
 * A:heap-size - how many elements in the heap are stored within array A.
 * Index: 0 -- length - 1
 *
 * @author wguo
 *
 */
public class HeapSort {

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
	public void maxHeapify(int[] a, int i, int heapSize){

		int l = left(i);
		int r = right(i);

		int largest = i;

		// find the largest element among itself and its
		// left and right children
		// compare to its left child
		if (l < heapSize && a[l] > a[i]){
			largest = l;
		}

		// compare to the right child
		if (r < heapSize && a[r] > a[largest]){
			largest = r;
		}

		// swap the largest element to the root
		// recursively call
		if (largest != i){
			int t = a[i];
			a[i] = a[largest];
			a[largest] = t;
			maxHeapify(a, largest, heapSize);
		}
	}

	/**
	 * Build a maximum heap for an array
	 *
	 * http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/util/PriorityQueue.java#PriorityQueue.heapify%28%29
	 *
	 * @param a
	 */
	public void buildMaxHeap(int[] a){
		for (int i = a.length >>> 1; i >= 0; i--){
			maxHeapify(a, i, a.length);
		}
	}


	public void sort(int[] a){

		// build the max heap first
		// O(nlgn)
		buildMaxHeap(a);

		int heapSize = a.length;
		for(int i = a.length - 1; i >= 1; i--){

			// swap a[0] to a[i];
			int t = a[i];
			a[i] = a[0];
			a[0] = t;

			heapSize--;
			maxHeapify(a, 0, heapSize);
			SortingUtil.printArray(a);
		}
	}


}
