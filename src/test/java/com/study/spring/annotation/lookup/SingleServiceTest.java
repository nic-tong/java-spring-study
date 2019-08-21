package com.study.spring.annotation.lookup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {MutiService.class, SingleService.class})
public class SingleServiceTest {

    @Autowired
    SingleService singleService;
    @Test
    public void print() {
        for (int i=0; i< 2; i++) {
            singleService.print(i+"hello");
        }
    }
}