package com.thoughtworks.collection;

import java.util.*;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {

        List<Integer> result = new ArrayList<>();

        int randomNumber = random.nextInt(3);
        while(number - randomNumber >=0){
            number = number - randomNumber;
            result.add(number);
        }

        return  result;
    }
}
