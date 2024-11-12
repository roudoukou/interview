package icu.xiamu.other;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 肉豆蔻吖
 * @date 2024/3/12
 */
public class Demo2 {
    public static void main(String[] args) {
        // demo1ForDate();

        demo2ForCalendar();


    }

    private static void demo2ForCalendar() {
        // Calendar 抽象类
        // Calendar c = Calendar.getInstance();
        // c.set(2024, Calendar.MARCH, 12); // 月份从 0 开始 , 0一月; 1二月; 2三悦...
        // System.out.println(c.get(Calendar.MONTH));
        // System.out.println(c.get(Calendar.HOUR));
        // System.out.println(c.get(Calendar.DAY_OF_WEEK)); // 1星期天 2星期一 3星期二

        Calendar today = Calendar.getInstance();
        System.out.println(today.get(Calendar.DAY_OF_WEEK));

        int year = 2014;
        int month = 3;
        today.set(Calendar.YEAR, year);
        today.set(Calendar.MONTH, month-1);
        System.out.println(today.getActualMaximum(Calendar.DAY_OF_MONTH)); // 获取当月的最大天数

        Calendar c1 = Calendar.getInstance();
        c1.set(2024, 2, 12); // 月份减一
        Calendar c2 = Calendar.getInstance();
        c2.set(2002, 10-1, 1); // 月份减一
        System.out.println((c1.getTimeInMillis() - c2.getTimeInMillis()) / (60 * 24 * 60 * 1000));

        // 闰年
        Calendar c3 = Calendar.getInstance();
        c3.set(Calendar.YEAR, 2024); // 月份减一
        if (c3.getActualMaximum(Calendar.DAY_OF_YEAR) > 365) {
            System.out.println("闰年");
        } else {
            System.out.println("非闰年");
        }
    }

    private static void demo1ForDate() {
        // Date (已过时, 不推荐使用)
        Date date1 = new Date();
        System.out.println(date1.toString());

        // 日期比较
        long time = date1.getTime(); // 时间戳
        System.out.println(time);   // 1710251441585

        Date date2 = new Date();
        System.out.println(date2.before(date1)); // false
        System.out.println(date2.after(date1));  // true
        System.out.println(date2.equals(date1)); // false

        System.out.println(date2.compareTo(date1)); // 1 不等于 0 等于
    }


    /**
     * User
     * 请你出几道题Calendar 的使用?
     *
     * ChatGPT
     * 当然，我可以给您提供一些关于Calendar类的使用的练习题。请注意，Java 8及更高版本引入了java.time包，推荐使用LocalDate和LocalDateTime等新的日期时间类。但为了练习Calendar类的使用，我们可以仍然使用它。以下是一些题目：
     *
     * 题目1：计算今天是星期几
     * 编写一个程序，使用Calendar类来确定今天是星期几，并将结果输出到控制台。
     *
     * 题目2：计算指定日期的月份天数
     * 编写一个程序，接受用户输入的年份和月份，然后使用Calendar类来计算该月份有多少天，并输出结果。
     *
     * 题目3：计算两个日期之间的天数差
     * 编写一个程序，接受用户输入的两个日期（年、月、日），然后使用Calendar类计算并输出这两个日期之间的天数差。
     *
     * 题目4：判断某年是否为闰年
     * 编写一个程序，接受用户输入的年份，然后使用Calendar类判断该年是否为闰年，并输出结果。
     *
     * 题目5：获取当前月的第一天和最后一天
     * 编写一个程序，使用Calendar类获取当前月的第一天和最后一天，并将它们输出到控制台。
     *
     * 请注意，这些题目主要用于练习Calendar类的基本用法，实际项目中可能更推荐使用java.time包中的新日期时间类。
     */
}
