package com.sdut.annotationtest;


import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class ReflectTest06 {
    public void test01(Map<String,User> map, List<User> list){
        System.out.println("test01");
    }

    public Map<String,User> test02(){
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = ReflectTest06.class.getMethod("test01", Map.class, List.class);

        //获取泛型类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();

        //打印泛型类型
        for (Type genericParameterType : genericParameterTypes) {
            //这里打印出来的只是获取到的集合
            System.out.println(genericParameterType);
            //判断是否是一个参数化类型，如果是就获得他的泛型
            if (genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments =
                        ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("它的泛型为"+ actualTypeArgument);
                }
            }
        }

        method = ReflectTest06.class.getMethod("test02",null);

        //获取返回值泛型
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments =
                    ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("它的泛型为"+ actualTypeArgument);
            }
        }
    }
}
