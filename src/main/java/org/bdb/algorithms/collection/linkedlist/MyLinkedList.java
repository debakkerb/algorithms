package org.bdb.algorithms.collection.linkedlist;

import org.bdb.algorithms.data.LinkedNode;

public class MyLinkedList<T> implements LinkedList<T> {

    protected LinkedNode<T> head;
    protected LinkedNode<T> tail;
    protected int size;

    public int size() {
        return size;
    }

    public T get(int idx) {
        if (idx > size) {
            throw new ArrayIndexOutOfBoundsException(String.format("Requested item at position %d, but there are only %d elements.", idx, size));
        }

        if (idx == 0) {
            return head.getValue();
        }

        if (idx == size - 1) {
            return tail.getValue();
        }

        LinkedNode<T> currentNode = head.getNext();
        int currentIdx = 1;
        while (currentNode != null) {
            if (currentIdx == idx) {
                return currentNode.getValue();
            }

            currentIdx++;
            currentNode = currentNode.getNext();
        }

        return null;
    }

    public void addFirst(T value) {
        LinkedNode<T> node = new LinkedNode<>(value, head);

        if (size == 0) {
            head = tail = node;
        } else {
            head = node;
        }

        size++;
    }

    public void addLast(T value) {
        LinkedNode<T> node = new LinkedNode<>(value);
        if (size == 0) {
            head = tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }

        size++;
    }

    public void add(T value) {
        addLast(value);
    }

    public T getFirst() {
        return this.head.getValue();
    }

    public T getLast() {
        return this.tail.getValue();
    }

    public void insert(T value, int idx) {
        if (idx > size) {
            throw new ArrayIndexOutOfBoundsException(String.format("Requested item at position %d, but there are only %d elements.", idx, size));
        }

        if (idx == 0) {
            addFirst(value);
        } else if (idx == size - 1) {
            addLast(value);
        } else {
            int tempIdx = 0;
            LinkedNode<T> currentNode = this.head;
            while (currentNode != null && tempIdx < idx - 1) {
                currentNode = currentNode.getNext();
                tempIdx++;
            }

            LinkedNode<T> newNode = new LinkedNode<>(value);
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);

            size++;
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
            size--;
        }
    }

    public void removeLast() {
        remove(size - 1);
    }

    public void remove(int idx) {
        if (size < idx) {
            throw new ArrayIndexOutOfBoundsException(String.format("Requested item at position %d, but there are only %d elements.", idx, size));
        }

        if (idx == 0) {
            removeFirst();
        } else {
            LinkedNode<T> node = getNode(idx - 1);
            if (idx == size - 1) {
                tail = node;
                tail.setNext(null);
            } else {
                node.setNext(node.getNext().getNext());
            }
            size--;
        }
    }

    public void reverse() {
        LinkedNode<T> previous = null;
        LinkedNode<T> current = this.head;
        this.tail = this.head;

        while (current != null) {
            LinkedNode<T> temp = current.getNext();
            current.setNext(previous);
            previous = current;
            current = temp;
        }

        this.head = previous;
    }

    public void insertBeforeEnd(int step, T value) {
        if (step > size) {
            throw new ArrayIndexOutOfBoundsException(String.format("Requested item at position %d, but there are only %d elements.", step, size));
        }

        int currentIdx = 0;
        LinkedNode<T> current = head;
        LinkedNode<T> pointer = head;
        LinkedNode<T> newNode = new LinkedNode<>(value);

        while (current != null) {
            if (currentIdx++ >= step) {
                pointer = pointer.getNext();
            }

            current = current.getNext();
        }

        LinkedNode<T> temp = pointer.getNext();
        pointer.setNext(newNode);
        newNode.setNext(temp);
    }

    @Override
    public boolean isPalindrome() {
        LinkedNode<T> startNode = this.head;
        LinkedNode<T> endNode = this.head;
        LinkedNode<T> middleStart = null;

        while (middleStart == null) {
            endNode = endNode.getNext().getNext();

            if (endNode == null) {
                middleStart = startNode.getNext();
            } else if (endNode.getNext() == null) {
                middleStart = startNode.getNext().getNext();
            } else {
                startNode = startNode.getNext();
            }
        }

        startNode.setNext(null);

        LinkedNode<T> reversed = reverse(middleStart);
        LinkedNode<T> current = this.head;
        while (current != null && reversed != null) {
            if (! current.getValue().equals(reversed.getValue())) {
                return false;
            }

            current = current.getNext();
            reversed = reversed.getNext();
        }

        return true;
   }

    private LinkedNode<T> reverse(LinkedNode<T> currentNode) {
        if (currentNode == null || currentNode.getNext() == null) {
            return currentNode;
        }

        LinkedNode<T> newHead = reverse(currentNode.getNext());

        currentNode.getNext().setNext(currentNode);
        currentNode.setNext(null);

        return newHead;
    }

    private LinkedNode<T> getNode(int idx) {
        LinkedNode<T> currentNode = this.head;
        for (int i = 0; i < idx; ++i) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }

    @Override
    public String toString() {
        LinkedNode<T> currentNode = this.head;
        StringBuilder output = new StringBuilder();

        while (currentNode != null) {
            if (currentNode != head) {
                output.append(", ");
            }

            output.append(currentNode.getValue());
            currentNode = currentNode.getNext();
        }

        return output.toString();
    }

}
