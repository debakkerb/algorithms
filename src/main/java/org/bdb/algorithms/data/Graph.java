package org.bdb.algorithms.data;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

    private List<GraphNode<T>> nodes;

    public void addNode(GraphNode<T> node) {
        if (this.nodes == null) {
            this.nodes = new ArrayList<>();
        }

        this.nodes.add(node);
    }

    public GraphNode<T> getNode(T value) {
        for (GraphNode<T> node : nodes) {
            if (node.getValue().equals(value)) {
                return node;
            }
        }

        throw new IllegalArgumentException(String.format("Node with value %s not found.", value));
    }

}
