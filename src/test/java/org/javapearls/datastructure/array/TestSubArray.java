package org.javapearls.datastructure.array;

import static org.junit.Assert.*;

import org.javapearls.datastructure.array.SubArray;
import org.junit.Test;

public class TestSubArray {

	@Test
	public void testFindMaxSubArray() {

		int a[] = {1,-1,10,10,5};
		SubArray sub = new SubArray();
		SubArray.SubSum sum = sub.findMaxSubArray(a, 0, a.length - 1);
		assertTrue(sum.sum == 25);
		assertTrue(sum.from == 2);
		assertTrue(sum.to == 4);


		int b[] = {1,-10,2};
		SubArray.SubSum sumb = sub.findMaxSubArray(b, 0, b.length - 1);
		assertTrue(sumb.sum == 2);
		assertTrue(sumb.from == 2);
		assertTrue(sumb.to == 2);

	}

}
