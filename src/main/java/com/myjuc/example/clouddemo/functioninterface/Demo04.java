package com.myjuc.example.clouddemo.functioninterface;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author: niehan
 * @Description:
 * Consumer 消费型接口: 只有输入，没有返回值
 * @Date:Create：in 2020/11/26 10:08
 */
public class Demo04 {
    public static void main(String[] args) {
//        Supplier supplier = new Supplier() {
//            @Override
//            public Object get() {
//                System.out.println("get()");
//                return 1024;
//            }
//        };
        Supplier supplier = ()->{
            System.out.println("get()");
            return 1024;
        };
        System.out.println(supplier.get());
    }
}
