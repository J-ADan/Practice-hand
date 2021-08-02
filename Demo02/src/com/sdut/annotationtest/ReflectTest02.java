package com.sdut.annotationtest;

import java.util.Scanner;

public class ReflectTest02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是" + person.name);

        //通过对象获得
        Class a1 = person.getClass();
        System.out.println(a1.hashCode());

        //通过forName全包名获得
        Class a2 = Class.forName("com.sdut.annotationtest.Student");
        System.out.println(a2.hashCode());

        //通过类名获得
        Class a3 = Student.class;
        System.out.println(a3.hashCode());

        //基本内置类型的包装类可以通过Type获得
        Class a4 = Integer.TYPE;
        System.out.println(a4);

        //获得父类类型
        Class a5 = a1.getSuperclass();
        System.out.println(a5);
    }
}

class Person{
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }
}

class Teacher extends Person{
    public Teacher() {
        this.name = "老师";
    }
}

class Student extends Person{
    public Student() {
        this.name = "学生";
    }
}