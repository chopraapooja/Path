package com.path;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by poojar on 3/7/2015.
 */
public class Main {
    public static void printPath(String citiesURL, String path) {
        if(citiesURL == null) {
            System.out.println(path);
        }

    }
    public static void main(String[] args){
        PathArgsParser parser = null;
        try {
            parser = new PathArgsParser(args);
            String src = parser.getSource();
            String dest = parser.getDest();
            String fileURL = parser.getFileURL();
            String cityFileURL = parser.getCityFileURL();
            PathsManager mgr = (fileURL != null) ? new PathsManager(fileURL) : new PathsManager();
            String invalidCity = mgr.doExists(src) ? (mgr.doExists(dest) ? null : dest) : src;
            if(invalidCity != null) {
                System.out.println("No city named \""+invalidCity+"\" found in database.");
            }
            else {
                printPath(cityFileURL, mgr.findPathBetween(src, dest, new ArrayList<String>()));
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
