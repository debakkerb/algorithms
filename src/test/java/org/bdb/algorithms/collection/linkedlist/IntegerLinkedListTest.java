package org.bdb.algorithms.collection.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerLinkedListTest {

    @Test
    public void testGetMedian() {
        assertEquals(3, createList(1, 2, 3, 4, 5).median());
    }

    @Test
    public void testGetMedian_even() {
        assertEquals(2.5, createList(1, 2, 3, 4).median());
    }

    @Test
    public void testGetMedian_small() {
        assertEquals(1.5, createList(1, 2).median());
    }

    private IntegerLinkedList createList(int... items) {
        IntegerLinkedList list = new IntegerLinkedList();
        for (int item : items) {
            list.add(item);
        }

        return list;
    }

}