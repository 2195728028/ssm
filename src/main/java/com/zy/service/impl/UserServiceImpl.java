package com.zy.service.impl;

import com.zy.entity.User;
import com.zy.mapper.UserMapper;
import com.zy.service.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Transactional
    @Override
    public void register(User user) {
        this.userMapper.insert(user);
    }

    @Override
    public User query(User user) {
        User user1 = userMapper.query(user);
        return user1;
    }


}
