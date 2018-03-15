package com.thoughtworks.collection;

import org.junit.Test;

import java.util.*;

import static org.fest.assertions.api.Assertions.assertThat;

public class MyMapTest {

    @Test
    public void should_map_to_triple(){

        Integer[] array = new Integer[]{1,3,5,4,9};
        List<Integer> list = Arrays.asList(array);

        MyMap myMap = new MyMap(list);

        Integer[] result = new Integer[]{3,9,15,12,27};
        List<Integer> resultList = Arrays.asList(result);

        assertThat(myMap.getTriple()).isEqualTo(resultList);
    }

    @Test
    public void should_map_to_letter(){

        Integer[] array = new Integer[]{1,2,3,4,5};
        List<Integer> list = Arrays.asList(array);

        MyMap myMap = new MyMap(list);

        String[] result = new String[]{"a", "b", "c", "d", "e"};
        List<String> resultList = Arrays.asList(result);

        assertThat(myMap.mapLetter()).isEqualTo(resultList);
    }

    @Test
    public void should_map_to_letters(){

        Integer[] array = new Integer[]{1,13,27,30,52,53};
        List<Integer> list = Arrays.asList(array);

        MyMap myMap = new MyMap(list);

        String[] result = new String[]{"a", "m", "aa", "ad", "az","ba"};
        List<String> resultList = Arrays.asList(result);

        assertThat(myMap.mapLetters()).isEqualTo(resultList);
    }

    @Test
    public void should_sort_from_big_to_small(){

        Integer[] array = new Integer[]{1,2,3,4,5};
        List<Integer> list = Arrays.asList(array);

        MyMap myMap = new MyMap(list);

        Integer[] result = new Integer[]{5,4,3,2,1};
        List<Integer> resultList = Arrays.asList(result);

        assertThat(myMap.sortFromBig()).isEqualTo(resultList);
    }

    @Test
    public void should_sort_from_small_to_big(){

        Integer[] array = new Integer[]{3,2,4,5,1};
        List<Integer> list = Arrays.asList(array);

        MyMap myMap = new MyMap(list);


        Integer[] result = new Integer[]{1,2,3,4,5};
        List<Integer> resultList = Arrays.asList(result);

        assertThat(myMap.sortFromSmall()).isEqualTo(resultList);
    }
}