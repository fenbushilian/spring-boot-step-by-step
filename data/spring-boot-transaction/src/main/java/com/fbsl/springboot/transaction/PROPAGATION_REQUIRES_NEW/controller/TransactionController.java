package com.fbsl.springboot.transaction.PROPAGATION_REQUIRES_NEW.controller;

import com.fbsl.constant.AppInfo;
import com.fbsl.springboot.transaction.PROPAGATION_REQUIRES_NEW.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 新建事务，如果当前存在事务，把当前事务挂起
 * propagation = PROPAGATION_REQUIRES_NEW
 */
@RestController("TransactionController.PROPAGATION_REQUIRES_NEW")
@RequestMapping("/PROPAGATION_REQUIRES_NEW/transaction")
public class TransactionController {

    @Autowired
    private UserService userService;


    /**
     * 验证新建事务模式；因为有2个事务，所以2个操作一个成功一个失败，各自不影响。
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
