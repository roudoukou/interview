package icu.xiamu.limit;


import cn.hutool.extra.servlet.JakartaServletUtil;
import jakarta.servlet.http.HttpServletRequestWrapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ServletUtils extends JakartaServletUtil {
    /**
     * 获取request
     */
    public static HttpServletRequest getRequest() {
        // try {
        //     // return getRequestAttributes().getRequest();
        //
        //     try {
        //         ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //         if (servletRequestAttributes != null) {
        //             return (HttpServletRequest) servletRequestAttributes.getRequest();
        //         } else {
        //             return null;
        //         }
        //     } catch (Exception e) {
        //         return null;
        //     }
        // } catch (Exception e) {
        //     return null;
        // }
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        return servletRequestAttributes.getRequest();
    }

    /**
     * 源代码应该想传入getRequest()参数去获取客户端的IP
     * 这坨代码的接收参数是jakarta包下的, 而不是javax包下的,
     * 在java8环境下有不少问题吧, 直接先写死了, 就一个ip, 到时候随便找个工具类再慢慢写上去就行了
     * 至少需要替换的环境 Spring6 JDK17 jakarta
     * @return
     */
    public static String getClientIP() {
        // return getClientIP(getRequest());
        return "127.0.0.1";
    }
}