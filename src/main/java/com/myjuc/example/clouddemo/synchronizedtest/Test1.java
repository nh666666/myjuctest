package com.myjuc.example.clouddemo.synchronizedtest;

/**
 * @Author: niehan
 * @Description:
 * @Date:Create：in 2020/11/20 16:00
 */
// 基本的卖票例子
public class Test1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(()->{
            for (int i=1;i<50;i++){
                ticket.sale();
            }
        },"A").start();

        new Thread(()->{
            for (int i=1;i<50;i++){
                ticket.sale();
            }
        },"B").start();

        new Thread(()->{
            for (int i=1;i<50;i++){
                ticket.sale();
            }
        },"C").start();

        new Thread(()->{
            for (int i=1;i<50;i++){
                ticket.sale();
            }
        },"D").start();

    }
}

class Ticket{
    private int number = 30;

    public synchronized void sale(){
        if(number > 0) {
            System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票，剩余："+number);
        }
    }
}