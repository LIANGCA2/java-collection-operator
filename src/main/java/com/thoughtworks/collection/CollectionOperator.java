package com.thoughtworks.collection;

import java.util.*;

public class CollectionOperator {

    public List<Integer> getListByInterval(int left, int right) {

        List<Integer> result = new ArrayList<>();

        if(left < right){
            for(int i=left; i<= right; i++){
                result.add(i);
            }
        }else{
            for(int i=left; i>= right; i--){
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {

        List<Integer> result = new ArrayList<>();
        if (left < right){
            for (int i=left; i<=right; i++){
                if(i%2 == 0){
                    result.add(i);
                }
            }
        }else{
            for (int i=left; i>= right; i--){
                if(i%2 == 0){
                    result.add(i);
                }
            }
        }

        return result;
    }

    public List<Integer> popEvenElments(int[] array) {
        List<Integer> result = new ArrayList<>();

        for (int i=0; i<array.length; i++){
            if(array[i]%2 == 0){
                result.add(array[i]);
            }
        }

        return result;
    }

    public int popLastElment(int[] array) {
        int index = array.length-1;
        return array[index];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<firstArray.length; i++){
            for(int j=0; j<secondArray.length; j++){
                if(firstArray[i] == secondArray[j]){
                    result.add(firstArray[i]);
                }
            }
        }

        return result;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0; i<firstArray.length; i++){
            result.add(firstArray[i]);
        }

        for(int i=0; i<secondArray.length; i++){
            int num =0;
            for(int j=0; j<firstArray.length; j++){

                if(!secondArray[i].equals(firstArray[j])){
                    num++;
                }
            }

            if(num == firstArray.length){
                result.add(secondArray[i]);
            }
        }

        return result;
    }
}
