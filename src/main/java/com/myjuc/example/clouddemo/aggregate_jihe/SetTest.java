package com.myjuc.example.clouddemo.aggregate_jihe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Author: niehan
 * @Description:
 * java.util.ConcurrentModificationException 并发修改异常！
 * Set<String> set = Collections.synchronizedSet(new HashSet<>());
 * @Date:Create：in 2020/11/20 17:29
 */
//java.util.ConcurrentModificationException
public class SetTest {
    public static void main(String[] args) {

        // Set<String> set = new HashSet<>();
        //Set<String> set = Collections.synchronizedSet(new HashSet<>());

        Set<String> set = new CopyOnWriteArraySet<>();
        for(int i=0;i<30;i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }

        Collections.synchronizedList(new ArrayList<>()).add(0);

    }
}
