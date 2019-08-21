package com.study.spring.object.factory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {PrototypeBean.class, SingleBean.class})
public class SingleBeanTest {


    @Autowired
    SingleBean singleBean;
    @Test
    public void print() {
        for (int i=0; i< 2; i++) {
            singleBean.print(i+"hello");
        }
    }
}