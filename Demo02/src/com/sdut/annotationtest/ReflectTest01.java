package com.sdut.annotationtest;

import javax.print.attribute.standard.OrientationRequested;

public class ReflectTest01 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.sdut.annotationtest.User");

        System.out.println(aClass);

        //一个类在内存中只有一个Class对象
        //一个类被加载后，类的整个结构都会被封装在Class对象中
        Class aClass1 = Class.forName("com.sdut.annotationtest.User");
        Class aClass2 = Class.forName("com.sdut.annotationtest.User");
        Class aClass3 = Class.forName("com.sdut.annotationtest.User");
        System.out.println(aClass1.hashCode());
        System.out.println(aClass2.hashCode());
        System.out.println(aClass3.hashCode());
    }

}

class User{
    private String name;
    private int id;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public User() {
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}