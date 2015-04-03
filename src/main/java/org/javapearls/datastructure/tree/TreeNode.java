package org.javapearls.datastructure.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode<E extends Comparable<E>>{

	public TreeNode<E> left;
    public TreeNode<E> right;
    public E data;

    public TreeNode(E e){
        this.left = null;
        this.right = null;
        this.data = e;
    }
    public TreeNode(TreeNode<E> l, TreeNode<E> r, E e){
        this.left = l;
        this.right = r;
        this.data = e;
    }

    public void setData(E e){
    	this.data = e;
    }

    public TreeNode<E> getLeft(){
        return this.left;
    }
    public TreeNode<E> getRight(){
        return this.right;
    }
    public E getData(){
        return this.data;
    }


    public static <E extends Comparable<E>> boolean isBST(TreeNode<E> root){
        if (root == null){
            return true;
        }

        TreeNode<E> left = root.getLeft();
        TreeNode<E> right = root.getRight();

        if (left == null && right == null){
            return true;
        }else if(left == null){
            return isBST(right) && (right.getData().compareTo(root.getData()) >0);
        }else if (right == null){
            return isBST(left) && (left.getData().compareTo(root.getData()) <= 0);
        }else{
            return isBST(left) && isBST(right) && (left.getData().compareTo(root.data) <= 0) &&
            (right.getData().compareTo(root.getData()) >0 );
        }
    }

    public static <E extends Comparable<E>> boolean isSame(TreeNode<E> a, TreeNode<E> b){

        if (a == null && b == null){
            return true;
        }
        if (a == null && b != null){
            return false;
        }
        if (a != null && b == null){
            return false;
        }

        if (a.data.compareTo(b.data) != 0){
            return false;
        }
        return isSame(a.left,b.left) && isSame(a.right,b.right);

    }

    /**
     *    left, root, right
     */
    public static <E extends Comparable<E>> void inorder(TreeNode<E> root){
        if (root == null) return;

        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }

    public static <E extends Comparable<E>> void preorder(TreeNode<E> root){
        if (root == null) return;

        System.out.println(root.data);
        preorder(root.left);
        preorder(root.right);
    }

    public static <E extends Comparable<E>> void postorder(TreeNode<E> root){
        if (root == null) return;
        postorder(root.left);
        System.out.println(root.data);
        postorder(root.right);
    }

    // root, left, right
    public static <E extends Comparable<E>> void preOrder(TreeNode<E> root){

    	if (root == null) return;

    	Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
    	stack.push(root);

    	while (!stack.isEmpty()){
    		TreeNode<E> node = stack.pop();
    		System.out.println(node.data);

    		if (node.right != null) {
    			stack.push(node.right);
    		}
    		if (node.left != null){
    			stack.push(node.left);
    		}
    	}
    }

    public static <E extends Comparable<E>> void inOrder(TreeNode<E> root){
    	if (root == null) {
    		return;
    	}

    	Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();

    	// push nodes has left children to the stack
    	TreeNode<E> current = root;
    	while (current.left != null){
    		stack.push(current);
    		current = current.left;
    	}

    	while (!stack.isEmpty()){
    		TreeNode<E> n = stack.pop();
    		System.out.println(n.data);

    		if (n.right != null){

    		}else {

    		}

    	}



    }

    public static <E extends Comparable<E>> void levelTraverse(TreeNode<E> root){

    	if (root == null) return;

    	Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
    	queue.add(root);

    	while (!queue.isEmpty()){

    		TreeNode<E> node  = queue.remove();

    		System.out.print(node.data + ",");

    		if (node.left != null){
    			queue.add(node.left);
    		}
    		if (node.right != null){
    			queue.add(node.right);
    		}
    	}

    	System.out.print("\n");

    }

    /**
     * this is DFS in binary tree. It is similar to pre-order traversal
     *
     * @param <E>
     * @param root
     * @param target
     * @return
     */
    public static <E extends Comparable<E>> TreeNode<E> search(TreeNode<E> root, E target){
    	if (root == null) return null;

    	int cmp = root.data.compareTo(target);
    	if (cmp == 0){
    		return root;
    	}else if (cmp < 0){
    		return search(root.right, target);
    	}else{
    		return search(root.left, target);
    	}
    }

    /**
     * BFS on BST is simlar to level traversal
     *
     * @param <E>
     * @param root
     * @param target
     * @return
     */
    public static <E extends Comparable<E>> TreeNode<E> bfs(TreeNode<E> root, E target){

        if (root == null) {
            return null;
        }

        // level traversal
        Queue<TreeNode<E>> queue = new LinkedList<TreeNode<E>>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode<E> node = queue.remove();

            int cmp = node.data.compareTo(target);
            if (cmp == 0){
                return node;
            } else if (cmp < 0){
                queue.add(node.right);
            } else {
                queue.add(node.left);
            }
        }

        return null;
    }

    /**
     * post order traverse: left, right, root
     * @param <E>
     * @param root
     */
    public static <E extends Comparable<E>> void postOrderTraverse(TreeNode<E> root){

        if (root == null) return;

        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.println(root.data);
    }


}