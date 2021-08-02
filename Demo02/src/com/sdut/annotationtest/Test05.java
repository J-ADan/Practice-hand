package com.sdut.annotationtest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test05 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.sdut.annotationtest.User");

        System.out.println("****************************");
        //获取类的名字
        System.out.println(c1.getName()); //获取全类名
        System.out.println(c1.getSimpleName()); //获取类名

        System.out.println("****************************");
        //获得类的属性
        Field [] field = c1.getFields(); //只能找到public属性
        for (Field field1 : field) {
            System.out.println(field1);
        }

        field = c1.getDeclaredFields();//找到全部属性
        for (Field field1 : field) {
            System.out.println(field1);
        }

        System.out.println("****************************");
        //获得指定属性的值
        Field name  = c1.getDeclaredField("name");
        System.out.println(name);

        System.out.println("****************************");
        //获得类的方法
        Method[] method = c1.getMethods();//获得本类及父类的全部public方法
        for (Method method1 : method) {
            System.out.println(method1);
        }

        method = c1.getDeclaredMethods();//获得本类的全部方法
        for (Method method1 : method) {
            System.out.println(method1);
        }

        System.out.println("****************************");
        //获得指定方法
        Method getName = c1.getMethod("getName",null);
        Method setName = c1.getMethod("setName", String.class);

        System.out.println(getName);
        System.out.println(setName);

        System.out.println("****************************");
        //获得构造器
        Constructor [] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }

        System.out.println("****************************");
        //获得指定的构造器
        Constructor constructor = c1.getDeclaredConstructor(String.class,int.class);
        System.out.println("指定的" + constructor);
    }
}
