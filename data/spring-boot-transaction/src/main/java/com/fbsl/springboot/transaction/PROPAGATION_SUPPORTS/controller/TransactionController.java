package com.fbsl.springboot.transaction.PROPAGATION_SUPPORTS.controller;

import com.fbsl.constant.AppInfo;
import com.fbsl.springboot.transaction.PROPAGATION_SUPPORTS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * 支持当前事务，如果当前没有事务，就以非事务方式执行
 * propagation = PROPAGATION_REQUIRES_NEW
 */
@RestController("TransactionController.PROPAGATION_SUPPORTS")
@RequestMapping("/PROPAGATION_SUPPORTS/transaction")
public class TransactionController {

    @Autowired
    private UserService userService;


    /**
     * 本质上被调用方法的事务融合到调用方法的事务中，要么全部成功，要么全部失败
     *  最终事务执行情况=被调用方法的事务成功与否&&调用方法的事务成功与否
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
     * 再次验证
     *  最终事务执行情况=被调用方法的事务成功与否&&调用方法的事务成功与否
     *  无论调用的方法出错，还是被调用的方法出错，只要有错误，就不会执行任何事务。
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
