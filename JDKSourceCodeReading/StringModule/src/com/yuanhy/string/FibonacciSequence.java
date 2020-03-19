package com.yuanhy.string;

public class FibonacciSequence {
    public static int getNData(int n){
        int i = 1;
        int j = 1;
        int sum=0;
        if(n<3){
           throw new IllegalArgumentException("n不能小于3");
        }

        for(int a = 0;a<n-2;a++){
            sum = i+j;
            i=j;
            j=sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(""+getNData(6));
    }
}
