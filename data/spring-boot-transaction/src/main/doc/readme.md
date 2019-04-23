
MySQL8.0.15+InnoDB+WIN10


单个数据库的spring事务支持

默认隔离级别：PROPAGATION_REQUIRED
http://localhost:8080//PROPAGATION_REQUIRED/transaction/test1?id=1
http://localhost:8080//PROPAGATION_REQUIRED/transaction/test2?id=1


压力测试，事务隔离对数据的影响  jmeter



查看事务方法：
1、通过sql语句
    在异常代码的地方设置断点后，通过如下语句查询
    
    SELECT a.trx_id, a.trx_state, a.trx_started, a.trx_query, b.ID, b.USER, b.DB, b.COMMAND, b.TIME, b.STATE, b.INFO, c.PROCESSLIST_USER, c.PROCESSLIST_HOST, c.PROCESSLIST_DB, d.SQL_TEXT FROM information_schema.INNODB_TRX a LEFT JOIN information_schema.PROCESSLIST b ON a.trx_mysql_thread_id = b.id AND b.COMMAND = 'Sleep' LEFT JOIN PERFORMANCE_SCHEMA.threads c ON b.id = c.PROCESSLIST_ID LEFT JOIN PERFORMANCE_SCHEMA.events_statements_current d ON d.THREAD_ID = c.THREAD_ID;
    
    
     
2、通过执行结果

