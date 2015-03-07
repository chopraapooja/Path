package com.path;

import java.util.*;
/**
 * Created by poojar on 3/7/2015.
 */
public class PathsManager {
    Map<String, ArrayList> directPaths = new HashMap<String, ArrayList>();
    PathsManager() {
        directPaths.put("Bangalore", new ArrayList<String>(Arrays.asList("Singapore")));
        directPaths.put("Singapore", new ArrayList<String>(Arrays.asList("Seoul", "Dubai","Bangalore")));
        directPaths.put("Seoul", new ArrayList<String>(Arrays.asList("Beijing","Singapore")));
        directPaths.put("Beijing", new ArrayList<String>(Arrays.asList("Tokyo","Seoul")));
        directPaths.put("Dubai", new ArrayList<String>(Arrays.asList("Singapore")));
        directPaths.put("Tokyo", new ArrayList<String>(Arrays.asList("Beijing")));
        directPaths.put("Patiala", new ArrayList<String>(Arrays.asList("Lahor")));
        directPaths.put("Lahor", new ArrayList<String>(Arrays.asList("Patiala")));

    }

    boolean isDirectPathBetween(String src, String dest) {
        ArrayList destinations = (ArrayList)directPaths.get(src);
        return directPaths.containsKey(src) && destinations.indexOf(dest) != -1;
    }

    Collection<ArrayList> getAllDestinations() {
        return directPaths.values();
    }
    // Anything who want to call this method should provide empty ArrayList &&
    //src and dest should be valided
    String findPathBetween(String src, String dest, ArrayList<String> visited) {
        if (isDirectPathBetween(src, dest)) {
            return src +"->"+ dest;
        }
        visited.add(src);
        for (Object key : ((directPaths.get(src)))) {
            if(visited.indexOf(key) == -1) {
                String path = findPathBetween((String)key, dest, visited);
                return path == null ? null : src +"->"+ path;
            }
        }
        return null;
    }

    boolean isThereAnyPathBetween(String src, String dest) {
        System.out.println(findPathBetween(src,dest, new ArrayList<String>()));
        return findPathBetween(src, dest, new ArrayList<String>()) == null ? false : true;
    }

    boolean doExistsAsDestination(String city) {
        Collection<ArrayList> destLists= getAllDestinations();
        for (ArrayList destList : destLists) {
            if (destList.contains(city)) return true;
        }
        return false;
    }

    boolean doExistsAsSource(String city) {
        return directPaths.containsKey(city);
    }

    boolean doExists(String city) {
        return doExistsAsSource(city) || doExistsAsDestination(city);
    }
}
