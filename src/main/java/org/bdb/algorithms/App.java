package org.bdb.algorithms;

import org.bdb.algorithms.tools.NameGenerator;

public class App
{
    public static void main( String[] args )
    {
        NameGenerator nameGenerator = new NameGenerator();
        nameGenerator.generateFile(50000000, true, "names.txt");

        System.out.println( "Hello World!" );
    }
}
