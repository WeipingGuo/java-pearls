package org.javapearls.datastructure.array;

import static org.junit.Assert.*;

import org.javapearls.datastructure.array.MaxDistance;
import org.junit.Test;

public class TestMaxDistance {


	@Test
	public void testMaxDistance(){

		int[] a = {10, 2, 4, 5, 4};
		System.out.println("max distance: " + MaxDistance.maxDistance(a));
		System.out.println("max distance2: " + MaxDistance.maxDistance2(a));
		System.out.println("===========================================");

		int[] b = {2, 10, 7, 8, 4, 6, 40};
		System.out.println("max distance: " + MaxDistance.maxDistance(b));
		System.out.println("max distance2:" + MaxDistance.maxDistance2(b));

		int[] c = {3, 3, 3, 5, 6, 4};
		System.out.println("max distance: " + MaxDistance.maxDistance(c));
		System.out.println("max distance2:" + MaxDistance.maxDistance2(c));
	}

	@Test
	public void testSecondMax(){
		int[] b = {2, 10, 7, 8, 4, 6, 40};
		int secondMax = MaxDistance.secondMax(b);
		assertTrue(secondMax == 10);

		int[] c = {2, 10, 7, 8, 4, 6, 40, 40};
		secondMax = MaxDistance.secondMax(c);
		assertTrue(secondMax == 10);

	}

}
