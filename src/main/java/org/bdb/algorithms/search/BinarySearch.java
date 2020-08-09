package org.bdb.algorithms.search;

import java.util.Comparator;

public class BinarySearch<T> implements Search<T> {

    @Override
    public int search(T[] items, T value, Comparator<T> comparator) {
        int left = 0;
        int right = items.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            int compare = comparator.compare(items[middle], value);

            if (compare == 0) {
                return middle;
            }

            if (compare < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }


        return -1;
    }
}
