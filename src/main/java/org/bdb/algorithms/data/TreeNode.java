package org.bdb.algorithms.data;

public class TreeNode<T> {

    private T value;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public void setValue(T smallestValue) {
        this.value = value;
    }
}