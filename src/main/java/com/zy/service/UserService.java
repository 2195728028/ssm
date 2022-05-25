package com.zy.service;

import com.zy.entity.User;

public interface UserService {
    void register(User user);
    User query(User user);
}
