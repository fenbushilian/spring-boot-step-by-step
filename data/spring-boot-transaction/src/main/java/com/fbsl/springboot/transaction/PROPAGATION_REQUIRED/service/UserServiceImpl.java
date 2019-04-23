package com.fbsl.springboot.transaction.PROPAGATION_REQUIRED.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserServiceImpl.PROPAGATION_REQUIRED")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService1 userService1;

    @Autowired
    private UserService0 userService0;


    @Override
    public void test1(Long id) {
        userService1.yes(id);
        userService0.no1(id);
    }


    @Override
    public void test2(Long id) {
        userService1.yes(id);
    }


}
