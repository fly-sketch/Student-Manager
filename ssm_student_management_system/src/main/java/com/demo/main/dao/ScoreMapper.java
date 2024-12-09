package com.demo.main.dao;

import com.demo.main.entity.Score;
import com.demo.main.entity.ScoreDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Score record);

    int insertSelective(Score record);

    Score selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Score record);

    int updateByPrimaryKey(Score record);

    List<Score> selectByField(@Param("field") String field, @Param("value") Object value);
    Score selectOneByField(@Param("field") String field, @Param("value") Object value);

    List<Score> selectAll();

    List<ScoreDto> selectAllDto();

    List<ScoreDto> selectDtoByField(@Param("field") String field, @Param("value") Object value);
}