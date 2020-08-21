package org.bdb.algorithms.collection.tree;

import org.bdb.algorithms.data.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testTree() {
//        BinaryTree<Integer> binaryTree = new BinaryTree<>((n1, n2) -> n1 - n2);
//
//        binaryTree.add(10);
//        binaryTree.add(20);
//        binaryTree.add(5);
//        binaryTree.add(40);
//        binaryTree.add(3);
//        binaryTree.add(6);
//
//        assertTrue(binaryTree.contains(10));
//        assertFalse(binaryTree.contains(100));
//        assertEquals(3, binaryTree.getDepth());
//        assertEquals(10, binaryTree.getLowestCommonAncestor(3, 40));
    }

    @Test
    public void testPrintPaths() {
        TreeNode<Integer> one = new TreeNode<>(10);
        TreeNode<Integer> two = new TreeNode<>(20);
        TreeNode<Integer> three = new TreeNode<>(30);
        TreeNode<Integer> four = new TreeNode<>(40);
        TreeNode<Integer> five = new TreeNode<>(50);
        TreeNode<Integer> six = new TreeNode<>(60);
        TreeNode<Integer> seven = new TreeNode<>(70);
        TreeNode<Integer> eight = new TreeNode<>(80);
        TreeNode<Integer> nine = new TreeNode<>(90);

        one.setLeft(two);
        one.setRight(three);

        two.setLeft(four);
        two.setRight(five);

        three.setLeft(six);
        three.setRight(seven);

        four.setRight(eight);
        five.setRight(nine);

        printPaths(one, new ArrayDeque<>());
    }

    private void printPaths(TreeNode<Integer> node, Deque<Integer> path) {
        if (node == null) {
            return;
        }

        path.offer(node.getValue());

        if (isLeaf(node)) {
            System.out.println(path);
        }

        printPaths(node.getLeft(), path);
        printPaths(node.getRight(), path);

        path.removeLast();
    }

    private boolean isLeaf(TreeNode<Integer> node) {
        return node.getLeft() == null && node.getRight() == null;
    }

}
