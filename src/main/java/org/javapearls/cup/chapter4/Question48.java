package org.javapearls.cup.chapter4;

import org.javapearls.datastructure.tree.TreeNode;


/**
 * two very large binary tree: T1 with millions of nodes,
 * T2 with hundreds of nodes. decide if T2 is a subtree
 * of T1
 *
 * @author wguo
 *
 */
public class Question48 {


	public static boolean containTree(TreeNode<Integer> t1, TreeNode<Integer> t2){
		if (t2 == null){
			return true;
		}
		return isSubtree(t1, t2);
	}

	public static boolean isSubtree(TreeNode<Integer> r1, TreeNode<Integer> r2){

		if (r1 == null){
			return false;
		}
		if (r1.data == r2.data){
			if ( matchTree(r1.left, r2.right)){
				return true;
			}
		}

		return isSubtree(r1.left, r2) || isSubtree(r1.right, r2);
	}

	private static boolean matchTree(TreeNode<Integer> r1, TreeNode<Integer> r2){
		if (r1 == null && r2 == null){
			return true;
		}
		if (r1 == null || r2 == null){
			return false;
		}
		if (r1.data != r2.data){
			return false;
		}
		return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
	}

}
