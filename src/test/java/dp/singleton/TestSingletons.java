package dp.singleton;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

public class TestSingletons {
    private static HashMap DATA = new HashMap();
    private static Integer SIZE = 100;
    @Test
    public void testGetInstanceHungry() throws  Exception{

        for (int i=0;i<=SIZE;i++) {
            SingletonLazyHungry singletonLazyHungry = SingletonLazyHungry.getInstance();
            new Thread(
                    () -> {
                        Assert.assertEquals(singletonLazyHungry,SingletonHungry.getInstance());
                    }
            ).start();

        }
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
}
