package com.sdut.annotationtest;

import javax.xml.ws.soap.Addressing;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

//利用反射实现算术运算
public class ReflectTest08 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String str = scanner.nextLine();

        Class<?> aClass = Class.forName("com.sdut.annotationtest.Calculation");
        Object o = aClass.newInstance();


        if (str.contains("+")) {
            String[] stra = str.split("\\+");
            Method add = aClass.getMethod("add", int.class, int.class);
            System.out.println(add.invoke(o, Integer.parseInt(stra[0]), Integer.parseInt(stra[1])));
        } else if (str.contains("-")) {
            String[] stra = str.split("\\-");
            Method subtract = aClass.getMethod("subtract", int.class, int.class);
            System.out.println(subtract.invoke(o, Integer.parseInt(stra[0]), Integer.parseInt(stra[1])));
        } else if (str.contains("*")) {
            String[] stra = str.split("\\*");
            Method multiply = aClass.getMethod("multiply", int.class, int.class);
            System.out.println(multiply.invoke(o, Integer.parseInt(stra[0]), Integer.parseInt(stra[1])));
        } else if (str.contains("/")) {
            String[] stra = str.split("\\/");
            Method divice = aClass.getMethod("divice", int.class, int.class);
            System.out.println(divice.invoke(o, Integer.parseInt(stra[0]), Integer.parseInt(stra[1])));
        } else {
            System.out.println("输入字符串无运算符");
        }


    }
}

class Calculation {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divice(int a, int b) {
        return a / b;
    }
}
