package com.thoughtworks.collection;

import java.util.*;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<array.length; i++){
            Integer[] everyArray = array[i];

            for(int j=0; j<everyArray.length; j++){
                result.add(everyArray[j]);
            }
        }
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        Flaten flaten = new Flaten(array);
        List<Integer> dimesionalArray = flaten.transformToOneDimesional();

        Filter filter = new Filter(dimesionalArray);
        return filter.getDifferentElements();
    }
}
