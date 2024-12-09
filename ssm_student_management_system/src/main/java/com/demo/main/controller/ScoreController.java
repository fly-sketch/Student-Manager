package com.demo.main.controller;

import com.demo.main.entity.Score;
import com.demo.main.service.ScoreService;
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
@RequestMapping("/score")
public class ScoreController {
    private final ScoreService service;


    @GetMapping("/student_course_management")
    public String studentCourseManagement(HttpServletRequest request) {
        if (request.getAttribute("list") == null) {
            request.setAttribute("list", service.findAllDto());
        }
        return "student_course_management";
    }

    @GetMapping("/student_course_management_condition")
    public String studentCourseManagementCondition(@RequestParam Integer id, HttpServletRequest request) {
        request.setAttribute("list", service.findDtoByField("s.id", id));
        return "student_course_management";
    }

    @GetMapping("/management")
    public String scoreManagement(HttpServletRequest request) {
        if (request.getAttribute("list") == null) {
            request.setAttribute("list", service.findAllDto());
        }
        return "score_management";
    }

    @GetMapping("/management_condition")
    public String managementCondition(@RequestParam Integer id, HttpServletRequest request) {
        request.setAttribute("list", service.findDtoByField("s.id", id));
        return "score_management";
    }

    @GetMapping("/delete")
    public void delete(@RequestParam Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.delete(id);
        response.sendRedirect(request.getContextPath() + "/score/management");
    }
    @GetMapping("/update")
    public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Score record = CommonUtil.requestParameterConvert(request, Score.class);
        service.update(record);
        response.sendRedirect(request.getContextPath() + "/score/management");
    }
    @GetMapping("/add")
    public void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Score record = CommonUtil.requestParameterConvert(request, Score.class);
        service.add(record);
        response.sendRedirect(request.getContextPath() + "/score/management");
    }
    @GetMapping("/getById")
    @ResponseBody
    public Score getById(Integer id) {
        return service.findOneByField("id", id);
    }
}
