package org.bdb.algorithms.collection.tree;

import org.bdb.algorithms.data.TreeNode;

import java.util.Comparator;

// TODO: Add interface and tests
public class BinaryTree<T> {

    private TreeNode<T> root;
    private final Comparator<? super T> comparator;

    public BinaryTree(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public void add(T value) {
        root = addRecursive(root, value);
    }

    private TreeNode<T> addRecursive(TreeNode<T> node, T value) {
        if (node == null) {
            return new TreeNode<>(value);
        }

        if (comparator.compare(value, node.getValue()) < 0 ) {
            node.setLeft(addRecursive(node.getLeft(), value));
        } else if (comparator.compare(value, node.getValue()) > 0) {
            node.setRight(addRecursive(node.getRight(), value));
        } else {
            return node;
        }

        return node;
    }

    public boolean contains(T value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(TreeNode<T> current, T value) {
        if (current == null) {
            return false;
        }

        if (current.getValue().equals(value)) {
            return true;
        }

        return comparator.compare(value, current.getValue()) < 0 ?
                containsRecursive(current.getLeft(), value) :
                containsRecursive(current.getRight(), value);
    }

    public void delete(T value) {
        root = deleteRecursive(root, value);
    }

    private TreeNode<T> deleteRecursive(TreeNode<T> current, T value) {
        if (current == null) {
            return null;
        }

        if (comparator.compare(value, current.getValue()) == 0) {
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            if (current.getLeft() == null) {
                return current.getRight();
            }

            T smallestValue = findSmallestValue(current.getRight());
            current.setValue(smallestValue);
            current.setRight(deleteRecursive(current.getRight(), smallestValue));
            return current;
        }

        if (comparator.compare(value, current.getValue()) < 0) {
            current.setLeft(deleteRecursive(current.getLeft(), value));
            return current;
        }

        current.setRight(deleteRecursive(current.getRight(), value));
        return current;
    }

    private T findSmallestValue(TreeNode<T> node) {
        return node.getLeft() == null ? node.getValue() : findSmallestValue(node.getLeft());
    }

    public int getDepth() {
        return recursiveDepth(root);
    }

    private int recursiveDepth(TreeNode<T> node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = recursiveDepth(node.getLeft());
        int rightDepth = recursiveDepth(node.getRight());

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public T getLowestCommonAncestor(T firstValue, T secondValue) {
        TreeNode<T> ancestor = recursiveLowestCommonAncestor(root, firstValue, secondValue);

        if (ancestor != null) {
            return ancestor.getValue();
        }

        return null;
    }

    private TreeNode<T> recursiveLowestCommonAncestor(TreeNode<T> node, T firstValue, T secondValue) {
        if (node == null) {
            return null;
        }

        if (comparator.compare(node.getValue(), firstValue) == 0 || comparator.compare(node.getValue(), secondValue) == 0) {
            return node;
        }

        var left = recursiveLowestCommonAncestor(node.getLeft(), firstValue, secondValue);
        var right = recursiveLowestCommonAncestor(node.getRight(), firstValue, secondValue);

        if (left != null && right != null) {
            return node;
        }

        if (left == null && right == null) {
            return null;
        }

        return left != null ? left : right;
    }

    // TODO
    public boolean isMirror() {
        return false;
    }

    // TODO
    public boolean isSymmetric() {
        return false;
    }
}
