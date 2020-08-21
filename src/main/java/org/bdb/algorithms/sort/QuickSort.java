package org.bdb.algorithms.sort;

import org.bdb.algorithms.tools.Printer;

import java.util.Comparator;

public class QuickSort<T> implements Sort<T> {
    private T[] items;
    private Comparator<T> comparator;

    @Override
    public T[] sort(T[] items, Printer<T> printer, Comparator<T> comparator) {
        this.items = items;
        this.comparator = comparator;

        quickSort(0, this.items.length - 1);
        return this.items;
    }

    private void quickSort(int start, int finish) {
        if (start < finish) {
            int partitionIdx = pivot(start, finish);
            quickSort(start, partitionIdx - 1);
            quickSort(partitionIdx + 1, finish);
        }
    }

    private int pivot(int start, int finish) {
        T pivot = this.items[finish];
        int tailIdx = start;

        for (int j = start; j < finish; j++) {
            if (comparator.compare(items[j], pivot) < 0) {
                swap(tailIdx, j);
                tailIdx++;
            }
        }

        swap(tailIdx, finish);

        return tailIdx;
    }

    private void swap(int idxA, int idxB) {
        T temp = this.items[idxA];
        this.items[idxA] = this.items[idxB];
        this.items[idxB] = temp;
    }
}
