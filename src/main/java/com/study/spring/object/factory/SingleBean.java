package com.study.spring.object.factory;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingleBean {

    @Autowired
    ObjectFactory<PrototypeBean> factory;

    public void print(String name) {
        System.out.println("single service is " + this);
        factory.getObject().test(name);
    }
}
