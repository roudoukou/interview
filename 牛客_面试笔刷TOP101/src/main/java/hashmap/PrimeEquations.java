package hashmap;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 第二题
 */
public class PrimeEquations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // String S = "1234"; // 示例输入
        String S = scanner.nextLine();
        Set<Integer> primes = new HashSet<>();
        generateCombinations(S, 0, "", primes);
        System.out.println(primes.size());
    }

    private static void generateCombinations(String S, int index, String current, Set<Integer> primes) {
        if (index == S.length()) {
            int sum = calculateSum(current);
            if (isPrime(sum)) {
                primes.add(sum);
            }
            return;
        }
        
        // 不插入加号
        generateCombinations(S, index + 1, current + S.charAt(index), primes);
        
        // 插入加号（如果不是第一个字符）
        if (index > 0) {
            generateCombinations(S, index + 1, current + "+" + S.charAt(index), primes);
        }
    }

    private static int calculateSum(String expression) {
        String[] numbers = expression.split("\\+");
        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
