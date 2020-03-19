package com.yuanhy.string;

import java.awt.*;

/**
 * 扩展一个类
 */
public class ExtendsPoint extends Point {
    public Color color;

    /**
     * 清零行为
     */
    public void clear() {
        /*
        * 调用超类（父类）的方法，这个是继承特性，super引用的是超类的实体，this引用的是当前对象的实体
        * super.clear()调用超类执行clear方法，实际上是调用超类Point对象执行clear方法
        * */
        super.clear();
        color = null;
    }
}
