package juc.cas;

import java.util.concurrent.locks.LockSupport;

/**
 * @Description 打印字母的线程，用于交叉打印
 * @ClassName CharThread
 * @author 胡迪江
 * @date 2020/4/24 00:55
 */
public class CharThread extends Thread{
    //是否准备运行
    private volatile static ReadyToRun r ;

    public void setR(ReadyToRun r){
        this.r = r;
    }

    private final static char[] CSTR = "ABCDEFGHI".toCharArray();

    @Override
    public void run() {
        for (int i=0;i<CSTR.length;i++) {
            while (ReadyToRun.getStatus()== ReadyToRun.ReadyRunThread.T2) {//如果是
            }
            System.out.print(CSTR[i]);
            ReadyToRun.changerStatus(ReadyToRun.ReadyRunThread.T2);
        }
    }
}
