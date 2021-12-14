package com.dexlace.jvm.charpter2;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    static class OOMObject{

    }

    // -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
    // （1）-XX:+HeapDumpOnOutOfMemoryError参数表示当JVM发生OOM时，自动生成DUMP文件。
    //
    //（2）-XX:HeapDumpPath=${目录}参数表示生成DUMP文件的路径，也可以指定文件名称，
    // 例如：-XX:HeapDumpPath=${目录}/java_heapdump.hprof。
    // 如果不指定文件名，默认为：java_<pid>_<date>_<time>_heapDump.hprof。
    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
