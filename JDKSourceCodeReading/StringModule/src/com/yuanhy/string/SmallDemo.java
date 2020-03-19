package com.yuanhy.string;

import java.io.InputStream;
import java.util.stream.IntStream;

public class SmallDemo {

    public static void main(String[] args) {
        testEvenNumber();
    }

    public static void testEvenNumber(){
        long num = IntStream.rangeClosed(1,100)
                .filter(a->a%2==0)
                .sum();
        System.out.println(num);
    }
}
