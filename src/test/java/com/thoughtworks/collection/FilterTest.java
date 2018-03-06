package com.thoughtworks.collection;

import org.junit.Test;

import java.util.*;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class FilterTest {

    @Test
    public void should_return_even(){
        Integer[] array = new Integer[] {1,2,3,4,5};
        List<Integer> arrayList =  Arrays.asList(array);

        Filter filter = new Filter(arrayList);

        Integer[] result = new Integer[]{2,4};
        List<Integer> resultList = Arrays.asList(result);

        assertThat(filter.filterEven()).isEqualTo(resultList);
    }

    @Test
    public void should_return_multiple_of_three(){
        Integer[] array = new Integer[] {6,2,3,4,9};
        List<Integer> arrayList =  Arrays.asList(array);

        Filter filter = new Filter(arrayList);

        Integer[] result = new Integer[]{6,3,9};
        List<Integer> resultList = Arrays.asList(result);

        assertThat(filter.filterMultipleOfThree()).isEqualTo(resultList);
    }

    @Test
    public void should_return_different_elements_in_arrayList(){
        Integer[] array = new Integer[] {1,1,1,2,3};
        List<Integer> arrayList = Arrays.asList(array);

        Integer[] result = new Integer[] {1,2,3};
        List<Integer> resultList = Arrays.asList(result);

        Filter filter = new Filter(arrayList);
        assertThat(filter.getDifferentElements()).isEqualTo(resultList);
    }

    @Test
    public void should_divide_array_and_return_number(){
        Integer[] array = new Integer[]{1,1,1,1,2,3,1,3,4,2,3,1,3,4,2};
        List<Integer> arrayList = Arrays.asList(array);

        Filter filter = new Filter(arrayList);

        Map result = new HashMap<>();
        result.put(1,6);
        result.put(2,3);
        result.put(3,4);
        result.put(4,2);

        assertThat(filter.getMapOfArrayList()).isEqualTo(result);
    }

    @Test
    public void should_return_divided_array(){
        Integer[] array = new Integer[]{1,1,1,1,2,3,1,3,4,2,3,1,3,4,2};
        List<Integer> arrayList = Arrays.asList(array);

        Filter filter = new Filter(arrayList);

        assertThat(filter.getDividedArray().size()).isEqualTo(4);
        assertThat(filter.getDividedArray().get(0).size()).isEqualTo(6);
        assertThat(filter.getDividedArray().get(1).size()).isEqualTo(3);
        assertThat(filter.getDividedArray().get(2).size()).isEqualTo(4);
        assertThat(filter.getDividedArray().get(3).size()).isEqualTo(2);
    }

    @Test
    public void should_return_common_elements(){
        Integer[] array = new Integer[] {6,2,3,4,9};
        Integer[] array1 = new Integer[] {2,3,5,9,6};

        List<Integer> arrayList =  Arrays.asList(array);
        List<Integer> arrayList1 =  Arrays.asList(array1);

        Filter filter = new Filter(arrayList);

        Integer[] result = new Integer[] {6,2,3,9};
        List<Integer> resultList = Arrays.asList(result);

        assertThat(filter.getCommonElements(arrayList, arrayList1)).isEqualTo(resultList);
    }

    @Test
    public void should_return_uncommon_elements(){
        Integer[] array = new Integer[] {6,2,3,4,9};
        Integer[] array1 = new Integer[] {2,3,5,9,6};

        List<Integer> arrayList =  Arrays.asList(array);
        List<Integer> arrayList1 =  Arrays.asList(array1);

        Filter filter = new Filter(arrayList);

        Integer[] result = new Integer[] {4};
        List<Integer> resultList = Arrays.asList(result);

        assertThat(filter.getUncommonElements(arrayList, arrayList1)).isEqualTo(resultList);
    }
}