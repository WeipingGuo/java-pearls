package org.javapearls.algorithm.sorting;


public class Swapper {


	/**
	 * An operation "swap" means removing an element from the array and appending
	 * it at the back of the same array. Find the minimum number of "swaps" needed
	 * to sort that array.
	 * Eg :- 3124
	 * Output: 2 (3124->1243->1234)
	 *
	 * -There is a large graph, where each node is a permutation of the given list
	 * of data; there is an edge points from node i to node j if we can move from
	 * permutation-i to permutation-j by using one "swap".
	 * -Now the question is I pick two nodes i and k in the graph, where k is
	 * special in that its permutation happens to be a sorted list; i is an
	 * arbitrary node.
	 * -Then I ask you "(1) What is length of the min-length path
	 * from i to k in the graph (2) What are exact nodes on the path?"; however,
	 * I didn't ask you to develop an algorithm to find that path, because doing
	 * so may need a sorting first and then a backtrack of path--using that for the
	 * purpose of sorting is not a good idea.
	 */
}
