package com.sdut.annotationtest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class AnnotationTest02 {

    //设置默认值的注解元素可以不写
    @Annotation1(age = 18)
    @Annotation2("姜富超")
    public void test(){

    }

}

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation1{
    //可以设置默认值
    String name() default "姜富超";
    int id() default 001;
    int age();
    String[] school() default {"sdut","st"};
}
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface Annotation2{
    //默认为value时，可以只写参数
    String value();
}