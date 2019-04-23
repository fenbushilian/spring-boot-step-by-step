package com.fbsl.springboot.transaction.PROPAGATION_NESTED.controller;

import com.fbsl.constant.AppInfo;
import com.fbsl.springboot.transaction.PROPAGATION_NESTED.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 如果调用方有配置事务，就用调用方事务。如果调用方没有事务，就用默认事务。
 * propagation = PROPAGATION_NESTED
 */
@RestController("TransactionController.PROPAGATION_NESTED")
@RequestMapping("/PROPAGATION_NESTED/transaction")
public class TransactionController {

    @Autowired
    private UserService userService;


    /**
     *
     * 调用方有事务，被调用方用调用方的事务，遇到错误全部回滚
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

    /**
     *
     * 调用方无事务，调用方数据提交。被调用方因为有事务，遇到错误回滚
     * @param id
     * @return
     */
    @GetMapping("/test2")
    public String test2(@RequestParam("id") Long id) {
        try {
            userService.test2(id);

        } catch (Exception e) {
            return e.getMessage();
        }
        return AppInfo.RETURN_INFO;
    }

}
