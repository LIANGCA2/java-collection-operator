package com.thoughtworks.collection;

import java.util.*;

public class Add {

    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    private List<Integer> returnEvenIndex(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i++) {
            if (i % 2 == 0) {
                result.add(arrayList.get(i));
            }
        }
        return result;
    }

    public int getSumOfEvens(int leftBorder, int rightBorder) {
        int sum = 0;
        if (leftBorder < rightBorder) {
            for (int i = leftBorder; i <= rightBorder; i++) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
        } else {
            for (int i = leftBorder; i >= rightBorder; i--) {
                if (i % 2 == 0) {
                    sum += i;
                }
            }
        }

        return sum;
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {

        int sum = 0;

        if (leftBorder < rightBorder) {
            for (int i = leftBorder; i <= rightBorder; i++) {
                if (i % 2 != 0) {
                    sum += i;
                }
            }
        } else {
            for (int i = leftBorder; i >= rightBorder; i--) {
                if (i % 2 != 0) {
                    sum += i;
                }
            }
        }

        return sum;
    }

    public String mapMedianToLetter(Integer left, Integer right) {
        int index;
        int number = left + right;

        if (number % 2 == 0) {
            index = number % 2;
        } else {
            index = number / 2;
        }

        if (index % 26 == 0) {
            return letterList.get(25);
        }
        return letterList.get(index % 26 - 1);
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        int sum = 0;
        for (Integer anArrayList : arrayList) {
            sum += (anArrayList * 3 + 2);
        }

        return sum;
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {

        List result = arrayList;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 != 0) {
                result.set(i, arrayList.get(i) * 3 + 2);
            }
        }

        return result;
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        int sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) % 2 != 0) {
                sum += (arrayList.get(i) * 3 + 5);
            }
        }

        return sum;
    }


    public List<Object> mapEvenToLetter(List<Integer> arrayList) {

        List<Object> result = new ArrayList<>();
        for (Integer anArrayList : arrayList) {
            if (anArrayList % 2 == 0) {

                int index = anArrayList;

                if (index % 26 == 0) {
                    result.add(letterList.get(25));
                } else {
                    result.add(letterList.get(index - 1));
                }
            } else {
                result.add(anArrayList);
            }
        }
        return result;
    }

    public String mapAverageToLetter(List<Integer> arrayList) {
        int sum = 0;
        for (Integer anArrayList : arrayList) {
            sum += anArrayList;
        }

        int average = sum / arrayList.size();

        if (average % 26 == 0) {
            return letterList.get(25);
        } else {
            return letterList.get(average - 1);
        }
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size() - 1; i++) {
            Integer resultElement = (arrayList.get(i) + arrayList.get(i + 1)) * 3;
            result.add(resultElement);
        }
        return result;
    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {

        List<Integer> resultList = this.returnEvenIndex(arrayList);

        int median;
        int size = resultList.size();
        if (size % 2 == 0) {
            median = (resultList.get(size / 2) + resultList.get(size / 2 - 1)) / 2;
        } else {
            median = resultList.get(size / 2);
        }

        return median;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {

        List<Integer> result = this.returnEvenIndex(arrayList);

        double sum = 0;
        for (Integer aResult : result) {
            sum += aResult;
        }

        return sum / result.size();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {

        List<Integer> result = this.returnEvenIndex(arrayList);

        for (Integer aResult : result) {
            if (aResult.equals(specialElment)) {
                return true;
            }
        }
        return false;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List evenList = this.returnEvenIndex(arrayList);
        List result = new ArrayList<>();

        result.add(evenList.get(0));
        for (Object anEvenList : evenList) {
            if (!result.contains(anEvenList)) {
                result.add(anEvenList);
            }
        }

        return result;
    }

    public Map<Integer, Integer> mapEvens(List<Integer> arrayList) {
        Map map = new HashMap<Integer, Integer>();

        for (Integer anArrayList : arrayList) {
            String string = "" + anArrayList;
            if (map.containsKey(string.length())) {
                map.put(string.length(), string.length() + 1);
            } else {
                map.put(string.length(), 1);
            }
        }

        return map;
    }

    public List<Integer> sortByTwoBigOneSmall(List<Integer> arrayList) {

        for (int i = 0; i < arrayList.size(); i++) {
            for (int j = i; j < arrayList.size(); j++) {
                if (arrayList.get(i) > arrayList.get(j)) {
                    Integer temp = arrayList.get(i);
                    arrayList.set(i, arrayList.get(j));
                    arrayList.set(j, temp);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arrayList.size(); i = i + 3) {
            if (i + 3 <= arrayList.size()) {

                result.add(arrayList.get(i + 1));
                result.add(arrayList.get(i + 2));
                result.add(arrayList.get(i));
            } else {
                for (int j = i; j < arrayList.size(); j++) {
                    result.add(arrayList.get(j));
                }
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
