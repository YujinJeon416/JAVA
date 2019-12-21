public class ComputerBuilder {

    private Computer computer;

    private ComputerBuilder() {
        computer = new Computer();
    }

//    좀 더 가독성 높은 버전
//    public static ComputerBuilder startWithCpu(String cpu) {
//        return new ComputerBuilder().setCpu(cpu);
//    }
//
    // static 해준다
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
