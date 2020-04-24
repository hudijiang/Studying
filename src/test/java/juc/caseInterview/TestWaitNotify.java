package juc.caseInterview;

import juc.caseInterview.crossPrint.waitNotify.CharThread;
import juc.caseInterview.crossPrint.waitNotify.NumThread;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class TestWaitNotify {
    @Test
    public void testWaitNotify() throws Exception{
        Object lock = new Object();
        CountDownLatch cdl = new CountDownLatch(1);
        Thread t1 = new Thread(new CharThread(lock,cdl));
        Thread t2 = new Thread(new NumThread(lock,cdl));
        t2.start();
        t1.start();
        t2.join();
    }
}
