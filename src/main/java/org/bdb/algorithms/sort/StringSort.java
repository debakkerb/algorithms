package org.bdb.algorithms.sort;

import org.bdb.algorithms.tools.Printer;

public class StringSort implements Sort<String> {
    private String[] items;
    private Printer<String> printer;

    @Override
    public void sort(String[] items, Printer<String> printer) {
        this.items = items;
        this.printer = printer;

        printer.print("Before sort: ", items);
        quickSort(0, items.length - 1);
        printer.print("After sort: ", items);
    }

    private void quickSort(int leftIdx, int rightIdx) {
        if (leftIdx < rightIdx) {
            int pivotIdx = getPivotIdx(leftIdx, rightIdx);
            quickSort(leftIdx, pivotIdx - 1);
            quickSort(pivotIdx + 1, rightIdx);
        }
    }

    private int getPivotIdx(int leftIdx, int rightIdx) {
        String name = items[rightIdx];
        int tailIdx = leftIdx - 1;
        for (int j = leftIdx; j < rightIdx; j++) {
            if (items[j].compareTo(name) < 0) {
                tailIdx++;
                swap(tailIdx, j);
            }
        }

        tailIdx++;
        swap(tailIdx, rightIdx);

        return tailIdx;
    }

    private void swap(int idxA, int idxB) {
        String temp = items[idxA];
        items[idxA] = items[idxB];
        items[idxB] = temp;
    }
}
