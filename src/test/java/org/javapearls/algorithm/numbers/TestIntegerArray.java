package org.javapearls.algorithm.numbers;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestIntegerArray {

	@Test
	public void testMaxSum(){
		int[] a = {2, -8, 3, -2, 4, -10};
		int sum = IntegerArray.maxSum(a);
		assertEquals(sum, 5);
	}

	@Test
	public void testMaxSumSeq(){
		int[] a = {2, -8, 3, -2, 4, -10};
		List<Integer> res = IntegerArray.maxSumSeq(a);
		for (Integer i : res){
			System.out.print(i + ",");
		}
		System.out.print("\n");
	}

	@Test
	public void testMaxSumSeq2(){
		int[] a = {2, -8, 3, -2, 4, -10};
		List<Integer> res = IntegerArray.maxSumSeq2(a);
		for (Integer i : res){
			System.out.print(i + ",");
		}
		System.out.print("\n");
	}

	@Test
	public void testFirstMissingPositiveNumber(){
		int[] a = {1, 2, 0};
		int[] b = {3,4,-1,1};
		int[] c = {-3,-4,1,2,6,7};
		int[] d = {10, 8, 4, 1, -1, -100};
		assertTrue(IntegerArray.findMissingPositiveInteger(a) == 3);
		assertTrue(IntegerArray.findMissingPositiveInteger(b) == 2);
		assertTrue(IntegerArray.findMissingPositiveInteger(c) == 3);
		assertTrue(IntegerArray.findMissingPositiveInteger(d) == 2);
	}


}
