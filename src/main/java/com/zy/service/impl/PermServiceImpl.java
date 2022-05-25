package com.zy.service.impl;

import com.zy.entity.Menu;
import com.zy.entity.Role;
import com.zy.mapper.PerMapper;
import com.zy.service.PermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PermServiceImpl implements PermService {
    @Autowired
    private PerMapper perMapper;
    @Override
    public List<Menu> queryPerAll() {
        List<Menu> menus = perMapper.queryPerAll();
        return menus;
    }

    @Override
    public List<Role> queryRoleAll() {
        List<Role> roles = perMapper.queryRoleAll();
        return roles;
    }

    @Override
    public List<Menu> queryMenuAll() {
        List<Menu> menus = perMapper.queryMenuAll();
        return menus;
    }

    @Override
    public void addPer(Menu menu) {
        Set<String> strings = perMapper.queryPer(menu.getUser().getUsername());

        if (!strings.contains(menu.getPerm())){
            if (menu.getPerm().equals("emp:add")){
                perMapper.insertper(menu.getRole().getId(),1);
            }else if(menu.getPerm().equals("emp:update")){
                perMapper.insertper(menu.getRole().getId(),2);
            }else {
                perMapper.insertper(menu.getRole().getId(),3);
            }
        }

    }

    @Override
    public void deleteById(Integer id) {
        perMapper.deleteById(id);
    }


}
