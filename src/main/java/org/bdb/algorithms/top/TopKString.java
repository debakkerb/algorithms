package org.bdb.algorithms.top;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Stream;

public class TopKString implements TopK<String> {

    private String[] items;
    private Map<String, Integer> uniqueOccurrences = new HashMap<>();

    @Override
    public String[] getMostOccurrences(String[] items, int k) {
        this.items = items;

        calculateUniqueOccurrences();
        Queue<String> topItems = new PriorityQueue<>((n1, n2) -> uniqueOccurrences.get(n1) - uniqueOccurrences.get(n2));

        for (String item : uniqueOccurrences.keySet()) {
            topItems.add(item);
            if (topItems.size() > k) {
                topItems.poll();
            }
        }

        String[] result = new String[k];
        for (int idx = k - 1; idx >= 0; idx--) {
            result[idx] = topItems.poll();
        }

        try (Stream<String> stream = Files.lines(Paths.get("filePath"))) {
            stream.forEach((line) -> {
                System.out.println(line);
            });
        } catch (IOException ioException) {

        }

        return result;
    }

    private void calculateUniqueOccurrences() {
        for (String item : items) {
            uniqueOccurrences.put(item, uniqueOccurrences.getOrDefault(item, 0) + 1);
        }
    }
}
