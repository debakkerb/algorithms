package org.bdb.algorithms.search;

import java.util.Comparator;

public interface Search<T> {

    int search(T[] items, T value, Comparator<T> comparator);

}
