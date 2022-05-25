package com.zy.entity;

import lombok.Data;
import org.apache.shiro.util.ByteSource;

@Data
public class User {

    private Integer id;
    private String username;
    private String password;
    private String salt;
}
