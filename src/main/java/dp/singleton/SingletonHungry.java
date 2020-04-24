package dp.singleton;

/**
 * @Description 单例模式
 *  饿汉模式
 * @ClassName Singleton
 * @author 胡迪江
 * @date 2020/4/13 20:45
 * 优点：在类加载时就已经被创建，不会存在多线程环境多次创建的情况
 * 缺点：即使在没有用到该对象也会被实例化，造成内存的浪费
 */
public class SingletonHungry {
    private static final SingletonHungry INSTANCE = new SingletonHungry();
    private SingletonHungry(){
    }
    public static SingletonHungry getInstance() {
        return INSTANCE;
    }
}
