package com.fbsl.springboot.transaction.PROPAGATION_NEVER.controller;

import com.fbsl.constant.AppInfo;
import com.fbsl.springboot.transaction.PROPAGATION_NEVER.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 如果调用方有配置事务，就报异常
 * propagation = PROPAGATION_MANDATORY
 */
@RestController("TransactionController.PROPAGATION_NEVER")
@RequestMapping("/PROPAGATION_NEVER/transaction")
public class TransactionController {

    @Autowired
    private UserService userService;


    /**
     *
     * 调用前设置一个事务，报错
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
     * 调用前无事务，正常执行
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
