package dp.singleton;

public enum SingletonEnum {
    INSTANCES;
    private Object data;

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public static SingletonEnum getInstances(){
        return INSTANCES;
    }
}
