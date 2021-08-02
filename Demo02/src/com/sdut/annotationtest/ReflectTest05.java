package com.sdut.annotationtest;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//性能测试
public class ReflectTest05 {
    //普通的调用方法
    public static void test01(){
        User user = new User();

        long satrtTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            user.getName();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("普通方式调用" + (endTime - satrtTime) + "ms");
    }

    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<? extends User> c1 = user.getClass();
        Method getName = c1.getMethod("getName", null);

        long satrtTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("反射方式调用" + (endTime - satrtTime) + "ms");
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user = new User();
        Class<? extends User> c1 = user.getClass();
        Method getName = c1.getMethod("getName", null);

        getName.setAccessible(true);
        long satrtTime = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(user,null);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("关闭检测方式调用" + (endTime - satrtTime) + "ms");
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
    }
}
