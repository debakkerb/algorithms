package org.bdb.algorithms.top;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

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
    }

}