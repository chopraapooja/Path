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
        String[] args = new String[]{"-f","paths","Patiala","Foo"};
        PathArgsParser parser = new PathArgsParser(args);
        assertEquals(parser.getSource(), "Patiala");
        assertEquals(parser.getDest(), "Foo");
        assertEquals(parser.getFileURL(), "paths");
    }
    @Test
    public void PathArgsParser_should_give_null_fileURL_when_only_source_and_destination_are_supplied() throws Exception{
        String[] args = new String[]{"Patiala","Foo"};
        PathArgsParser parser = new PathArgsParser(args);
        assertEquals(parser.getFileURL(), null);
    }
    @Test
    public void PathArgsParser_should_give_null_cityFileURL_when_only_source_and_destination_are_supplied() throws Exception{
        String[] args = new String[]{"Patiala","Foo"};
        PathArgsParser parser = new PathArgsParser(args);
        assertEquals(parser.getCityFileURL(), null);
    }

    @Test
    public void PathArgsManager_should_extract_cityInfo_file_name_when_c_option_is_present() throws Exception {
        String[] args = new String[]{"-c","city","Patiala","Foo"};
        PathArgsParser parser = new PathArgsParser(args);
        assertEquals(parser.getSource(), "Patiala");
        assertEquals(parser.getDest(), "Foo");
        assertEquals(parser.getFileURL(), null);
        assertEquals(parser.getCityFileURL(), "city");
    }
    @Test
    public void PathArgsManager_should_read_f_and_c_both_options_together() throws Exception {
        String[] args = new String[]{"-c","city","-f","paths","Patiala","Foo"};
        PathArgsParser parser = new PathArgsParser(args);
        assertEquals(parser.getSource(), "Patiala");
        assertEquals(parser.getDest(), "Foo");
        assertEquals(parser.getFileURL(), "paths");
        assertEquals(parser.getCityFileURL(), "city");
    }
}
























