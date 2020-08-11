package org.bdb.algorithms.collection.tree;

/**
 * Build a Min Heap, where the value of the root node is smaller than its children.  Nodes are always inserted to the left first
 * and the tree should maintain it's depth.  The underlying data structure is an Array (or ArrayList).
 *
 * Positions:
 *  parent(k) = pos / 2
 *  left(k) = (pos * 2) + 1
 *  right(k) = (pos * 2) + 2
 *
 *  isLeaf(k) = middle <= k <= size
 *
 * For example, when 1, 2, 3, 4, 5, 6 is inserted, the array looks like this: 1, 2, 4, 5, 3, 6.
 */
public class MinHeap {
    private static final int INITIAL_CAPACITY = 11;

    private int[] heap;
    private int size;

    public MinHeap() {
        init(INITIAL_CAPACITY);
    }

    public MinHeap(int initialCapacity) {
        init(initialCapacity);
    }

    private void init(int initialCapacity) {
        this.heap = new int[initialCapacity];
        heap[0] = Integer.MIN_VALUE;
    }

    public int peek() {
        return heap[0];
    }

//    public int poll() {
//
//    }

    public void add(int value) {
        if (++size > heap.length) {
            increaseHeap();
        }

        heap[size] = value;
        int current = size;
        while (value < heap[getParent(current)]) {
            swap(current, getParent(current));
            current = getParent(current);
        }

    }

    /**
     * Whenever the capacity of the current list is reached, a new array is created with double the length of the
     * existing array and all items are copied.  This is considered the amortized cost of the operation.
     */
    private void increaseHeap() {
        int[] temp = new int[heap.length * 2];
        for (int idx = 0; idx < size; idx++) {
            temp[idx] = heap[idx];
        }
        this.heap = temp;
    }

    private void swap(int fpos, int spos) {
        int tmp = heap[fpos];
        heap[fpos] = heap[spos];
        heap[spos] = tmp;
    }

    private int getParent(int pos) {
        return pos / 2;
    }

    private int getLeftChild(int pos) {
        return (pos * 2) + 1;
    }

    private int getRightChild(int pos) {
        return (pos * 2) + 2;
    }

    private boolean isLeaf(int pos) {
        return pos >= (size / 2) && pos <= size;
    }
}
