package com.yuanhy.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class FileReadClass {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("D:/data/yuanhy-190916-jdkCodeReading/in.txt");
            byte[] bytes = new byte[1024];

            int size = inputStream.read(bytes);
            System.out.println("size:"+size);
            System.out.println("byteLength:"+bytes.length);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
