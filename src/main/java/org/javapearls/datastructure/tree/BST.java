package org.javapearls.datastructure.tree;


public class BST <E extends Comparable<E>>{

	private TreeNode<E> root;

	public BST(){
		this.root = null;
	}

	public void put(E e){
		if (root == null){
			root = new TreeNode<E>(e);
		}else{
			put(e, root);
		}
	}

	public int size(){
		if (root == null){
			return 0;
		}
		return size(root);
	}

	private int size(TreeNode<E> node){
		if (node == null){
			return 0;
		}
		return size(node.getLeft()) + size(node.getRight()) + 1;
	}

	/**
	 * put an element under root node
	 *
	 * @param e
	 * @param node
	 */
	private void put(E e, TreeNode<E> node){
		if (node == null){
			node = new TreeNode<E>(e);
		}

		int cmp = e.compareTo(root.getData());
		if (cmp <= 0){
			put(e, root.getLeft());
		}else {
			put(e, root.getRight());
		}
	}

}
