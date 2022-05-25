package com.zy.service;

import com.zy.entity.Dept;
import com.zy.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> queryEmps();
    void add(Emp emp);
    Emp queryById(Integer id);
    void update(Emp emp);
    void deleteById(Integer id);
}
