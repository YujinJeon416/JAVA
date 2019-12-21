package Builder1.After;

// abstract Builder
public abstract class BluePrint {
    abstract public void setCpu(String cpu);
    abstract public void setRam(String ram);
    abstract public void setStorage(String storage);
    abstract public Computer getComputer();

}
