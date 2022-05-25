package com.zy.mapper;

import com.zy.entity.User;

public interface UserMapper {
    void insert (User user);
    User query(User user);
    User getByName(String username);

}
