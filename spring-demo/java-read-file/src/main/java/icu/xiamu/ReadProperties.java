package icu.xiamu;

import java.io.*;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * @author 肉豆蔻吖
 * @date 2024/3/16
 */
public class ReadProperties {
    public static void main(String[] args) throws IOException {

        // 解析properties文件
        // 1.使用 getClassLoader 读取文件
        // demo1();

        // 2. InputStream
        // demo2();

        // 3.ResourceBundle
        // demo3();

        // 4.ResourceBundle
        demo4();
    }

    private static void demo4() throws IOException {
        File file = new File("E:\\Code\\面试题\\spring-demo\\java-read-file\\src\\main\\resources\\application.properties");
        InputStream inputStream = new FileInputStream(file);
        ResourceBundle resource = new PropertyResourceBundle(inputStream);
        String url = resource.getString("spring.datasource.url");
        System.out.println("url = " + url);
    }

    private static void demo3() {
        ResourceBundle resource = ResourceBundle.getBundle("application"); // 这个不需要后缀 .properties
        String url = resource.getString("spring.datasource.url");
        System.out.println("url = " + url);

        String username = resource.getString("spring.datasource.username");
        System.out.println("username = " + username);

        String password = resource.getString("spring.datasource.password");
        System.out.println("password = " + password);

        String driverName = resource.getString("spring.datasource.driver-class-name");
        System.out.println("driverName = " + driverName);
    }

    private static void demo2() throws IOException {
        Properties properties = new Properties();
        BufferedReader br = new BufferedReader(new FileReader("E:\\Code\\面试题\\spring-demo\\java-read-file\\src\\main\\resources\\application.properties"));
        properties.load(br);
        String url = properties.getProperty("spring.datasource.url");
        System.out.println("url1 = " + url);

        String username = properties.getProperty("spring.datasource.username");
        System.out.println("username = " + username);

        String password = properties.getProperty("spring.datasource.password");
        System.out.println("password = " + password);

        String driverName = properties.getProperty("spring.datasource.driver-class-name");
        System.out.println("driverName = " + driverName);
    }

    private static void demo1() throws IOException {
        Properties properties = new Properties();
        InputStream resourceAsStream = ReadProperties.class.getClassLoader().getResourceAsStream("application.properties");
        properties.load(resourceAsStream);
        String url1 = properties.getProperty("spring.datasource.url");
        Object url2 = properties.get("spring.datasource.url");
        System.out.println("url1 = " + url1);
        System.out.println("url2 = " + url2);

        String username = properties.getProperty("spring.datasource.username");
        System.out.println("username = " + username);

        String password = properties.getProperty("spring.datasource.password");
        System.out.println("password = " + password);

        String driverName = properties.getProperty("spring.datasource.driver-class-name");
        System.out.println("driverName = " + driverName);
    }
}
