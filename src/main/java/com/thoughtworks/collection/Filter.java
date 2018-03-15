package com.thoughtworks.collection;

import java.util.*;

public class Filter {

    List<Integer>  array;

    public Filter(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<array.size(); i++){
            if(array.get(i)%2 == 0){
                result.add(array.get(i));
            }
        }

        return result;
    }

    public List<Integer> filterMultipleOfThree() {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<array.size(); i++){
            if(array.get(i)%3 == 0){
                result.add(array.get(i));
            }
        }

        return result;
    }

    public List<Integer> getDifferentElements() {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<array.size(); i++){
            if(!result.contains(array.get(i))){
                result.add(array.get(i));
            }
        }

        return result;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<firstList.size(); i++){
            if(secondList.contains(firstList.get(i))){
                result.add(firstList.get(i));
            }
        }

        return result;
    }

}