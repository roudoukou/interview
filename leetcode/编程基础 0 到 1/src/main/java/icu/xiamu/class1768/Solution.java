package icu.xiamu.class1768;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/merge-strings-alternately/description/?envType=study-plan-v2&envId=programming-skills
 */
class Solution {

    public String mergeAlternately(String word1, String word2) {
        return solve1(word1, word2);
    }

    private String solve1(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return null;
        }
        if (word1.length() == 0) {
            return word2;
        }
        if (word2.length() == 0) {
            return word1;
        }

        String result = "";
        if (word1.length() == word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                result += String.valueOf(word1.charAt(i));
                result += String.valueOf(word2.charAt(i));
            }

            return result;
        }


        if (word1.length() > word2.length()) {
            for (int i = 0; i < word2.length(); i++) {
                result += String.valueOf(word1.charAt(i));
                result += String.valueOf(word2.charAt(i));
            }
            result += word1.substring(word2.length());
        } else {
            for (int i = 0; i < word1.length(); i++) {
                result += String.valueOf(word1.charAt(i));
                result += String.valueOf(word2.charAt(i));
            }
            result += word2.substring(word1.length());
        }

        return result;
    }

    public static void main(String[] args) {
        assertResult("apbqcr", "abc", "pqr");
        assertResult("apbqrs", "ab", "pqrs");
        assertResult("apbqcd", "abcd", "pq");
    }

    // 傻乎乎的写了一堆就是想动态的去判断结果, 感觉写不出来妈的
    private static boolean allTestsPassed = true;

    static {
        // 注册关闭挂钩
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            if (allTestsPassed) {
                System.out.println("所有测试用例通过");
            } else {
                System.out.println("存在未通过的测试用例");
            }
        }));
    }

    public static void assertResult(Object expected, Object... input) {
        // 获取堆栈信息
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        // 第一个元素是当前方法，第二个元素是调用当前方法的方法，因此要取第三个元素
        String className = stackTrace[2].getClassName();

        try {
            Class<?> clazz = Class.forName(className);
            Method currentMethod = null;
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.toString().contains("main")) {
                    continue;
                }
                if (method.toString().contains("public")) {
                    currentMethod = method;
                    break;
                }
            }

            if (currentMethod != null) {
                // System.out.println(currentMethod);
                Object o = clazz.newInstance();
                Object invoke = currentMethod.invoke(o, input);
                if (!invoke.equals(expected)) {
                    allTestsPassed = false;
                    System.out.println(String.format("测试未通过，输入: %s 期望: %s, 实际: %s",
                            Arrays.toString(input), expected, invoke));
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}