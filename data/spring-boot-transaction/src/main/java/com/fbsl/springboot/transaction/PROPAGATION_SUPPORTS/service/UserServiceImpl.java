package com.fbsl.springboot.transaction.PROPAGATION_SUPPORTS.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserServiceImpl.PROPAGATION_SUPPORTS")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService1 userService1;


    @Override
    public void test1(Long id) {
        userService1.yes(id);

    }

    @Override
    public void test2(Long id) {
        userService1.yes1(id);

    }


}
