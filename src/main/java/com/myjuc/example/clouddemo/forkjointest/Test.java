package com.myjuc.example.clouddemo.forkjointest;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2020/11/26 14:31
 */
public class Test {
    public static void main(String[] args) {
//        test1();//6901

//        try {
//            test2();//4750
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        test3();//342

    }
    public static void test1(){
        Long sum = 0L;
        Long start = System.currentTimeMillis();
        for(Long i=0l;i<10_0000_0000;i++) {
            sum +=i;
        }
        Long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }

    public static void test2() throws Exception{
        Long start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L,10_0000_0000L);
        ForkJoinTask<Long> submit = forkJoinPool.submit(task);
        Long sum = submit.get();
        Long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }

    public static void test3(){
        Long start = System.currentTimeMillis();
        //stream并行流
        long sum = LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0,Long::sum);
        Long end = System.currentTimeMillis();
        System.out.println("sum="+sum+" 时间："+(end-start));
    }

}
