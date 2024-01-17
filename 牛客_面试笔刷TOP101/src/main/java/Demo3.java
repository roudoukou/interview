import java.util.Arrays;
import java.util.Scanner;

public class Demo3 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }

   /* public static void main(String[] args) {
        int[] arr = {2, 0, 9, 4, 5, 8, 4, 6, 7, 6, 6, 8, 7, 6, 4, 1, 7, 0, 5, 5};
        int limit = 8;

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.split(",");
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt( split[i] );
        }

        limit = scanner.nextInt();


        Arrays.sort(arr);

        System.out.println(arr[limit]);
    }*/
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}