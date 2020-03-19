package com.yuanhy.thread;


public class AddNum  {
    private Integer num;

    public int getNum() {
        return num;
    }

    public void increateNum(Integer num){
        for(int i=0;i<10;i++){
            synchronized (num){
                num++;
                System.out.println(num);
            }

        }


    }

    public static void main(String[] args) {
        AddNum addNum = new AddNum();
        Thread thread1 = new Thread(new AddNumThread1(addNum));
        Thread thread2 = new Thread(new AddNumThread2(addNum));
        thread1.start();
        thread2.start();

    }
}
