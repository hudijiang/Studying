package juc.caseInterview.crossPrint.transferQueue;

import java.util.concurrent.TransferQueue;

/**
 * @Description 打印字母的线程，用于交叉打印
 * @ClassName CharThread
 * @author 胡迪江
 * @date 2020/4/24 00:55
 */
public class CharThread implements Runnable{
    //共享数据队列
    private volatile TransferQueue<Character> queue ;

    public CharThread(TransferQueue queue){
        this.queue = queue ;
    }

    private final static char[] CSTR = "ABCDEFGHI".toCharArray();

    @Override
    public void run() {
        for (int i=0;i<CSTR.length;i++) {
            try {
                queue.transfer(CSTR[i]);
                System.out.print(queue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
