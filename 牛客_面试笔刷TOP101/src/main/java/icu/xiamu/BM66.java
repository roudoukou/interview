package icu.xiamu;

/**
 * 没解出来, 妈的不会做这题
 */
public class BM66 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * <p>
     * longest common substring
     *
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    private static String maxSubString = "";
    private static int maxLength = 0;
    public String LCS(String str1, String str2) {
        // write code here
        solve2(str1, str2, 0, 0, 0);
        return maxSubString;
    }

    private String solve2(String str1, String str2, int s1Index, int s2Index, int current) {
        if (str1 == null || str2 == null || s1Index >= str1.length() || s2Index >= str2.length()) {
            return "";
        }


        if (str1.charAt(s1Index) == str2.charAt(s2Index)) {

            String result2 = String.valueOf(str1.charAt(s1Index));
            String result3 = solve2(str1, str2, s1Index + 1, s2Index + 1, current+1);
            // System.out.println(result2 + "#" + result3);
            String result1 = result2 + result3;

            maxSubString = maxSubString.length() > result3.length() ? maxSubString : result3;

            return result1;
        } else {
            String string1 = solve2(str1, str2, s1Index + 1, s2Index, current + 1);
            String string2 = solve2(str1, str2, s1Index, s2Index + 1, current + 1);
            // System.out.println(string1 + "@" + string2);
            return string1.length() > string2.length() ? string1 : string2;
        }
    }

    /*
    1AB2345CD   12345EF     "1"
    AB2345CD    2345EF      "1"
    ...
    B2345CD     2345EF      "1"
    2345CD      2345EF      "2"
    ...
    345CD       345EF       "23"
    45CD        45EF        "234"
    5CD         5EF         "2345"
    CD          EF          "2345"
    C           EF          "2345"
     */

    private String solve1(String str1, String str2, int s1Index, int s2Index) {
        if (str1 == null || str2 == null || s1Index >= str1.length() || s2Index >= str2.length()) {
            return "";
        }


        if (str1.charAt(s1Index) == str2.charAt(s2Index)) {

            String result2 = String.valueOf(str1.charAt(s1Index));
            String result3 = solve1(str1, str2, s1Index + 1, s2Index + 1);
            System.out.println(result2 + "#" + result3);
            String result1 = result2 + result3;
            return result1;
        } else {
            String string1 = solve1(str1, str2, s1Index + 1, s2Index);
            String string2 = solve1(str1, str2, s1Index, s2Index + 1);
            System.out.println(string1 + "@" + string2);
            return string1.length() > string2.length() ? string1 : string2;
        }
    }

    public static void main(String[] args) {
        String result = new BM66().LCS("1AB2345CD", "12345EF");
        System.out.println(result);

    }
}
