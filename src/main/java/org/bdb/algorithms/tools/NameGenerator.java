package org.bdb.algorithms.tools;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * This class reads in names.txt and generates a list of random names.  It does this by computing a random int and check if
 * it can be divided by 3.  If so, add a random number of copies of that name, depending on whether or not duplicates are allowed.
 */
public class NameGenerator implements Generator<String> {

    private static final Logger LOGGER = LogManager.getLogger(NameGenerator.class);

    private static final String INPUT_FILE = "src/main/resources/names.txt";

    @Override
    public List<String> generate(int size, boolean withDuplicates) {
        File inputFile = new File(INPUT_FILE);
        List<String> nameList = new ArrayList<>(size);

        try (Stream<String> stream = Files.lines(Paths.get(inputFile.getAbsolutePath()))) {
            Random random = new Random();
            stream.forEach(name -> {
                boolean add = random.nextInt(size) % 3 == 0;
                if (add && nameList.size() <= size) {
                    if (!withDuplicates) {
                        nameList.add(name);
                    } else {
                        int copies = random.nextInt(50);
                        for (int i = 0; i < copies && nameList.size() <= size; i++) {
                            nameList.add(name);
                        }
                    }
                }
            });

            Collections.shuffle(nameList);

            return nameList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void generateFile(int size, boolean withDuplicates, String outputPath) {
        List<String> names = generate(size, withDuplicates);
        Path path = Paths.get(outputPath);
        try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(path))) {
            for (String name : names) {
                writer.println(name);
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
