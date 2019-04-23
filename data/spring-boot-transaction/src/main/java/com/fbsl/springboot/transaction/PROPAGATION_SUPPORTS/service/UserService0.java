package com.fbsl.springboot.transaction.PROPAGATION_SUPPORTS.service;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserService0 {


    void no(Long id);


    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.SUPPORTS)
    void yes(Long id);
}
