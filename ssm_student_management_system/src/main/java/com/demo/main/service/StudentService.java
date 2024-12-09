package com.demo.main.service;

import com.demo.main.dao.StudentMapper;
import com.demo.main.entity.Student;
import com.demo.main.utils.CommonUtil;
import com.demo.main.utils.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentMapper mapper;

    public boolean login(String username, String password, HttpServletRequest request) {
        Student databaseStudent = mapper.selectOneByField("username", username);
        if (databaseStudent != null && databaseStudent.getPassword().equals(password)) {
            CommonUtil.setLogin(request, databaseStudent.getId(), username, RoleEnum.STUDENT);
            return true;
        }
        return false;
    }

    public void register(Student student) {
        mapper.insertSelective(student);
    }

    public List<Student> findAll() {
        return mapper.selectAll();
    }

    public List<Student> findByField(String field, Object value) {
        return mapper.selectByField(field, value);
    }
    public Student findOneByField(String field, Object value) {
        return mapper.selectOneByField(field, value);
    }

    public void add(Student record) {
        mapper.insertSelective(record);
    }

    public boolean update(Student record) {
        return mapper.updateByPrimaryKeySelective(record) > 0;
    }
    public boolean delete(Integer id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }
}
