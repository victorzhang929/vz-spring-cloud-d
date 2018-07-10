package com.victorzhang.cloud.mongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 消费者测试类
 *
 * @author zhangwei
 * @email zhangwei@cetiti.com
 * @date 2018-07-10 10:28:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testMongodbId() {
        Customer customer = new Customer("zhang", "wei");
        customer = customerRepository.save(customer);
        System.out.println(customer.getId());
    }
}
