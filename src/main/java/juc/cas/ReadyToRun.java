package juc.cas;
/**
 * @Description 线程共享数据类
 * @ClassName ReadyToRun
 * @author 胡迪江
 * @date 2020/4/24 15:40
 */
public class ReadyToRun {
    enum ReadyRunThread {T1,T2};
    private static volatile ReadyRunThread r = ReadyRunThread.T1;//默认为T1线程运行

    public static synchronized void changerStatus(ReadyRunThread rs) {
        r = rs;
    }

    public static synchronized ReadyRunThread getStatus(){
        return r;
    }

}
