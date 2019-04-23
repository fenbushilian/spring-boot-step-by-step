package com.fbsl.springboot.transaction.PROPAGATION_REQUIRED.service;

import com.fbsl.dao.UserMapper;
import com.fbsl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("UserService0Impl.PROPAGATION_REQUIRED")
public class UserService0Impl implements UserService0 {


    @Autowired
    private UserMapper userMapper;


    @Override
    public void no1(Long id) {
        User user = userMapper.selectById(id);
        user.setAge(user.getAge() + 1);
        userMapper.updateById(user);
        throw new RuntimeException("抛出异常");
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
    public void no2(Long id) {
        User user = userMapper.selectById(id);
        user.setAge(user.getAge() + 1);
        userMapper.updateById(user);
        throw new RuntimeException("抛出异常");
    }


}
