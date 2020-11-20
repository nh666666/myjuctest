package com.myjuc.example.clouddemo.synchronizedtest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2020/11/20 16:15
 */
public class Test2 {
    public static void main(String[] args) {

        Ticket2 ticket = new Ticket2();

        new Thread(()->{
            for (int i=1;i<40;i++){
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i=1;i<40;i++){
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i=1;i<40;i++){
                ticket.sale();
            }
        },"C").start();

    }
}

/**
 * Lock三部曲
 * 1、new ReentrantLock();
 * 2、lock.lock();//加锁
 * 3、finally=> lock.unlock();//解锁
 */
class Ticket2 {
    private int number = 30;
    Lock lock = new ReentrantLock();

    public synchronized void sale(){
        lock.lock();

        try {
            if(number > 0) {
                System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票，剩余："+number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
