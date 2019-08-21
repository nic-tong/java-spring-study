package com.study.spring.annotation.lookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(scopeName = SCOPE_PROTOTYPE)
public class MutiService {

    @Autowired
    SingleService singleService;

    public void test(String name) {
        System.out.println("this name is " + name + ", class is " + this);
        System.out.println("this signle service is " + singleService);
    }
}
