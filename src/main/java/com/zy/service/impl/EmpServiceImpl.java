package com.zy.service.impl;

import com.zy.entity.Dept;
import com.zy.entity.Emp;
import com.zy.mapper.EmpMapper;
import com.zy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> queryEmps() {
        List<Emp> emps = empMapper.queryAll();
        return emps;
    }


    @Override
    public void add(Emp emp) {
        empMapper.insert(emp);

    }

    @Override
    public Emp queryById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    @Override
    public void update(Emp emp) {
           empMapper.update(emp);
    }

    @Override
    public void deleteById(Integer id) {
         empMapper.deleteById(id);
    }
}
