package singleton;

import org.junit.Assert;
import org.junit.Test;
import java.util.HashMap;

public class TestSingleton {
    private static HashMap DATA = new HashMap();
    private static Integer SIZE = 100;
    @Test
    public void testGetInstanceHungry() throws  Exception{

        for (int i=0;i<=SIZE;i++) {
            new Thread(
                    () -> {
                        Assert.assertEquals(SingletonHungry.getInstance(),SingletonHungry.getInstance());
                    }
            ).start();

        }
    }

    @Test
    public void testGetInstanceLazyHungry() throws  Exception{

        for (int i=0;i<=SIZE;i++) {
            new Thread(
                    () -> {
                        Assert.assertEquals(SingletonLazyHungry.getInstance(),SingletonLazyHungry.getInstance());
                    }
            ).start();

        }
    }

    @Test
    public void testGetInstanceEnum() throws  Exception{

        for (int i=0;i<=SIZE;i++) {
            new Thread(
                    () -> {
                        Assert.assertEquals(SingletonEnum.INSTANCES.getInstances(),SingletonEnum.INSTANCES.getInstances());
                    }
            ).start();

        }
    }
}
