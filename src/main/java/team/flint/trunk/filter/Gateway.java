package team.flint.trunk.filter;

import team.flint.trunk.utils.JwtKit;
import team.flint.trunk.utils.MDCKit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 内嵌网关
 */
@Slf4j
public class Gateway implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)  {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        // 获取用户ID
        Long userId = JwtKit.getId(httpServletRequest.getHeader("token"));
        // 设置用户ID
        httpServletRequest.setAttribute("userId", userId);
        // 设置MDC
        MDCKit.saveMDC(httpServletRequest.getRequestURI(), userId);
        // 开始执行时间
        long start = System.currentTimeMillis();
        try {
            GatewayRequest gatewayRequest = new GatewayRequest(httpServletRequest);
            if (httpServletRequest.getMethod().equalsIgnoreCase(HttpMethod.POST.name())) {
                log.info("request: {}", gatewayRequest.getRequestBody());
            } else {
                log.info("request: {}", gatewayRequest.getQueryString());
            }
            filterChain.doFilter(gatewayRequest, httpServletResponse);
        } catch (Throwable t) {
            log.error("gateway", t);
        } finally {
            log.info("cost-time={} ", System.currentTimeMillis() - start);
            // 删除MDC
            MDCKit.removeMDC();
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
