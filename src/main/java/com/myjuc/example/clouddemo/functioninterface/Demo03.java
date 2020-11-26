package com.myjuc.example.clouddemo.functioninterface;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @Author: niehan
 * @Description:
 * Consumer 消费型接口: 只有输入，没有返回值
 * @Date:Create：in 2020/11/26 10:08
 */
public class Demo03 {
    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String s) {
//                System.out.println(s);
//            }
//        };

        Consumer<String> consumer = (str)->{
            System.out.println(str);
        };
        consumer.accept("karry wang");
    }
}
