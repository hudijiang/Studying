package dp.singleton;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class TestSingletons {
    private static HashMap DATA = new HashMap();
    private static Integer SIZE = 100;

    //饿汉模式单元测试
    @Test
    public void testGetSingletonHungry() throws  Exception{

        for (int i=0;i<=SIZE;i++) {
            SingletonHungry singletonLazyHungry = SingletonHungry.getInstance();
            new Thread(
                    () -> {
                        Assert.assertEquals(singletonLazyHungry,SingletonHungry.getInstance());
                    }
            ).start();

        }
    }

    //饿汉单例反序列化测试
    @Test
    public void testGetSingletonHungry2()throws Exception{
        SingletonHungry singletonEnum = SingletonHungry.getInstance();
        FileOutputStream fos = new FileOutputStream("Enum Object");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(singletonEnum);
        oos.flush();
        fos.close();


        SingletonHungry singletonEnum1 = null;
        FileInputStream fis = new FileInputStream("Enum Object");
        ObjectInputStream ois = new ObjectInputStream(fis);
        singletonEnum1 = (SingletonHungry)ois.readObject();
        ois.close();
        //反序列化后2个对象不相等
        Assert.assertNotEquals(singletonEnum,singletonEnum1);
    }

    @Test
    public void testGetInstanceLazyHungry() throws  Exception{
        SingletonLazyHungry lazyHungry = SingletonLazyHungry.getInstance();
        for (int i=0;i<=SIZE;i++) {
            new Thread(
                    () -> {
                        Assert.assertEquals(lazyHungry,SingletonLazyHungry.getInstance());
                    }
            ).start();

        }
    }

    //懒汉单例反序列化测试
    @Test
    public void testGetInstanceLazyHungry2()throws Exception{
        SingletonLazyHungry singletonEnum = SingletonLazyHungry.getInstance();
        FileOutputStream fos = new FileOutputStream("Enum Object");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(singletonEnum);
        oos.flush();
        fos.close();


        SingletonLazyHungry singletonEnum1 = null;
        FileInputStream fis = new FileInputStream("Enum Object");
        ObjectInputStream ois = new ObjectInputStream(fis);
        singletonEnum1 = (SingletonLazyHungry)ois.readObject();
        ois.close();
        //反序列化后2个对象不相等
        Assert.assertNotEquals(singletonEnum,singletonEnum1);
    }

    @Test
    public void testGetInstanceEnum() throws  Exception{
        SingletonEnum singletonEnum = SingletonEnum.getInstances();
        for (int i=0;i<=SIZE;i++) {
            new Thread(
                    () -> {
                        Assert.assertEquals(singletonEnum,SingletonEnum.getInstances());
                    }
            ).start();

        }
    }

    //单例反序列化测试
    @Test
    public void testGetInstanceEnum2()throws Exception{
        SingletonEnum singletonEnum = SingletonEnum.getInstances();
        singletonEnum.setData(new Object());
        FileOutputStream fos = new FileOutputStream("Enum Object");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(singletonEnum);
        oos.flush();
        fos.close();


        SingletonEnum singletonEnum1 = null;
        FileInputStream fis = new FileInputStream("Enum Object");
        ObjectInputStream ois = new ObjectInputStream(fis);
        singletonEnum1 = (SingletonEnum)ois.readObject();
        ois.close();

        Assert.assertEquals(singletonEnum,singletonEnum1);
    }
}

