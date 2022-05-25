package com.zy.controller;

import com.zy.entity.Dept;
import com.zy.entity.Emp;
import com.zy.entity.Menu;
import com.zy.entity.Role;
import com.zy.mapper.PerMapper;
import com.zy.service.PermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class ProController {
    @Autowired
   private PermService permService;
    @GetMapping("/perm")
    public String queryPerAll(Map map){
        List<Menu> menus= permService.queryPerAll();
        map.put("menus",menus);
        return "Perm/list";
    }
    @GetMapping("/perm/permAdd")
    public String permAdd(Map map){
        List<Role> roles = permService.queryRoleAll();
        List<Menu> menus = permService.queryMenuAll();
        map.put("roles",roles);
        map.put("menus",menus);
        return "Perm/add";

    }
    @PostMapping("/perm")
    public String add(Menu menu) {
        System.out.println(menu);
     /*   emp.setStatus(1);
        System.out.println(emp);
        empService.add(emp);*/
        permService.addPer(menu);

        return "redirect:/perm";
    }
    @DeleteMapping("/perm")
    public String edit(Integer id){

        System.out.println("删除的id=====================>"  + id);
        permService.deleteById(id);

        return "redirect:/perm";

    }


}
