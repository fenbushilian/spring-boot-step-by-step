package com.fbsl.springboot.transaction.PROPAGATION_NOT_SUPPORTED.service;

import com.fbsl.dao.UserMapper;
import com.fbsl.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service("UserService0Impl.PROPAGATION_NOT_SUPPORTED")
public class UserService0Impl implements UserService0 {


    @Autowired
    private UserMapper userMapper;


    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.NOT_SUPPORTED)
    public void no(Long id) {
        User user = userMapper.selectById(id);
        user.setAge(user.getAge() + 1);
        userMapper.updateById(user);
        throw new RuntimeException("抛出异常");
    }


}
