public class Computer {
    private String cpu;
    private String ram;
    private String storage;

    public Computer() {
        this.setCpu("default");
        this.setRam("default");
        this.setStorage("default");
    }

    public Computer(String cpu, String ram, String storage) {
        this.setCpu(cpu);
        this.setRam(ram);
        this.setStorage(storage);
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getStorage() {
        return storage;
    }

    public void setStorage(String storage) {
        this.storage = storage;
    }


    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                '}';
    }
}
