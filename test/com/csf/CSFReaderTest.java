package com.csf;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by poojar on 3/8/2015.
 */
public class CSFReaderTest {
    CSFReader csfReader;

    boolean compareKeys(Map map1, Map map2) {
        if (map1.size() != map2.size()) return false;
        for (Object key : map1.keySet()) {
            if(! map2.containsKey(key)) return false;
        }
        return true;
    }

    @Before
    public void setUp() throws Exception {
        csfReader = new CSFReader();
    }

    @Test
    public void toMap_should_map_string_having_CSV_into_map() {
        String number = "1,one";
        Map<String, List<String>> numberMap = csfReader.toMap(number);
        Map<String, List<String >> expectedMap = new HashMap<>();
        expectedMap.put("1", Arrays.asList("one"));
        assertTrue(compareKeys(expectedMap, numberMap));
        for(Object key : numberMap.keySet()) {
            assertTrue(numberMap.get(key).containsAll(expectedMap.get(key)));
        }
    }
    @Test
    public void toMap_should_map_string_having_CSV_with_multiple_lines_into_map(){
        String numbers = "1,one\n2,two";
        Map<String, List<String>> numbersMap = csfReader.toMap(numbers);
        Map<String, List<String>> expectedMap = new HashMap<>();
        expectedMap.put("1", Arrays.asList("one"));
        expectedMap.put("2", Arrays.asList("two"));
        assertTrue(compareKeys(expectedMap, numbersMap));
        for(Object key : numbersMap.keySet()) {
            assertTrue(numbersMap.get(key).containsAll(expectedMap.get(key)));
        }
    }
    @Test
    public void toMap_should_put_repeating_key_values_in_the_same_key() {
        String numbers = "1,one\n2,two\n1,ek";
        Map<String, List<String>> numbersMap = csfReader.toMap(numbers);
        Map<String, List<String>> expectedMap = new HashMap<>();
        expectedMap.put("1", Arrays.asList("one","ek"));
        expectedMap.put("2", Arrays.asList("two"));
        assertTrue(compareKeys(expectedMap, numbersMap));
        for(Object key : numbersMap.keySet()) {
            assertTrue(numbersMap.get(key).containsAll(expectedMap.get(key)));
        }
    }

}











