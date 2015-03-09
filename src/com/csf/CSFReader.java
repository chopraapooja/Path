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

    public Map toDirectPaths(String str) {
        String[] lines = str.split("\n");
        int j = 0, k=1;
        Map<String, ArrayList<String>> result = new HashMap<>();
        for (String line : lines) {
            String[] vals = line.split(",");
            if(vals.length == 2) {
                for (int i = 0; i < 2; i++) {
                    if(result.containsKey(vals[j])) {
                        result.get(vals[j]).add(vals[k]);
                    }
                    else{
                        result.put(vals[j],new ArrayList<String>(Arrays.asList(vals[k])));
                    }
                    j=1; k=0;
                }
            }
        }
        return result;
    }
    public Map toMap(String str) {
        String[] lines = str.split("\n");
        Map<String, ArrayList<String>> result = new HashMap<>();
        for (String line : lines) {
            String[] vals = line.split(",");
            if(vals.length == 2) {
                if(result.containsKey(vals[0])) {
                    result.get(vals[0]).add(vals[1]);
                }
                else{
                    result.put(vals[0],new ArrayList<String>(Arrays.asList(vals[1])));
                }
            }
        }
        return result;
    }



    public static void main(String[] args) throws IOException {
        String fileURL = args[0];
        CSFReader r = new CSFReader(fileURL);
        String fileContents = r.getFileContents();
        System.out.println(fileContents);
    }

}

























