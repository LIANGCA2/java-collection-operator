package com.thoughtworks.collection;

import java.util.*;
import java.util.stream.IntStream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {

        List<Integer> result = new ArrayList<>();
        int randomNumber = random.nextInt(3);

        IntStream.range(1, number / randomNumber + 1)
                .reduce(number, (reducedNum, index) -> {
                    int readucedValue = reducedNum - index;
                    result.add(readucedValue);
                    return randomNumber;
                });
        return result;
//
//        while(number - randomNumber >=0){
//            number = number - randomNumber;
//            result.add(number);
//        }
//
//        return  result;
    }
}
