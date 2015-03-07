package com.csf;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by poojar on 3/7/2015.
 */
public class Spike {
    public static void main(String[] args) throws IOException {
        CSFReader cr = new CSFReader("./data/paths.txt");
        Map<String,String[]> fileContants = new HashMap<>();
        String fc = cr.getFileContents();
        String[] lines = fc.split("\n");
        System.out.println(lines);
    }
}
