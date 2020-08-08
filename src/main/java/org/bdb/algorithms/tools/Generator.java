package org.bdb.algorithms.tools;

import java.util.List;

public interface Generator<T> {

    List<T> generate(int size, boolean withDuplicates);

    void generateFile(int size, boolean withDuplicates, String outputPath);

}
