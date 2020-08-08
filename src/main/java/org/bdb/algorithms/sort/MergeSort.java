package org.bdb.algorithms.sort;

import org.bdb.algorithms.tools.Printer;

public class MergeSort implements Sort<Integer> {
    private Integer[] items;
    private Printer<Integer> printer;

    @Override
    public void sort(Integer[] items, Printer<Integer> printer) {
        this.items = items;
        this.printer = printer;

        printer.print("Before sort: ", items);
        mergeSort(0, items.length - 1);
        printer.print("After sort: ", items);
    }

    private void mergeSort(int start, int finish) {
        if (start < finish) {
            int middle = (start + finish) / 2;
            mergeSort(start, middle);
            mergeSort(middle + 1, finish);

            merge(start, middle, finish);
        }
    }

    private void merge(int start, int middle, int finish) {
        int tempIdx1 = middle - start + 1;
        int tempIdx2 = finish - middle;

        int[] tempArr1 = new int[tempIdx1];
        int[] tempArr2 = new int[tempIdx2];

        for (int idx = 0; idx < tempIdx1; idx++) {
            tempArr1[idx] = items[start + idx];
        }

        for (int idx = 0; idx < tempIdx2; idx++) {
            tempArr2[idx] = items[middle + 1 + idx];
        }

        int itemsIdx = start;
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < tempIdx1 && idx2 < tempIdx2) {
            if (tempArr1[idx1] <= tempArr2[idx2]) {
                items[itemsIdx] = tempArr1[idx1];
                idx1++;
            } else {
                items[itemsIdx] = tempArr2[idx2];
                idx2++;
            }

            itemsIdx++;
        }

        while (idx1 < tempIdx1) {
            items[itemsIdx] = tempArr1[idx1];
            idx1++;
            itemsIdx++;
        }

        while (idx2 < tempIdx2) {
            items[itemsIdx] = tempArr2[idx2];
            idx2++;
            itemsIdx++;
        }
    }
}
