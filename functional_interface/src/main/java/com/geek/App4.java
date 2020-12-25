package com.geek;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface MyInterface<T, R> {

    R strategy(T t, R r);

}

/**
 * @author geek
 */
public class App4 {

    private static void test(MyInterface<String, List> inter) {
        List<String> list = inter.strategy("hello", new ArrayList());
        System.out.println(list);
    }

    public static void main(String[] args) {
        test(new MyInterface<String, List>() {
            @Override
            public List strategy(String s, List list) {
                list.add(s);
                return list;
            }
        });

        test((x, y) -> {
            y.add(x);
            return y;
        });

        /*
        (x, y) -> { ... } ==> test(param) ==> param == MyInterface ==> Lambda 表达式 ==> MyInterface 类型。
        这个就是对于 Lambda 表达式的类型检查。MyInterface 接口就是 Lambda 表达式的目标类型（Target Typing）。

        (x, y) -> { ... } ==> MyInterface.strategy(T t, R r) ==> MyInterface<String, List> inter
            ==> T==String R==List ==> lambda (x, y) == strategy(T t, R r) ==> x == T == String, y == R == List
            Lambda 表达式参数的类型检查。
         */

        test((x, y) -> {
            y.add(x);
            return y;

//            x.add();// Cannot resolve method 'add()'
        });
    }

}
