package org.javapearls.datastructure.tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.javapearls.cup.chapter2.SNode;
import org.junit.Test;

public class TestTreeQuestions {

	@Test
	public void testTree2Linkedlist(){

		TreeNode<Integer> a9 = new TreeNode<Integer>(9);
		TreeNode<Integer> a8 = new TreeNode<Integer>(a9, null, 8);
		TreeNode<Integer> a7 = new TreeNode<Integer>(7);
		TreeNode<Integer> a6 = new TreeNode<Integer>(6);
		TreeNode<Integer> a5 = new TreeNode<Integer>(null, a8, 5);
		TreeNode<Integer> a4 = new TreeNode<Integer>(null, a7, 4);
		TreeNode<Integer> a3 = new TreeNode<Integer>(null, a6, 3);
		TreeNode<Integer> a2 = new TreeNode<Integer>(null, a5, 2);
		TreeNode<Integer> a1 = new TreeNode<Integer>(a3, a4, 1);
		TreeNode<Integer> root = new TreeNode<Integer>(a1, a2, 0);

		TreeNode.levelTraverse(root);

		List<SNode<Integer>> res = TreeQuestions.tree2LinkedList(root);
		assertTrue(res.size() == 5);

		for (SNode<Integer> node : res){
			node.print();
		}

	}

	@Test
	public void testTreeOrderLevel(){

		TreeNode<Integer> a9 = new TreeNode<Integer>(9);
		TreeNode<Integer> a8 = new TreeNode<Integer>(a9, null, 8);
		TreeNode<Integer> a7 = new TreeNode<Integer>(7);
		TreeNode<Integer> a6 = new TreeNode<Integer>(6);
		TreeNode<Integer> a5 = new TreeNode<Integer>(null, a8, 5);
		TreeNode<Integer> a4 = new TreeNode<Integer>(null, a7, 4);
		TreeNode<Integer> a3 = new TreeNode<Integer>(null, a6, 3);
		TreeNode<Integer> a2 = new TreeNode<Integer>(null, a5, 2);
		TreeNode<Integer> a1 = new TreeNode<Integer>(a3, a4, 1);
		TreeNode<Integer> root = new TreeNode<Integer>(a1, a2, 0);

		TreeNode.levelTraverse(root);

		ArrayList<ArrayList<Integer>> res = TreeQuestions.levelOrder(root);
		assertTrue(res.size() == 5);

		for (ArrayList<Integer> arr : res){
			System.out.println(arr.toString());
		}

	}

	@Test
	public void testMaxPathSum(){
		TreeNode<Integer> a9 = new TreeNode<Integer>(9);
		TreeNode<Integer> a8 = new TreeNode<Integer>(a9, null, 8);
		TreeNode<Integer> a7 = new TreeNode<Integer>(7);
		TreeNode<Integer> a6 = new TreeNode<Integer>(6);
		TreeNode<Integer> a5 = new TreeNode<Integer>(null, a8, 5);
		TreeNode<Integer> a4 = new TreeNode<Integer>(null, a7, 4);
		TreeNode<Integer> a3 = new TreeNode<Integer>(null, a6, 3);
		TreeNode<Integer> a2 = new TreeNode<Integer>(null, a5, 2);
		TreeNode<Integer> a1 = new TreeNode<Integer>(a3, a4, 1);
		TreeNode<Integer> root = new TreeNode<Integer>(a1, a2, -1);

		int res = TreeQuestions.maxPathSum(root);

		System.out.println(res);

	}

	@Test
	public void testAllPaths(){

		TreeNode<Integer> a9 = new TreeNode<Integer>(9);
		TreeNode<Integer> a8 = new TreeNode<Integer>(a9, null, 8);
		TreeNode<Integer> a7 = new TreeNode<Integer>(7);
		TreeNode<Integer> a6 = new TreeNode<Integer>(6);
		TreeNode<Integer> a5 = new TreeNode<Integer>(null, a8, 5);
		TreeNode<Integer> a4 = new TreeNode<Integer>(null, a7, 4);
		TreeNode<Integer> a3 = new TreeNode<Integer>(null, a6, 3);
		TreeNode<Integer> a2 = new TreeNode<Integer>(null, a5, 2);
		TreeNode<Integer> a1 = new TreeNode<Integer>(a3, a4, 1);
		TreeNode<Integer> root = new TreeNode<Integer>(a1, a2, -1);

		List<LinkedList<Integer>> allPaths = TreeQuestions.allPaths(root);
		for (LinkedList<Integer> list : allPaths){
			print(list);
		}

	}

	private void print(LinkedList<Integer> list){

		for (Integer i : list){
			System.out.print(i + "-->");
		}
		System.out.println();
	}


}
