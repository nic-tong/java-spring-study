package com.study.spring.annotation;

/**
 * 使用实现单例注入多例
 * 使用lookup 实现在单例中注入多例，会发现生成一个cglib代理的单例
 * lookup 注解 底层实现仍然通过 BeanFactory.getBean 来获取一个多例的对象
 */