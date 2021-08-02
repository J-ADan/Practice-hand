package com.sdut.annotationtest;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;

public class ReflectTest07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> aClass = Class.forName("com.sdut.annotationtest.Student01");

        //通过反射获得注解
        Annotation[] annotations = aClass.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        System.out.println("********************");

        //获取注解的值
        classAnnotation annotation = aClass.getAnnotation(classAnnotation.class);
        String value = annotation.value();
        System.out.println(value);

        //获得属性的注解
        Field name = aClass.getDeclaredField("name");
        fieldAnnotation annotation1 = name.getAnnotation(fieldAnnotation.class);
        System.out.println(annotation1.length());
        System.out.println(annotation1.type());
        System.out.println(annotation1.name());
    }
}

@classAnnotation("db_student")
class Student01{
    @fieldAnnotation(type = "int",name = "db_id",length = "10")
    private int id;
    @fieldAnnotation(type = "varchar",name = "db_name",length = "3")
    private String name;
    @fieldAnnotation(type = "int",name = "db_age",length = "3")
    private int age;

    public Student01() {
    }

    public Student01(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

//类的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface classAnnotation{
    String value();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface fieldAnnotation{
    String type();
    String name();
    String length();
}