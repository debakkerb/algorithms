package org.bdb.algorithms.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode<T> {
    private T value;
    private List<GraphNode<T>> neighbours;

    public GraphNode(T value) {
        this.value = value;
    }

    public void addNeighbour(GraphNode<T> neighbour) {
        if (neighbours == null) {
            neighbours = new ArrayList<>();
        }

        neighbours.add(neighbour);
    }

    public T getValue() {
        return this.value;
    }

    public List<GraphNode<T>> getNeighbours() {
        return this.neighbours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode<?> graphNode = (GraphNode<?>) o;
        return Objects.equals(value, graphNode.value) &&
                Objects.equals(neighbours, graphNode.neighbours);
    }

}
