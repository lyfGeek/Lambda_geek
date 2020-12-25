package com.geek;

import com.geek.impl.MessageFormatImpl;
import com.geek.impl.UserCredentialImpl;

/**
 * Hello World!
 *
 * @author geek
 */
public class App1 {

    public static void main(String[] args) {
        //        System.out.println( "Hello World!" );
        IUserCredential userCredential = new UserCredentialImpl();
        System.out.println(userCredential.verifyUser("admin"));
        // 系统管理员

        /**
         * 需求改动：
         *      所有的用户验证。可以同时获取用户的验证信息[是否验证成功 | 成功 ~ 返回用户 | null]
         *
         * jdk 1.8 以前只能修改实现类。
         */
        System.out.println(IUserCredential.getCredential("admin"));
        // admin ~ 系统管理员

        String msg = "hello world";
        if (IMessageFormat.verifyMessage(msg)) {
            IMessageFormat format = new MessageFormatImpl();
            System.out.println(format.format(msg, "json"));
        }

        // 匿名内部类实现接口的抽象方法。
        IUserCredential ic2 = new IUserCredential() {
            @Override
            public String verifyUser(String username) {
                return "admin".equals(username) ? "管理员" : "会员";
            }
        };

        System.out.println(ic2.verifyUser("manager"));
        System.out.println(ic2.verifyUser("admin"));

        // Lambda 表达式。针对函数式接口的简单实现。
        IUserCredential ic3 = (String username) -> "admin".equals(username) ? "lbd 管理员" : "lbd 会员";

        System.out.println(ic3.verifyUser("manager"));
        System.out.println(ic3.verifyUser("admin"));
    }

}
