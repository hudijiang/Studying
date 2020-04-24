package juc.lockSupport;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

/**
 * @Description 打印字母的线程，用于交叉打印
 * @ClassName CharThread
 * @author 胡迪江
 * @date 2020/4/24 00:55
 */
public class CharThread extends Thread{
    private volatile Thread t;

    public void setT(Thread t){
        this.t = t;
    }

    private final static char[] CSTR = "ABCDEFGHI".toCharArray();

    @Override
    public void run() {
        for (int i=0;i<CSTR.length;i++) {
            System.out.print(CSTR[i]);
            LockSupport.unpark(t);//唤醒其他线程
            LockSupport.park();//阻塞当前线程
        }
    }
}
