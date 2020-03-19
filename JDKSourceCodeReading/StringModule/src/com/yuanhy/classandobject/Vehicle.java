package com.yuanhy.classandobject;

/**
 * 创建一个 Vehicle 类,静态变量nextID保存下一辆车的标识号，非静态变量id保存每一辆车的标识号
 * <p>
 * final：
 * final 变量一旦赋值将不可改变，否则编译报错
 * <p>
 * 类成员的访问控制：从小到大
 * private: 只能被包含它的类自身访问（我理解为类访问）（被继承子类的成员不能使用private,通过public方法访问private变量）
 * package: 顾名思义就是被包含它的类自身以及所在包的其他类访问（我理解为包访问）
 * protected: 被包含它的类自身访问、同一个包的其他类访问以及
 * 包含它的类的子类访问（这里注意，不管是在同一个包还是不同包，主要是子类所在的位置）
 * public: 被任何类访问
 */
public class Vehicle {

    public static int nextID;

    public String name;

    public int id;

    public final static double LENGTH = 2.5;

    public static void main(String[] args) {
        Vehicle baoma = new Vehicle();
        baoma.id = nextID++;
        baoma.name = "宝马";

        Vehicle bentian = new Vehicle();
        bentian.id = nextID++;
        bentian.name = "本田";

        System.out.println("生产"+baoma.id+baoma.name+"和"+bentian.id
                +bentian.name);
    }
}
