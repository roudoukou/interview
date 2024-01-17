package demo01;

/**
 * 第一题, 输出i, j, k的值
 */
public class demo1 {
    public static void main(String[] args) {
        int i = 1;
        //i++就是先使用了i, 之后再进行i+1 首先返回变量当前的值，然后才把变量增加1
        i = i++;        // i = 1
        int j = i++;    // j = 1, i = 2
        int k = i + ++i * i++;  // 2 + 3 * 3
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        System.out.println("k = " + k);
    }
}
