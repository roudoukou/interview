package class3136;

class Solution {
    public boolean isValid(String word) {
        if (word.length() < 3) {
            return false;
        }
        int status1 = 0;
        int status2 = 0;
        int status3 = 0;
        for (int i = 0; i < word.length(); i++) {
            if ("aeiou".contains(String.valueOf(word.charAt(i)).toLowerCase())) {
                status1++;
            } else if ("qwrtypsdfghjklzxcvbnm".contains(String.valueOf(word.charAt(i)).toLowerCase())) {
                status2++;
            } else if ("1234567890".contains(String.valueOf(word.charAt(i))))  {

            } else {
                return false;
            }
        }

        return status1 >= 1 && status2 >= 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("234Adas"));
        System.out.println(new Solution().isValid("b3"));
        System.out.println(new Solution().isValid("a3$e"));
        System.out.println(new Solution().isValid("3pp"));
        System.out.println(new Solution().isValid("aya"));
        System.out.println(new Solution().isValid("234Adas"));
    }
}