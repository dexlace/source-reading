package com.dexlace.jvm.charpter3;

public class ReferenceCountingGC {
    private Object instance;
    private static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        //objA 中有objB,objB中有objA
        objA.instance = objB;
        objB.instance = objA;
        //虽然objA 和objB 置空,但这是指将他们的引用置空,在堆内存中,这两个对象还是互相持有\依赖的,这就是循环引用。
        objA = null;
        objB = null;
    }

    // 记得配置-XX:+PrintGCDetails才能打出gc信息
    public static void main(String[] args) {
        testGC();
    }
}

