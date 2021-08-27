package com.bambi.springday02;

import com.bambi.springday02.domain.dao.User;
import com.bambi.springday02.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringDay02ApplicationTests {
    private static Logger logger = LoggerFactory.getLogger(SpringDay02ApplicationTests.class);
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(user -> {
            logger.info("user name --->{}",user.getName());
        });
    }

}
