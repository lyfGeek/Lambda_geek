package com.geek;

/**
 * @author geek
 */
public class LambdaApp {

    /*
        基本语法。

        - 声明：Lambda 表达式绑定的接口类型。
        - 参数：包含在一对圆括号中，和绑定的接口中的抽象方法的参数个数及顺序一致。
        - 操作符：->
        - 执行代码块：包含在一堆大括号中，出现在操作符号的右侧。

        [接口声明] = (参数) -> {执行代码块};
     */

    public static void main(String[] args) {
        Ilambda1 i1 = () -> {
            System.out.println("hello");
            System.out.println("hello1");
        };
        i1.test();

        Ilambda1 i12 = () -> System.out.println("hello");
        i12.test();

        Ilambda2 i2 = (String s, int a) -> System.out.println(s + " says: my age is " + a);
        i2.test("geek", 3);

        // 可以不写参数类型。
        Ilambda2 i21 = (s, a) -> System.out.println(s + " says: my age is " + a);
        i21.test("geek", 3);

        Ilambda3 i3 = (x, y) -> x + y;
        System.out.println(i3.test(1, 2));
    }

    // 没有参数没有返回值的 Lambda 表达式绑定的接口。
    interface Ilambda1 {
        void test();
    }

    // 有参数没有返回值的 Lambda 表达式绑定的接口。
    interface Ilambda2 {
        void test(String name, int age);
    }

    // 有参数和返回值的 Lambda 表达式绑定的接口。
    interface Ilambda3 {
        int test(int x, int y);
    }

}
