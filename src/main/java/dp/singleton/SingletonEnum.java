package dp.singleton;

class Singleton{
}

public enum SingletonEnum {
    INSTANCES;
    private Singleton instances;

    SingletonEnum(){
        instances = new Singleton();
    }

    public Singleton getInstances(){
        return instances;
    }
}
