package org.bdb.algorithms.top;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKString implements TopK<String>{

    private String[] items;
    private Map<String, Integer> occurrences;

    @Override
    public String[] getMostOccurrences(String[] items, int k) {
        this.items = items;

        countOccurrences();

        PriorityQueue<String> queue = new PriorityQueue<>((n1, n2) -> occurrences.get(n1) - occurrences.get(n2));
        for (String item : occurrences.keySet()) {
            queue.add(item);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        String[] topKItems = new String[k];
        for (int idx = k - 1; idx >= 0; idx--) {
            topKItems[idx] = queue.poll();
        }

        return topKItems;
    }

    private void countOccurrences() {
        occurrences = new HashMap<>();
        for (String item : items) {
            occurrences.put(item, occurrences.getOrDefault(item, 0) + 1);
        }
    }
}
