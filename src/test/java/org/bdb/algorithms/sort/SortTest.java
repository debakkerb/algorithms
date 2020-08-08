package org.bdb.algorithms.sort;

import org.bdb.algorithms.tools.ArrayPrinter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SortTest {

    @Test
    public void testSort() {
        Sort<Integer> sort = new QuickSortHoare<>();

        Integer[] sortedItems = sort.sort(
                new Integer[]{10, 6, 5, 22},
                new ArrayPrinter<>(),
                (n1, n2) -> n1 - n2
        );

        assertThat(new Integer[]{5, 6, 10, 22}, Matchers.arrayContaining(sortedItems));
    }

    @Test
    public void testSort_negativeValues() {
        Sort<Integer> sort = new QuickSortHoare<>();

        Integer[] sortedItems = sort.sort(
                new Integer[]{10, -3, 5, 100},
                new ArrayPrinter<>(),
                (n1, n2) -> n1 - n2
        );

        assertThat(new Integer[]{-3, 5, 10, 100}, Matchers.arrayContaining(sortedItems));
    }

    @Test
    public void testQuickSort() {
        Sort<Integer> sort = new QuickSort<>();
        Integer[] sortedItems = sort.sort(
                new Integer[]{50, 23, 1, 100, 80, 77, 9},
                new ArrayPrinter<>(),
                (n1, n2) -> n1 - n2
        );

        assertThat(new Integer[]{1, 9, 23, 50, 77, 80, 100}, Matchers.arrayContaining(sortedItems));
    }
}