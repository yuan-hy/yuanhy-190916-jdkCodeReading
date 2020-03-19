package com.yuanhy.string;

/**
 * ClassDeclaration 类，包括字段和方法
 * 类的具体对象是一个实例，包含类的字段和方法
 *
 */
public class ClassDeclaration {
    /**
     * public 表示 java 虚拟机任何一个对象都可以调用 main 方法
     * static 表示属于这个类
     * 返回值类型是 void 表示无返回值
     * 方法签名：方法名和方法参数组成,main
     * 方法头：public static void main(String[] args)
     * 方法体：
     *         System.out.println("Hello World!");
     *
     * 方法声明：方法头+方法体：public static void main(String[] args) {
     *         System.out.println("Hello World!");
     *     }
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
