package com.dexlace.reflect.proxy;

public class RealSubject implements Subject {
    @Override
    public String say(String name, int age) {
        return name+": "+age;
    }
}
