package com.csf;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.*;

/**
 * Created by poojar on 3/7/2015.
 */
public class CSFReader {
    private String fileContents;

    public CSFReader(String fileURL)throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileURL));
        String fileContents = "", currentLine;
        while ((currentLine = br.readLine()) != null) {
            fileContents += currentLine + "\n";
        }
        this.fileContents = fileContents;
    }

    public CSFReader() {

    }

    public String getFileContents() {
        return this.fileContents;
    }

    public Map toMap(String str) {
        String[] lines = str.split("\n");
        Map<String, List<String>> result = new HashMap<>();
        for (String line : lines) {
            String[] vals = line.split(",");
            if(vals.length == 2) {
                if(result.containsKey(vals[0])) {

                }
            result.put(vals[0],Arrays.asList(vals[1]));
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        CSFReader r = new CSFReader("./data/paths.txt");
        String fileContents = r.getFileContents();
        System.out.println(fileContents);
        Map<String,ArrayList<String>> paths = r.toMap(fileContents);
//        System.out.println(paths.keySet());
    }

}

























