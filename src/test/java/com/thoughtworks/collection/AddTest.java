package com.thoughtworks.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;


public class AddTest {

    @Test
    public void should_get_sum_of_evens(){
        int leftBorder = 1;
        int rightBorder = 10;

        Add add = new Add();
        assertThat(add.getSumOfEvens(leftBorder, rightBorder)).isEqualTo(30);
        assertThat(add.getSumOfEvens(rightBorder, leftBorder)).isEqualTo(30);
    }

    @Test
    public void should_get_sum_of_odds(){
        int leftBorder = 1;
        int rightBorder = 10;

        Add add = new Add();
        assertThat(add.getSumOfOdds(leftBorder, rightBorder)).isEqualTo(25);
        assertThat(add.getSumOfOdds(rightBorder, leftBorder)).isEqualTo(25);
    }

    @Test
    public void should_map_median_to_letter(){
        Integer left = 20;
        Integer right = 53;

        Add add = new Add();

        assertThat(add.mapMedianToLetter(left, right)).isEqualTo("j");
    }

    @Test
    public void should_get_triple_and_add_two(){
        Integer[] array = new Integer[]{1,5,7,11,35,67};
        List<Integer> arrayList = Arrays.asList(array);

        Add add = new Add();

        assertThat(add.getSumTripleAndAddTwo(arrayList)).isEqualTo(390);
    }

    @Test
    public void should_get_triple_of_odd_and_add_two(){
        Integer[] array = new Integer[]{1,5,7,12,11,35,54,67,70};
        List<Integer> arrayList = Arrays.asList(array);

        Integer[] result = new Integer[]{5,17,23,12,35,107,54,203,70};
        List<Integer> resultList = Arrays.asList(result);

        Add add = new Add();

        assertThat(add.getTripleOfOddAndAddTwo(arrayList)).isEqualTo(resultList);
    }

    @Test
    public void should_get_sum_of_processed_odd(){
        Integer[] array = new Integer[]{1,5,7,12,11,35,54,67,70};
        List<Integer> arrayList = Arrays.asList(array);
        Add add = new Add();

        assertThat(add.getSumOfProcessedOdds(arrayList)).isEqualTo(408);
    }

    @Test
    public void should_map_even_to_letter(){
        Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> arrayList = Arrays.asList(array);

        Object[] result = new Object[]{1,"b",3,"d",5,"f",7,"h",9,"j"};
        List<Object> resultObject = Arrays.asList(result);

        Add add = new Add();
        assertThat(add.mapEvenToLetter(arrayList)).isEqualTo(resultObject);
    }

    @Test
    public void should_map_average_to_letter(){

        Integer[] array = new Integer[]{1,2,3,4,5,6,7,8,9,10};
        List<Integer> arrayList = Arrays.asList(array);

        Add add = new Add();

        assertThat(add.mapAverageToLetter(arrayList)).isEqualTo("e");
    }

    @Test
    public void should_process_elements(){
        Integer[] array = new Integer[]{1,3,5,7,9,11,13,15,17,19,21};
        List<Integer> arrayList = Arrays.asList(array);

        Add add = new Add();

        Integer[] result = new Integer[]{12,24,36,48,60,72,84,96,108,120};
        List<Integer> resultList = Arrays.asList(result);

        assertThat(add.getProcessedList(arrayList)).isEqualTo(resultList);
    }

    @Test
    public void should_return_median_of_even_index(){
        Integer[] array = new Integer[]{1,2,3,4,5};
        List<Integer> arrayList = Arrays.asList(array);

        Add add = new Add();
        assertThat(add.getMedianOfEvenIndex(arrayList)).isEqualTo((double) 3);
    }

    @Test
    public void should_return_average_of_even_index(){
        Integer[] array = new Integer[]{1,2,3,4,5};
        List<Integer> arrayList = Arrays.asList(array);

        Add add = new Add();
        assertThat(add.getAverageOfEvenIndex(arrayList)).isEqualTo((double) 3);
    }

    @Test
    public void should_return_whether_include_special_element(){
        Integer[] array = new Integer[] {1,2,3,4,5};
        List<Integer> arrayList = Arrays.asList(array);

        Add add = new Add();

        Integer existedElment = 3;
        assertThat(add.isIncludedInEvenIndex(arrayList, existedElment)).isEqualTo(true);

        Integer unexistedElment = 2;
        assertThat(add.isIncludedInEvenIndex(arrayList, unexistedElment)).isEqualTo(false);
    }

    @Test
    public void should_return_unrepeated_elements_from_evens(){
        Integer[] array = new Integer[] {1,2,3,4,1,5};
        List<Integer> arrayList = Arrays.asList(array);

        Integer[] result = new Integer[]{1,3};
        List<Integer> resultList = Arrays.asList(result);

        Add add = new Add();
        assertThat(add.getUnrepeatedFromEvenIndex(arrayList)).isEqualTo(resultList);
    }

    @Test
    public void should_divide_evens(){
        Add add = new Add();

        Integer[] array = new Integer[] {1,12,3,24,5,16,7,118,6};
        List<Integer> arrayList = Arrays.asList(array);

        assertThat(add.mapEvens(arrayList).get(1)).isEqualTo(2);
        assertThat(add.mapEvens(arrayList).get(2)).isEqualTo(3);
        assertThat(add.mapEvens(arrayList).get(3)).isEqualTo(1);
    }

    @Test
    public void should_sort_by_two_big_followed_one_small(){
        Add add = new Add();

        Integer[] firstArray = new Integer[] {1,2,3,4,5,6,7,8};
        List<Integer> firstArrayList = Arrays.asList(firstArray);

        Integer[] firstResult = new Integer[]{2,3,1,5,6,4,7,8};
        List<Integer> firstResultList = Arrays.asList(firstResult);

        assertThat(add.sortByTwoBigOneSmall(firstArrayList)).isEqualTo(firstResultList);


        Integer[] secondArray = new Integer[] {1,2,3,4,5,6,7,8,9};
        List<Integer> secondArrayList = Arrays.asList(secondArray);

        Integer[] secondResult = new Integer[]{2,3,1,5,6,4,8,9,7};
        List<Integer> secondResultList = Arrays.asList(secondResult);

        assertThat(add.sortByTwoBigOneSmall(secondArrayList)).isEqualTo(secondResultList);
    }

    @Test
    public void should_sort_by_even_and_odd(){
        Add add = new Add();

        Integer[] array = new Integer[] {1,2,3,4,5,6,7,8};
        List<Integer> arrayList = Arrays.asList(array);

        Integer[] result = new Integer[]{2,4,6,8,7,5,3,1};
        List<Integer> resultList = Arrays.asList(result);

        assertThat(add.sortByEvenAndOdd(arrayList)).isEqualTo(resultList);
    }
}
