package com.geek;

/**
 * @author geek
 */
public class App3 {

    private String s1 = "全局变量";

    public static void main(String[] args) {
        App3 app3 = new App3();
//        app3.testInnerClass();
        app3.testLambda();
    }

    // 匿名内部类中对变量的访问。
    private void testInnerClass() {
        String s2 = "局部变量";

        new Thread(new Runnable() {
            String s3 = "内部变量";

            @Override
            public void run() {
                // 访问全局变量。
//                System.out.println(this.s1);// this 关键字 ~ 表示当前内部类型的对象。
                System.out.println(s1);

                // 访问局部变量。
                System.out.println(s2);
//                s2 = "hello";// 不能对局部变量进行修改（final）。

                System.out.println(s3);
                System.out.println(this.s3);
            }
        }).run();
    }

    // Lambda 表达式变量捕获。
    private void testLambda() {
        String s2 = "局部变量 Lambda";

        new Thread(() -> {
            String s3 = "内部变量 Lambda";

            // 访问全局变量。
            System.out.println(this.s1);// this 关键字 ~ 表示的就是所属方法所在的类型的对象。
            // 访问局部变量。
            System.out.println(s2);
//                s2 = "hello";// 不能对局部变量进行修改（final）。

            System.out.println(s3);
            s3 = "Lambda 内部变量直接修改。";
        }).start();
    }

}
