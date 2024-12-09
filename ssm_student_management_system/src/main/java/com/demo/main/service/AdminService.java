package com.demo.main.service;

import com.demo.main.dao.AdminMapper;
import com.demo.main.entity.Admin;
import com.demo.main.utils.CommonUtil;
import com.demo.main.utils.RoleEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminMapper mapper;

    public boolean login(String username, String password, HttpServletRequest request) {
        Admin databaseStudent = mapper.selectOneByField("username", username);
        if (databaseStudent != null && databaseStudent.getPassword().equals(password)) {
            CommonUtil.setLogin(request, databaseStudent.getId(), username, RoleEnum.ADMIN);
            return true;
        }
        return false;
    }

    public List<Admin> findAll() {
        return mapper.selectAll();
    }

    public List<Admin> findByField(String field, Object value) {
        return mapper.selectByField(field, value);
    }
    public Admin findOneByField(String field, Object value) {
        return mapper.selectOneByField(field, value);
    }
    public void add(Admin record) {
        mapper.insertSelective(record);
    }
    public boolean update(Admin record) {
        return mapper.updateByPrimaryKeySelective(record) > 0;
    }
    public boolean delete(Integer id) {
        return mapper.deleteByPrimaryKey(id) > 0;
    }
}
