package com.path;

/**
 * Created by poojar on 3/9/2015.
 */
public class PathArgsParser {
    private String source;
    private String dest;
    private String fileURL;

    String getSource() {
        return source;
    }

    String getDest() {
        return dest;
    }

    int indexOf(String[] strings, String searchStr) {
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i];
            if (str.equals(searchStr)) return i;
        }
        return -1;
    }

    public String getFileURL() {
        return fileURL;
    }

    public PathArgsParser(String[] args) throws Exception {
        if(args.length < 2) throw new Exception("Insufficent Arguments");
        if(args.length >= 2) {
            this.source = args[0];
            this.dest = args[1];
        }
        int indexOfF = indexOf(args, "-f");
        if(indexOfF != -1) {
            fileURL = args[indexOfF + 1];
        }
    }

}
