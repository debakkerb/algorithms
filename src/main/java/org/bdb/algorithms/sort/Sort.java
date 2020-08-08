package org.bdb.algorithms.sort;


import org.bdb.algorithms.tools.Printer;

import java.util.Comparator;

public interface Sort<T> {

    T[] sort(T[] items, Printer<T> printer, Comparator<T> comparator);

}
