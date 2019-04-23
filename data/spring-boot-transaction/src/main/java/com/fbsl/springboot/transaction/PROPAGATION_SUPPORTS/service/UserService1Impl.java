package com.fbsl.springboot.transaction.PROPAGATION_SUPPORTS.service;

import com.fbsl.dao.UserMapper;
import com.fbsl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("UserService1Impl.PROPAGATION_SUPPORTS")
public class UserService1Impl implements UserService1 {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService0 userService0;

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
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

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    public void yes1(Long id) {
            userService0.yes(id+1);


            User user = userMapper.selectById(id);
            user.setAge(user.getAge() + 2);
            userMapper.updateById(user);
            throw new RuntimeException("抛出异常");

    }

}
