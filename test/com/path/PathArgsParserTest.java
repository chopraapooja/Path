package com.path;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by poojar on 3/9/2015.
 */
public class PathArgsParserTest {
    @Test
    public void PathArgsParser_should_extract_source_and_destination_from_2Arguments() {
        String[] args = new String[]{"Patiala","Foo"};
        PathArgsParser parser = new PathArgsParser(args);
        assertEquals(parser.getSource(), "Patiala");
        assertEquals(parser.getDest(), "Foo");
    }
//    @Test(expected = java.lang.Exception.class)
//    public void PathArgsParser_should_throw_exception_when_args_length_is_less_than_2() {
//        String[] args = new String[]{"Patiala","Foo"};
//        PathArgsParser parser = new PathArgsParser(args);
//    }
}
