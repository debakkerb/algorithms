package org.bdb.algorithms.tools;

import java.util.List;

public interface Generator<T> {

    List<T> generate(int size, boolean withDuplicates);

}
