package com.demo.main.controller;

import com.demo.main.entity.Student;
import com.demo.main.service.AdminService;
import com.demo.main.service.StudentService;
import com.demo.main.service.TeacherService;
import com.demo.main.utils.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final AdminService adminService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam RoleEnum role,
                            @RequestParam String username,
                            @RequestParam String password,
                            HttpServletRequest request) {

        if (username == null || password == null) {
            request.setAttribute("data", new Result<>(ResultCode.FAILURE, "用户或密码不能为空"));
            return "login";
        }

        username = username.trim();
        password = password.trim();

        boolean flag = false;

        switch (role) {
            case STUDENT:
                flag = studentService.login(username, password, request);
                break;
            case TEACHER:
                flag = teacherService.login(username, password, request);
                break;
            case ADMIN:
                flag = adminService.login(username, password, request);
        }

        if (flag) {
            request.setAttribute("data", new Result<>(ResultCode.SUCCESS, "登录成功"));
            System.out.println(PermissionUtil.getHomePathByCurrentRole(request));
            return "redirect:" + PermissionUtil.getHomePathByCurrentRole(request);
        }

        request.setAttribute("data", new Result<>(ResultCode.FAILURE, "登录失败"));
        return "login";
    }

    @PostMapping("/register")
    public String registerPost(HttpServletRequest request) {
        studentService.register(CommonUtil.requestParameterConvert(request, Student.class));
        return "register";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        CommonUtil.setLogout(request);
        return "login";
    }
}
