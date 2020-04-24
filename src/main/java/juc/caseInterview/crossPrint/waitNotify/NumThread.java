package juc.caseInterview.crossPrint.waitNotify;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 输出数字的线程，用于交叉打印
 * @ClassName NumThread
 * @author 胡迪江
 * @date 2020/4/24 00:54
 */
public class NumThread implements Runnable{
    /**
     * 锁
     */
    private volatile Object lock;

    private CountDownLatch cdl ;

    public NumThread(Object lock,CountDownLatch cdl) {
        this.lock = lock;
        this.cdl = cdl;
    }

    private final static char[] NSTR = "123456789".toCharArray();

    @Override
    public void run() {
        try {
            cdl.await();//保证让输出字母的线程先执行
        } catch (Exception e) {
            e.printStackTrace();
        }
        synchronized (lock) {
            try {
                for (int i=0;i<NSTR.length;i++) {
                    System.out.print(NSTR[i]);
                    lock.notify();//释放对象锁
                    lock.wait();//阻塞当前线程
                }
                lock.notify();//释放对象锁，用于输出最后一个字符释放对象锁
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
