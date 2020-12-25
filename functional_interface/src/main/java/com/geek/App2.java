package com.geek;

import java.util.UUID;
import java.util.function.*;

/**
 * @author geek
 */
public class App2 {

    public static void main(String[] args) {

        Predicate<String> predicate = (String username) -> "admin".equals(username);
//        Predicate<String> predicate = "admin"::equals;
        // 接受参数对象 T，返回一个 boolean 类型结果。
        System.out.println(predicate.test("manager"));
        System.out.println(predicate.test("admin"));

        Consumer<String> consumer = (String msg) -> {
            System.out.println("要发送的消息：" + msg);
            System.out.println("消息发送完成。");
        };
        // 接受参数对象 T，不反回结果。
        consumer.accept("Hello");
        consumer.accept("Hello1");


        Function<String, Integer> fun = (String gender) -> "male".equals(gender) ? 1 : 0;
        // 接受参数对象 T，返回结果对象 R。
        System.out.println(fun.apply("male"));
        System.out.println(fun.apply("female"));

        Supplier<String> supplier = () -> UUID.randomUUID().toString();
        // 不接受参数，提供 T 对象的创建工厂。
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());


        UnaryOperator<String> unaryOperator = (String img) -> {
            img += "[100x200]";
            return img;
        };
        // 接受参数对象 T，返回结果对象。
        System.out.println(unaryOperator.apply("原图---"));
        // 原图---[100x200]


        BinaryOperator<Integer> binaryOperator = (Integer i1, Integer i2) -> i1 > i2 ? i1 : i2;
        // 接受两个 T 对象，返回一个 T 对象结果。
        System.out.println(binaryOperator.apply(12, 13));
    }

}
