package team.flint.trunk.interceptor;

import team.flint.trunk.annotation.IsToken;
import team.flint.trunk.model.HeaderEnum;
import team.flint.trunk.utils.JwtKit;
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
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod handlerMethod) {
            // 获取处理方法上的注解
            IsToken tokenAnnotation = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), IsToken.class);
            if (tokenAnnotation != null) {
                return JwtKit.verifyToken(request.getHeader(HeaderEnum.TOKEN.getKey()));
            }
        }
        return true;
    }
}
