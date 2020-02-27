package org.sunjian.fanxings;

public class Demo2 {
    public static void main(String[] args) {

    }
}

interface MyMap<P, E> {
    public void put(P p, E e);
}

class MyHashMap<P, E> implements MyMap{

    @Override
    public void put(Object o, Object o2) {
        System.out.println(o);
    }
}


/*
* extends 是上限
* super   是下限
* */