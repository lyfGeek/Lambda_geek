package com.geek;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author geek
 */
public class APIDemo {

    public static void main(String[] args) {
        List<String> accountList = new ArrayList<>();
        accountList.add("Geek");
        accountList.add("Tom");
        accountList.add("Jerry");
        accountList.add("luzhishen");
        accountList.add("wusong");

        // map(); 中间操作。map(); 方法接收一个 Functional 接口。
//        accountList = accountList.stream().map(x -> "梁山好汉：" + x).collect(Collectors.toList());
//        accountList.forEach(System.out::println);
        System.out.println("～　～　～　～　～　～　～");

        // filter(); 添加过滤条件，拂绿符合条件的用户。
//        accountList = accountList.stream().filter(x -> x.length() > 5).collect(Collectors.toList());
//        accountList.forEach(System.out::println);

        // forEach(); 增强型循环。
//        accountList.forEach(x -> System.out.println("forEach => " + x));
        // 如果要多次迭代操作。
//        accountList.forEach(x -> System.out.println("forEach => " + x));
//        accountList.forEach(x -> System.out.println("forEach => " + x));
        // 冗余。
        // ↓ ↓ ↓

        // peek(); 中间操作。迭代数据完成数据的依次处理过程。
//        accountList.stream()
//                .peek(x -> System.out.println("peek 1" + x))
//                .peek(x -> System.out.println("peek 2" + x))
//                .forEach(System.out::println);
//
        // Stream 中对于数字运算的支持。
        List<Integer> list = new ArrayList<>();
        list.add(20);
        list.add(17);
        list.add(3);
        list.add(11);
        list.add(26);
        list.add(27);
        list.add(27);

        // skip(); 中间操作，有状态，跳过部分数据。
//        list.stream().skip(3).forEach(System.out::println);

        // limit(); 中间操作，有状态，限制输出数据量。
//        list.stream().skip(3).limit(2).forEach(System.out::println);

        // distinct(); 中间操作，有状态，剔除重复数据。
//        list.stream().distinct().forEach(System.out::println);

        // sorted(); 中间操作，有状态，排序。
        // max(); 获取最大值。
        Optional<Integer> optional = list.stream().max((x, y) -> x - y);
        System.out.println(optional.get());
        // min(); 获取最小值。

        // reduce(); 合并处理数据。
        Optional<Integer> optional1 = list.stream().reduce((sum, x) -> sum + x);
        System.out.println(optional1.get());
    }

}
