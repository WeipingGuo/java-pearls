package org.javapearls.collections.queue;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * Numbers are generated randomly and stored into an expanding array,
 * how would you keep track the median
 */
public class MedianTrack {

	private int size;

	// leftHeap is used to track smaller half so that the max element is root
	// rightHeap is used to track bigger half so the the min element is at root
	private PriorityQueue<Integer> leftHeap;
	private PriorityQueue<Integer> rightHeap;

	public MedianTrack(){
		this.size = 0;
		leftHeap = new PriorityQueue<Integer>();
		rightHeap = new PriorityQueue<Integer>(13, new ReverseComparator());
	}

	public void add(int data){

		leftHeap.add(data);
		rebalance();
		size++;
	}

	public int getMedian(){
		if (size % 2 == 0){
			return (leftHeap.peek() + rightHeap.peek())/2;
		}else{
			return leftHeap.peek();
		}
	}

	private void rebalance(){

		while (true){
			int left = leftHeap.size();
			int right = rightHeap.size();
			if (left > right + 1){
				rightHeap.add(leftHeap.remove());
			}else if (right > left + 1){
				leftHeap.add(rightHeap.remove());
			}else{
				break;
			}
		}
	}

	private static class ReverseComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}

	}


}
