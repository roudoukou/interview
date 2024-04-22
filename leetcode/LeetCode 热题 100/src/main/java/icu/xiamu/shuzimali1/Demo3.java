package icu.xiamu.shuzimali1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/22
 */
public class Demo3 {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Scanner in = new Scanner(System.in);
        String str1 = in.nextLine();

        // write your code here......
        try {

            String[] time = str1.split(" ");
            int length = time.length;
            if (length != 6) {
                int i = 1 / 0;
            }

            String result = time[0] + "-" + time[1] + "-" + time[2] + " " + time[3] + ":" + time[4] + ":" + time[5];
            Date date = sdf.parse(result);

            System.out.println("北京时间为：" + sdf.format(date.getTime()));
            System.out.println("纽约时间为：" + sdf.format(date.getTime() - (long) (12 * 60 * 60 * 1000)));
            // 北京时间为：2021-09-08 14:38:05
            // 纽约时间为：2021-09-08 02:38:05
        } catch (Exception e) {
            System.out.println("您输入的数据不合理");
        }

    }
}
