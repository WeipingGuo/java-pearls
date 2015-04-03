package org.javapearls.algorithm.ordering;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class TestKthElement {

	@Test(expected=IllegalArgumentException.class)
	public void testFindElementNullArray() {
		KthElement.findElement(null, 100);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFindElementEmptyArray() {
		KthElement.findElement(new int[0], 100);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testFindElementKthOverflow(){
		int[] a = {1,2,3,4};
		KthElement.findElement(a, 5);
	}

	@Test
	public void testFindElementSingle(){
		int[] a = {5};
		assertEquals(KthElement.findElement(a, 0), 5);
	}

	@Test
	public void testFindElementNormal(){
		int[] a = {5,8,2,6,4,10};
		assertEquals(KthElement.findElement(a, 0), 2);
		assertEquals(KthElement.findElement(a, 1), 4);
		assertEquals(KthElement.findElement(a, 2), 5);
		assertEquals(KthElement.findElement(a, 3), 6);
		assertEquals(KthElement.findElement(a, 4), 8);
		assertEquals(KthElement.findElement(a, 5), 10);
	}

	@Test
	public void testFindElementSmallest(){
		int[] a = {5,8,2,6,4,10,100};
		assertEquals(KthElement.findElement(a, 0), 2);
	}

	@Test
	public void testFindElementBiggest(){
		int[] a = {5,8,2,6,4,10,100};
		assertEquals(KthElement.findElement(a, a.length-1), 100);
	}

	@Test
	public void testFindElementSortedArrays(){
		int[] a = {5,8,2,6,4,10,100};
		Arrays.sort(a);
		assertEquals(KthElement.findElement(a, 0), 2);
		assertEquals(KthElement.findElement(a, 3), 6);
		assertEquals(KthElement.findElement(a, a.length-1), 100);
	}

}
