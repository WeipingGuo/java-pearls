package org.javapearls.algorithm.oj;

import org.javapearls.cup.chapter2.SNode;


/**
 * Given a linked list and a value x, partition it such that all nodes less than x
 * come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * @author wguo
 *
 */
public class PartitionList {

	public static SNode<Integer> partition(SNode<Integer> header, int x){

		SNode<Integer> dummyNode = new SNode<Integer>(-1);
		SNode<Integer> pivotNode = new SNode<Integer>(-1);

		SNode<Integer> newHeader = dummyNode, pivot = pivotNode;
		while (header != null){
			if (header.element < x){
				newHeader.next = header;
				newHeader = newHeader.next;
			}else{
				pivot.next = header;
				pivot = pivot.next;
			}
			header = header.next;
		}

		pivot.next = null;
		newHeader.next = pivotNode.next;

		return dummyNode.next;
	}

}
