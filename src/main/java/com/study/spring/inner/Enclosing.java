package com.study.spring.inner;

/**
 * @author lianghong.tlh
 * @date 2019/08/24
 */

public class Enclosing {

    private static void test(String name, int size) {
        assert size > 0;
        assert name.length() >  3;
        System.out.println(name + ":" + size);
    }

    public static void main(String[] args) {
        test("11111", -2);
    }
}
