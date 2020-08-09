package org.bdb.algorithms.top;

import java.util.HashMap;
import java.util.Map;

public class TopKHoareString implements TopK<String> {

    private Map<String, Integer> occurrences = new HashMap<>();

    @Override
    public String[] getMostOccurrences(String[] items, int k) {
        countOccurrences(items);



        return new String[0];
    }

    private void countOccurrences(String[] items) {
        for (String item : items) {
            occurrences.put(item, occurrences.getOrDefault(item, 0) + 1);
        }
    }

}
