package com.geek;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * - 集合操作。
 * - Stream 处理流程。
 * 　数据源。
 * 　数据转换。
 * 　获取结果。
 * - 获取 Stream 对象。
 * 　- 从集合或数组中获取。
 * 　　Collection.stream();。
 * 　　Collection.parallelStream();。
 * 　　Arrays.stream(T t);。
 * 　- BufferReader。
 * 　　BufferReader.lines();。
 * 　- 静态工厂。
 * 　　java.util.stream.IntStream.range();。
 * 　　java.nio.file.Files.walk();。
 * 　- 自定构建。
 * 　　java.util.Spliterator();。
 * 　- more。
 * 　　Random.ints();。
 * 　　Pattern.splitAsStream();。
 * <p>
 * - 中间操作 API。（intermediate）。
 * 操作结果是一个 Stream。中间操作可以有一或多个连续的中间操作，需要注意的是，中间操作只记录操作方式，不做具体执行，知道结束操作发生时，才做数据的最终执行。
 * 中间操作就是业务逻辑处理。
 * 中间操作过程：
 * 　无状态：数据处理时，不受前置操作的影响。
 * map / filter / peek / parallel / sequential / unordered。
 * 　有状态：数据处理时，受到前置操作的影响。
 * distinct / sorted / limit / skip。
 * <p>
 * - 终结操作 / 结束操作。（terminal）。
 * 一个 Stream 对象，只能有一个 Terminal 操作。这个操作一旦发生，就会真实处理数据，生成对应的处理结果。
 * 终结操作。
 * —— 短路操作：当前的 Stream 对象必须处理完集合中所有数据，才能得到处理结果。
 * forEach / forEachOrdered / toArray / reduce / collect / min / max / count / iterator。
 * —— 非短路操作：当前的 Stream 对象在处理过程中，一旦满足某个条件，就可以得到结果。
 * anyMatch / allMatch / noneMatch / findFirst / findAny。
 * short-circuiting。无限大的 Stream -> 有限大的 Stream。
 *
 * @author geek
 */
public class ArraysDemo {

    public static void main(String[] args) {
        // 批量数据 --> Stream 对象。
        // 多个数据。
        Stream<String> stream1 = Stream.of("admin", "Tom", "Jerry");
        System.out.println("stream1 = " + stream1);

        // 数组。
        String[] strings = {"geek", "haha"};
        Stream<String> stream2 = Arrays.stream(strings);
        System.out.println("stream2 = " + stream2);

        // 列表。
        List<String> list = new ArrayList<>();
        list.add("少林");
        list.add("武当");
        list.add("青城");
        list.add("峨眉");
        list.add("崆峒");
        Stream<String> stream3 = list.stream();
        System.out.println("stream3 = " + stream3);

        // 集合。
        Set<String> set = new HashSet<>();
        set.add("少林罗汉拳");
        set.add("武当长拳");
        set.add("青城剑法");
        Stream<String> stream4 = set.stream();
        System.out.println("stream4 = " + stream4);

        // map。
        Map<String, Integer> map = new HashMap<>();
        map.put("geek", 3);
        map.put("Tom", 12);
        map.put("Jerry", 11);
        Stream<Map.Entry<String, Integer>> stream5 = map.entrySet().stream();
        System.out.println("stream5 = " + stream5);

        // Stream 对象对于基本数据类型的功能封装。
        // int / long / long。
        IntStream.of(10, 20, 30).forEach(System.out::println);
        IntStream.range(1, 5).forEach(System.out::println);// 1 ~ 4。
        IntStream.rangeClosed(1, 5).forEach(System.out::println);// 1 ~ 5。

        // Stream 对象 --> 转换得到指定的数据类型。
        // 数组。
//        String[] strings1 = stream1.toArray(String[]::new);
//        System.out.println("strings1 = " + strings1);

        // 字符串。
//        String string = stream1.collect(Collectors.joining()).toString();
//        System.out.println("string = " + string);
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
        // string = adminTomJerry

        // 列表。
//        List<String> list1 = stream1.collect(Collectors.toList());
//        System.out.println("list1 = " + list1);
        // list1 = [admin, Tom, Jerry]

        // 集合。
//        Set<String> set1 = stream1.collect(Collectors.toSet());
//        System.out.println("set1 = " + set1);
        // set1 = [Tom, admin, Jerry]

        // map。
        Map<String, String> map1 = stream1.collect(Collectors.toMap(x -> x, y -> "value:" + y));
        System.out.println("map1 = " + map1);
        // map1 = {Tom=value:Tom, admin=value:admin, Jerry=value:Jerry}
    }

}
