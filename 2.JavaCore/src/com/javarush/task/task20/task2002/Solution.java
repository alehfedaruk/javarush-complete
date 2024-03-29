package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust
        // outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте
        // outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("F:\\Education\\File1.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here
            // - инициализируйте поле users для объекта javaRush тут
            for (int i = 0; i < 3; i++) {
                User user = new User();
                if (i == 0) {
                    user.setCountry(User.Country.UKRAINE);
                } else if (i == 1) {
                    user.setCountry(User.Country.RUSSIA);
                } else {
                    user.setCountry(User.Country.OTHER);
                }
                javaRush.users.add(user);
            }
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object
            // - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
