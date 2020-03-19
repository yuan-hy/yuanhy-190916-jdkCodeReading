package com.yuanhy.thread;

/**
 * synchronized 实际高性能用法
 * synchronized(被共享处理的对象的引用 expr){
 *     执行语句 statement
 * }
 *
 * 获取 expr 的锁，并执行 statement 操作
 *
 * 同步编程是会影响性能的，所以一般使用 synchronized 作用于处理共享对象的代码块，
 * 不用于整个方法，只对于局部需要保护的共享对象
 *
 *
 */
public class CreateThread {
    public static void main(String[] args) {
        Thread thread = new Thread("newThread");

        ThreadGroup threadGroup = new ThreadGroup("threadGroup");

        threadGroup.checkAccess();
        System.out.println(threadGroup.getMaxPriority());
        System.out.println(threadGroup.getName());
        thread.setName("thread1");
        thread.start();
        Thread[] threads = new Thread[2];
        threads[0] = thread;
        System.out.println(thread.getName());
        System.out.println(threadGroup.enumerate(threads));
    }


}
