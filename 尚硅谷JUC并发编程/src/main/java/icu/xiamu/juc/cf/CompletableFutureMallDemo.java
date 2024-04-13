package icu.xiamu.juc.cf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author 肉豆蔻吖
 * @date 2024/4/13
 */
public class CompletableFutureMallDemo {
    public static void main(String[] args) {
        // chain链式调用
        // chain();

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            int i =  1/0;
            return "hello 1234";
        });
        // System.out.println(completableFuture.get());
        System.out.println(completableFuture.join());
    }

    private static void chain() {
        Student student = new Student();

        student.setId(1);
        student.setStudentName("黄磊");
        student.setMajor("软件工程");

        System.out.println(student);

        Student student2 = student.setId(2)
                .setStudentName("黄磊")
                .setMajor("泌尿科");
        System.out.println(student2);

        // 运行结果:
        /*
        Student(id=1, studentName=黄磊, major=软件工程)
        Student(id=2, studentName=黄磊, major=泌尿科)
         */
    }
}

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
class Student {
    private Integer id;
    private String studentName;
    private String major;

    // 链式调用本质基本上就是返回值返回了当前函数对象本身
    /*
    public void setId(Integer id) {
        this.id = id;
    }

    public Student setId(Integer id) {
        this.id = id;
        return this;
    }
    */
}