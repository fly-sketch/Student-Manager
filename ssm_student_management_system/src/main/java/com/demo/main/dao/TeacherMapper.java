package com.demo.main.dao;

import com.demo.main.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    List<Teacher> selectByField(@Param("field") String field, @Param("value") Object value);

    Teacher selectOneByField(@Param("field") String field, @Param("value") Object value);

    List<Teacher> selectAll();
}