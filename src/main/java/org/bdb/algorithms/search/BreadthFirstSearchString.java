package org.bdb.algorithms.search;

import org.bdb.algorithms.data.Graph;
import org.bdb.algorithms.data.GraphNode;

import java.util.*;

public class BreadthFirstSearchString implements PathSearch<String> {

    @Override
    public String[] searchPath(Graph<String> graph, String start, String end) {
        GraphNode<String> startNode = graph.getNode(start);
        GraphNode<String> endNode = graph.getNode(end);

        Deque<GraphNode<String>> nodes = new ArrayDeque<>();
        nodes.offer(startNode);

        Map<GraphNode<String>, GraphNode<String>> parents = new HashMap<>();
        parents.put(startNode, null);

        while (!nodes.isEmpty()) {
            GraphNode<String> node = nodes.poll();
            if (node.equals(endNode)) {
                return constructPath(parents, endNode);
            }

            List<GraphNode<String>> neighbours = node.getNeighbours();
            for (GraphNode<String> neighbour : neighbours) {
                if (!parents.containsKey(neighbour)) {
                    parents.put(neighbour, node);
                    nodes.offer(neighbour);
                }
            }
        }

        return null;
    }

    private String[] constructPath(Map<GraphNode<String>, GraphNode<String>> parents, GraphNode<String> endNode) {
        List<String> reversePath = new ArrayList<>();
        GraphNode<String> currentNode = endNode;
        while (currentNode != null) {
            reversePath.add(currentNode.getValue());
            currentNode = parents.get(currentNode);
        }

        Collections.reverse(reversePath);
        return reversePath.toArray(new String[reversePath.size()]);
    }

}
