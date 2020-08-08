package org.bdb.algorithms.collection.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTest {

    @Test
    public void testTree() {
        BinaryTree<Integer> binaryTree = new BinaryTree<>((n1, n2) -> n1 - n2);

        binaryTree.add(10);
        binaryTree.add(20);
        binaryTree.add(5);
        binaryTree.add(40);
        binaryTree.add(3);
        binaryTree.add(6);

        assertTrue(binaryTree.contains(10));
        assertFalse(binaryTree.contains(100));
        assertEquals(3, binaryTree.getDepth());
        assertEquals(10, binaryTree.getLowestCommonAncestor(3, 40));
    }

}
