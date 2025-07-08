package icu.xiamu.other;

import java.util.*;
import java.util.stream.Collectors;

interface MyInterface {
    public void doSometing(String s);
}

public class Demo {
    public static void main(String[] args) {
        // List<String> list = Arrays.asList("apple", "banana", "orange");
        // 1.遍历
        // for (String fruit : list) {
        //     System.out.println(fruit);package icu.xiamu;
        //
        // import javax.swing.plaf.synth.SynthOptionPaneUI;
        // import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
        // import java.util.*;
        // import java.util.concurrent.LinkedTransferQueue;
        // import java.util.stream.Collectors;
        //
        // interface MyInterface {
        //     public void doSometing(String s);
        // }
        //
        // public class Demo {
        //     public static void main(String[] args) {
        //         // List<String> list = Arrays.asList("apple", "banana", "orange");
        //         // 1.遍历
        //         // for (String fruit : list) {
        //         //     System.out.println(fruit);
        //         // }
        //         //
        //         // List<String> list1 = Arrays.asList("apple", "banana", "orange");
        //         // list1.forEach((fruit) -> {
        //         //     System.out.println(fruit);
        //         // });
        //
        //         // 2.排序
        //         // List<String> list2 = Arrays.asList("apple", "banana", "orange");
        //         // Collections.sort(list2, new Comparator<String>() {
        //         //     @Override
        //         //     public int compare(String o1, String o2) {
        //         //         return o1.compareTo(o2);
        //         //     }
        //         // });
        //         // list2.forEach(System.out::println);
        //         //
        //         // List<String> list3 = Arrays.asList("apple", "banana", "orange");
        //         // Collections.sort(list2, (s1, s2) -> {
        //         //     return s1.compareTo(s2);
        //         // });
        //         // list3.forEach(System.out::println);
        //
        //         // 3.过滤
        //         // List<String> list4 = Arrays.asList("apple", "banana", "orange");
        //         // ArrayList<String> filteredList = new ArrayList<>();
        //         // for (String fruit : list4) {
        //         //     if (fruit.startsWith("a")) {
        //         //         filteredList.add(fruit);
        //         //     }
        //         // }
        //         // System.out.println(filteredList);
        //         //
        //         // List<String> collect = list4.stream().filter(fruit -> {
        //         //     return fruit.startsWith("a");
        //         // }).collect(Collectors.toList());
        //         // System.out.println(collect);
        //
        //         // 4.映射
        //         // List<String> list5 = Arrays.asList("apple", "banana", "orange");
        //         // List<Integer> lengths = new ArrayList<>();
        //         // for (String fruit: list5) {
        //         //     lengths.add(fruit.length());
        //         // }
        //         // System.out.println(lengths);
        //         //
        //         // List<Integer> collect = list5.stream().map(fruit -> {
        //         //     return fruit.length();
        //         // }).collect(Collectors.toList());
        //         // System.out.println(collect);
        //
        //         // 5.规约
        //         // List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        //         // int sum = 0;
        //         // for (int i : list) {
        //         //     sum += i;
        //         // }
        //         // System.out.println(sum);
        //         //
        //         // Integer reduce = list.stream().reduce(0, (a, b) -> {
        //         //     return a + b;
        //         // });
        //         // System.out.println(reduce);
        //
        //         // 6.分组 按照字符串长度分组
        //         // List<String> list5 = Arrays.asList("apple", "banana", "orange");
        //         // HashMap<Integer, List<String>> grouped = new HashMap<>();
        //         // for (String fruit : list5) {
        //         //     int length = fruit.length();
        //         //     if (!grouped.containsKey(length)) {
        //         //         grouped.put(length, new ArrayList<>());
        //         //     }
        //         //     grouped.get(length).add(fruit);
        //         // }
        //         // System.out.println(grouped);
        //         //
        //         // List<String> list6 = Arrays.asList("apple", "banana", "orange");
        //         // Map<Integer, List<String>> collect = list6.stream().collect(Collectors.groupingBy(fruit -> fruit.length()));
        //         // System.out.println(collect);
        //
        //         // 7.函数式接口实现
        //         // MyInterface myObject = new MyInterface() {
        //         //     public void doSometing(String input) {
        //         //         System.out.println(input);
        //         //     }
        //         // };
        //         // myObject.doSometing("Hello World");
        //         //
        //         // MyInterface myObject2 = input -> System.out.println(input);
        //         // myObject2.doSometing("Hello World");
        //
        //
        //         // 8.创建线程
        //         // Thread thread = new Thread(new Runnable() {
        //         //     @Override
        //         //     public void run() {
        //         //         System.out.println("Thread is running");
        //         //     }
        //         // });
        //         // thread.start();
        //         //
        //         // new Thread(() -> {
        //         //     System.out.println("Thread is running");
        //         // }).start();
        //
        //         // 9. Optional
        //         // String str = "Hello World";
        //         // if (str != null) {
        //         //     System.out.println(str.toUpperCase());
        //         // }
        //         //
        //         // Optional<String> strs = Optional.ofNullable("Hello World");
        //         // strs.map(String::toUpperCase).ifPresent(System.out::println);
        //
        //         // 10.流水线
        //         List<String> list6 = Arrays.asList("apple", "banana", "orange");
        //         ArrayList<String> filteredList = new ArrayList<>();
        //         for (String fruit : list6) {
        //             if (fruit.startsWith("a")) {
        //                 filteredList.add(fruit.toUpperCase());
        //             }
        //         }
        //         Collections.sort(filteredList);
        //         System.out.println(filteredList);
        //
        //         List<String> list7 = Arrays.asList("apple", "banana", "orange");
        //         List<String> collect = list7.stream().filter(fruit -> fruit.startsWith("a")).map(String::toUpperCase).sorted().collect(Collectors.toList());
        //         System.out.println(collect);
        //     }
        // }
        // }
        //
        // List<String> list1 = Arrays.asList("apple", "banana", "orange");
        // list1.forEach((fruit) -> {
        //     System.out.println(fruit);
        // });

        // 2.排序
        // List<String> list2 = Arrays.asList("apple", "banana", "orange");
        // Collections.sort(list2, new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return o1.compareTo(o2);
        //     }
        // });
        // list2.forEach(System.out::println);
        //
        // List<String> list3 = Arrays.asList("apple", "banana", "orange");
        // Collections.sort(list2, (s1, s2) -> {
        //     return s1.compareTo(s2);
        // });
        // list3.forEach(System.out::println);

        // 3.过滤
        // List<String> list4 = Arrays.asList("apple", "banana", "orange");
        // ArrayList<String> filteredList = new ArrayList<>();
        // for (String fruit : list4) {
        //     if (fruit.startsWith("a")) {
        //         filteredList.add(fruit);
        //     }
        // }
        // System.out.println(filteredList);
        //
        // List<String> collect = list4.stream().filter(fruit -> {
        //     return fruit.startsWith("a");
        // }).collect(Collectors.toList());
        // System.out.println(collect);

        // 4.映射
        // List<String> list5 = Arrays.asList("apple", "banana", "orange");
        // List<Integer> lengths = new ArrayList<>();
        // for (String fruit: list5) {
        //     lengths.add(fruit.length());
        // }
        // System.out.println(lengths);
        //
        // List<Integer> collect = list5.stream().map(fruit -> {
        //     return fruit.length();
        // }).collect(Collectors.toList());
        // System.out.println(collect);

        // 5.规约
        // List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // int sum = 0;
        // for (int i : list) {
        //     sum += i;
        // }
        // System.out.println(sum);
        //
        // Integer reduce = list.stream().reduce(0, (a, b) -> {
        //     return a + b;
        // });
        // System.out.println(reduce);

        // 6.分组 按照字符串长度分组
        // List<String> list5 = Arrays.asList("apple", "banana", "orange");
        // HashMap<Integer, List<String>> grouped = new HashMap<>();
        // for (String fruit : list5) {
        //     int length = fruit.length();
        //     if (!grouped.containsKey(length)) {
        //         grouped.put(length, new ArrayList<>());
        //     }
        //     grouped.get(length).add(fruit);
        // }
        // System.out.println(grouped);
        //
        // List<String> list6 = Arrays.asList("apple", "banana", "orange");
        // Map<Integer, List<String>> collect = list6.stream().collect(Collectors.groupingBy(fruit -> fruit.length()));
        // System.out.println(collect);

        // 7.函数式接口实现
        // MyInterface myObject = new MyInterface() {
        //     public void doSometing(String input) {
        //         System.out.println(input);
        //     }
        // };
        // myObject.doSometing("Hello World");
        //
        // MyInterface myObject2 = input -> System.out.println(input);
        // myObject2.doSometing("Hello World");


        // 8.创建线程
        // Thread thread = new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         System.out.println("Thread is running");
        //     }
        // });
        // thread.start();
        //
        // new Thread(() -> {
        //     System.out.println("Thread is running");
        // }).start();

        // 9. Optional
        // String str = "Hello World";
        // if (str != null) {
        //     System.out.println(str.toUpperCase());
        // }
        //
        // Optional<String> strs = Optional.ofNullable("Hello World");
        // strs.map(String::toUpperCase).ifPresent(System.out::println);

        // 10.流水线
        List<String> list6 = Arrays.asList("apple", "banana", "orange");
        ArrayList<String> filteredList = new ArrayList<>();
        for (String fruit : list6) {
            if (fruit.startsWith("a")) {
                filteredList.add(fruit.toUpperCase());
            }
        }
        Collections.sort(filteredList);
        System.out.println(filteredList);

        List<String> list7 = Arrays.asList("apple", "banana", "orange");
        List<String> collect = list7.stream().filter(fruit -> fruit.startsWith("a")).map(String::toUpperCase).sorted().collect(Collectors.toList());
        System.out.println(collect);
    }
}
