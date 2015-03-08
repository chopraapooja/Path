package com.csf;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

/**
 * Created by poojar on 3/8/2015.
 */
public class CSFReaderTest {
    CSFReader csfReader;

    @Before
    public void setUp() throws Exception {
        csfReader = new CSFReader();
    }

    @Test
    public void toMap_should_map_string_having_CSV_into_map() {
        String number = "1,one";
        Map<String, String[]> numberMap = csfReader.toMap(number);
        Map<String, String[]> expectedMap = new HashMap<>();
        expectedMap.put("1", new String[]{"one"});
        assertTrue(numberMap.containsKey("1"));
        assertArrayEquals(numberMap.get("1"), new String[]{"one"});
        assertEquals(numberMap.keySet().size(), 1);
    }
    @Test
    public void toMap_should_map_string_having_CSV_with_multiple_lines_into_map(){
        String numbers = "1,one\n2,two";
        Map<String, String[]> numbersMap = csfReader.toMap(numbers);
        Map<String, String[]> expectedMap = new HashMap<>();
        expectedMap.put("1", new String[]{"one"});
        expectedMap.put("2", new String[]{"two"});
        assertTrue(numbersMap.containsKey("1"));
        assertTrue(numbersMap.containsKey("2"));
        assertArrayEquals(numbersMap.get("1"), new String[]{"one"});
        assertArrayEquals(numbersMap.get("2"), new String[]{"two"});
        assertEquals(numbersMap.keySet().size(), 2);
    }


}











