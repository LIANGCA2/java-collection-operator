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

}