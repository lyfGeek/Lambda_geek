package com.geek;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

interface IPerson {

    /**
     * 抽象方法。通过制定类型的构造方法初始化对象数据。
     *
     * @param name
     * @param gender
     * @param age
     * @return
     */
    Person initPerson(String name, String gender, int age);

}

/**
 * @author geek
 */
public class Test {

    public static void main(String[] args) {

        // 静态方法引用。
        // 类型名称.方法名称(); ==> 类型名称::方法名称。
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Geek1", "男", 25));
        personList.add(new Person("Geek2", "男", 18));
        personList.add(new Person("Geek3", "男", 3));
        personList.add(new Person("Geek4", "男", 21));
        personList.add(new Person("Geek5", "男", 9));

        // 排序。匿名内部类。
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
//                return 0;
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(personList);

        // 排序。Lambda。
        Collections.sort(personList, (p1, p2) -> p1.getAge() - p2.getAge());
        System.out.println(personList);

        // 排序。静态方法引用。
        Collections.sort(personList, Person::compareByAge);

        System.out.println(personList);

        // ~ ~

        // 排序。实例方法引用。
        // 创建类型对应的一个对象。 ==> 对象::实例方法名称。
        PersonUtil personUtil = new PersonUtil();
        Collections.sort(personList, personUtil::compareByName);
        System.out.println("Geek1".hashCode());
        System.out.println("Geek2".hashCode());
        System.out.println(personList);
        // 68679309（Geek1）
        //68679310（Geek2）
        //[Person(name=Geek1, gender=男, age=25), Person(name=Geek2, gender=男, age=18), Person(name=Geek3, gender=男, age=3), Person(name=Geek4, gender=男, age=21), Person(name=Geek5, gender=男, age=9)]

        // 构造方法引用。绑定函数式接口。
        IPerson iPerson = Person::new;
        Person person = iPerson.initPerson("Tom", "男", 23);
        System.out.println(person);
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {

    private String name;
    private String gender;
    private int age;

    static int compareByAge(Person p1, Person p2) {
        return p1.getAge() - p2.getAge();
    }

}

class PersonUtil {

    // 增加一个实例方法。
    int compareByName(Person p1, Person p2) {
        return p1.getName().hashCode() - p2.getName().hashCode();
    }

}
