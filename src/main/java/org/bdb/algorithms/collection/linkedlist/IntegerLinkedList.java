package org.bdb.algorithms.collection.linkedlist;

import org.bdb.algorithms.data.LinkedNode;

public class IntegerLinkedList extends MyLinkedList<Integer> {

    /**
     * Two pointers, one advances one node faster than the other.
     * The purpose is to find the middle of the list
     * @return
     */
    public double median() {
        if (super.head == null) {
            return 0.0;
        }

        LinkedNode<Integer> q = super.head;
        LinkedNode<Integer> s = super.head;
        boolean middle = false;

        while (! middle) {
            q = q.getNext().getNext();
            if (q == null) {
                double current = s.getValue();
                double next = s.getNext().getValue();
                return (current + next) / 2;
            } else if (q.getNext() == null) { // Odd number of elements
                return s.getNext().getValue();
            } else {
                s = s.getNext();
            }
        }

        return Double.MIN_VALUE;
    }

}
