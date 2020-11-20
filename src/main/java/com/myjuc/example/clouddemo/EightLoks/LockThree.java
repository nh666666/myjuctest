package com.myjuc.example.clouddemo.EightLoks;

import java.util.concurrent.TimeUnit;

/**
 * @Author: niehan
 * @Description:
 * 5、增加两个静态的同步方法，只有一个对象，先打印 发短信？打电话？发短信
 * 6、两个对象！增加两个静态的同步方法， 先打印 发短信？打电话？ 发短信，因为锁的是类模板
 * @Date:Create：in 2020/11/20 17:05
 */
public class LockThree {
    public static void main(String[] args) {
        // 两个对象的Class类模板只有一个，static，锁的是Class
        Phone3 phone1 = new Phone3();
        Phone3 phone2 = new Phone3();

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
class Phone3{

    // synchronized 锁的对象是方法的调用者！
    // static 静态方法
    // 类一加载就有了！锁的是Class
    public static synchronized void sendSms(){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public static synchronized void call(){
        System.out.println("打电话");
    }

}
