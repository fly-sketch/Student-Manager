package com.demo.main.service;

import com.demo.main.dao.TeacherMapper;
import com.demo.main.entity.Teacher;
import com.demo.main.utils.CommonUtil;
import com.demo.main.utils.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherMapper mapper;

    public boolean login(String username, String password, HttpServletRequest request) {
        Teacher databaseStudent = mapper.selectOneByField("username", username);
        if (databaseStudent != null && databaseStudent.getPassword().equals(password)) {
            CommonUtil.setLogin(request, databaseStudent.getId(), username, RoleEnum.TEACHER);
            return true;
        }
        return false;
    }

    public List<Teacher> findAll() {
        return mapper.selectAll();
    }

    public List<Teacher> findByField(String field, Object value) {
        return mapper.selectByField(field, value);
    }
    public Teacher findOneByField(String field, Object value) {
        return mapper.selectOneByField(field, value);
    }
    public void add(Teacher record) {
        mapper.insertSelective(record);
    }
    public boolean update(Teacher record) {
        return mapper.updateByPrimaryKeySelective(record) > 0;
    }
    public boolean delete(Integer id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }
}
