package org.practice.streamDemo;

import java.util.stream.IntStream;

public class ParallelStream {
    public static void main(String[] args) {
        IntStream range=IntStream.rangeClosed(1,10);
        range.forEach(x->System.out.println(Thread.currentThread().getName()+" value "+x));
//        range.forEach(System.out::println);

        System.out.println("-------------------");

        IntStream rangeParallel= IntStream.rangeClosed(1,10);
        rangeParallel.parallel().forEach(x->System.out.println(Thread.currentThread().getName()+" value "+x));
//        rangeParallel.parallel().forEach(System.out::println);
    }
}
