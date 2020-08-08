package org.bdb.algorithms.collection.linkedlist;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyLinkedListTest {

    @Test
    public void testSize() {
        LinkedList<String> names = new MyLinkedList<>();
        names.add("John");
        names.addFirst("Olivia");
        names.addLast("Jacob");
        names.add("Emily");
        names.addLast("Sophia");
        names.remove(3);
        names.removeFirst();
        names.removeLast();

        assertEquals(2, names.size());
    }

    @Test
    public void testRemoveNodes() {
        LinkedList<String> names = new MyLinkedList<>();
        names.add("John");
        names.addLast("Jacob");
        names.addFirst("Sophia");
        names.addFirst("Emily");
        names.remove(0);
        names.removeFirst();

        assertEquals(2, names.size());
        assertEquals("John", names.getFirst());
        assertEquals("John", names.get(0));
    }

    @Test
    public void testReverse() {
        LinkedList<String> names = new MyLinkedList<>();
        names.add("John");
        names.add("Jacob");
        names.add("Jane");
        names.addFirst("Emily");
        names.addLast("Sophia");
        names.removeFirst();
        names.removeLast();
        names.remove(2);
        names.reverse();

        assertEquals("Jacob", names.getFirst());
        assertEquals("John", names.getLast());
    }

    @Test
    public void isPalindrome() {
        LinkedList<Integer> numbers = new MyLinkedList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(1);

        assertTrue(numbers.isPalindrome());
        numbers.addFirst(0);
        assertFalse(numbers.isPalindrome());
    }
}
