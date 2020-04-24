package singleton;

/**
 * @Description 单例
 * 懒汉模式
 * @ClassName SingletonLazyHungry
 * @author 胡迪江
 * @date 2020/4/13 21:38
 * 优点：在需要对象是再实例化单例对象，一定上节省了内存
 * 缺点:
 */
public class SingletonLazyHungry {
    private static volatile SingletonLazyHungry INSTANCE ;
    private SingletonLazyHungry() {
    }
    public static SingletonLazyHungry getInstance() {
        if (INSTANCE==null) {
            synchronized (SingletonLazyHungry.class) {
                if (INSTANCE==null) {
                    INSTANCE = new SingletonLazyHungry();
                }
            }
        }
        return INSTANCE;
    }
}
