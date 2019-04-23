package com.fbsl.springboot.transaction.PROPAGATION_REQUIRED.service;

import com.fbsl.dao.UserMapper;
import com.fbsl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("UserService1Impl.PROPAGATION_REQUIRED")
public class UserService1Impl implements UserService1 {


    @Autowired
    private UserMapper userMapper;


    @Autowired
    private UserService0 userService0;

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
    public void yes(Long id) {
        try {
            User user = userMapper.selectById(id);
            user.setAge(user.getAge() + 2);
            userMapper.updateById(user);
        }catch (Exception e) {

        }
        try {
            userService0.no2(id);
        } catch (Exception e) {

    }
    }


}
