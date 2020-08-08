package org.bdb.algorithms.sort;


import org.bdb.algorithms.tools.Printer;

public interface Sort<T> {

    void sort(T[] items, Printer<T> printer);

}
