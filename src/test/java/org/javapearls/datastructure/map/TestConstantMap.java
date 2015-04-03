package org.javapearls.datastructure.map;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestConstantMap {

	@Test
	public void testConstantMap(){

		ConstantMap<Integer> map = new ConstantMap<Integer>();
		map.add(200);
		map.add(100);
		map.add(5);
		map.add(7);
		map.add(34);

		assertTrue(map.get(5) == 5);
		assertTrue(map.get(100) == 100);
		assertNull(map.get(1000));

		System.out.println("random element: " + map.random());
		System.out.println("random element: " + map.random());
		System.out.println("random element: " + map.random());
		System.out.println("random element: " + map.random());
		System.out.println("random element: " + map.random());

		map.delete(5);
		assertNull(map.get(5));

		System.out.println("random element: " + map.random());
		System.out.println("random element: " + map.random());
		System.out.println("random element: " + map.random());
		System.out.println("random element: " + map.random());
	}

}
