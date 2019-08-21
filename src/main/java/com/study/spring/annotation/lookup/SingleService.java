package com.study.spring.annotation.lookup;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class SingleService {


    @Lookup
    protected abstract MutiService getMutiService();

    public void print(String name ) {
        System.out.println("single service is " + this);
        getMutiService().test(name);
    }
}
