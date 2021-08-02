package com.sdut.annotationtest;

import javax.sound.midi.Soundbank;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest04 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> c1 = Class.forName("com.sdut.annotationtest.User");

        //通过反射回来的c1构造一个对象
        //Object o = c1.newInstance();
        //因为我们确定这个对象是User的对象所以我们可以强转
        //这个方法实质上时调用了无参的构造方法
        User user1 = (User) c1.newInstance();
        System.out.println(user1);

        //通过构造器创建对象
        Constructor<?> constructor = c1.getDeclaredConstructor(String.class, int.class);
        User user2 = (User)constructor.newInstance("姜富超", 18);
        System.out.println(user2);
        System.out.println("******************");

        //通过反射调用普通方法
        User user3 = (User) c1.newInstance();
        Method setName = c1.getMethod("setName", String.class);

        //invoke激活的意思(对象,"方法的值")
        setName.invoke(user3,"姜富超");
        System.out.println(user3.getName());

        System.out.println("******************");
        //通过反射操作属性
        User user4 = (User) c1.newInstance();
        Field name = c1.getDeclaredField("name");

        //因为name属性为私有的属性，所以需要关闭安全检测
        name.setAccessible(true);
        name.set(user4,"姜富超");
        System.out.println(user4.getName());

    }
}
