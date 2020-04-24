package juc.lockSupport;

import org.junit.Test;
/**
 * @Description 使用LockSupport的park和unpark方法实现线程唤醒和等待
 * @ClassName TestLockSupport
 * @author 胡迪江
 * @date 2020/4/24 15:06
 */
public class TestLockSupport {

    @Test
    public void testLockSupport() throws Exception{
        CharThread t1 = new CharThread();
        NumThread t2 = new NumThread();
        t1.setT(t2);
        t2.setT(t1);

        t2.start();
        t1.start();
        t2.join();
    }
}
