package com.thoughtworks.collection;

import java.util.*;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {

        return Arrays.stream(this.array).flatMap(Arrays::stream).collect(Collectors.toList());
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        Flaten flaten = new Flaten(array);
        List<Integer> dimesionalArray = flaten.transformToOneDimesional();

        Filter filter = new Filter(dimesionalArray);
        return filter.getDifferentElements();
    }
}
