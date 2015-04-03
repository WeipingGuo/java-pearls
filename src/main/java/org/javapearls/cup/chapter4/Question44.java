package org.javapearls.cup.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.javapearls.cup.chapter2.SNode;
import org.javapearls.datastructure.tree.TreeNode;

/**
 * Create a linked list for each given level of BST
 *
 * @author wguo
 *
 */
public class Question44 {

	public static List<SNode<Integer>> createLinkedListByLevel(TreeNode<Integer> root){

		if (root == null){
			return null;
		}

		List<SNode<Integer>> res = new ArrayList<SNode<Integer>>();

		// level barrier
		TreeNode<Integer> barrier = new TreeNode<Integer>(-1);
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		queue.add(root);
		queue.add(barrier);

		while (queue.size() > 1){
			TreeNode<Integer> n = queue.remove();
			SNode<Integer> newList = new SNode<Integer>(n.data);
			SNode<Integer> current = newList;
			while (n != barrier){
				if (n.left != null){
					queue.add(n.left);
				}
				if (n.right != null){
					queue.add(n.right);
				}
				current.next = new SNode<Integer>(n.data);
				current = current.next;
				n = queue.remove();
			}

			// add to the result
			res.add(newList);

			// add  barrier to the queue
			queue.add(barrier);
		}

		return res;
	}

}
