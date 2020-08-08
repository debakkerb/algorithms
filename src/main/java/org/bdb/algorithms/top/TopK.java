package org.bdb.algorithms.top;

import java.util.Comparator;

public interface TopK<T> {

    /**
     * Given a list of items, return the top K occurrences in that list.
     *
     * @param items : array of items
     * @param k : top K
     * @return : Most occurrences for the top k items
     */
    T[] getMostOccurrences(T[] items, int k);

}
