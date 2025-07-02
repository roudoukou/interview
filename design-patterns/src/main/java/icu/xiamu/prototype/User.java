package icu.xiamu.prototype;

/**
 * @author roudoukou
 * @date 2025/5/25
 */
public class User implements Cloneable {

    private String userName;
    private Integer age;
    private String email;

    public User() {
        this.userName = userName;
        this.age = age;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
