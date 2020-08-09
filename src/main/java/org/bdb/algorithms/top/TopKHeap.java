package org.bdb.algorithms.top;

import java.util.*;

public class TopKHeap<T> implements TopK<T> {

    private T[] items;
    private Map<T, Integer> occurrences;

    @Override
    public T[] getMostOccurrences(T[] items, int k) {
        this.items = items;

        countOccurrences();

        PriorityQueue<T> minHeap = new PriorityQueue<>((n1, n2) -> occurrences.get(n1) - occurrences.get(n2));
        for (T t : occurrences.keySet()) {
            minHeap.add(t);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<T> topItems = new ArrayList<>(k);
        for (int idx = k - 1; idx >= 0; idx--) {
            topItems.add(0, minHeap.poll());
        }

        // This results in an ClassCastException.
        // TODO: Investigate why (
        return (T[]) topItems.toArray();
    }

    private void countOccurrences() {
        occurrences = new HashMap<>();
        for (T t : items) {
            occurrences.put(t, occurrences.getOrDefault(t, 0) + 1);
        }
    }
}
