package com.fbsl.springboot.transaction.PROPAGATION_NEVER.service;

import com.fbsl.dao.UserMapper;
import com.fbsl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("UserService0Impl.PROPAGATION_NEVER")
public class UserService0Impl implements UserService0 {


    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.NEVER)
    public void no(Long id) {
        User user = userMapper.selectById(id);
        user.setAge(user.getAge() + 1);
        userMapper.updateById(user);
     }


}
