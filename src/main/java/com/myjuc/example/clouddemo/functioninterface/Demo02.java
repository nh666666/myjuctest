package com.myjuc.example.clouddemo.functioninterface;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @Author: niehan
 * @Description:
 * 断定型接口：有一个输入参数，返回值只能是 布尔值！
 * @Date:Create：in 2020/11/26 10:08
 */
public class Demo02 {
    public static void main(String[] args) {
        //判断字符串是否为空
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                return s.isEmpty();
//            }
//        };

        Predicate<String> predicate = (str)->{return str.isEmpty();};
        System.out.println(predicate.test("karry wang"));
    }
}
