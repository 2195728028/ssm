package com.zy.mapper;

import com.zy.entity.Dept;
import com.zy.entity.Menu;
import com.zy.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface PerMapper {
    Set<String> queryPer(String username);
    List<Menu> queryPerAll();
    List<Role> queryRoleAll();
    List<Menu> queryMenuAll();
    int insertper( @Param("i") int i,@Param("j") int j);
    void deleteById(Integer id);


}
