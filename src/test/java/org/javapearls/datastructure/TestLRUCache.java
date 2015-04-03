package org.javapearls.datastructure;

import static org.junit.Assert.*;


import org.javapearls.datastructure.linkedlist.LRUCache;
import org.junit.Test;


public class TestLRUCache {


	@Test
	public void testNewLRUCache(){

		LRUCache<String, String> cache = new LRUCache<String, String>(10);

		assertTrue(cache.get("one") == null);

		cache.put("one", "one");
		assertTrue(cache.get("one").equals("one"));
		assertTrue(cache.size() == 1);
		cache.remove("one");

		assertTrue(cache.get("one") == null);
		assertTrue(cache.size() == 0);

		for (int i = 0; i < 15; i++){
			cache.put("key" + i, "value" + i);
		}

		assertTrue(cache.size() == 15);
		assertTrue(cache.containsKey("key0"));
		assertTrue(cache.containsKey("key14"));
	}

}
