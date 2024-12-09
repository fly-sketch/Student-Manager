package com.demo.main.dao;

import com.demo.main.entity.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectByField(@Param("field") String field, @Param("value") Object value);
    Student selectOneByField(@Param("field") String field, @Param("value") Object value);

    List<Student> selectAll();
}