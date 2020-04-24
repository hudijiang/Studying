package juc.caseInterview;

import juc.caseInterview.crossPrint.transferQueue.CharThread;
import juc.caseInterview.crossPrint.transferQueue.NumThread;
import org.junit.Test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class TestTransferQueue {

    @Test
    public void testTransferQueue() throws Exception{
        TransferQueue<Character> queue = new LinkedTransferQueue<Character>();
        Thread t1 = new Thread(new CharThread(queue));
        Thread t2 = new Thread(new NumThread(queue));
        t1.start();
        t2.start();

        t2.join();
        t1.join();
    }

}
