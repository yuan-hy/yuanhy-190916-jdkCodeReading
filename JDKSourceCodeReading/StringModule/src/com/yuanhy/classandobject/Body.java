package com.yuanhy.classandobject;

/**
 * 类是用关键字 class 定义的，Body是类名，花括号括起来是类的所有成员
 *
 * Body mercury mercury是个变量，这个变量理解为类Body的对象的引用，这样只是声明，并未创建对象
 *
 * 类成员包括三种：
 *      字段、方法、嵌套类或者嵌套接口，嵌套类或者嵌套接口顾名思义在类或者接口中还有其他的类或者接口
 *
 * 类修饰符，在类的声明的前面（class关键字前面）添加修饰符限定属性
 *          注解，一般在类声明上方
 *          访问控制符：例如public等
 *          abstract 抽象类
 *          final类，不允许有子类
 *
 *  字段：
 *      类中声明的变量就是字段，例如Body类中声明的idNum、name、orbits就是字段
 *
 *  初始化默认值：
 *        boolean  false
 *        char    '\u0000'
 *        byte、short、int、long   0
 *        float、double   +0.0
 *        object reference   null
 *
 *  静态字段变量作用：
 *      在一个类中被这个类的所有对象共享，而非静态变量则不会
 *
 *  静态导入：static import
 *          在头部使用的imoirt static ***方式叫做静态引入，在Java SE 1.5.0（JDK 5）引入的特性。
 *          为了访问静态成员，有必要限定它们来自的类的引用。例如，必须这样使用：
 *          double r = Math.cos(Math.PI * theta);
 *
 *          import static java.lang.Math.PI;
 *          double r = cos(PI * theta);
 *
 *
 */
public class Body {
    public long idNum;
    public String name;
    public Body orbits;

    public static long nextID = 0;
}
