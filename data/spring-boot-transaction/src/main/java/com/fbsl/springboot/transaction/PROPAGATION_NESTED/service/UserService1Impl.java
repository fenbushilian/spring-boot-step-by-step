package com.fbsl.springboot.transaction.PROPAGATION_NESTED.service;

import com.fbsl.dao.UserMapper;
import com.fbsl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("UserService1Impl.PROPAGATION_NESTED")
public class UserService1Impl implements UserService1 {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService0 userService0;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void yes(Long id) {
        User user = userMapper.selectById(id);
        user.setAge(user.getAge() + 2);
        userMapper.updateById(user);
        userService0.no(id + 1);
    }

    @Override
     public void yes1(Long id) {
        User user = userMapper.selectById(id);
        user.setAge(user.getAge() + 2);
        userMapper.updateById(user);
        userService0.no(id + 1);
    }





}
