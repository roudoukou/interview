
// class HelloA {
//     public HelloA() {
//         System.out.println("HelloA");
//     }
//
//     {
//         System.out.println("I'm A class");
//     }
//
//     static {
//         System.out.println("static A");
//     }
// }

public class HelloB  {
    // public HelloB() {
    //     System.out.println("HelloB");
    // }
    //
    // {
    //     System.out.println("I'm B class");
    // }
    //
    // static {
    //     System.out.println("static B");
    // }

    public static void main(String[] args) {

        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);

        Integer b1 = 100;
        Integer b2 = 100;
        System.out.println(b1 == b2);

        Integer c1 = 200;
        Integer c2 = 200;
        System.out.println(c1 == c2);
        // System.out.println("main start");
        // new HelloB();
        // new HelloB();
        // System.out.println("main end");
    }
}
