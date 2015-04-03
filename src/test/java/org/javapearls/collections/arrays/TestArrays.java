package org.javapearls.collections.arrays;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.javapearls.collections.queue.JobScheduler;
import org.junit.Test;


public class TestArrays {

	@Test
	public void testArrayCopy(){

		char[] text = "This is a good afternoon".toCharArray();
		char[] copy = new char[text.length];

		System.arraycopy(text,0, copy, 0, text.length);

		assertTrue(Arrays.equals(text, copy));

		char[] c = text.clone();
		assertTrue(Arrays.equals(text, c));
	}

	@Test
	public void testSortAndBinarySearch(){
		int[] a = new int[]{10,5,7,8,-4,20};
		int[] b = new int[]{-4,5,7,8,10,20};
		Arrays.sort(a);

		assertTrue(Arrays.equals(a, b));

		assertTrue(Arrays.binarySearch(a, 7) == 2);
		assertTrue(Arrays.binarySearch(a, 100) < 0);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testCloneAndFill(){
		byte[] data = new byte[96];
		assertTrue(data[50] == (byte)0);

		Arrays.fill(data, (byte)(-1));
		assertTrue(data[50] == (byte)(-1));

		Class type = data.getClass();
		assertTrue(type.isArray());
		Class elementType = type.getComponentType();
		assertTrue(elementType.isPrimitive());

	}

	@Test
	public void testJobScheduler(){
		@SuppressWarnings("unused")
		JobScheduler sched = new JobScheduler();

//		sched.value = 100;
//		JobScheduler.JobComparator comp = sched.new JobComparator();
	}

}
