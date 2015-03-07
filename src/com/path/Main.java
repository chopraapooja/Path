package com.path;

/**
 * Created by poojar on 3/7/2015.
 */
public class Main {
    public static void main(String[] args) {
        String src = args[0].equals("null")  ? "Bangalore" : args[0];
        String dest = args[1].equals("null") ? "Singapore" : args[1];
        PathsManager mgr = new PathsManager();
        String invalidCity = mgr.doExists(src) ? (mgr.doExists(dest) ? null : dest) : src;

        if(invalidCity != null) {
        	System.out.println("No city named \""+invalidCity+"\" found in database.");
        }
        else {
        	System.out.println(mgr.isThereAnyPathBetween(src,dest));
        }
    }
}
