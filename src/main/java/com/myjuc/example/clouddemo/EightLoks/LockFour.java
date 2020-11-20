package com.myjuc.example.clouddemo.EightLoks;

import java.util.concurrent.TimeUnit;

/**
 * @Author: niehan
 * @Description:
 * * 1、1个静态的同步方法，1个普通的同步方法 ，一个对象，先打印 发短信？打电话？ 打电话
 * * 2、1个静态的同步方法，1个普通的同步方法 ，两个对象，先打印 发短信？打电话？ 打电话
 * @Date:Create：in 2020/11/20 17:17
 */
public class LockFour {
    public static void main(String[] args) {

        // 两个对象的Class类模板只有一个，static，锁的是Class
        Phone4 phone1 = new Phone4();
        Phone4 phone2 = new Phone4();

        //锁的存在
        new Thread(()->{
            phone1.sendSms();
        },"A").start();

        //捕获
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone2.call();
        },"B").start();

    }
}
class Phone4{

    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    // 普通的同步方法 锁的调用者
    public synchronized void call(){
        System.out.println("打电话");
    }


}

