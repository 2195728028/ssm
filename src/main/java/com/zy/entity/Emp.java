package com.zy.entity;

import lombok.Data;

@Data
public class Emp {
    private Integer id;
    private String name;
    private Integer sex;
    private Dept dept;
    private Integer status;
}
