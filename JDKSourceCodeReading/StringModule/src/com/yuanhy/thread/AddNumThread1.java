package com.yuanhy.thread;

public class AddNumThread1 implements Runnable {
    private AddNum addNum;

    public AddNumThread1(AddNum addNum) {
        this.addNum = addNum;
    }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            addNum.increateNum(1);
        }
    }
}
