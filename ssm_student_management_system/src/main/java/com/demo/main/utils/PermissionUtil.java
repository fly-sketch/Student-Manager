package com.demo.main.utils;

import com.demo.main.exception.NotLoggedInException;
import lombok.Data;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * 权限工具类
 * 配置所有角色对应权限
 */
@Data
public class PermissionUtil {
    public static final String IS_LOGIN = "is_login",
            // 广义user
            USERNAME = "username",
            USER_ID = "user_id",
            ROLE = "role";

    // 不可变静态可访问页面列表map
    // 角色-可访问页面
    public static Map<RoleEnum, Map<String, String>> rolePageInfoMap;
    // 基本权限
    public static List<String> basePermissionList = new ArrayList<>(Arrays.asList("/",
            "/login",
            "/register",
            "/logout",
            "/student/add"));
    // 角色权限
    public static Map<RoleEnum, List<String>> rolePermissionMap = new HashMap<>();

    static {
        // 角色对应页面
        Map<String, String> studentPageInfoMap = new LinkedHashMap<String, String>() {{
            put("成绩查看", "/score/student_course_management");
        }};

        Map<String, String> teacherPageInfoMap = new LinkedHashMap<String, String>() {{
            put("学生管理", "/student/management");
            put("课程管理", "/course/management");
            put("成绩管理", "/score/management");
        }};

        Map<String, String> adminPageInfoMap = new LinkedHashMap<String, String>() {{
            put("学生管理", "/student/management");
            put("教师管理", "/teacher/management");
            put("管理员管理", "/admin/management");
            put("课程管理", "/course/management");
            put("成绩管理", "/score/management");
        }};

        rolePageInfoMap = new HashMap<RoleEnum, Map<String, String>>() {{
            put(RoleEnum.STUDENT, studentPageInfoMap);
            put(RoleEnum.TEACHER, teacherPageInfoMap);
            put(RoleEnum.ADMIN, adminPageInfoMap);
        }};

        // 角色权限
        List<String> studentPermission = new ArrayList<>(Arrays.asList("/score/student_course_management",
                "/score/student_course_management_condition"));
        List<String> teacherPermission = new ArrayList<>(Arrays.asList("/student/management",
                "/course/management",
                "/score/management",
                "/student/management_condition",
                "/student/edit",
                "/student/delete",
                "/course/management_condition",
                "/score/management_condition",
                "/course/management_condition",
                "/score/add",
                "/course/add",
                "/score/edit",
                "/score/delete",
                "/course/edit",
                "/course/delete",
                "/student/getById",
                "/score/getById",
                "/course/getById",
                "/student/update",
                "/score/update",
                "/course/update"
                ));
        List<String> adminPermission = new ArrayList<>(Arrays.asList("/teacher/management",
                "/admin/management",
                "/admin/management_condition",
                "/teacher/management_condition",
                "/teacher/add",
                "/admin/add",
                "/teacher/delete",
                "/teacher/edit",
                "/admin/delete",
                "/admin/edit",
                "/admin/getById",
                "/teacher/getById",
                "/admin/update",
                "/teacher/update"
                ));

        adminPermission.addAll(teacherPermission);

        rolePermissionMap.put(RoleEnum.STUDENT, studentPermission);
        rolePermissionMap.put(RoleEnum.TEACHER, teacherPermission);
        rolePermissionMap.put(RoleEnum.ADMIN, adminPermission);

        rolePermissionMap.forEach((key, value) -> value.addAll(basePermissionList));
    }

    // 登录状态获取
    public static boolean isLogin(HttpSession session) {
        return session.getAttribute(IS_LOGIN) != null;
    }

    public static boolean isLogin(HttpServletRequest request) {
        return isLogin(request.getSession());
    }

    public static boolean isLogin(ServletRequest request) {
        return isLogin((HttpServletRequest) request);
    }

    // 获取map首个元素值
    public static <T> T getFirstValueByMap(Map<?, T> map) {
        return map.entrySet().iterator().next().getValue();
    }

    public static String getFirstStringValueByMap(Map<?, String> map) {
        return getFirstValueByMap(map);
    }

    // 获取对应角色首页路径
    public static String getHomePathByRole(RoleEnum role) {
        return getFirstStringValueByMap(rolePageInfoMap.get(role));
    }

    // 获取项目路径
    public static String getProjectPath(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    // 获取当前全路径
    public static String getCurrentFullPath(HttpServletRequest request) {
        return getProjectPath(request) + request.getServletPath();
    }

    // 获取当前登录角色
    public static RoleEnum getRoleByCurrentRole(HttpServletRequest request) {
        Object value = request.getSession().getAttribute(ROLE);
        if (value == null) {
            throw new NotLoggedInException("用户未登录");
        }
        return (RoleEnum) value;
    }

    // 获取对应角色首页全路径
    public static String getHomeFullPathByRole(RoleEnum role, HttpServletRequest request) {
        return getProjectPath(request) + getFirstStringValueByMap(rolePageInfoMap.get(role));
    }

    // 获取当前登录角色首页路径
    public static String getHomePathByCurrentRole(HttpServletRequest request) {
        return getHomePathByRole(getRoleByCurrentRole(request));
    }

    // 获取当前登录角色首页全路径
    public static String getHomeFullPathByCurrentRole(HttpServletRequest request) {
        return getHomeFullPathByRole(getRoleByCurrentRole(request), request);
    }
}
