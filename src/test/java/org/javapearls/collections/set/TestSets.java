package org.javapearls.collections.set;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;


/**
 * Set Interface
 * Its implementation:
 * 	HashSet	- represented as hash table
 * 	LinkedHashSet - represented as linked hash table, preserves the insertion order
 * 	EnumSet		- bit fields
 * 	TreeSet		- red-black tree: sorted ascending
 * 	CopyOnWriteArraySet	- array: thread-safe without synchronized method
 *
 * @author wguo
 *
 */

public class TestSets {

	@Test
	public void testSortedSet(){

		String[] strArray = new String[]{"one", "two", "three", "four"};

		SortedSet<String> strSet =
			new TreeSet<String>(Arrays.asList(strArray));
		System.out.println(strSet);

		assertTrue(strSet.first().equals(strArray[3]));

		// not stable sort?
		//assertTrue(strSet.last().equals(strArray[2]));
	}

	@Test
	public void testHashSet(){

		Integer []  intArray =  {10,8,7,5,-1,100,34};
		HashSet<Integer> intSet = new HashSet<Integer>();

		intSet.addAll(Arrays.asList(intArray));

		assertTrue(intSet.size() == 7);
		System.out.println(intSet);

		// preserve the insertion order
		HashSet<Integer> linkedHashSet =
			new LinkedHashSet<Integer>(Arrays.asList(intArray));
		System.out.println(linkedHashSet);
	}

}
