package com.zy.entity;

import lombok.Data;

@Data
public class Menu {
    private Integer id;
    private String name;
    private Role role;
    private User user;
    private String perm;
}
