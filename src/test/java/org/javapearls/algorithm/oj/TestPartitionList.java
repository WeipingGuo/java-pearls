package org.javapearls.algorithm.oj;

import org.javapearls.cup.chapter2.SNode;
import org.junit.Test;

public class TestPartitionList {

	@Test
	public void testPartioinList(){
		SNode<Integer> two = new SNode<Integer>(2, null);
		SNode<Integer> five = new SNode<Integer>(5, two);
		SNode<Integer> two2 = new SNode<Integer>(2, five);
		SNode<Integer> three = new SNode<Integer>(3, two2);
		SNode<Integer> four = new SNode<Integer>(4, three);
		SNode<Integer> one = new SNode<Integer>(1, four);

		System.out.println("original list:");
		print(one);

		SNode<Integer> newHeader = PartitionList.partition(one, 3);
		System.out.println("partition list:");
		print(newHeader);
	}

	private void print(SNode<Integer> header){
		while (header != null){
			System.out.print(header.element + "->");
			header = header.next;
		}
		System.out.println();
	}


}
