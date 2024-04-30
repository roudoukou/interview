package icu.xiamu.limit;

public class R<T> {
    private Integer code; // 响应代码，例如200代表成功
    private String message; // 响应消息，例如"成功"
    private T data; // 响应数据，可以是任何类型

    // 构造函数
    public R() {
    }

    public R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    // 快速创建R对象的静态方法
    public static <T> R<T> ok(String message, T data) {
        return new R<>(200, message, data);
    }

    public static <T> R<T> ok(T data) {
        return new R<>(200, "成功", data);
    }

    //失败静态方法
    public static R error() {
        R r = new R();
        r.setCode(500);
        r.setMessage("失败");
        r.setData(null);
        return r;
    }

    public static <T> R<T> error(String message) {
        return new R<>(500, message, null);
    }

    public static <T> R<T> error(Integer code, String message) {
        return new R<>(code, message, null);
    }

    // Getter和Setter
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
