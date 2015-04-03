package org.javapearls.algorithm.oj;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TestPalindromePartitioning {

	@Test
	public void testPalindromePartion(){
		String orig = "aabb";
		List<LinkedList<String>> partitions = PalindromePartitioning.partition(orig);

		for (LinkedList<String> list : partitions){
			print(list);
		}

	}

	private void print(LinkedList<String> list){
		for (String s : list){
			System.out.print(s + ",");
		}
		System.out.println();
	}
}
