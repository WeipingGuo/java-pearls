package org.javapearls.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.javapearls.cup.chapter2.SNode;

public class TreeQuestions {


	/**
	 * Given an unbalanced BST, create a linked list at each depth.
	 *
	 * @param <E>
	 * @param root
	 * @return
	 */
	public static <E extends Comparable<E>> List<SNode<E>> tree2LinkedList(TreeNode<E> root){

		ArrayList<SNode<E>> res = new ArrayList<SNode<E>>();
		// return an empty list
		if (root == null){
			return res;
		}

		Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
		TreeNode<E> barrier = new TreeNode<E>(null); // a depth barrier
		queue.add(root);
		queue.add(barrier);

		while (queue.size() > 1){

			// create a linked list using the elements in the queue
			TreeNode<E> tNode = queue.remove();
			SNode<E> header = new SNode<E>(tNode.getData());
			SNode<E> current = header;
			while (true) {
				if (tNode.getLeft() != null){
					queue.add(tNode.getLeft());
				}
				if (tNode.getRight() != null){
					queue.add(tNode.getRight());
				}

				tNode = queue.remove();
				if (tNode == barrier){
					break;
				}
				SNode<E> lnode = new SNode<E>(tNode.getData());
				current.next = lnode;
				current = lnode;
			}
			// add the barrrier
			queue.add(barrier);

			// add the newly created linked list to the result
			res.add(header);
		}

		return res;
	}


	/**
	 * Definition for binary tree
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode<Integer> root) {

	    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

	    	// return an empty list
			if (root == null){
				return res;
			}

			// use a queue to track all the tree nodes
			// and barrier to separate each level
			Queue<TreeNode<Integer>> queue =
				new LinkedList<TreeNode<Integer>>();
			TreeNode<Integer> barrier = new TreeNode<Integer>(null);
			queue.add(root);
			queue.add(barrier);

			while (queue.size() > 1){

				// create an ArrayList using all the elements in the queue
				ArrayList<Integer> levelArray = new ArrayList<Integer>();
				TreeNode<Integer> node = queue.remove();
				levelArray.add(node.getData());

				while (true) {

					if (node.getLeft() != null){
						queue.add(node.getLeft());
					}
					if (node.getRight() != null){
						queue.add(node.getRight());
					}

					node = queue.remove();
					if (node == barrier){
						break;
					}

					levelArray.add(node.getData());
				}

				// add the barrrier
				queue.add(barrier);

				// add the newly created array to the result
				res.add(levelArray);
			}

			return res;
	    }

	/**
	 * find an element in an BST
	 *
	 * @param <E>
	 * @param root
	 * @param target
	 * @return
	 */
	public static <E extends Comparable<E>> TreeNode<E> find(TreeNode<E> root,
			E target) {
		if (root == null)
			return null;

		int cmp = root.getData().compareTo(target);
		if (cmp == 0) {
			return root;
		} else if (cmp < 0) {
			return find(root.getRight(), target);
		} else {
			return find(root.getLeft(), target);
		}

	}

	public static <E extends Comparable<E>> TreeNode<E> delete(TreeNode<E> root, E target){
		if (root == null) return null;

		int cmp = root.getData().compareTo(target);
		if (cmp < 0){
			return delete(root.getRight(), target);
		}else if(cmp > 0){
			return delete(root.getLeft(), target);
		}

		// delete the current node
		// three different cases: leaf, has one child,
		// has two children
		if (root.getLeft() == null && root.getRight() == null){ // leaf node

		}else if (root.getLeft() == null && root.getRight() != null){ // has right child

		}else if (root.getLeft() != null && root.getRight() == null){ // has left child

		}else{ // both left and right child

		}

		return root;
	}

	/**
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
	 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
	 *
	 * @param root
	 * @return
	 */
	public static int sum(TreeNode<Integer> root){
		return sum(root, 0);
	}

	public static int sum(TreeNode<Integer> root, int num){
		if (root == null) {
			return 0;
		}
		num = num * 10 + root.getData();

		// leaf node
		if (root.getLeft() == null && root.getRight() == null){
			return num;
		}

		int leftSum = (root.getLeft() == null) ? 0 : sum(root.getLeft(), num);
		int rightSum = (root.getRight() == null) ? 0 : sum(root.getRight(), num);

		return leftSum + rightSum;
	}

	/**
	 * total paths for given binary tree
	 * @param root
	 * @return
	 */
	public static int paths(TreeNode<Integer> root){
	    if (root == null) return 0;

	    // leaf node
	    if (root.getLeft() == null && root.getRight() == null){
	        return 1;
	    }

	    return paths(root.getLeft()) + paths(root.getRight());
	}

	/**
	 * Given a binary tree, find the maximum path sum.
	 * The path may start and end at any node in the tree.
	 *
	 * @param root
	 * @return
	 */
	public static int maxPathSum(TreeNode<Integer> root){
		List<Integer> maxSum = new ArrayList<Integer>(1);
		maxSum.add(Integer.MIN_VALUE);
		maxPathSum(root, maxSum);
		return maxSum.get(0);
	}

	public static int maxPathSum(TreeNode<Integer> root, List<Integer> maxSum){
		if (root == null) {
			return 0;
		}

		int leftMax = maxPathSum(root.getLeft(), maxSum);
		int rightMax =maxPathSum(root.getRight(), maxSum);

		int curMax = Math.max(root.getData(), Math.max(root.getData() + leftMax, root.getData() + rightMax));
		maxSum.set(0, Math.max(maxSum.get(0), Math.max(curMax, root.getData() + leftMax + rightMax)));

		return curMax;
	}


	public static int maxDepth(TreeNode<Integer> root){
		if (root == null){
			return 0;
		}
		return Math.max(maxDepth(root.getLeft()), maxDepth(root.getRight())) + 1;
	}


	/**
	 * Lowest common ancestor: assume distinct values for each node
	 *
	 * @param root
	 * @param a
	 * @param b
	 * @return
	 */
	public static TreeNode<Integer> LCA (TreeNode<Integer> root, TreeNode<Integer> a, TreeNode<Integer> b){

		if (root == null || a == null || b == null) return null;

		// Node a and b are on the each side of the tree
		if ( (a.getData() < root.getData() && b.getData() > root.getData()) ||
				(a.getData() > root.getData() && b.getData() < root.getData()) ){
			return root;
		}

		// both are on the left subtree
		if (a.getData() < root.getData() && b.getData() < root.getData()){
			return LCA(root.getLeft(), a, b);
		}

		// both are on the right subtree
		if (a.getData() > root.getData() && b.getData() > root.getData()){
			return LCA(root.getRight(), a, b);
		}

		// root node equals to one of nodes
		if (a.getData() == root.getData() || b.getData() == root.getData()){
			return root;
		}

		return null;
	}

	/**
	 * find all the paths from the root to the leaves
	 *
	 * @param root
	 * @return
	 */
	public static List<LinkedList<Integer>> allPaths(TreeNode<Integer> root){

		List<LinkedList<Integer>> paths = new ArrayList<LinkedList<Integer>>();
		LinkedList<Integer> currentPath = new LinkedList<Integer>();
		currentPath.add(root.getData());

		runDFS(root, paths, currentPath);

		return paths;
	}

	private static void runDFS(TreeNode<Integer> node,
			List<LinkedList<Integer>> paths, LinkedList<Integer> currentPath) {

		// leaf node, we are done
		if (node.left == null && node.right == null){
			paths.add(new LinkedList<Integer>(currentPath));
			currentPath.remove(currentPath.size() - 1);
		} else {
			if (node.left != null ){
				currentPath.add(node.left.getData());
				runDFS(node.left, paths, currentPath);
			}

			if (node.right != null){
				currentPath.add(node.right.getData());
				runDFS(node.right, paths, currentPath);
			}
			currentPath.remove(currentPath.size() - 1);
		}

	  }

	/**
	 *	By starting at the top of the triangle and moving to adjacent numbers on the
	 *	row below, the maximum total from top to bottom is 27
	 *			 5
	 *	       9  6
	 *	     4   6  8
	 *	  0   7  1   5
	 * I.e. 5 + 9 + 6 + 7 = 27.
	 *
	 * find the maximum total from top to bottom a text file containing a triangle
	 * with 100 rows.
	 * @return
	 */
	public static int maxSum(){

		return -1;
	}


}
