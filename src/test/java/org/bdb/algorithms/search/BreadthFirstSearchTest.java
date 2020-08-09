package org.bdb.algorithms.search;

import org.bdb.algorithms.data.Graph;
import org.bdb.algorithms.data.GraphNode;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class BreadthFirstSearchTest {

    @Test
    public void testSearch() {
        PathSearch<String> search = new BreadthFirstSearchString();
        String[] path = search.searchPath(constructGraph(), "Bjorn", "Anuj");
        assertThat(new String[]{"Bjorn", "Bob", "Anuj"}, Matchers.arrayContaining(path));
    }

    private Graph<String> constructGraph() {
        GraphNode<String> bjorn = new GraphNode<>("Bjorn");
        GraphNode<String> bob = new GraphNode<>("Bob");
        GraphNode<String> anuj = new GraphNode<>("Anuj");
        GraphNode<String> alice = new GraphNode<>("Alice");
        GraphNode<String> peggy = new GraphNode<>("Peggy");
        GraphNode<String> claire = new GraphNode<>("Claire");
        GraphNode<String> jonny = new GraphNode<>("Jonny");
        GraphNode<String> thom = new GraphNode<>("Thom");

        bjorn.addNeighbour(alice);
        bjorn.addNeighbour(bob);
        bjorn.addNeighbour(claire);

        bob.addNeighbour(anuj);
        bob.addNeighbour(peggy);

        alice.addNeighbour(alice);

        claire.addNeighbour(jonny);
        claire.addNeighbour(thom);

        Graph<String> graph = new Graph<>();
        graph.addNode(bjorn);
        graph.addNode(bob);
        graph.addNode(anuj);
        graph.addNode(alice);
        graph.addNode(peggy);
        graph.addNode(peggy);
        graph.addNode(claire);
        graph.addNode(jonny);
        graph.addNode(thom);

        return graph;
    }

}