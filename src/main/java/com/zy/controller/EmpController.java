package com.zy.controller;

import com.zy.entity.Dept;
import com.zy.entity.Emp;
import com.zy.service.DeptService;
import com.zy.service.EmpService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class EmpController {

    @Autowired
    private EmpService empService;
    @Autowired
    private DeptService deptService;

    @GetMapping("/emp/emps")
    public String queryEmps(Map map){
        List<Emp> emps = this.empService.queryEmps();

        map.put("emps",emps);
        return "emp/list";

    }
    @RequiresPermissions("emp:add")
    @GetMapping("/emp/preAdd")
    public String preAdd(Map map){
        List<Dept> depts = this.deptService.queryAll();
        map.put("depts",depts);

        return "emp/add";

    }
    @RequiresPermissions("emp:add")
    @PostMapping("/emp")
    public String add(Emp emp){
        emp.setStatus(1);
        System.out.println(emp);
        empService.add(emp);
        return "redirect:/emp/emps";
    }
    @RequiresPermissions(value={"emp:update"})
    @GetMapping("/emp/{id}")
    public String preEdit(@PathVariable("id") Integer id, Map map){
        /*System.out.println("id=====================>" + id);*/
        Emp emp = this.empService.queryById(id);
        List<Dept> depts = this.deptService.queryAll();

        map.put("emp",emp);
        map.put("depts",depts);

        return "emp/eit";

    }
    @RequiresPermissions(value={"emp:update"})
    @PutMapping("/emp")
    public String update(Emp emp){
        System.out.println(emp);
             this.empService.update(emp);
        return "redirect:/emp/emps";
    }
    @RequiresPermissions(value={"emp:del"})
    @DeleteMapping("/emp")
    public String edit(Integer id){

        System.out.println("删除的id=====================>"  + id);
        this.empService.deleteById(id);

        return "redirect:/emp/emps";

    }
}
