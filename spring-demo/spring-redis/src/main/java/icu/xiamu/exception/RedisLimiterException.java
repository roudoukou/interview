package icu.xiamu.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 肉豆蔻吖
 * @date 2024/5/1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RedisLimiterException extends RuntimeException {
    private Integer code;
    private String message;

    public RedisLimiterException(String message) {
        this.message = message;
    }
}
