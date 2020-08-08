package org.bdb.algorithms.collection.linkedlist;

public interface LinkedList<T> {

    T get(int idx);

    void addFirst(T value);

    void addLast(T value);

    void add(T value);

    T getFirst();

    T getLast();

    void insert(T value, int idx);

    void removeFirst();

    void removeLast();

    void remove(int idx);

    void reverse();

    void insertBeforeEnd(int step, T value);

    int size();

    boolean isPalindrome();

}

