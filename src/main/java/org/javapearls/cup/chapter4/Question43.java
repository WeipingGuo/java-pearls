package org.javapearls.cup.chapter4;

import org.javapearls.datastructure.tree.TreeNode;

public class Question43 {
	/**
	 * Given sorted array with unique integer element
	 * create a BST with minimum height
	 */

	public static TreeNode<Integer> createBST(int[] array){

		if (array == null || array.length == 0){
			return null;
		}
		return createBST(array, 0, array.length - 1);

	}

	public static TreeNode<Integer> createBST(int[] array, int left, int right){
		if (left > right) return null;
		if (left == right){
			return new TreeNode<Integer>(array[left]);
		}

		int middle = (left + right)/2;
		TreeNode<Integer> n = new TreeNode<Integer>(array[middle]);
		n.left = createBST(array, left, middle - 1);
		n.right = createBST(array, middle + 1, right);

		return n;
	}

}
