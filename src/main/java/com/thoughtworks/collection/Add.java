package com.thoughtworks.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {

    private List<Integer> returnEvenList(List<Integer> arrayList) {
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

        List<Integer> resultList = this.returnEvenList(arrayList);

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

        List<Integer> result = this.returnEvenList(arrayList);
        return result.stream().mapToInt(num -> num).sum() / result.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {

        List<Integer> result = this.returnEvenList(arrayList);

        for (Integer aResult : result) {
            if (aResult.equals(specialElment)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List evenList = this.returnEvenList(arrayList);
        List result = new ArrayList<>();

        result.add(evenList.get(0));
        for (Object anEvenList : evenList) {
            if (!result.contains(anEvenList)) {
                result.add(anEvenList);
            }
        }

        return result;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();

        for (Integer anArrayList : arrayList) {
            if (anArrayList % 2 != 0) {
                oddList.add(anArrayList);
            }
        }

        for (Integer anArrayList : arrayList) {
            if (anArrayList % 2 == 0) {
                evenList.add(anArrayList);
            }
        }

        for (int i = 0; i < evenList.size(); i++) {
            for (int j = 0; j < evenList.size(); j++) {
                if (evenList.get(i) < evenList.get(j)) {
                    int temp = evenList.get(i);
                    evenList.set(i, evenList.get(j));
                    evenList.set(j, temp);
                }
            }
        }

        for (int i = 0; i < oddList.size(); i++) {
            for (int j = 0; j < oddList.size(); j++) {
                if (oddList.get(i) > oddList.get(j)) {
                    int temp = oddList.get(i);
                    oddList.set(i, oddList.get(j));
                    oddList.set(j, temp);
                }
            }
        }

        List<Integer> result = evenList;
        for (Integer anOddList : oddList) {
            result.add(anOddList);
        }

        return result;
    }
}
