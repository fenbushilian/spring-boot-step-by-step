package com.fbsl.springboot.transaction.PROPAGATION_NOT_SUPPORTED.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserServiceImpl.PROPAGATION_NOT_SUPPORTED")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService1 userService1;


    @Override
    public void test1(Long id) {
        userService1.yes(id);

    }




}
