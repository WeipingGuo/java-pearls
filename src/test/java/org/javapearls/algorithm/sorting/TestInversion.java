package org.javapearls.algorithm.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestInversion {


	@Test
	public void testFindInversion() {
		int[] a = {10,8};
		assertTrue(Inversion.findInversion(a) ==  1);

		int[] b = {10,8,14,7,67,5,20};
		assertTrue(Inversion.findInversion(b) ==  10);
	}

	@Test
	public void testInversionMerge() {

		int[] k = {100,120};
		assertTrue(Inversion.inversions(k, 0, 1) == 0);

		int[] a = {10,8};
		assertTrue(Inversion.inversions(a, 0, 1) ==  1);

		int[] b = {10,8,14,7,67,5,20};
		assertTrue(Inversion.inversions(b, 0, b.length - 1) ==  10);

	}

}
