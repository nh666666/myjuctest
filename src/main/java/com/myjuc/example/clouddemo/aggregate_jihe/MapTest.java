package com.myjuc.example.clouddemo.aggregate_jihe;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: niehan
 * @Description:
 * java.util.ConcurrentModificationException 并发修改异常！
 * @Date:Create：in 2020/11/20 17:29
 */
//java.util.ConcurrentModificationException
public class MapTest {
    public static void main(String[] args) {
        // map 是这样用的吗？ 不是，工作中不用 HashMap
        // 默认等价于什么？ new HashMap<>(16,0.75);
        // Map<String, String> map = new HashMap<>();
        // 唯一的一个家庭作业：研究ConcurrentHashMap的原理
        Map<String, String> map =  new ConcurrentHashMap<>();
        for(int i=0;i<10;i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

        Collections.synchronizedList(new ArrayList<>()).add(0);

    }
}
