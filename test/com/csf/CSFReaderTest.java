package com.csf;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.IsEqual.equalTo;
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
        Map<String, String[]> numberMap = csfReader.toMap(number);
        Map<String, String[]> expectedMap = new HashMap<>();
        expectedMap.put("1", new String[]{"one"});
        assertTrue(compareKeys(expectedMap, numberMap));
        for(Object key : numberMap.keySet()) {
            assertArrayEquals(numberMap.get(key),expectedMap.get(key));
        }
    }
    @Test
    public void toMap_should_map_string_having_CSV_with_multiple_lines_into_map(){
        String numbers = "1,one\n2,two";
        Map<String, String[]> numbersMap = csfReader.toMap(numbers);
        Map<String, String[]> expectedMap = new HashMap<>();
        expectedMap.put("1", new String[]{"one"});
        expectedMap.put("2", new String[]{"two"});
        assertTrue(compareKeys(expectedMap, numbersMap));
        for(Object key : numbersMap.keySet()) {
            assertArrayEquals(numbersMap.get(key),expectedMap.get(key));
        }
    }
    @Test
    public void toMap() {
//        String str1[] = new String[]{"you","me"};
//        String str2[] = new String[]{"you","me"};
//        System.out.println(str1.equals(str2));
//        assertArrayEquals(str1, str2);
    }

}











