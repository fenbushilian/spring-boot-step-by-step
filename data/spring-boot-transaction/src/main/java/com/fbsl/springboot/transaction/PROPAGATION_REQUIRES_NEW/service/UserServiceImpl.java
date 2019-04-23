package com.fbsl.springboot.transaction.PROPAGATION_REQUIRES_NEW.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("UserServiceImpl.PROPAGATION_REQUIRES_NEW")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserService1 userService1;


    @Override
    public void test1(Long id) {
        userService1.yes(id);

    }


}
