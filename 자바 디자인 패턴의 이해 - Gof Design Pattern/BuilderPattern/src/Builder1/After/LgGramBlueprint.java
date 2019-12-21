package Builder1.After;

// concrete Builder
public class LgGramBlueprint extends BluePrint {
    private Computer computer;

    public LgGramBlueprint() {
        computer = new Computer();
    }

    @Override
    public void setCpu(String cpu) {
        computer.setCpu(cpu);
    }

    @Override
    public void setRam(String ram) {
        computer.setRam(ram);
    }

    @Override
    public void setStorage(String storage) {
        computer.setStorage(storage);
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
