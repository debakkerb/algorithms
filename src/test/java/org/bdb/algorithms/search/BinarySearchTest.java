package org.bdb.algorithms.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchTest {

    @Test
    public void testSearch() {
        Integer[] items = {
                10, 20, 30, 40, 50, 60
        };
        Search<Integer> search = new BinarySearch<>();
        assertEquals(2, search.search(items, 30, Integer::compareTo));
    }

    @Test
    public void testSearchString() {
        String[] items = {
                "Jane", "John", "Thanos", "Wolverine"
        };
        Search<String> search = new BinarySearch<>();
        assertEquals(3, search.search(items, "Wolverine", String::compareTo));
        assertEquals(-1, search.search(items, "Test", String::compareTo));
    }
}