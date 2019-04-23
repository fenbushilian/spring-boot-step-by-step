package com.fbsl.springboot.transaction.PROPAGATION_NOT_SUPPORTED.controller;

import com.fbsl.constant.AppInfo;
import com.fbsl.springboot.transaction.PROPAGATION_NOT_SUPPORTED.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 以非事务方式执行操作，如果当前存在事务，就把当前事务挂起
 * propagation = PROPAGATION_REQUIRES_NEW
 */
@RestController("TransactionController.PROPAGATION_NOT_SUPPORTED")
@RequestMapping("/PROPAGATION_NOT_SUPPORTED/transaction")
public class TransactionController {

    @Autowired
    private UserService userService;


    /**
     *  一个默认事务正常执行，一个无事务执行，结果：执行2条记录的更新
     *
     * @param id
     * @return
     */
    @GetMapping("/test1")
    public String test1(@RequestParam("id") Long id) {
        try {
            userService.test1(id);

        } catch (Exception e) {
            return e.getMessage();
        }
        return AppInfo.RETURN_INFO;
    }


}
