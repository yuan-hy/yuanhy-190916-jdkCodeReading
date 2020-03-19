package com.yuanhy.thread;

public class AddNumThread2 implements Runnable {
    private AddNum addNum;

    public AddNumThread2(AddNum addNum) {
        this.addNum = addNum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            addNum.increateNum(1);
        }
    }
}
