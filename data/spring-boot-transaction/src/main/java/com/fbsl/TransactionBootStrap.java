package com.fbsl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

@EnableTransactionManagement

@MapperScan("com.fbsl.dao")

public class TransactionBootStrap {
    public static void main(String[] args) {
        SpringApplication.run(TransactionBootStrap.class, args);
    }
}
