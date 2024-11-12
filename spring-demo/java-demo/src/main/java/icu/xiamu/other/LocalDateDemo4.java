package icu.xiamu.other;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author 肉豆蔻吖
 * @date 2024/3/17
 * 参考文章: https://blog.csdn.net/qq_31635851/article/details/117880835
 */
public class LocalDateDemo4 {
    public static void main(String[] args) {
        // 1.获取当前日期
        LocalDate now = LocalDate.now();
        System.out.println(now);

        System.out.println(LocalDate.now(Clock.systemUTC())); // 从指定时钟中获取当前日期
        System.out.println(LocalDate.now(Clock.systemDefaultZone())); // 指定时区获取日期

        // 2.指定日期
        LocalDate localDate1 = LocalDate.of(2024, 3, 18); // 这个月份索引不是从0开始
        System.out.println(localDate1);
        LocalDate localDate2 = LocalDate.of(2024, Month.MARCH, 18);
        System.out.println(localDate2);

        // 3.纪元日数 从 1970-01-01 开始
        LocalDate localDate3 = LocalDate.ofEpochDay(23122);
        System.out.println(localDate3);

        // 4.从 2024-01-01 为例, 表示一年过去多少天
        LocalDate localDate4 = LocalDate.ofYearDay(2024, 33);
        System.out.println(localDate4);

        // 5.字符串转LocalDate对象
        LocalDate localDate5 = LocalDate.parse("2024-10-01"); // DateTimeParseException 2024-10:01
        System.out.println(localDate5);

        // 6.指定字符串格式
        LocalDate localDate6 = LocalDate.parse("01-10-2024", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        // 年月日要对应上 DateTimeParseException 2024-10-01
        // 前导零也不能少 DateTimeParseException 1-10-2024
        System.out.println(localDate6);

        // 7.从 TemporalAccessor接口的实现类实现的对象 转成LocalDate对象
        LocalDate localDate7 = LocalDate.from(LocalDate.now());
        System.out.println(localDate7);

        // 8.做加法
        LocalDate localDate8 = LocalDate.now();
        System.out.println(localDate8);
        // TemporalUnit 接口的实现类是 ChronoUnit , ChronoUnit 是一个枚举类
        LocalDate localDate9 = localDate8.plus(15, ChronoUnit.DAYS);
        System.out.println(localDate9);

        // Period 实现了 TemporalAmount 接口
        LocalDate localDate10 = localDate8.plus(Period.of(2024, 3, 17)); // 2024-03-17 + 2024-03-17 = 4048-07-04
        System.out.println(localDate10);

        LocalDate localDate11 = localDate8.plusDays(15);
        System.out.println(localDate11);

        // 9.minus 做减法
        LocalDate localDate12 = localDate11.minus(15, ChronoUnit.DAYS);
        System.out.println(localDate12);

        // 10.with 调整日期
        LocalDate localDate13 = LocalDate.now();
        System.out.println(localDate13);  // 2024-03-17 是星期日 , 通过 with 调整之后返回这周的周一 2024-03-11
        LocalDate localDate14 = localDate13.with(DayOfWeek.MONDAY);
        System.out.println(localDate14);

        LocalDate localDate15 = localDate13.with(ChronoField.YEAR, 2021); // 02-29 会转成那一年的 02-28
        System.out.println(localDate15);

    }
}
