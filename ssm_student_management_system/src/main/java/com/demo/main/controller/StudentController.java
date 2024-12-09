package com.demo.main.controller;

import com.demo.main.entity.Student;
import com.demo.main.service.StudentService;
import com.demo.main.utils.CommonUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    @GetMapping("/management")
    public String studentManagement(HttpServletRequest request) {
        if (request.getAttribute("list") == null) {
            request.setAttribute("list", service.findAll());
        }
        return "student_management";
    }

    @GetMapping("/management_condition")
    public String studentManagement(@RequestParam String name, HttpServletRequest request) {
        request.setAttribute("list", service.findByField("name", name));
        return "student_management";
    }

    @GetMapping("/delete")
    public void delete(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.delete(id);
        response.sendRedirect(request.getContextPath() + "/student/management");
    }
    @GetMapping("/update")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = CommonUtil.requestParameterConvert(request, Student.class);
        service.update(student);
        response.sendRedirect(request.getContextPath() + "/student/management");
    }
    @GetMapping("/add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Student student = CommonUtil.requestParameterConvert(request, Student.class);
        service.add(student);
        response.sendRedirect(request.getContextPath() + "/student/management");
    }

    @GetMapping("/getById")
    @ResponseBody
    public Student getById(Integer id) {
        return service.findOneByField("id", id);
    }
}
