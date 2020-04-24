package juc.cas;

import org.junit.Test;

/**
 * @Description 使用CAS线程切换
 * @ClassName TestCas
 * @author 胡迪江
 * @date 2020/4/24 15:06
 */
public class TestCas {
    @Test
    public void testLockSupport() throws Exception{
        ReadyToRun r = new ReadyToRun();
        CharThread t1 = new CharThread();
        NumThread t2 = new NumThread();
        t1.setR(r);
        t2.setR(r);

        t2.start();
        t1.start();
        t2.join();
    }
}
