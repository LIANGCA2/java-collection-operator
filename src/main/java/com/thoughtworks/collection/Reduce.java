package com.thoughtworks.collection;

import java.util.List;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().reduce(Integer::max).get();
    }

    public double getMinimum() {
        return arrayList.stream().reduce(Integer::min).get();
    }

    public double getOrderedMedian() {

        int index = arrayList.size() / 2;
        if (index % 2 == 0) {
            return arrayList.stream().skip(index - 1).limit(2).mapToInt(num -> num).average().getAsDouble();
        } else {
            return arrayList.stream().skip(index).findFirst().get();
        }
    }

    //实现接口SingleLink，然后再此函数内使用
    public double getMedianInLinkList(SingleLink<Integer> singleLink) {

        int index = arrayList.size() / 2;

        if (arrayList.size() % 2 == 0) {
            return (singleLink.getNode(index) + singleLink.getNode(index + 1)) / 2.0;
        } else {
            return singleLink.getNode(index + 1);
        }
    }

    public int getFirstEven() {
        return arrayList.stream().filter(num -> num % 2 == 0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        int firstEvent = arrayList.stream().filter(num -> num % 2 == 0).findFirst().get();
        return arrayList.indexOf(firstEvent);
    }

    public boolean isEqual(List<Integer> objectList) {
        Boolean isEqual = false;
        if (objectList.size() == arrayList.size()) {
            isEqual = IntStream.range(0, arrayList.size())
                    .allMatch(index -> arrayList.get(index) == objectList.get(index));
        }
        return isEqual;
    }

    public int getLastOdd() {
        return arrayList.stream().filter(num -> num % 2 != 0).reduce((first, second) -> second).get();
    }

    public int getIndexOfLastOdd() {
        return arrayList.lastIndexOf(getLastOdd());
    }

    public double getAverage() {
        return arrayList.stream().mapToDouble(num -> num).average().getAsDouble();
    }
}
