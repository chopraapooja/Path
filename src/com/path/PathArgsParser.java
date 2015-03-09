package com.path;

/**
 * Created by poojar on 3/9/2015.
 */
public class PathArgsParser {
    private String source;
    private String dest;
    String getSource() {
        return source;
    }
    String getDest() {
        return dest;
    }
    public PathArgsParser(String[] args) {
        if(args.length == 2) {
            this.source = args[0];
            this.dest = args[1];
        }
    }
}
