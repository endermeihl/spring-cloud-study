package com.ender.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(resolver = ProfilesResolver.class)
public abstract class ExerciseApplicationTests implements ApplicationContextAware {

    protected Logger log = LoggerFactory.getLogger(this.getClass().getName());
    protected ApplicationContext applicationContext;

    protected ObjectMapper json = new ObjectMapper();

    @Rule
    public TestName name = new TestName() {
        @Override
        protected void starting(Description d) {
            super.starting(d);
            log.info("\u001B[1;31m----------------------------测试方法：" + name.getMethodName() + "开始----------------------------\u001B[0m");
        }

        @Override
        protected void finished(Description description) {
            super.finished(description);
            log.info("\u001B[1;31m----------------------------测试方法：" + name.getMethodName() + "结束----------------------------\u001B[0m");
        }
    };

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Before
    public void init() {
        log.info("\u001B[1;31m----------------------------方法开始动作----------------------------\u001B[0m");
    }

    @After
    public void after() {
        log.info("\u001B[1;31m----------------------------方法结束动作----------------------------\u001B[0m");
    }

    protected void log(String desc, Object o) {
        try {
            log.info("\u001B[1;34m" + desc + ":" + json.writeValueAsString(o) + "\u001B[0m");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    protected void log(Object o) {
        try {
            log.info("\u001B[1;34m" + json.writeValueAsString(o) + "\u001B[0m");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void contextLoads() {
    }

}
