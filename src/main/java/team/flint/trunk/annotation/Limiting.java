package team.flint.trunk.annotation;


import java.lang.annotation.*;

/**
 * 限流注解
 * @author noah
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Limiting {
    /**
     * 限流key,支持使用Spring el表达式来动态获取方法上的参数值
     * 格式类似于  #code.id #{#code}
     */
    String key() default "";

    /**
     * 限流时间,单位秒
     */
    int time() default 3;

    /**
     * 提示消息 支持国际化 格式为 {code}
     */
    String message();
}
