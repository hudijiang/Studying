package juc.caseInterview.crossPrint.waitNotify;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 打印字母的线程，用于交叉打印
 * @ClassName CharThread
 * @author 胡迪江
 * @date 2020/4/24 00:55
 */
public class CharThread implements Runnable{
    /**
     * 锁
     */
    private volatile Object lock;

    private CountDownLatch cdl ;

    public CharThread(Object lock,CountDownLatch cdl) {
        this.lock = lock;
        this.cdl = cdl;
    }

    private final static char[] CSTR = "ABCDEFGHI".toCharArray();

    @Override
    public void run() {
        synchronized (lock) {
            cdl.countDown();//通知输出数字的线程可以开始执行了
            try {
                for (int i=0;i<CSTR.length;i++) {
                    System.out.print(CSTR[i]);
                    lock.notify();//释放当前锁
                    lock.wait();//阻塞当前线程
                }
                lock.notify();//释放对象锁，用于输出最后一个字符释放对象锁
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
