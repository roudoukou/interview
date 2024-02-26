尚硅谷50道Java面试题，大厂高频java面试真题

## mysql 调优
无过滤不索引
覆盖索引, 和做到回表操作

索引缺点: 影响更新效率, 磁盘存储空间

order by也要匹配最左前缀

order by 排序要所有字段都是一个顺序, 要么所有的都是升序, 所有的都是降序

不要使用select *

## JVM内存模型为啥要分新生代和老年代, 对于新生代, 为什么要

## 常见远程调用有几种?
TCP UDP
常用框架 netty resttemplate 
长短连接(复用)

## 什么是自动配置
SpringBoot工程中添加注解 @SpringBootApplication 完成自动配置
这个注解中包含另外一个注解 @ComponentScan , 这个注解主要就是为了扫描其他包的一些容器
会读取每个jar包下的 META/spring.factories 和 spring-boot-autoconfigure-2.6.7.jar 中的配置

## 什么是起步依赖
指的是各种starter, pom.xml 其中包含了框架所需要的其他依赖以及默认配置文件, 不需要我们手动配置了