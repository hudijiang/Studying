package juc.caseInterview.crossPrint.lockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description 输出数字的线程，用于交叉打印
 * @ClassName NumThread
 * @author 胡迪江
 * @date 2020/4/24 00:54
 */
public class NumThread extends  Thread{
    private volatile Thread t;

    public void setT(Thread t){
        this.t = t;
    }

    private final static char[] NSTR = "123456789".toCharArray();

    @Override
    public void run() {
        for (int i=0;i<NSTR.length;i++) {
            LockSupport.park();//阻塞
            System.out.print(NSTR[i]);
            LockSupport.unpark(t);//唤醒另一个线程
        }
    }
}
