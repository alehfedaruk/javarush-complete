package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream inputStream = null;
        int max = 0;
        inputStream = new FileInputStream(path);
        while (inputStream.available() > 0) {
            int data = inputStream.read();
            if (data > max) {
                max = data;
            }
        }
        inputStream.close();
        System.out.println(max);
    }
}
