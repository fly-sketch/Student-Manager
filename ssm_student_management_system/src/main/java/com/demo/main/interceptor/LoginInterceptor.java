package com.demo.main.interceptor;

import com.demo.main.utils.PermissionUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        if (PermissionUtil.isLogin(request)) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
    }
}
