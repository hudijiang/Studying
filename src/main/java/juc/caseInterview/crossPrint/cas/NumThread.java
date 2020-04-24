package juc.caseInterview.crossPrint.cas;

/**
 * @Description 输出数字的线程，用于交叉打印
 * @ClassName NumThread
 * @author 胡迪江
 * @date 2020/4/24 00:54
 */
public class NumThread extends  Thread{
    //是否准备运行
    private volatile static ReadyToRun r ;

    public void setR(ReadyToRun r){
        this.r = r;
    }

    private final static char[] NSTR = "123456789".toCharArray();

    @Override
    public void run() {
        for (int i=0;i<NSTR.length;i++) {
            while (ReadyToRun.getStatus()== ReadyToRun.ReadyRunThread.T1) {//如果是
            }
            System.out.print(NSTR[i]);
            ReadyToRun.changerStatus(ReadyToRun.ReadyRunThread.T1);
        }
    }
}
