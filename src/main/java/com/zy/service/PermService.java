package com.zy.service;

import com.zy.entity.Dept;
import com.zy.entity.Menu;
import com.zy.entity.Role;

import java.util.List;

public interface PermService {
    List<Menu> queryPerAll();
    List<Role> queryRoleAll();
    List<Menu> queryMenuAll();
    void addPer(Menu menu);
    void deleteById(Integer id);
}
