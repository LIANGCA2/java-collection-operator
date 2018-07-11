package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CollectionOperator {

    private List<Integer> getListOfReducedOfTwoNums(int leftBorder, int rightBorder, Function<Integer, Boolean> isContinue) {
        return leftBorder < rightBorder
                ? getListOfReducedBetweenBigAdnsmallNum(leftBorder, rightBorder, isContinue)
                : getListOfReducedBetweenBigAdnsmallNum(rightBorder, leftBorder, isContinue);
    }

    private List<Integer> getListOfReducedBetweenBigAdnsmallNum(int smallNum, int bigNum, Function<Integer, Boolean> isContinue) {
        return IntStream.range(smallNum, bigNum + 1)
                .filter(isContinue::apply)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Integer> getListByInterval(int left, int right) {
        List<Integer> reducedOfTwoNumsList = this.getListOfReducedOfTwoNums(left, right, num -> true);
        return left < right
                ? reducedOfTwoNumsList
                : reducedOfTwoNumsList.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> reducedOfTwoNumsList = this.getListOfReducedOfTwoNums(left, right, num -> num % 2 == 0);
        return left < right
                ? reducedOfTwoNumsList
                : reducedOfTwoNumsList.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed().filter(num -> num % 2 == 0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        int index = array.length - 1;
        return array[index];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {

        return Arrays.stream(firstArray).boxed().filter(numInFirst ->
                Arrays.stream(secondArray).boxed().anyMatch(numInSecond -> numInSecond.equals(numInFirst)))
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> unCommonList = Arrays.stream(secondArray).filter(num ->
                !Arrays.stream(firstArray).anyMatch(numInFirst -> numInFirst.equals(num))
        ).collect(Collectors.toList());

        List<Integer> results = Arrays.stream(firstArray).collect(Collectors.toList());
        results.addAll(unCommonList);
        return results;

    }
}
