package org.javapearls.algorithm.numbers;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

public class TestNumbers {

	@Test
	public void testFirstMissingPositiveNumber(){

		int[] arrayA = {1,2,0};
		assertEquals(3, Numbers.firstMissingPositiveNumber(arrayA));

		int[] arrayB = {3,4,-1,1};
		assertEquals(2, Numbers.firstMissingPositiveNumber(arrayB));
	}

	@Test
	public void testFirstMissingPositiveNumberBySort(){
		int[] arrayA = {1,2,0};
		assertEquals(3, Numbers.firstMissingPositiveNumberBySort(arrayA));

		int[] arrayB = {3,4,-1,1};
		assertEquals(2, Numbers.firstMissingPositiveNumberBySort(arrayB));
	}

	@Test
	public void testFirstMissingPositiveNumberConstant(){
		int[] arrayA = {1,2,0};
		assertEquals(3, Numbers.firstMissingPositiveNumberConstant(arrayA));

		int[] arrayB = {3,4,-1,1};
		assertEquals(2, Numbers.firstMissingPositiveNumberConstant(arrayB));
	}

	@Test
	public void testFirstUniqueNumber(){
		int[] array = {2,4,5,4,2,-3, 10, 5, 6, 6, 5};
		int unique = Numbers.firstUniqueNumber(array);
		assertEquals(unique, -3);
	}

	@Test (expected=IllegalArgumentException.class)
	public void testFirstUniqueNumberEmptyArray(){
		int[] array = {};
		Numbers.firstUniqueNumber(array);
	}

	@Test
	public void testMissingNumbers(){
		int[] array = {2, 4, 0, 6, 7, 0, 3};
		List<Integer> list = Numbers.missingNumbers(array);
		assertEquals(list.size(), 2);
		assertEquals(list.get(0).intValue(), 1);
		assertEquals(list.get(1).intValue(), 5);
	}

	@Test
	public void testSquareRoot(){
		BigDecimal sqrt = Numbers.squareRoot(2, 500);

		System.out.println(sqrt);
	}

}
