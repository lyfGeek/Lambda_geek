package com.geek;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author geek
 */
public class StreamTest {

    public static void main(String[] args) {

        // 测试数据：存储多个账号的列表。
        List<String> accounts = new ArrayList<>();
        accounts.add("tom");
        accounts.add("jerry");
        accounts.add("beita");
        accounts.add("shuke");
        accounts.add("geek");

        // 长度 >= 5 的有效账号。
        for (String account : accounts) {
            if (account.length() >= 5) {
                System.out.println("有效账号：" + account);
            }
        }

        // 迭代方式。
        Iterator<String> iterator = accounts.iterator();
        while (iterator.hasNext()) {
            String account = iterator.next();
            if (account.length() >= 5) {
                System.out.println("it 有效账号：" + account);
            }
        }

        // Stream 结合 Lambda 表达式。
        List validAccounts = accounts.stream().filter(s -> s.length() >= 5).collect(Collectors.toList());
        Stream<String> stream = accounts.stream();
        System.out.println(stream);// java.util.stream.ReferencePipeline$Head@2d98a335
        System.out.println(validAccounts);
    }

}
