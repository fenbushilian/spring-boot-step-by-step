package com.fbsl.springboot.transaction.PROPAGATION_SUPPORTS.service;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserService1 {


    void yes(Long id);


    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRES_NEW)
    void yes1(Long id);
}
