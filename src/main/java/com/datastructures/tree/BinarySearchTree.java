package com.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable> {
	private Node<E> root;

	public boolean isEmpty() {
		return root == null;
	}

	public Node<E> getRoot() {
		return root;
	}

	public void insert(final E data) {
		root = insert(data, root);
	}

	public Node<E> insert(final E data, final Node<E> node) {
		if (node == null) {
			return new Node<>(data);
		}
		if (data.compareTo(node.data) < 0) {
			node.left = insert(data, node.left);
		} else if (data.compareTo(node.data) > 0) {
			node.right = insert(data, node.right);
		}
		return node;
	}
	
	public void preOrder(Node<E> node) {
		if (node != null) {
			System.out.printf("%d ", node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void levelOrderTraversal() {
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<E> tempNode = queue.poll();
			System.out.printf("%d ", tempNode.data);
			if (tempNode.left != null)
				queue.add(tempNode.left);
			if (tempNode.right != null)
				queue.add(tempNode.right);
		}
	}

	public void inOrder(Node<E> node) {
		if (node != null) {
			inOrder(node.left);
			System.out.printf("%d ", node.data);
			inOrder(node.right);
		}
	}

	public void postOrder(Node<E> node) {
		if (node != null) {
			preOrder(node.left);
			preOrder(node.right);
			System.out.printf("%d ", node.data);
		}
	}
	
	public boolean isBST() {
		return isBST(root);
	}

	private boolean isBST(Node<E> root2) {
		// TODO Auto-generated method stub
		return false;
	}

	private static final class Node<E extends Comparable> {
		private Node<E> left;
		private Node<E> right;
		private E data;

		private Node(final E data) {
			this.data = data;
		}
	}

}
