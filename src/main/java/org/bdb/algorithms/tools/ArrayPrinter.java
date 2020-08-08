package org.bdb.algorithms.tools;

public class ArrayPrinter<T> implements Printer<T>{

    @Override
    public void print(String header, T[] items) {
        System.out.println(header);
        boolean isFirst = true;
        for (T item : items) {
            if (!isFirst) {
                System.out.print(", ");
            }

            System.out.print(item);
            isFirst = false;
        }
        System.out.println();
    }

}
