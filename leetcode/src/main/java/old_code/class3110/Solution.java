package class3110;

class Solution {
    public int scoreOfString(String s) {
        char[] array = s.toCharArray();
        int result = 0;
        for (int i = 0; i < array.length-1; i++) {
            result += Math.abs((int) array[i+1] - (int) array[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().scoreOfString("hello")); // 13
        System.out.println(new Solution().scoreOfString("zaz")); // 50
    }
}