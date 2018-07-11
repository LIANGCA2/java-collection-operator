package com.thoughtworks.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {

    private List<Integer> getEvenList(List<Integer> arrayList) {
        return arrayList.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
    }

    public int getSumOfEvens(int leftBorder, int rightBorder) {
        Function<Integer, Boolean> isContinue = num -> num % 2 == 0;
        return getSumOfReducedOfTwoNums(leftBorder, rightBorder, isContinue);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {

        Function<Integer, Boolean> isContinue = num -> num % 2 != 0;
        return getSumOfReducedOfTwoNums(leftBorder, rightBorder, isContinue);
    }

    private int getSumOfReducedOfTwoNums(int leftBorder, int rightBorder, Function<Integer, Boolean> isContinue) {
        return leftBorder < rightBorder
                ? getEvenSumOfReducedOfTwoNums(leftBorder, rightBorder, isContinue)
                : getEvenSumOfReducedOfTwoNums(rightBorder, leftBorder, isContinue);
    }

    private int getEvenSumOfReducedOfTwoNums(int smallNum, int bigNum, Function<Integer, Boolean> isContinue) {
        return IntStream.range(smallNum, bigNum + 1)
                .filter(isContinue::apply)
                .reduce((num1, num2) -> num1 + num2)
                .getAsInt();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(num -> num * 3 + 2).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {

        return arrayList.stream()
                .map(num -> num % 2 != 0 ? num * 3 + 2 : num)
                .collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(num -> num % 2 != 0).mapToInt(num -> num * 3 + 5).sum();

    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        arrayList.stream().reduce((num1, num2) -> {
                    Integer num = (num1 + num2) * 3;
                    result.add(num);
                    return num2;
                }
        );
        return result;
    }

    public double getMedianOfEven(List<Integer> arrayList) {

        List<Integer> resultList = this.getEvenList(arrayList);

        int median;
        int size = resultList.size();
        if (size % 2 == 0) {
            median = (resultList.get(size / 2) + resultList.get(size / 2 - 1)) / 2;
        } else {
            median = resultList.get(size / 2);
        }
        return median;
    }

    public double getAverageOfEven(List<Integer> arrayList) {

        List<Integer> eventList = this.getEvenList(arrayList);
        return eventList.stream().mapToInt(num -> num).sum() / eventList.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {

        List<Integer> eventList = this.getEvenList(arrayList);
        return eventList.stream().anyMatch(num -> num.equals(specialElment));
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();

        this.getEvenList(arrayList).forEach(num -> {
            if (arrayList.stream().filter(filterNum -> filterNum.equals(num)).count() == 1) {
                result.add(num);
            }
        });

        return result;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {

        List<Integer> evenList = this.getEvenList(arrayList).stream()
                .sorted()
                .collect(Collectors.toList());
        List<Integer> oddList = arrayList.stream()
                .filter(num -> num % 2 != 0)
                .sorted((num1, num2) -> num2 - num1)
                .collect(Collectors.toList());

        evenList.addAll(oddList);
        return evenList;
    }
}
