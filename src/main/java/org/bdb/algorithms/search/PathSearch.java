package org.bdb.algorithms.search;

import org.bdb.algorithms.data.Graph;

public interface PathSearch<T> {

    T[] searchPath(Graph<T> graph, T start, T end);

}
