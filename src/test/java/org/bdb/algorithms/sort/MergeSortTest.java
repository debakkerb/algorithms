package org.bdb.algorithms.sort;

import org.bdb.algorithms.tools.ArrayPrinter;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MergeSortTest {

    @Test
    public void testSortNames() {
        String[] names = {"John", "Jane", "Emily", "Xavier", "Thanos", "Steve"};
        Sort<String> sort = new MergeSort<>();
        String[] sortedArray = sort.sort(names, new ArrayPrinter<>(), String::compareTo);

        assertThat(new String[]{
                "Emily", "Jane", "John", "Steve", "Thanos", "Xavier"
        }, Matchers.arrayContaining(sortedArray));
    }

    @Test
    public void testSortNumbers() {
        Integer[] numbers = {50, 10, 0, -6, 44, 23, 100};
        Sort<Integer> sort = new MergeSort<>();
        Integer[] sortedItems = sort.sort(numbers, new ArrayPrinter<>(), Integer::compareTo);

        assertThat(new Integer[]{
                -6, 0, 10, 23, 44, 50, 100
        }, Matchers.arrayContaining(sortedItems));
    }

}