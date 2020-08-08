package org.bdb.algorithms.sort;

import org.bdb.algorithms.tools.Printer;

import java.util.Comparator;

public class QuickSortHoare<T> implements Sort<T> {

    private T[] items;

    @Override
    public T[] sort(T[] items, Printer<T> printer, Comparator<T> comparator) {
        this.items = items;
        quickSort(0, this.items.length - 1, comparator);
        return items;
    }

    private void quickSort(int start, int finish, Comparator<T> comparator) {
        if (start < finish) {
            int partitionIdx = partition(start, finish, comparator);
            partition(start, partitionIdx, comparator);
            partition(partitionIdx + 1, finish, comparator);
        }
    }

    private int partition(int start, int finish, Comparator<T> comparator) {
        T pivot = this.items[start];

        int left = start - 1;
        int right = finish + 1;

        while (true) {
            do {
                left++;
            } while (comparator.compare(this.items[left], pivot) < 0);

            do {
                right--;
            } while (comparator.compare(this.items[right], pivot) > 0);

            if (left >= right) {
                return right;
            }

            swap(left, right);
        }
    }

    private void swap(int idxA, int idxB) {
        T temp = items[idxA];
        items[idxA] = items[idxB];
        items[idxB] = temp;
    }

}
