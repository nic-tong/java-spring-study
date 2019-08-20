package com.study.spring.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Component
@Scope(scopeName = SCOPE_PROTOTYPE)
public class MutiService {

    public void test(String name) {
        System.out.println("this name is " + name + ", class is " + this);
    }
}
