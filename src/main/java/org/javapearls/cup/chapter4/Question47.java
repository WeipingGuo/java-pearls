package org.javapearls.cup.chapter4;

import org.javapearls.datastructure.tree.TreeNode;

/**
 * find the first common ancestor of two nodes in a binary
 * tree
 *
 * @author wguo
 *
 */
public class Question47 {


	public static TreeNode<Integer> commonAncestor(TreeNode<Integer> root, TreeNode<Integer> p,
			TreeNode<Integer> q){

		if (root == null){
			return null;
		}

		// either p or q is the root
		if (root == p || root == q){
			return root;
		}

		boolean isLeftChild = isChild(root.left, p);
		boolean isRightChild = isChild(root.right, q);

		if (isLeftChild && isRightChild){ 			// p and q are on different subtree
			return root;
		}else if (isLeftChild && !isRightChild){ 	// p and q are on the left subtree
			return commonAncestor(root.left, p, q);
		}else {										// p, q are on the right subtree
			return commonAncestor(root.right,p, q);
		}

	}


	private static boolean isChild(TreeNode<Integer> root, TreeNode<Integer> p){

		if (root == null){
			return false;
		}
		if (root == p){
			return true;
		}

		return isChild(root.left, p) || isChild(root.right, p);
	}

}
