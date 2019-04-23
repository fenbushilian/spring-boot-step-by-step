package com.fbsl.springboot.transaction.PROPAGATION_NOT_SUPPORTED.service;

import com.fbsl.dao.UserMapper;
import com.fbsl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserService1Impl.PROPAGATION_NOT_SUPPORTED")
public class UserService1Impl implements UserService1 {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService0 userService0;

    @Override
    public void yes(Long id) {


        try {

            User user = userMapper.selectById(id);
            user.setAge(user.getAge() + 2);
            userMapper.updateById(user);
        }catch (Exception e) {

        }
        try {
            userService0.no(id+1);
        } catch (Exception e) {


        }

    }





}
