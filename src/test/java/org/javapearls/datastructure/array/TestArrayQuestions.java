package org.javapearls.datastructure.array;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.javapearls.datastructure.array.ArrayQuestions;
import org.junit.Test;

public class TestArrayQuestions {

	@Test
	public void testArrayUnion(){
		Integer[] a = {1,2,3,4};
		Integer[] b = {2, 4, 7, 8};

		System.out.println("a = " + Arrays.toString(a));
		System.out.println("b = " + Arrays.toString(b));

		Integer[] c = ArrayQuestions.union(a, b);

		System.out.print("c = " + Arrays.toString(c));
	}

	@Test
	public void testArrayIntersection(){
		Integer[] a = {1,2,3,4};
		Integer[] b = {2, 4, 7, 8};

		System.out.println("a = " + Arrays.toString(a));
		System.out.println("b = " + Arrays.toString(b));

		Integer[] c = ArrayQuestions.intersection(a, b);

		System.out.print("c = " + Arrays.toString(c));
	}

	@Test
	public void testFindDuplication(){
		int[] a = {1,2,2,3};
		int duplicated = ArrayQuestions.findDup(a);
		assertEquals(duplicated, 2);
		assertEquals(ArrayQuestions.findDup2(a), 2);

		int[] b = {1, 1, 2, 3, 4};
		duplicated = ArrayQuestions.findDup(b);
		assertEquals(duplicated, 1);
		assertEquals(ArrayQuestions.findDup2(b), 1);
	}

	@Test
	public void testNumberReorder(){
		int[] array = {-5,2,-3,4,-8, -9, 1, 3, -10};

		ArrayQuestions.reorder(array);
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + ",");
		}

	}

	@Test
	public void testArrayTransform(){
		int[] a = {2, 4, 7, 8, 10, -1, 5};
		int[] b= ArrayQuestions.tranform(a);
		print(b);
		int[] b1 = ArrayQuestions.transform2(a);
		print(b1);
		assertTrue(Arrays.equals(b, b1));
	}

	@Test
	public void testArrayZero(){
		int[] a = {7, 1, 1, -2, 3, 4};
		boolean zeroSum = ArrayQuestions.sumZero(a);
		assertTrue(zeroSum);

		zeroSum = ArrayQuestions.sumZero2(a);
		assertTrue(zeroSum);
	}

	@Test
	public void testSortArrayEvenOdd(){
		int[] a = {7, 1, 10, -2, 3, 4, 20, 8, 12};
		ArrayQuestions.sortEvenOdd(a);
		print(a);
	}

	@Test
	public void testLowerBound(){
		int[] a = {-2, 3, 3, 3, 3, 4, 8, 8, 8, 12, 20, 20, };
		assertTrue(ArrayQuestions.lowerBound(a, 2) == -1);
		assertTrue(ArrayQuestions.lowerBound(a, -2) == 0);
		assertTrue(ArrayQuestions.lowerBound(a, 3) == 1);
		assertTrue(ArrayQuestions.lowerBound(a, 4) == 5);
		assertTrue(ArrayQuestions.lowerBound(a, 8) == 6);
		assertTrue(ArrayQuestions.lowerBound(a, 12) == 9);
		assertTrue(ArrayQuestions.lowerBound(a, 20) == 10);
	}

	@Test
	public void testUpperBound(){
		int[] a = {-2, 3, 3, 3, 3, 4, 8, 8, 8, 12, 20, 20, };
		assertTrue(ArrayQuestions.upperBound(a, 2) == -1);
		assertTrue(ArrayQuestions.upperBound(a, -2) == 0);
		assertTrue(ArrayQuestions.upperBound(a, 3) == 4);
		assertTrue(ArrayQuestions.upperBound(a, 4) == 5);
		assertTrue(ArrayQuestions.upperBound(a, 8) == 8);
		assertTrue(ArrayQuestions.upperBound(a, 12) == 9);
		assertTrue(ArrayQuestions.upperBound(a, 20) == 11);

		int[] b = {1, 1, 1, 1, 1, 1, 1, 1, 1};
		assertTrue(ArrayQuestions.lowerBound(b, 1) == 0);
		assertTrue(ArrayQuestions.upperBound(b, 1) == b.length - 1);
	}

	@Test
	public void testOccurance(){
		int[] a = {-2, 3, 20, 12, 0, 4, 3, 3, 3, 4, 8, 8, 8, 12, 20, 20, };
		assertTrue(ArrayQuestions.occurance(a, 100) == 0);
		assertTrue(ArrayQuestions.occurance(a, -2) == 1);
		assertTrue(ArrayQuestions.occurance(a, 3) == 4);
		assertTrue(ArrayQuestions.occurance(a, 4) == 2);
		assertTrue(ArrayQuestions.occurance(a, 8) == 3);
		assertTrue(ArrayQuestions.occurance(a, 12) == 2);
		assertTrue(ArrayQuestions.occurance(a, 20) == 3);
	}

	@Test
	public void testDuplicationRemoval(){
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("world");
		list.add("hello");
		list.add("hello");
		list.add("wguo");
		list.add("who");

		List<String> noDup = ArrayQuestions.removeDuplicate(list);
		for (String s : noDup){
			System.out.println(s);
		}

		System.out.println("keep the original order:");
		noDup = ArrayQuestions.removeDuplicationReserveOrder(list);
		for (String s : noDup){
			System.out.println(s);
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testPringMissingNullArray(){
	  ArrayQuestions.printMissing(null, 99);
	}
	
	@Test
	public void testPrintMissingEmpty(){
	  ArrayQuestions.printMissing(new int[0], 99);
	}
	
	@Test
	public void testPrintMissingSunny(){
	  int[] a = {0, 1, 3, 50, 75};
	  ArrayQuestions.printMissing(a, 99);
	}
	
	@Test
	public void testPrintMissingSingleElement(){
	  int[] a = {0};
	  ArrayQuestions.printMissing(a, 99);
	  
	  int[] b = {10};
	  ArrayQuestions.printMissing(b, 99);
	  
	  int[] c = {99};
	  ArrayQuestions.printMissing(c, 99);
	  
	  System.out.println("======");	  
	  ArrayQuestions.printMissing(c, 1000);
	}
	
	@Test 
	public void testPrintMissingCompleteSet(){
	  int[] a = new int[100];
	  for (int i = 0; i < a.length; i++){
	    a[i] = i;
	  }
	  ArrayQuestions.printMissing(a, 99);
	}
	
	private void print(int[] a){
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i] + ",");
		}
		System.out.println();
	}


}
