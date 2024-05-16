package com.chl.search.test;

import org.apache.poi.ss.formula.functions.T;

public class MyReflectTest {

    static Sun<T> sun;

    public static void main(String[] args) {
        Sun<Integer> sun1 = getSun(Integer.class);
    }

    public static <T> Sun<T> getSun(Class<T> tClass) {
        return (Sun<T>) sun;
    }

}

interface Sun<T> {
}

class StringFather implements Sun<String> {

}

class IntegerFather implements Sun<Integer> {

}

class Register {


}

