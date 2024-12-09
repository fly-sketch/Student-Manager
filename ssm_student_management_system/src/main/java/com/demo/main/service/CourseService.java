package com.demo.main.service;

import com.demo.main.dao.CourseMapper;
import com.demo.main.entity.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseMapper mapper;

    public List<Course> findAll() {
        return mapper.selectAll();
    }

    public List<Course> findByField(String field, Object value) {
        return mapper.selectByField(field, value);
    }
    public Course findOneByField(String field, Object value) {
        return mapper.selectOneByField(field, value);
    }
    public void add(Course record) {
        mapper.insertSelective(record);
    }
    public boolean update(Course record) {
        return mapper.updateByPrimaryKeySelective(record) > 0;
    }
    public boolean delete(Integer id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }
}
