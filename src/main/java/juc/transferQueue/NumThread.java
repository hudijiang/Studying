package juc.transferQueue;

import juc.cas.ReadyToRun;

import java.util.concurrent.TransferQueue;

/**
 * @Description 输出数字的线程，用于交叉打印
 * @ClassName NumThread
 * @author 胡迪江
 * @date 2020/4/24 00:54
 */
public class NumThread implements  Runnable{
    //共享数据队列
    private volatile TransferQueue<Character> queue ;

    public NumThread(TransferQueue queue){
        this.queue = queue ;
    }

    private final static char[] NSTR = "123456789".toCharArray();

    @Override
    public void run() {
        for (int i=0;i<NSTR.length;i++) {
            try {
                System.out.print(queue.take());
                queue.transfer(NSTR[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
