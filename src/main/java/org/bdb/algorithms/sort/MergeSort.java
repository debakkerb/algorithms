package org.bdb.algorithms.sort;

import org.bdb.algorithms.tools.Printer;

import java.util.Comparator;

public class MergeSort<T> implements Sort<T> {
    private T[] helper;
    private T[] items;
    private Comparator<T> comparator;

    @Override
    public T[] sort(T[] items, Printer<T> printer, Comparator<T> comparator) {
        this.items = items;
        this.helper = (T[]) (new Object[items.length]);
        this.comparator = comparator;

        mergeSort(0, items.length - 1);

        return this.items;
    }

    private void mergeSort(int low, int high) {
        if (low < high) {
            int middle = low + (high - low) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);

            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {
        for (int idx = low; idx <= high; idx++) {
            helper[idx] = this.items[idx];
        }

        int leftIdx = low;
        int rightIdx = middle + 1;
        int itemIdx = low;

        while (leftIdx <= middle && rightIdx <= high) {
            if (comparator.compare(helper[leftIdx], helper[rightIdx]) <= 0) {
                this.items[itemIdx] = helper[leftIdx];
                leftIdx++;
            } else {
                this.items[itemIdx] = helper[rightIdx];
                rightIdx++;
            }

            itemIdx++;
        }

        while (leftIdx <= middle) {
            this.items[itemIdx] = helper[leftIdx];
            itemIdx++;
            leftIdx++;
        }
    }

}
