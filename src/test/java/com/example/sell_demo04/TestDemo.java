package com.example.sell_demo04;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDemo {
private final Logger logger= LoggerFactory.getLogger(TestDemo.class);
    @Test
    public void contextLoads() {
       logger.debug("logger日志，debug");
        logger.info("logger日志，info");
        logger.error("logger日志，error");
    }

}
