package com.datastructures.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTests {

	BinarySearchTree<Integer> tree;

	@BeforeEach
	void setUp() throws Exception {
		tree = new BinarySearchTree<>();
		tree.insert(10);
		tree.insert(12);
		tree.insert(30);
		tree.insert(5);
		tree.insert(15);
		tree.insert(20);
		tree.insert(9);
		tree.insert(1);
		tree.insert(6);
		tree.insert(7);
	}

	@Test
	void testIsEmpty() {
		 assertFalse(tree.isEmpty());
	}

	@Test
	void testInsert() {
		tree.insert(11);
		tree.insert(16);
		tree.insert(17);
		System.out.println();
		System.out.println("Level Order");
		tree.levelOrderTraversal();
	}

	@Test
	void testInOrder() {
		System.out.println();
		System.out.println("inOrder");
		tree.inOrder(tree.getRoot());
	}

	@Test
	void testPreOrder() {
		System.out.println();
		System.out.println("preOrder");
		tree.preOrder(tree.getRoot());
	}
	
	@Test
	void testPostOrder() {
		System.out.println();
		System.out.println("postOrder");
		tree.postOrder(tree.getRoot());
	}

}
