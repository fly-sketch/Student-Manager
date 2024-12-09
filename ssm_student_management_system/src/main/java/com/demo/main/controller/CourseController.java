package com.demo.main.controller;

import com.demo.main.entity.Course;
import com.demo.main.service.CourseService;
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
@RequestMapping("/course")
public class CourseController {
    private final CourseService service;

    @GetMapping("/management")
    public String courseManagement(HttpServletRequest request) {
        if (request.getAttribute("list") == null) {
            request.setAttribute("list", service.findAll());
        }
        return "course_management";
    }

    @GetMapping("/management_condition")
    public String managementCondition(@RequestParam Integer id, HttpServletRequest request) {
        request.setAttribute("list", service.findByField("id", id));
        return "course_management";
    }

    @GetMapping("/delete")
    public void delete(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.delete(id);
        response.sendRedirect(request.getContextPath() + "/course/management");
    }
    @GetMapping("/update")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Course record = CommonUtil.requestParameterConvert(request, Course.class);
        service.update(record);
        response.sendRedirect(request.getContextPath() + "/course/management");
    }
    @GetMapping("/add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Course record = CommonUtil.requestParameterConvert(request, Course.class);
        service.add(record);
        response.sendRedirect(request.getContextPath() + "/course/management");
    }
    @GetMapping("/getById")
    @ResponseBody
    public Course getById(Integer id) {
        return service.findOneByField("id", id);
    }
}
