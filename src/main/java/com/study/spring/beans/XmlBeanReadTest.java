package com.study.spring.beans;

import org.junit.Assert;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lianghong.tlh
 * @date 2019/08/31
 */
public class XmlBeanReadTest {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) beanFactory.getBean("person");
        Assert.assertEquals(person.getAge(), 10);



    }
}
