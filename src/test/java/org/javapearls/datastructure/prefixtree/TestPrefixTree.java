package org.javapearls.datastructure.prefixtree;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestPrefixTree {

	@Test
	public void testPrefixTree(){

		Trie pTree = new Trie();
		pTree.addWord("hello");
		pTree.addWord("car");
		pTree.addWord("cat");
		pTree.addWord("fat");

		assertTrue(pTree.containWord("hello"));
		assertTrue(pTree.containWord("car"));
		assertTrue(pTree.containWord("cat"));
		assertTrue(pTree.containWord("fat"));

		assertFalse(pTree.containPrefix("at"));
		assertTrue(pTree.containPrefix("ca"));

		Node node = pTree.getPrefix("he");
		assertFalse(node == null);
		assertEquals(node.getValue(), "he");
	}

}
