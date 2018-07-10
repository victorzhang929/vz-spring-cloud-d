package com.victorzhang.cloud.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 消费者数据访问接口
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @create 2018-07-10 10:26:21
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    /**
     * 根据姓氏查找
     *
     * @param firstName
     * @return
     */
    Customer findByFirstName(String firstName);


    /**
     * 根据名字查找
     *
     * @param lastName
     * @return
     */
    List<Customer> findByLastName(String lastName);
}
