package com.demo.main.dao;

import com.demo.main.entity.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    Course selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKeyWithBLOBs(Course record);

    int updateByPrimaryKey(Course record);

    List<Course> selectByField(@Param("field") String field, @Param("value") Object value);
    Course selectOneByField(@Param("field") String field, @Param("value") Object value);

    List<Course> selectAll();
}