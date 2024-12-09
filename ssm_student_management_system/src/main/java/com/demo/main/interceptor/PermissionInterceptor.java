package com.demo.main.interceptor;

import com.demo.main.utils.PermissionUtil;
import com.demo.main.utils.RoleEnum;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PermissionInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        RoleEnum roleEnum = PermissionUtil.getRoleByCurrentRole(request);

        // 判断对应权限列表中是否包含当前想要访问的路径，如果是则通过，否则跳转至对应身份首页面
        boolean flag = PermissionUtil.rolePermissionMap.get(roleEnum).contains(request.getServletPath());
        if (flag) {
            request.setAttribute("links", PermissionUtil.rolePageInfoMap.get(roleEnum));
            return true;
        } else {
            response.getWriter().println("you do not have permission for this operation.");
            return false;
        }
    }
}
