package com.zy.service.impl;

import com.zy.entity.Dept;
import com.zy.mapper.DeptMapper;
import com.zy.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;
    @Override
    public List<Dept> queryAll() {
        List<Dept> depts = deptMapper.queryDepts();
        return depts;
    }
}
