package com.demo.main.dao;

import com.demo.main.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    List<Admin> selectByField(@Param("field") String field, @Param("value") Object value);

    Admin selectOneByField(@Param("field") String field, @Param("value") Object value);

    List<Admin> selectAll();
}