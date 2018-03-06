package com.thoughtworks.collection;

import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getSum() {
        int sum = 0;

        for(int i=0; i<arrayList.size(); i++){
            sum += arrayList.get(i);
        }

        return sum;
    }

    public int getMaximum() {
        int maximum = arrayList.get(0);

        for(int i=1; i<arrayList.size(); i++){
            if(arrayList.get(i) > maximum){
                maximum = arrayList.get(i);
            }
        }

        return maximum;
    }

    public double getMinimum() {
        int mimimum = arrayList.get(0);

        for(int i=1; i<arrayList.size(); i++){
            if(arrayList.get(i) < mimimum){
                mimimum = arrayList.get(i);
            }
        }

        return mimimum;
    }

    public double getOrderedMedian() {
        double result;
        int index;

        if(arrayList.size()%2 != 0){
            index = arrayList.size()/2;
            result = arrayList.get(index);
        }else{
            index = arrayList.size()/2;
            result = ((double)(arrayList.get(index) + arrayList.get(index-1)))/2;
        }

        return result;
    }

    public double getUnorderedMedian() {

        List<Integer> orderList = arrayList;
        for(int i=0; i<orderList.size(); i++){
            for(int j=i; j<orderList.size(); j++){

                if(orderList.get(i) < orderList.get(j)){
                    int temp = orderList.get(i);
                    orderList.set(i,orderList.get(j));
                    orderList.set(j, temp);
                }
            }

        }

        Reduce reduce = new Reduce(orderList);
        return reduce.getOrderedMedian();
    }

    //实现接口SingleLink，然后再此函数内使用
    public double getMedianInLinkList(SingleLink<Integer> singleLink) {

        for(int i=0; i<arrayList.size(); i++){

            singleLink.addTailPointer(arrayList.get(i));
        }

        int index = arrayList.size()/2;

        if(arrayList.size()%2 == 0){
            return (singleLink.getNode(index) + singleLink.getNode(index+1))/2.0;
        }else{
            return singleLink.getNode(index+1);
        }
    }

    public int getFirstEven() {

        for(int i=0; i<arrayList.size(); i++){
            if(arrayList.get(i)%2 == 0){
                return arrayList.get(i);
            }
        }

        return -1;
    }

    public int getIndexOfFirstEven() {
        for(int i=0; i<arrayList.size(); i++){
            if(arrayList.get(i)%2 == 0){
                return i;
            }
        }

        return -1;
    }

    public boolean isEqual(List<Integer> objectList) {

        if(objectList.size() != arrayList.size()){
            return false;
        }else{
            for(int i=0; i<arrayList.size(); i++){

                if(arrayList.get(i) != objectList.get(i)){
                    return false;
                }
            }
        }

        return true;
    }

    public int getLastOdd() {

        for(int i=arrayList.size()-1; i>=0; i--){
            if(arrayList.get(i)%2 == 1){
                return arrayList.get(i);
            }
        }
        return -1;
    }

    public int getIndexOfLastOdd() {
        for(int i=arrayList.size()-1; i>=0; i--){
            if(arrayList.get(i)%2 == 1){
                return i;
            }
        }
        return -1;
    }

    public double getAverage() {
        Reduce reduce = new Reduce(arrayList);

        double sum = (double) reduce.getSum();
        return sum/arrayList.size();
    }
}
