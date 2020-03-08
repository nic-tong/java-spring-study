package com.study.spring.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 一个通用的构造器
 * @author lianghong.tlh
 * @date 2020/03/04
 */
public class CommonBuilder<T> {

    private final Supplier<T> instanceSupplier;

    private List<Consumer<T>> modifiers = new ArrayList<>(8);

    private CommonBuilder(Supplier<T> instanceSupplier) {
        this.instanceSupplier = instanceSupplier;
    }

    public static <T> CommonBuilder<T> of(Supplier<T> instanceSupplier) {
        return new CommonBuilder<>(instanceSupplier);
    }

    public <P1> CommonBuilder<T> with(OneArgConsumer<T, P1> consumer, P1 p) {
        Consumer<T> tConsumer = instance-> consumer.accept(instance, p);
        modifiers.add(tConsumer);
        return this;
    }

    public <P1,P2> CommonBuilder<T> with(TwoArgConsumer<T, P1, P2> consumer, P1 p1, P2 p2) {
        Consumer<T> tConsumer = instance-> consumer.accept(instance, p1, p2);
        modifiers.add(tConsumer);
        return this;
    }

    public <P1,P2, P3> CommonBuilder<T> with(ThreeArgConsumer<T, P1, P2, P3> consumer, P1 p1, P2 p2, P3 p3) {
        Consumer<T> tConsumer = instance-> consumer.accept(instance, p1, p2, p3);
        modifiers.add(tConsumer);
        return this;
    }


    public T build(){
        T value = instanceSupplier.get();
        modifiers.forEach(modifier-> modifier.accept(value));
        modifiers.clear();
        return value;
    }

    @FunctionalInterface
    public interface OneArgConsumer<T, P1> {
        /**
         * 接收一个参数
         * @param t1
         * @param p
         */
        void accept(T t1, P1 p);
    }

    @FunctionalInterface
    public interface TwoArgConsumer<T, P1, P2> {
        /**
         * 接收2个参数
         * @param t1
         * @param p1
         * @param p2
         */
        void accept(T t1, P1 p1, P2 p2);
    }

    @FunctionalInterface
    public interface ThreeArgConsumer<T, P1, P2, P3> {
        /**
         * 接收2个参数
         * @param t1
         * @param p1
         * @param p2
         * @param p3
         */
        void accept(T t1, P1 p1, P2 p2, P3 p3);
    }
}
