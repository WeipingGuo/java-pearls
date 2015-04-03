package org.javapearls.cup.chapter4;

import org.javapearls.datastructure.tree.TreeNode;

public class Question41 {

	public static boolean isBalancedBST(TreeNode<Integer> root){
		if (root == null){
			return true;
		}

		int diff = getHeight(root.left) - getHeight(root.right);
		if (Math.abs(diff) > 1){
			return false;
		}else{
			return isBalancedBST(root.left) && isBalancedBST(root.right);
		}
	}

	public static boolean isBalanced(TreeNode<Integer> root){
		if (checkHeight(root) == -1){
			return false;
		}
		return true;
	}

	public static int checkHeight(TreeNode<Integer> root){
		if (root == null){
			return 0;
		}

		// check left
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1){
			return -1;
		}

		// check right
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1){
			return -1;
		}

		// check diff
		int diff = leftHeight - rightHeight;
		if (Math.abs(diff) > 1){
			return -1;
		}else{
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	public static int getHeight(TreeNode<Integer> root){
		if (root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}

	public static int maxHeight(TreeNode<Integer> root){
		if (root == null){
			return 0;
		}
		return Math.max(maxHeight(root.left), maxHeight(root.right)) + 1;
	}

	public static int minHeight(TreeNode<Integer> root){
		if (root == null){
			return 0;
		}
		return Math.min(minHeight(root.left), minHeight(root.right)) + 1;
	}

}
