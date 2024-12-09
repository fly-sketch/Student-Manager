package com.demo.main.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
    public static final String PROJECT_NAME = "学生管理系统";
    // Date转String
    public static String convertDateToString(Date date, String format) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

    public static String convertDateToString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    // String转Date
    public static Date convertToDate(String dateString) {
        // 尝试解析 "yyyy-MM-dd" 格式
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            // 如果解析失败，则尝试解析 "yyyy-MM-dd HH:mm:ss" 格式
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                return dateFormat.parse(dateString);
            } catch (ParseException ex) {
                // 日期格式不合法情况
                return null;
            }
        }
    }

    // request Parameter 转换为指定类型对象
    public static <T> T requestParameterConvert(HttpServletRequest request, Class<T> clazz) {
        Class<T> tClass = clazz;
        T entity;
        try {
            entity = tClass.newInstance();
            for (Field field : tClass.getDeclaredFields()) {
                field.setAccessible(true);

                String parameter = request.getParameter(field.getName());
                Object value = null;
                Class<?> fieldType = field.getType();

                if (parameter == null || parameter.isEmpty()) {
                    continue;
                }

                // 字符串转换所有类型
                // 属性类型为Integer
                if (fieldType.equals(Integer.class) || fieldType.equals(int.class)) {
                    value = Integer.parseInt(parameter);
                } else if (fieldType.equals(String.class)) {
                    value = parameter;
                } else if (fieldType.equals(Timestamp.class)) {
                    value = convertToDate(parameter);
                } else if (fieldType.equals(Date.class)) {
                    value = convertToDate(parameter);
                    // value = parameter;
                } else if (fieldType.equals(Long.class) || fieldType.equals(long.class)) {
                    value = Long.parseLong(parameter);
                } else if (fieldType.equals(Double.class) || fieldType.equals(double.class)) {
                    value = Double.parseDouble(parameter);
                } else if (fieldType.equals(Float.class) || fieldType.equals(float.class)) {
                    value = Float.parseFloat(parameter);
                } else if (fieldType.equals(Short.class) || fieldType.equals(short.class)) {
                    value = Short.parseShort(parameter);
                } else if (fieldType.equals(Byte.class) || fieldType.equals(byte.class)) {
                    value = Byte.parseByte(parameter);
                } else if (fieldType.equals(Boolean.class) || fieldType.equals(boolean.class)) {
                    value = Boolean.parseBoolean(parameter);
                }

                field.set(entity, value);
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return entity;
    }

    public static void setLogin(HttpServletRequest request, Object userid, String username, RoleEnum roleEnum) {
        HttpSession session = request.getSession();
        setLogin(session, userid, username, roleEnum);
    }

    public static void setLogin(HttpSession session, Object userid, String username, RoleEnum roleEnum) {
        session.setAttribute(PermissionUtil.IS_LOGIN, true);
        session.setAttribute(PermissionUtil.USER_ID, userid);
        session.setAttribute(PermissionUtil.USERNAME, username);
        session.setAttribute(PermissionUtil.ROLE, roleEnum);
    }

    public static void setLogout(HttpServletRequest request) {
        setLogout(request.getSession());
    }

    public static void setLogout(HttpSession session) {
        session.setAttribute(PermissionUtil.IS_LOGIN, false);
        session.setAttribute(PermissionUtil.USER_ID, null);
        session.setAttribute(PermissionUtil.USERNAME, null);
        session.setAttribute(PermissionUtil.ROLE, null);
    }
}
