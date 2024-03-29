package com.javarush.task.task33.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/
public class Solution {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        File file = new File(fileName);
        ObjectMapper mapper = new ObjectMapper();
        T readValue = mapper.readValue(file, clazz);
        return readValue;
    }

    public static void main(String[] args) {

    }
}
