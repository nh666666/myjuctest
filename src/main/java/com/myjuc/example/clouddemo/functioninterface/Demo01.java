package com.myjuc.example.clouddemo.functioninterface;

import java.util.function.Function;

/**
 * @Author: niehan
 * @Description:
 * Function 函数型接口, 有一个输入参数，有一个输出
 * 只要是 函数型接口 可以 用 lambda表达式简化
 * @Date:Create：in 2020/11/26 10:08
 */
public class Demo01 {
    public static void main(String[] args) {

//         Function<String,String> function = new Function<String,String>() {
//         @Override
//         public String apply(String str) {
//             return str;
//             }
//         };

        Function<String,String> function =  (str)->{return str;};
        System.out.println(function.apply("karry wang"));
    }
}
