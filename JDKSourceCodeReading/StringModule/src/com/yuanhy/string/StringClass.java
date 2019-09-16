package com.yuanhy.string;

/**
 * author yuanhy
 *
 */
public class StringClass {

    public static void main(String[] args) {
        System.out.println("say hello");
        char[] b = new char[]{'a','b'};
        char a = (char)-3;
        System.out.println(a);
        System.out.println(String.copyValueOf(b));
    }
}
