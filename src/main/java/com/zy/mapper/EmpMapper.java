package com.zy.mapper;

import com.zy.entity.Emp;
import com.zy.entity.User;

import java.util.List;

public interface EmpMapper {
    List<Emp> queryAll();
    void insert(Emp emp);
    Emp getById(Integer id);
    void update(Emp emp);
    void deleteById(Integer id);

}
