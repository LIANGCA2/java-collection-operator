package com.thoughtworks.collection;

import java.util.*;
import java.util.stream.Collectors;

public class MyMap {

    private List<Integer> array;

    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List<Integer> tripleList = new ArrayList<>();

        for (int i = 0; i < array.size(); i++) {
            tripleList.add(array.get(i) * 3);
        }
        return tripleList;
    }

    public List<String> mapLetter() {

        return array.stream().map(num -> letterList.get(num - 1)).collect(Collectors.toList());
    }

    public List<String> mapLetters() {

        List<String> result = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {

            int currentElement = array.get(i);

            if (currentElement <= 26) {
                result.add(letterList.get(currentElement - 1));
            } else {

                int firstIndex = currentElement / 26;
                int secondIndex = currentElement % 26;

                if (secondIndex == 0) {
                    secondIndex = 26;
                    firstIndex--;
                }

                String mapLetter = letterList.get(firstIndex - 1) + letterList.get(secondIndex - 1);
                result.add(mapLetter);
            }
        }

        return result;
    }

    public List<Integer> sortFromBig() {

        for (int i = 0; i < array.size(); i++) {
            for (int j = i + 1; j < array.size(); j++) {

                if (array.get(i) < array.get(j)) {
                    Integer temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                }
            }
        }

        return array;
    }

    public List<Integer> sortFromSmall() {
        for (int i = 0; i < array.size(); i++) {
            for (int j = i + 1; j < array.size(); j++) {

                if (array.get(i) > array.get(j)) {
                    Integer temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                }
            }
        }

        return array;
    }
}
