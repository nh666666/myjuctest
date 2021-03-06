package com.myjuc.example.clouddemo.streamtest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: niehan
 * @Description:
 * 题目要求：一分钟内完成此题，只能用一行代码实现！
 *  现在有5个用户！筛选：
 *  1、ID 必须是偶数
 *  2、年龄必须大于23岁
 *  3、用户名转为大写字母
 *  4、用户名字母倒着排序
 *  5、只输出一个用户！
 * @Date:Create：in 2020/11/26 10:47
 */
public class Test {
    public static void main(String[] args) {
        User u1 = new User(1,"k",21);
        User u2 = new User(2,"y",22);
        User u3 = new User(3,"x",23);
        User u4 = new User(4,"m",24);
        User u5 = new User(5,"d",25);
        List<User> list = Arrays.asList(u1,u2,u3,u4,u5);
        list.stream().filter(u->{return u.getId()%2==0;})
                .filter(u->{return u.getAge()>23;})
                .map(u->{ return u.getName().toUpperCase();})
                .sorted((uu1,uu2)->{return uu2.compareTo(uu1);})
                .limit(1)
                .forEach(System.out::println);
    }
}
