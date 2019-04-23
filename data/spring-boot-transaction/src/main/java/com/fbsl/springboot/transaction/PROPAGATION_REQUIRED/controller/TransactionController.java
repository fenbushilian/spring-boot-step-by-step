package com.fbsl.springboot.transaction.PROPAGATION_REQUIRED.controller;

import com.fbsl.constant.AppInfo;
import com.fbsl.springboot.transaction.PROPAGATION_REQUIRED.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 默认事务隔离级别
 * propagation = Propagation.REQUIRED
 * 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择
 */
@RestController("TransactionController.REQUIRED")
@RequestMapping("/PROPAGATION_REQUIRED/transaction")
public class TransactionController {

    @Autowired
    private UserService userService;


    /**
     * 验证没有事务的异常回滚场景,2次数据库操作全部更新
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


    /**
     * 验证默认事务传递模式，因为只有一个事务，所以一旦出错，全部不更新。
     *
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
