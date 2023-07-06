package team.flint.trunk.interceptor;

import team.flint.trunk.annotation.Limiting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
@Slf4j
public class LimitingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod handlerMethod) {
            // 获取处理方法上的注解
            Limiting tokenAnnotation = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), Limiting.class);
            if (tokenAnnotation != null) {
                // todo 实现限流
                return true;
            }
        }
        return true;
    }
}
