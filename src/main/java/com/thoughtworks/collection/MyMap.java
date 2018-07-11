package com.thoughtworks.collection;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MyMap {

    private List<Integer> array;

    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {

        return array.stream().map(num -> num * 3).collect(Collectors.toList());
    }

    public List<String> lettersmapLetter() {
        return array.stream().map(num -> letterList.get(num - 1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {

        return array.stream().map(num -> {
            num = num - 1;
            int letterSize = letterList.size();

            String resultStr = "";
            if (num >= letterSize) {
                int baseLocateNum = num % letterSize;
                int firstLocateNum = num / (letterSize);
                resultStr = letterList.get(firstLocateNum - 1) + letterList.get(baseLocateNum);
            } else {
                resultStr = letterList.get(num);
            }
            return resultStr;

        }).collect(Collectors.toList());
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
