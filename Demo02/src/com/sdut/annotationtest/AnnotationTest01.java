package com.sdut.annotationtest;

import java.lang.annotation.*;
//自定义注解
@MyAnnotation
public class AnnotationTest01 {
    @MyAnnotation
    public void test() {

    }
}


//表示注解可以使用的范围，即可以使用在类和方法
@Target(value = {ElementType.TYPE, ElementType.METHOD})

//表示注解存在的级别，即在什么地方可以存在
@Retention(RetentionPolicy.RUNTIME)

//表示注解可以存在与于javadoc中
@Documented

//表示注解可以被子类继承
@Inherited
@interface MyAnnotation {

}