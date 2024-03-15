package icu.xiamu;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person {
    String name;
    int age;
    String gender;

    public Person() {
    }

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

class Product {
    String name;
    double price;
    String category;

    public Product() {
    }

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                '}';
    }
}

class Student {
    String name;
    int age;
    String className;

    public Student() {
    }

    public Student(String name, int age, String className) {
        this.name = name;
        this.age = age;
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }
}

class User {
    String username;
    int age;
    String city;

    public User() {
    }

    public User(String username, int age, String city) {
        this.username = username;
        this.age = age;
        this.city = city;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }
}

/**
 * @author 肉豆蔻吖
 * @date 2024/3/14
 */
public class Demo3 {
    public static void main(String[] args) {
        // 1.编写一个lambda表达式，对给定的列表按照字符串长度进行升序排序。
        List<String> list1 = Arrays.asList("apple", "banana", "orange", "strawberry", "kiwi");
        System.out.println(list1.stream().sorted((a, b) -> {
            return a.length() - b.length();
        }).collect(Collectors.toList()));

        // 2.编写一个lambda表达式，过滤给定列表中的偶数。
        List<Integer> list2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list2.stream().filter(num -> num % 2 == 0).collect(Collectors.toList()));

        // 3.编写一个lambda表达式，接受两个参数，并返回它们的和。
        List<Integer> list3 = Arrays.asList(5, 10);
        System.out.println(list3.stream().reduce(0, (a, b) -> {
            return a + b;
        }));

        // 4.编写一个lambda表达式，找到给定列表中的最大值。
        List<Integer> list4 = Arrays.asList(12, 35, 7, 29, 41, 23);
        System.out.println(list4.stream().max(Integer::compareTo).get());

        // 5.编写一个lambda表达式，接受一个数字，并返回它的平方。
        List<Integer> list5 = Arrays.asList(6, 10, 12);
        System.out.println(list5.stream().map(l -> l * l).collect(Collectors.toList()));

        // 6.给定一个字符串列表，编写一个Lambda表达式，计算列表中以元音字母（a、e、i、o、u）开头的单词的数量。
        List<String> list6 = Arrays.asList("apple", "banana", "orange", "strawberry", "kiwi", "elephant", "igloo", "umbrella");
        System.out.println(list6.stream().filter(l -> {
            return l.startsWith("a") || l.startsWith("e") || l.startsWith("i") || l.startsWith("o") || l.startsWith("u");
        }).collect(Collectors.toList()));

        // 7.给定一个字符串列表，编写一个Lambda表达式，将列表中的单词连接成一个长字符串，每个单词之间用空格分隔。
        List<String> list7 = Arrays.asList("Java", "is", "a", "powerful", "programming", "language");
        System.out.println(list7.stream().reduce((a, b) -> {
            return a + " " + b;
        }).orElse(""));

        // 8.给定一个字符串列表，编写一个Lambda表达式，检查列表中的所有字符串是否都是小写。
        List<String> list8 = Arrays.asList("Java", "is", "a", "powerful", "programming", "language");
        System.out.println(list8.stream().allMatch(l -> l.equals(l.toLowerCase())));

        // 9.给定一个字符串列表，编写一个Lambda表达式，找出列表中长度大于等于5且包含字母'o'的单词。
        List<String> list9 = Arrays.asList("apple", "banana", "orange", "strawberry", "kiwi", "potato", "tomato");
        list9.stream().filter(l -> {
            return l.length() >= 5 && l.contains("o");
        }).collect(Collectors.toList()).forEach(System.out::println);

        // 10.给定一个整数列表，编写一个Lambda表达式，计算列表中所有偶数的平方和。
        List<Integer> list10 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list10.stream().filter(l -> l % 2 == 0).map(l -> l * l).forEach(System.out::println);
        System.out.println(list10.stream().filter(l -> l % 2 == 0).map(l -> l * l).map(Object::toString).collect(Collectors.joining(" ")));

        // 11.将列表中的偶数按照平方值的降序排列，并且将结果以逗号分隔的形式输出到控制台。
        List<Integer> list11 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(list11.stream()
                .filter(l -> l % 2 == 0)
                .map(l -> l * l)
                .sorted((a, b) -> b - a).map(Object::toString)
                .collect(Collectors.joining(",")));

        // 12.给定一个包含多个单词的句子，编写一个Lambda表达式，将句子中的每个单词的第一个字母转换为大写，并将结果输出到控制台。
        String sentence = "hello world how are you";
        Arrays.stream(sentence.split(" ")).map(l -> {
            return l.substring(0, 1).toUpperCase() + l.substring(1);
        }).forEach(System.out::println);

        // 13.给定一个整数列表，编写一个Lambda表达式，找出列表中的所有素数，并将结果以逗号分隔的形式输出到控制台。
        List<Integer> list13 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);
        System.out.println(list13.stream().filter(l -> {
            if (l <= 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(l); i++) {
                if (l % i == 0) {
                    return false;
                }
            }
            return true;
        }).map(Object::toString).collect(Collectors.joining(",")));

        // 14.给定一个字符串列表，编写一个Lambda表达式，将列表中的所有字符串连接成一个长字符串，每个字符串之间用逗号分隔，且连接后的字符串长度不能超过50个字符。
        List<String> list14 = Arrays.asList("Java", "is", "a", "powerful", "programming", "language", "with", "a", "rich", "ecosystem");
        System.out.println(list14.stream().reduce((a, b) -> {
            if (a.length() + b.length() <= 50) {
                return a + "," + b;
            } else {
                return a;
            }
        }).orElse(""));

        // 15.给定一个字符串列表，编写一个Lambda表达式，找出列表中所有长度大于等于5且包含字母'e'的单词，并将结果以逗号分隔的形式输出到控制台。
        List<String> list15 = Arrays.asList("apple", "banana", "orange", "strawberry", "kiwi", "potato", "tomato");
        System.out.println(list15.stream().filter(l -> l.length() >= 5 && l.contains("e"))
                .collect(Collectors.joining(",")));

        // 16.给定一个包含人员信息的列表，每个人员包含姓名、年龄和性别属性。编写一个Lambda表达式，过滤出年龄大于等于18岁的所有男性，并将结果按照性别分组。
        List<Person> list16 = Arrays.asList(
                new Person("Alice", 25, "female"),
                new Person("Bob", 30, "male"),
                new Person("Charlie", 20, "male"),
                new Person("Diana", 17, "female"),
                new Person("Eve", 22, "female")
        );
        System.out.println(list16.stream()
                .filter(p -> p.getAge() >= 18)
                .collect(Collectors.groupingBy(l -> l.getGender())));

        // 17.给定一个包含商品信息的列表，每个商品包含名称、价格和类别属性。编写一个Lambda表达式，过滤出价格大于等于100的所有电子产品，并将结果按照类别分组。
        List<Product> list17 = Arrays.asList(
                new Product("Laptop", 1200.0, "electronics"),
                new Product("Smartphone", 800.0, "electronics"),
                new Product("Headphones", 50.0, "electronics"),
                new Product("Book", 20.0, "books"),
                new Product("Tablet", 300.0, "books"),
                new Product("TV", 1500.0, "electronics")
        );

        System.out.println(list17.stream().filter(product -> product.getPrice() >= 100)
                .collect(Collectors.groupingBy(Product::getCategory)));

        // 18.给定一个包含学生信息的列表，每个学生包含姓名、年龄和班级属性。编写一个Lambda表达式，过滤出年龄大于等于18岁的所有学生，并将结果按照班级分组。
        List<Student> list18 = Arrays.asList(
                new Student("Alice", 20, "A"),
                new Student("Bob", 17, "B"),
                new Student("Charlie", 19, "A"),
                new Student("Diana", 18, "C"),
                new Student("Eve", 21, "B")
        );
        System.out.println(list18.stream()
                .filter(student -> student.getAge() >= 18)
                .collect(Collectors.groupingBy(Student::getClassName)));

        // 19.给定一个包含用户信息的列表，每个用户包含用户名、年龄和所在城市属性。编写一个Lambda表达式，找出年龄大于等于18岁且所在城市为"New York"的所有用户，并按照年龄降序排列，然后将结果输出到控制台。
        List<User> list19 = Arrays.asList(
                new User("Alice", 25, "New York"),
                new User("Bob", 30, "Los Angeles"),
                new User("Charlie", 20, "New York"),
                new User("Diana", 17, "Chicago"),
                new User("Eve", 22, "New York")
        );
        System.out.println(list19.stream()
                .filter(user -> user.getAge() >= 18 && "New York".equals(user.getCity()))
                .sorted((a, b) -> {
                    return b.getAge() - a.getAge();
                }).collect(Collectors.toList()));

        // 20.给定一个包含用户信息的列表，每个用户包含用户名、年龄和所在城市属性。
        // 编写一个Lambda表达式，找出年龄大于等于18岁的所有用户，并按照年龄降序排列。然后，将结果按照所在城市分组，并计算每个城市的用户数量，最后将结果输出到控制台。
        List<User> list20 = Arrays.asList(
                new User("Alice", 25, "New York"),
                new User("Bob", 30, "Los Angeles"),
                new User("Charlie", 20, "New York"),
                new User("Diana", 17, "Chicago"),
                new User("Eve", 22, "New York")
        );
        System.out.println(list20.stream()
                .filter(user -> user.getAge() >= 18)
                .sorted((a, b) -> b.getAge() - a.getAge())
                .collect(Collectors.groupingBy(User::getCity, Collectors.counting())));
    }
}
