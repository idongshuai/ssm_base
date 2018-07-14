package ds.interceptor;

import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理员登录拦截器
 *
 * @author 董帅
 */
public class AdminLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        SecurityContextImpl securityContextImpl = (SecurityContextImpl) request
                .getSession().getAttribute("SPRING_SECURITY_CONTEXT");


        if (securityContextImpl != null) {
            response.sendRedirect(request.getContextPath() + "/manager/framework/index.jsp");
            return false;
        }

        return true;
    }
}
