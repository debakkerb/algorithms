package org.bdb.algorithms.sort;

import org.bdb.algorithms.tools.Printer;

public class QuickSort implements Sort<Integer> {

    private Integer[] items;
    private Printer<Integer> printer;

    @Override
    public void sort(Integer[] items, Printer<Integer> printer) {
        this.items = items;
        this.printer = printer;

        printer.print("Before sort: ", items);
        quickSort(0, items.length - 1);
        printer.print("After sort: ", items);
    }

    private void quickSort(int start, int finish) {
        if (start < finish) {
            int partitionIdx = partition(start, finish);
            quickSort(start, partitionIdx - 1);
            quickSort(partitionIdx + 1, finish);
        }
    }

    private int partition(int start, int finish) {
        int pivot = items[finish];
        int tail = start - 1;

        for (int j = start; j < finish; j++) {
            if (items[j] <= pivot) {
                tail++;
                swap(tail, j);
            }
        }

        tail++;
        swap(finish, tail);
        return tail;
    }

    private void swap(int idxA, int idxB) {
        int temp = items[idxA];
        items[idxA] = items[idxB];
        items[idxB] = temp;
    }

}
