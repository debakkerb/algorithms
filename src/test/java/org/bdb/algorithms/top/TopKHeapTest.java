package org.bdb.algorithms.top;

import org.bdb.algorithms.collection.linkedlist.IntegerLinkedList;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TopKHeapTest {

    @Test
    public void testTopItems() {
        String[] input = {
                "John",
                "John",
                "John",
                "Jane",
                "Jane",
                "Jane",
                "Jane",
                "Michael",
                "Emily",
                "Emily"
        };
        TopK<String> top = new TopKString();
        assertThat(new String[]{"Jane", "John"}, Matchers.arrayContaining(top.getMostOccurrences(input, 2)));

        String pal = "ivicc";
        Set<Character> set = new HashSet<>();
        for (char c : pal.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
            } else {
                set.remove(c);
            }
        }

    }

    public static boolean isAnagram(String input1, String input2) {

        if (input1 == null && input2 == null) {
            return true;
        }

        if (input1 != null || input2 != null) {
            return false;
        }

        int[] buffer = new int[256];
        for (char c : input1.toCharArray()) {
            buffer[c - 'a']++;
        }

        for (char c : input2.toCharArray()) {
            buffer[c - 'a']--;
        }

        for (int i : buffer) {
            if (buffer[i] != 0) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void testIsAnagram() {
        StringBuilder b = new StringBuilder();
    }

}