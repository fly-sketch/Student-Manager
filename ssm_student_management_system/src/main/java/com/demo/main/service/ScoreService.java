package com.demo.main.service;

import com.demo.main.dao.ScoreMapper;
import com.demo.main.entity.Score;
import com.demo.main.entity.ScoreDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreMapper mapper;

    public List<Score> findAll() {
        return mapper.selectAll();
    }

    public List<Score> findByField(String field, Object value) {
        return mapper.selectByField(field, value);
    }
    public Score findOneByField(String field, Object value) {
        return mapper.selectOneByField(field, value);
    }
    public void add(Score record) {
        mapper.insertSelective(record);
    }
    public boolean update(Score record) {
        return mapper.updateByPrimaryKeySelective(record) > 0;
    }
    public boolean delete(Integer id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }

    public List<ScoreDto> findAllDto() {
        return mapper.selectAllDto();
    }
    public List<ScoreDto> findDtoByField(String field, Object value) {
        return mapper.selectDtoByField(field, value);
    }
}
