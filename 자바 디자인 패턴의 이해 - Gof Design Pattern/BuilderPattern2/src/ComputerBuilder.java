public class ComputerBuilder {

    private Computer computer;

    private ComputerBuilder() {
        computer = new Computer();
    }

//    �� �� ������ ���� ����
//    public static ComputerBuilder startWithCpu(String cpu) {
//        return new ComputerBuilder().setCpu(cpu);
//    }
//
    // static ���ش�
    public static ComputerBuilder start() {
        return new ComputerBuilder();
    }

    public ComputerBuilder setCpu(String cpu) {
        computer.setCpu(cpu);
        return this;
    }

    public ComputerBuilder setRam(String ram) {
        computer.setRam(ram);
        return this;
    }

    public ComputerBuilder setStorage(String Storage) {
        computer.setStorage(Storage);
        return this;
    }

    public Computer build() {
        return this.computer;
    }

}
