package com.path;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by poojar on 3/9/2015.
 */
public class PathArgsParserTest {
    @Test
    public void PathArgsParser_should_extract_source_and_destination_from_2Arguments() throws Exception{
        String[] args = new String[]{"Patiala","Foo"};
        PathArgsParser parser = new PathArgsParser(args);
        assertEquals(parser.getSource(), "Patiala");
        assertEquals(parser.getDest(), "Foo");
    }
    @Test
    public void PathArgsParser_should_throw_exception_when_args_length_is_less_than_2() throws Exception{
        String[] args = new String[]{"Patiala"};
        String errMsg = null;
        try {
            PathArgsParser parser = new PathArgsParser(args);
        } catch (java.lang.Exception e) {
            errMsg = e.getMessage();
        }
        assertTrue(errMsg.equals("Insufficent Arguments"));
    }
    @Test
    public void PathsArgsParser_should_extract_file_name_when_f_option_is_present() throws Exception {
        String[] args = new String[]{"Patiala","Foo","-f","paths"};
        PathArgsParser parser = new PathArgsParser(args);
        assertEquals(parser.getSource(), "Patiala");
        assertEquals(parser.getDest(), "Foo");
        assertEquals(parser.getFileURL(), "paths");
    }
}
