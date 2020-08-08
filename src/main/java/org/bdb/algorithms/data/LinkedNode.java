package org.bdb.algorithms.data;

public class LinkedNode<T> {
    private T value;
    private LinkedNode<T> next;

    public LinkedNode(T value) {
        this.value = value;
    }

    public LinkedNode(T value, LinkedNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public T getValue() {
        return this.value;
    }

    public LinkedNode<T> getNext() {
        return this.next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

}
