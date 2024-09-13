package class7;

class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
        }
        String s = String.valueOf(Math.abs(x));
        StringBuilder stringBuilder = new StringBuilder(s);
        try {
            return Integer.parseInt(flag ? "-" + stringBuilder.reverse().toString() : stringBuilder.reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        // System.out.println(new Solution().reverse(123));
        // System.out.println(new Solution().reverse(-123));
        // System.out.println(new Solution().reverse(120));
        // System.out.println(new Solution().reverse(0));
        System.out.println(new Solution().reverse(1534236469));
    }
}