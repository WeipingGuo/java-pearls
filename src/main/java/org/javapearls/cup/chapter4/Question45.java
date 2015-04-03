package org.javapearls.cup.chapter4;

import org.javapearls.datastructure.tree.TreeNode;

public class Question45 {

	/**
	 * all the left node must <= current node
	 * all the right nodes must > current node
	 * @param root
	 * @return
	 */
	public static boolean isBST(TreeNode<Integer> root){
	    if (root == null) {
	        return true;
	    }
	    return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBST(TreeNode<Integer> root, int min, int max){

		if (root == null){
			return true;
		}
		if (root.data < min || root.data > max){
			return false;
		}
		return isBST(root.left, min, root.data) && isBST(root.right, root.data + 1, max);
	}

}
